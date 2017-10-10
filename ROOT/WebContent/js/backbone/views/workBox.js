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
            'contextmenu .node': 'onRightClick'
        },

        initialize: function() {
      			/* -------------------- initialisation for drawing a graph -------------------- */
            var area_id = this.el.id;

      			// set the size of the SVG element using the size of a window
      			var ret_chart = init_chart_data(area_id, 700);
      			push_chart_data(area_id, ret_chart);

      			// set the zoom functionality - In order to make zoomable screen, zoom(g element) covers whole display in the beginning.
      			var zoom = set_zoom(chart.svg);
            chart.zoom = zoom;

      			// set up simulations for force-directed graphs
      			var ret_simulation = set_simulation(15, chart.svg_width, chart.svg_height);
      			push_node_style_data(ret_simulation);

            // the simulation used when drawing a force-directed graph
            chart.simulation = ret_simulation.simulation;

      			getLatestAnalysis(function(data){

                // $("#modal_select_analysis").modal('show');

      				  // initiate the SVG on the work box for drawing a graph
      					if(data.graphID && !_.isEmpty(data.graphID)){
      						createCookie('graph_id', data.graphID, 2);
      					}

      					var ret_graph = draw(data.nodes, data.edges, chart);
      					push_graph_data(ret_graph);

      					chart.simulation = restart_simulation(false);
      				/* ------------------------------------------------------------------------------- */

      			});

      			this.listenTo(app.Nodes, 'add', this.addNode);
            // this.listenTo(app.Edges, 'add', this.addEdge);
        },

        onRightClick: function(obj) {

            // return native menu if pressing control
            if (obj.ctrlKey) return;

            var index = obj.currentTarget.__data__.index;
            var target = obj.currentTarget.id.substr(5);

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
								simulation = restart_simulation(true);

                            } else if (opt.currentTarget.id == "link-from") {
								app.workBoxView.changeLinkFrom(target);
                            } else if (opt.currentTarget.id == "link-to") {
                                var attr = null;

                                if (link_from == target) {
									// if the first point and the second point are same, shows an error message
									alertMessage(obj, "You can't choose the same node for connection.");
                                } else {
									// create a new model of edge
									attr = app.workBoxView.createEdge(link_from, target);

									if (attr) {
										// draw the node
										chart.edge = addNewEdge(attr);

										// re-start graph
										simulation = restart_simulation(true);

										app.workBoxView.changeLinkFrom(target);
									} else {
										// if the edge connects between i-nodes(Info, Claim), shows an error message
										alertMessage(obj, "This connection looks not correct. You should choose at least one between Pref, Con or Pro.");
									}
                                }
                            }

                            menu.hide();
                        });

            return false;
        },

		changeLinkFrom: function(target){
			if(!link_from){
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

	      // view details of node via details box
        var form_list = $("form");
        for(var i = 0 ; i < form_list.length ; i++){
          if(form_list[i].id.substr(5) == id){
            $("#" + form_list[i].id).show();
          } else {
            $("#" + form_list[i].id).hide();
          }
        }

        $("#details-node").show();
        $("#details-tweet").hide();

			return id;
    },

		createNode: function(id) {

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
			var now = new Date();

			var year = now.getFullYear();
			var month = now.getMonth() + 1;
			var date = now.getDate();
			var hour = now.getHours();
			var min = now.getMinutes();
			var sec = now.getSeconds();

			var time = year + "-" + (month < 10 ? "0" + month : month) + "-"
					+ (date < 10 ? "0" + date : date) + " "
					+ (hour < 10 ? "0" + hour : hour) + ":"
					+ (min < 10 ? "0" + min : min) + ":"
					+ (sec < 10 ? "0" + sec : sec);

			var nodeID = generateUUID(); // Math.floor(Math.random() * 1000) + 1;
			var graphID = readCookie('graph_id');

			var attr = {
			  id: nodeID,
			  text: input,
			  input: input,
			  dtg: time,
			  type: type,
			  nodeID: nodeID,
			  graphID: graphID
			};

      // creates model of the node in the collection and sends POST request to a back-end service
      app.Nodes.create(attr, {type: 'POST'});

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
			$("#details-node").append(view.render().el);
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
			if (className == 'edge') { return null; }

			var edgeID = generateUUID(); // Math.floor(Math.random() * 100000) + 1;
			var graphID = readCookie('graph_id');

			var attr = {
				id: edgeID,
				target: target,
				source: source,
				edgeID: edgeID,
				className: className,
				graphID : graphID
			};

			// creates model of the edge in the collection and sends POST request to a back-end service
			app.Edges.create(attr, {type: 'POST'});

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
			if (className == 'edge') { return null; }

            var attr = {
				id: data['edgeID'],
				target: target,
				source: source,
				formEdgeID: data['formEdgeID'],
				edgeID: data['edgeID'],
				className: className,
				graphID : data['graphID']
            };

			// creates model of the edge in the collection and sends POST request to a back-end service
            app.Edges.create(attr);

            return className;
          },

        clearWorkBox: function(){

      			// debugger;

      			// clear collections without sending DELETE requests
      			while(app.Nodes.length > 0){
      				var model = app.Nodes.at(0);
      				model.trigger("destroy", model);
      			}

      			while(app.Edges.length > 0){
      				var model = app.Edges.at(0);
      				model.trigger("destroy", model);
      			}

      			// removes the div used for views of previous nodes.
      			var divElement = this.$el[0].childNodes;

      			while(divElement.length > 3){
      				divElement.forEach(function(ch){
      					if(ch.nodeName.toLowerCase() == 'div'){
      						ch.outerHTML = "";
      					}
      				});
      			}

      			// removes the g used for the previous graph
      			var svgElement = this.$el.children()[0].childNodes;

      			while(svgElement.length > 3){
      				svgElement.forEach(function(ch){
      					if(ch.nodeName.toLowerCase() == 'g'){
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
            var zoom = set_zoom(chart.svg);
            chart.zoom = zoom;

            // set up simulations for force-directed graphs
            var ret_simulation = set_simulation(15, chart.svg_width, chart.svg_height);
            push_node_style_data(ret_simulation);

            // the simulation used when drawing a force-directed graph
            chart.simulation = ret_simulation.simulation;

            // reset a current Eval box
            app.evalBoxView.clear();

      			return svgElement;
      		}
    });
