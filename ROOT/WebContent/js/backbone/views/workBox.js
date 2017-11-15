var app = app || {};

/**
 * WorkBox
 * ---------------------------------
 * the UI for 'workBox'
 */

app.WorkBoxView = Backbone.View
  .extend({
    el: '#d3-area-chart',

    events: {
      'click .node': 'viewDetails',
      'dblclick .node': 'popupNodeView',
      'contextmenu .node': 'onRightClick'
    },

    initialize: function() {

      /* -------------------- initialisation for drawing a graph -------------------- */
      var area_id = this.el.id;

      // set the size of the SVG element using the size of a window
      var ret_chart = init_chart_data(area_id, 700);
      push_chart_data(area_id, ret_chart);

      // set the zoom functionality - In order to make zoomable screen, zoom(g element) covers whole display in the beginning.
      var zoom = set_zoom(chart.svg.el);
      chart.zoom = zoom;

      // set up simulations for force-directed graphs
      var ret_simulation = set_simulation(15, chart.svg.width, chart.svg.height);
      push_node_style_data(ret_simulation);

      // the simulation used when drawing a force-directed graph
      chart.simulation = ret_simulation.simulation;

      this.listenTo(app.Nodes, "add", this.addNode);

      this.listenTo(app.Nodes, "update", function() {

        // Calls PROVSIMP webservice to save the node provenance after evrytime it is added.
        var param = {
          "action": "save",
          "nodes": app.Nodes.toJSON()
        }

        Backbone.ajax({
          type: "POST",
          contentType: "application/json",
          url: remote_server + "/PROVSIMP/rest/ProcProv",
          data: JSON.stringify(param),
          success: function(data) {
            console.log(data);

          },
          error: function(e) {
            var responseText = e.responseText;
            if (responseText) {
              var error_msg = responseText.split('h1>')[1];

              // when evalutation is failed, the reason will be shown
              console.log(error_msg.substring(0, error_msg.length - 2));
            } else {
              console.log(e);
            }
          }
        });


        $("#saveProgress").attr("disabled", false);
      });

      this.listenTo(app.Edges, "update", function() {
        $("#saveProgress").attr("disabled", false);
      });

      slider_wb = $("#slider-wb").slider({
        formatter: function(value) {
          if (chart.nodes) {
            chart.nodes.forEach(function(d) {
              $("#draw_" + d.nodeID + ' text').html(parseText(d.text, value));
            });
          }
          return value;
        }
      });

      $("#row-workbox").hide();
    },

    onRightClick: function(obj) {

      // return native menu if pressing control
      if (obj.ctrlKey) return;

      var index = obj.currentTarget.__data__.index;
      var target = obj.currentTarget.id.substr(5);

      var self = this;

      // open menu
      var menu = $("#contextMenu")
        .show()
        .css({
          "position": "absolute",
          "left": obj.pageX,
          "top": obj.pageY
        })
        .off('click')
        .on(
          'click',
          'a',
          function(opt) {
            if (opt.currentTarget.id == "delete-node") {

              // delete selected node
              deleteNode(index);

              // delete the model of selected node
              var node_model = app.Nodes.get(target);
              node_model.destroy();

              // delete edges which are connected to selected node
              var deleted_edges = deleteEdge(target);

              // delete the models of extracted edges
              deleted_edges.forEach(function(e) {
                var edge_model = app.Edges.get(e.edgeID);
                edge_model.destroy();
              });

              // re-start force-directed graph
              chart.simulation = restart_simulation(chart.simulation, true);

              if (link_from == target) {
                self.changeLinkFrom(target);
              }

            } else if (opt.currentTarget.id == "link-from") {
              self.changeLinkFrom(target);
            } else if (opt.currentTarget.id == "link-to") {
              var attr = null;

              if (link_from == target) {
                // if the first point and the second point are same, shows an error message
                alertMessage(obj, "You can't choose the same node for connection.");
              } else {
                // create a new model of edge
                attr = self.createEdge(link_from, target);

                if (attr) {
                  // draw the node
                  chart.edge = addNewEdge(attr);

                  // re-start graph
                  chart.simulation = restart_simulation(chart.simulation, true);

                  self.changeLinkFrom(target);
                } else {
                  // if the edge connects between i-nodes(Info, Claim), shows an error message
                  alertMessage(obj, "This connection looks not correct. You should choose at least one between Pref, Con or Pro.");
                }
              }
            } else if (opt.currentTarget.id == "cancel-link") {
              if (!_.isEmpty(link_from)) {
                self.changeLinkFrom(target);
              }
            }

            menu.hide();
          });

      return false;
    },

    changeLinkFrom: function(target) {
      if (!link_from) {
        // save id in the flag of first point
        link_from = target;

        // changes style for designating the first point of linking
        $("#draw_" + link_from + " rect").toggleClass("node-highlight");
      } else {
        // changes styles and initialize the flag of the first point
        $("#draw_" + link_from + " rect").toggleClass("node-highlight");

        link_from = null;
      }

      $("#link-from").toggleClass("disabled");
      $("#link-to").toggleClass("disabled");

      return link_from;
    },

    viewDetails: function(obj) {
      var id = obj.currentTarget.id;
      id = id.substr(5);

      var node = app.Nodes.get(id).attributes;

      $("#details-node .details-nodeID").text(node.nodeID);
      $("#details-node .details-dtg").text(node.dtg);
      $("#details-node .details-source").text(node.source);
      $("#details-node .details-text").text(node.text);
      $("#details-node .details-eval").text(node.eval);
      $("#details-node .details-commit").text(node.commit);
      $("#details-node .details-uncert").text(node.uncert);

      $("#details-node").show();
      $("#details-tweet").hide();

      return id;
    },

    popupNodeView: function(obj) {
      var id = obj.currentTarget.id;
      id = id.substr(5);

      // If a node is linked with another node which is a pro-node and starts with 'L'
      var edges = chart.edges.filter(function(d) {
        return ((d.source.id == id) && (d.target.type == "RA") && d.target.text.startsWith("L") && (d.target.text.length == 3));
      });

      if (edges && edges.length > 0) {

        $("#node_" + id + " .row-critical .col-select").empty();

        d3.json('./cqs.json', function(data) {
          edges.forEach(function(edge) {
            if (edge.target.text) {
              var cq = edge.target.text.replace("L", "CQ");

              var select_cq = $("#node_" + id + " .row-critical select[name=sel_" + cq + "]");

              if (select_cq.length < 1) {

                var row = $("<div></div>", {
                  'class': "form-group row"
                }).appendTo($("#node_" + id + " .row-critical .col-select"));

                var cq_source = chart.edges.filter(function(d) {
                  return ((d.target.id == id) && (d.source.type == "CA") && d.source.text.startsWith(cq) && (d.source.text.length == 5));
                });

                var select_value = "";
                if (cq_source && cq_source.length > 0) {
                  select_value = cq_source[0].source.text;
                }

                var select = $("<select></select>", {
                  'name': "sel_" + cq,
                  'class': "form-control"
                }).appendTo(
                  $("<div></div>", {
                    'class': "col-md-10"
                  }).appendTo(row)
                ).on("change", function(event) {
                  var selected_cq = $("#node_" + id + " .row-critical select[name=" + event.target.name + "] option:selected").val();

                  var existed_cq_number = chart.edges.filter(function(d) {
                    return ((d.target.id == id) && (d.source.type == "CA") && d.source.text.startsWith(selected_cq));
                  });

                  if (existed_cq_number && existed_cq_number.length > 0) {
                    $("#node_" + id + " .row-critical button[name=" + event.target.name.replace("sel", "btn") + "]").addClass("disabled");
                  } else {
                    $("#node_" + id + " .row-critical button[name=" + event.target.name.replace("sel", "btn") + "]").removeClass("disabled");
                  }
                });

                var button = $("<button></button>", {
                  'name': "btn_" + cq,
                  'class': "btn " + (select_value ? "disabled" : "") + " btn-default btn-ask",
                  'type': "button",
                  'text': "Ask"
                }).appendTo(
                  $("<div></div>", {
                    'class': "col-md-2"
                  }).appendTo(row)
                );

                if (data["CQ"][cq]) {
                  data["CQ"][cq].forEach(function(d, idx) {
                    var option = $("<option></option>", {
                      'value': cq + (idx + 1),
                      'text': cq + (idx + 1) + " - " + d,
                      'selected': ((cq + (idx + 1)) == select_value)
                    }).appendTo(select);
                  });
                }
              }
            }
          });
        });

        $("#node_" + id + " .row-critical").show();
      }

      $("#node_" + id).modal('show');
    },

    createNode: function(id, tweet_uri, text) {

      // generates the type of a new node
      var input = id.toUpperCase();

      var type = "I";
      if (input == "PREF") {
        type = "P";
      } else if (input == "PRO") {
        type = "RA";
      } else if (input == "CON") {
        type = "CA";
      }

      // generates created time using format string type
      var time = generateDate();

      var nodeID = generateUUID();

      var source = (tweet_uri) ? tweet_uri : readCookie('user_name');

      var attr = {
        source: source,
        id: nodeID,
        text: (text) ? text : input,
        input: input,
        dtg: time,
        type: type,
        nodeID: nodeID,
        graphID: chart.graph_id
      };

      // creates model of the node in the collection and sends POST request to a back-end service
      app.Nodes.create(attr, {
        type: 'POST'
      });

      return attr;
    },

    createNodeModelFromData: function(data) {

      var attr = {
        id: data['nodeID'],
        source: data['source'],
        uncert: data['uncert'],
        eval: data['eval'],
        text: data['text'],
        input: data['input'],
        dtg: data['dtg'],
        commit: data['commit'],
        type: data['type'],
        nodeID: data['nodeID'],
        annot: data['annot'],
        graphID: data['graphID']
      };

      // creates model of the node in the collection and sends POST request to a back-end service
      app.Nodes.create(attr);

      return attr;
    },

    addNode: function(node) {
      // when the new model is created in the collection, a view of the new model is created.
      var view = new app.NodeView({
        model: node
      });

      this.$el.append(view.render().el);
    },

    createEdge: function(source, target) {

      // designates the edge's class using the type of connected nodes
      var className = 'edge';
      var targetNode = $('#draw_' + target).children()[0];
      if (targetNode) {
        var targetNodeClassName = targetNode.className.baseVal;
        if (targetNodeClassName.includes("pro-node")) {
          className = 'pro-edge edge';
        } else if (targetNodeClassName.includes("con-node")) {
          className = 'con-edge edge';
        } else if (targetNodeClassName.includes("pref-node")) {
          className = 'pref-edge edge';
        }
      }

      var sourceNode = $('#draw_' + source).children()[0];
      if (sourceNode) {
        var sourceNodeClassName = sourceNode.className.baseVal;
        if (sourceNodeClassName.includes("pro-node")) {
          className = 'pro-edge edge';
        } else if (sourceNodeClassName.includes("con-node")) {
          className = 'con-edge edge';
        } else if (sourceNodeClassName.includes("pref-node")) {
          className = (className == 'edge') ? 'pref-edge edge' : className;
        }
      }

      // at least one node should be pref, pro or con node
      if (className == 'edge') {
        return null;
      }

      var edgeID = generateUUID(); // Math.floor(Math.random() * 100000) + 1;
      var graphID = chart.graph_id;

      var attr = {
        id: edgeID,
        target: target,
        source: source,
        edgeID: edgeID,
        className: className,
        graphID: graphID
      };

      // creates model of the edge in the collection and sends POST request to a back-end service
      app.Edges.create(attr, {
        type: 'POST'
      });

      return attr;
    },

    createEdgeModelFromData: function(data) {

      // designates the edge's class using the type of connected nodes
      var target = data['target'];
      var source = data['source'];

      var className = 'edge';
      var targetNode = $('#draw_' + target).children()[0];
      if (targetNode) {
        var targetNodeClassName = targetNode.className.baseVal;
        if (targetNodeClassName.includes("pro-node")) {
          className = 'pro-edge edge';
        } else if (targetNodeClassName.includes("con-node")) {
          className = 'con-edge edge';
        } else if (targetNodeClassName.includes("pref-node")) {
          className = 'pref-edge edge';
        }
      }

      var sourceNode = $('#draw_' + source).children()[0];
      if (sourceNode) {
        var sourceNodeClassName = sourceNode.className.baseVal;
        if (sourceNodeClassName.includes("pro-node")) {
          className = 'pro-edge edge';
        } else if (sourceNodeClassName.includes("con-node")) {
          className = 'con-edge edge';
        } else if (sourceNodeClassName.includes("pref-node")) {
          className = (className == 'edge') ? 'pref-edge edge' : className;
        }
      }

      // at least one node should be pref, pro or con node
      if (className == 'edge') {
        return null;
      }

      var attr = {
        id: data['edgeID'],
        target: target,
        source: source,
        formEdgeID: data['formEdgeID'],
        edgeID: data['edgeID'],
        className: className,
        graphID: data['graphID']
      };

      // creates model of the edge in the collection and sends POST request to a back-end service
      app.Edges.create(attr);

      return className;
    },

    clearWorkBox: function() {

      // debugger;

      // clear collections without sending DELETE requests
      while (app.Nodes.length > 0) {
        var model = app.Nodes.at(0);
        model.trigger("destroy", model);
      }

      while (app.Edges.length > 0) {
        var model = app.Edges.at(0);
        model.trigger("destroy", model);
      }

      // removes the div used for views of previous nodes.
      var divElement = this.$el[0].childNodes;

      while (divElement.length > 3) {
        divElement.forEach(function(ch) {
          if (ch.nodeName.toLowerCase() == 'div') {
            ch.outerHTML = "";
          }
        });
      }

      // removes the g used for the previous graph
      var svgElement = this.$el.children()[0].childNodes;

      while (svgElement.length > 3) {
        svgElement.forEach(function(ch) {
          if (ch.nodeName.toLowerCase() == 'g') {
            ch.outerHTML = "";
          }
        });
      }

      /* -------------------- initialisation for drawing a graph -------------------- */
      var area_id = this.el.id;

      // set the size of the SVG element using the size of a window
      var ret_chart = init_chart_data(area_id, 700);
      push_chart_data(area_id, ret_chart);

      // set the zoom functionality - In order to make zoomable screen, zoom(g element) covers whole display in the beginning.
      var zoom = set_zoom(chart.svg.el);
      chart.zoom = zoom;

      // set up simulations for force-directed graphs
      var ret_simulation = set_simulation(15, chart.svg.width, chart.svg.height);
      push_node_style_data(ret_simulation);

      // the simulation used when drawing a force-directed graph
      chart.simulation = ret_simulation.simulation;

      // reset a current Eval box
      app.evalBoxView.clear();

      return svgElement;
    }
  });
