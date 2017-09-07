//js/views/evalBox.js

var app = app || {};

/**
 * EvalBox
 * ---------------------------------
 * the UI for 'evalBox'
 */

app.EvalBoxView = Backbone.View.extend({
	el: '#eval_box',

	events: {
		'click #evaluate': 'evaluate',
		'click #clear': 'clear',
		'click #nlg': 'nlg'
	},

	initialize: function(){
		// this.$el.attr('style', 'display: none');
	},

	render: function(){

	},

	evaluate: function(){
		
		app.evalBoxView.clear();

		var param = {
			"action": "eval",
			"graph": {
				"uncert": "OFF",
				"nodes": app.Nodes.toJSON(),
				"edges": app.Edges.toJSON()
			}
		}
		
	    $.ajax({
			type : "POST",
			contentType: "application/json",
			// dataType : "application/json",
			url : "/ers/rest/WriteRules",
			data : JSON.stringify(param),
			success : function(data) {
				// console.log(data);
				
				if(data){
					if(data.fail){
						// when evalutation is failed, the reason will be shown
						$("#eval_fail_msg").text(data.cause);
						$("#eval_fail").show();
						
						// colors and chunks should be hidden
						$("#eval_colors").hide();						
						$("#eval_chunks").hide();
					} else {
						// makes a list of evaluation options from the result
						var colors_keys = Object.keys(data.colors);
						
						// First row is for explaining which color means
						var explain = $("<label></label>", {
							"class": "list-group-item"
						}).appendTo($("#eval_colors"));
						
						var span = $("<span></span>", {
							"text": "Success",
							"class": "evalbox-text",
							"style": "color: #31a354; font-weight: bold;"
						}).appendTo(explain);
						
						var span = $("<span></span>", {
							"text": "Fail",
							"class": "evalbox-text",
							"style": "color: #f03b20; font-weight: bold;"
						}).appendTo(explain);
						
						var span = $("<span></span>", {
							"text": "Question",
							"class": "evalbox-text",
							"style": "color: #feb24c; font-weight: bold;"
						}).appendTo(explain);
							
						// makes a list of evaluation colours according to the result
						colors_keys.forEach(function(d){
							
							var options = $("<label></label>", {
								"class": "list-group-item"
							}).appendTo($("#eval_colors"));							
							
							var radio_btn = $("<input/>", {
								"type": "radio",
								"name": "eval_options_radio",
								"id": d
							}).click(function(obj){		
							
								// before evaluated colors are displayed, previous colors are removed
								graph_data.nodes.forEach(function(d){
									$("#draw_" + d.nodeID + " text")
										.removeAttr("class");
								});
								
								var targetID = obj.currentTarget.id;								
								app.evalBoxView.clickColors(targetID, data.colors);
								
							}).appendTo(options);
							
							var span = $("<span></span>", {
								"text": d,
								"class": "evalbox-text"
							}).appendTo(options);
						});
						
						// makes a list of evaluation chunks according to the result
						var chunks_keys = Object.keys(data.chunks);
						
						var color = d3.scaleOrdinal(d3.schemeCategory10);
						
						chunks_keys.forEach(function(d, index){	

							var chunks = $("<label></label>", {
								"class": "list-group-item"
							}).appendTo($("#eval_chunks"));									
							
							var checkbox_btn = $("<input/>", {
								"type": "checkbox",
								"name": "eval_chunks_checkbox",
								"id": d
							}).click(function(obj){			
								var targetID = obj.currentTarget.id;							
								app.evalBoxView.clickChunks(targetID, data.chunks);								
							}).appendTo(chunks);
							
							var span = $("<span></span>", {
								"text": d,
								"class": "evalbox-text"
							}).appendTo(chunks);
							
							var div = $("<div></div>", {
								"style": "background-color: " + color(index),
								"id": "color_" + d,
								"class": "evalbox-square"
							}).appendTo(chunks);
						});

						// error message should be hidden
						$("#eval_fail").hide();

						// colors and chunks should be shown
						$("#eval_colors").show();
						$("#eval_chunks").show();

					}
				}
			},
			error : function(e) {
				console.log(e);
			}
	   });
	},

	clear: function(){

		// clear all style which were changed by Eval Box
		graph_data.nodes.forEach(function(d){
			$("#draw_" + d.nodeID + " text")
				.removeAttr("class");
			
			$("#draw_" + d.nodeID + " rect")
				.removeAttr("stroke")
				.removeAttr("stroke-width");

			$("#node_" + d.nodeID + " .modal_eval_value")
				.html("<em>N/A</em>");

		});
	
		// error message should be hidden
		$("#eval_fail").hide();
		
		$("#eval_colors").html("");						
		$("#eval_chunks").html("");
	},

	nlg: function(){
		
		var param = {
			"action": "nlg",
			"graph": {
				"nodes": app.Nodes.toJSON(),
				"edges": app.Edges.toJSON()
			}
		}
		
	    $.ajax({
			type : "POST",
			contentType: "application/json",
			// dataType : "application/json",
			url : "/ers/rest/WriteRules",
			data : JSON.stringify(param),
			success : function(result) {		
				if(result){
					$("#nlg_result_fail").text(result.fail);
					
					if(result.text){
						$("#nlg_result_text").text(result.text);
					} else {
						$("#nlg_result_text").text(" ");
					}
					
					$("#nlg_result").modal('show');
				}
			},
			error : function(e) {
				console.log(e);
			}
	   });
	},
	
	clickColors: function(targetID, colors){
		
		var target = colors[targetID];
		var keys = Object.keys(target);
		
		keys.forEach(function(d){
			var eval_value = target[d];
			
			// the strike of text are changed accordin to evaluated values
			var className = null;
			if(eval_value == "V"){
				className = "success";
			} else if(eval_value == "X"){
				className = "fail";
			} else if(eval_value =="?"){
				className = "question";
			}
			
			$("#draw_" + d + " text").addClass(className);
			$("#node_" + d + " .modal_eval_value").html("<em>" + eval_value + "</em>");
		});
		
		return keys;
	},
	
	clickChunks: function(targetID, chunks){
		
		var target_nodes = chunks[targetID]["nodes"];
		
		if(target_nodes && target_nodes.length > 0){
			var styleAttr = $("#color_" + targetID)[0].attributes['style'].value;
			
			var color_start = styleAttr.valueOf().indexOf('#');
			
			var backgroundColor = styleAttr.valueOf().substring(color_start, color_start + 7);
			
			// show or clear the evaluated chunks according to whether checkbox is checked or not
			var checked = ($("input[id=" + targetID + "]:checked").length > 0);
			
			if(checked){									
				target_nodes.forEach(function(d){
					var nodeID = d.nodeID;
					
					$("#draw_" + nodeID + " rect")
						.attr("stroke", backgroundColor)
						.attr("stroke-width", "3px");
				});
			} else {
				target_nodes.forEach(function(d){
					var nodeID = d.nodeID;
					
					$("#draw_" + nodeID + " rect")
						.removeAttr("stroke")
						.removeAttr("stroke-width");
				});
			}
		}

		return target_nodes;		
	}
});
