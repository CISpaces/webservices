// js/views/toolBox.js

var app = app || {};

/**
 * ToolBox
 * ---------------------------------
 * the UI for 'toolBox'
 */

app.ToolBoxView = Backbone.View.extend({
  el: '.navbar',

  events: {
      'click #settings': 'settings',
      'click #help': 'help',

      'click #newWorkBox': 'newWorkBox',
      'click #callFile': 'file',
      'click #saveProgress' : 'save',
	    'click #history' : 'analysisHistory',

      'click .btn-sm': 'createNode'
  },

  initialize: function() {

  },

  render: function() {

  },

  settings: function() {
   // alert('settings');
  },

  help: function() {
    // alert('help');
  },

  newWorkBox: function() {
    app.workBoxView.clearWorkBox();

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

  	var graphID = generateUUID();

  	var object =  {
      "graphID"  : graphID,
      "userID" : readCookie('user_id'),
      "timest" : time,
      "isshared" : false,
      "parentgraphid" : null
    };

  	$.ajax({
  			type: 'POST',
  			url: 'VC/rest/new',
  			//dataType: 'text',
  			contentType: 'application/json',
  			data: JSON.stringify(object),
  			success: function(result){
  					createCookie('graph_id', graphID, 2);

  					/* -------------------- initialisation for drawing a graph -------------------- */
            var area_id = app.workBoxView.el.id;

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

            var ret_graph = draw([], [], chart);
            push_graph_data(ret_graph);

            chart.simulation = restart_simulation(false);

  			},
  			error: function(result){
  				alert('Something went wrong. Please try again.');
  			}
  		});
  },

  file: function() {

    app.workBoxView.clearWorkBox();

    var input_file = $("#myFile").click();

	   return input_file;
  },

  createNode: function(obj) {
    var id = obj.currentTarget.id;

	  // creates model of the node
    var attr = app.workBoxView.createNode(id);

    // var index = chart.findIndex(function(e){ return e.id == app.workBoxView.el.id; });

  	var restart = true;
  	if(chart.nodes.length < 1)
  		restart = false;

  	// draws a new node
  	chart.node = addNewNode(attr, chart);

  	// re-start changed graph
  	chart.simulation = restart_simulation(restart);
  },

  save: function(){
	  var title = prompt("Please enter a title", "Analysis1");
	  if(title != null){
		  var graphID = readCookie('graph_id');
		  var userID = readCookie('user_id');
		  var object =  { "graphID"  : graphID, "userID" : userID, "title" : title};
		  $.ajax({
			type: 'POST',
			url: 'VC/rest/save',
			//dataType: 'text',
			contentType: 'application/json',
			data: JSON.stringify(object),
			success: function(result){
				alert("Version " + title + " saved.");
			},
			error: function(result){
				alert('Something went wrong. Please try again.');
			}
		});
	  }
  },

  analysisHistory: function(){
		var graphID = readCookie('graph_id');
		var object = {"graphID"  : graphID};

  	$.get( "VC/rest/history", object )
      .done(function( result ) {
        if(result){
          $("#history_list").html("");

					if(result.history){
						var arr = result.history;
						arr.forEach(function(d){

							var options = $("<label></label>", {
								"class": "list-group-item"
							}).appendTo($("#history_list"));


							var radio_btn = $("<input/>", {
								"type": "radio",
								"name": "history_options_radio",
								"id": d.title
							}).click(function(obj){
								//display graph upon clicking on a radio button
								// console.log(d.analysis);
								if(d.analysis){
									$("#selectedAnalysis").text(d.analysis);
								}
							}).appendTo(options);

							var span = $("<span></span>", {
								"text": d.title + " Created on " + d.timest,
								"class": "history-text"
							}).appendTo(options);
						});
					}
          $("#history_result").modal('show');
        }
      });
  },

  importAnalysis: function(){
	  var analysis = document.getElementById('selectedAnalysis').innerHTML;
	  if(analysis){
		  var json = JSON.parse(analysis);
		  var object = { "graphID" : json.graphID, "nodes" : json.nodes, "edges" : json.edges };
			$.ajax({
			type: 'POST',
			url: 'VC/rest/updateAnalysis',
			contentType: 'application/json',
			data: JSON.stringify(object),
			success: function(result){
						alert('success');
					},
			error: function(result){
						alert('Error in the ajax request.');
						//callback(result);
					}
			});

		  app.workBoxView.clearWorkBox();

      var ret_graph = draw(json.nodes,json.edges, chart);
      push_graph_data(ret_graph);

      chart.simulation = restart_simulation(false);

		  $('#history_result').modal('hide');
	  }

  }
});
