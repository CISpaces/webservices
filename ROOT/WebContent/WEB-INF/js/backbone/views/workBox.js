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
            'click .node': 'editForm',
            'contextmenu .node': 'onRightClick'
          },

          initialize: function() {
            // var dataset = d3.json("data/Cap16_MilesLarge_All(2).cis", draw);

            // var dataset = d3.json("data/new-analysis(2).cis", draw);

            this.listenTo(app.Nodes, 'add', this.addNode);
            // this.listenTo(app.Edges, 'add', this.addEdge);
          },

          render: function() {

          },

          onRightClick: function(obj) {

            // return native menu if pressing control
            if (obj.ctrlKey) return;

            var index = obj.currentTarget.__data__.index;
            var id = obj.currentTarget.id.substr(5);
            /*
             * if( link_from ){ } else { $("#link-from").attr("class", "btn
             * btn-link"); $("#link-to").attr("class", "btn btn-link disabled"); }
             */

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

                                deleteNode(index);

                                var node_model = app.Nodes.get(id);
                                node_model.destroy();

                                var deleted_edges = deleteEdge(id);

                                deleted_edges.forEach(function(e) {
                                  var edge_model = app.Edges.get(e.edgeID);
                                  edge_model.destroy();
                                });

                              } else if (opt.currentTarget.id == "link-from") {
                                link_from = id;
                                $("#draw_" + link_from + " rect").toggleClass(
                                        "node-highlight");

                                $("#link-from").toggleClass("disabled");
                                $("#link-to").toggleClass("disabled");
                              } else if (opt.currentTarget.id == "link-to") {

                                var res = true;

                                if (link_from === id) {

                                  debugger;
                                  $(".alert-danger span")
                                          .html(
                                                  "You choose the same node for connection.");
                                  $(".alert-danger").show().css({
                                    "position": "absolute",
                                    "left": obj.pageX,
                                    "top": obj.pageY,
                                    // "z-index": 1000,
                                    "width": "220px"
                                  }).on('click', 'a', function(obj) {
                                    $(".alert-danger").hide();
                                  });

                                } else {
                                  res = app.workBoxView.createEdge(link_from,
                                          id);
                                }

                                if (res) {
                                  $("#draw_" + link_from + " rect")
                                          .toggleClass("node-highlight");
                                  link_from = null;

                                  $("#link-from").toggleClass("disabled");
                                  $("#link-to").toggleClass("disabled");
                                } else {
                                  $(".alert-danger span")
                                          .html(
                                                  "This connection looks not correct. You should choose at least one between Pref, Con or Pro.");
                                  $(".alert-danger").show().css({
                                    "position": "absolute",
                                    "left": obj.pageX,
                                    "top": obj.pageY,
                                    "z-index": 1000,
                                    "width": "220px"
                                  }).on('click', 'a', function(obj) {
                                    $(".alert-danger").hide();
                                  });
                                }
                              }

                              menu.hide();
                            });

            return false;
          },

          editForm: function(obj) {
            var id = obj.currentTarget.id;
            id = id.substr(5);

            $("#node_" + id).modal('show');
          },

          createNode: function(id) {
            var input = id.toUpperCase();

            var now = new Date();

            var year = now.getFullYear();
            var month = now.getMonth() + 1;
            var date = now.getDate();
            var hour = now.getHours();
            var min = now.getMinutes();
            var sec = now.getSeconds();

            var time = year + "/" + (month < 10 ? "0" + month : month) + "/"
                    + (date < 10 ? "0" + date : date) + " "
                    + (hour < 10 ? "0" + hour : hour) + ":"
                    + (min < 10 ? "0" + min : min) + ":"
                    + (sec < 10 ? "0" + sec : sec);

            var type = "I";
            if (input == "PREF") {
              type = "P";
            } else if (input == "PRO") {
              type = "RA";
            } else if (input == "CON") {
              type = "CA";
            }

            var nodeID = Math.floor(Math.random() * 1000) + 1;

            var attr = {
              id: nodeID,
              text: input,
              input: input,
              dtg: time,
              type: type,
              nodeID: nodeID
            }
            app.Nodes.create(attr);

            addNewNode(attr);
          },

          createNodeFromFile: function(data) {
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
              annot: data['annot']
            }

            app.Nodes.create(attr);
          },

          addNode: function(node) {
            var view = new app.NodeView({
              model: node
            });
            this.$el.append(view.render().el);
          },

          createEdge: function(source, target) {

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
                className = (className == 'edge') ? 'pref-edge edge'
                        : className;
              }
            }

            if (className == 'edge') { return false; }

            var edgeID = Math.floor(Math.random() * 100000) + 1;

            var attr = {
              id: edgeID,
              target: target,
              source: source,
              edgeID: edgeID,
              className: className
            }

            app.Edges.create(attr);

            addNewEdge(attr);

            return true;
          },

          createEdgeFromFile: function(data) {
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
                className = (className == 'edge') ? 'pref-edge edge'
                        : className;
              }
            }

            var attr = {
              id: data['edgeID'],
              target: target,
              source: source,
              formEdgeID: data['formEdgeID'],
              edgeID: data['edgeID'],
              className: className
            }

            app.Edges.create(attr);

            return className;
          },

        clearWorkBox: function(){
			// app.Nodes.clear();
			_.invoke(app.Nodes.toArray(), 'destroy');
			
			// app.Edges.clear();
			_.invoke(app.Edges.toArray(), 'destroy');
			
			var svgElement = this.$el.children()[0].childNodes;
			svgElement.forEach(function(ch){
				if(ch.nodeName == 'g'){
					ch.outerHTML = "";
				}
			});
		}
        });