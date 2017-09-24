/**
 * global functions for cispaces
 */
function generateUUID() {
	var d = new Date().getTime();
	
	var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		var r = (d + Math.random()*16)%16 | 0;
		d = Math.floor(d/16);
		return (c=='x' ? r : (r&0x7|0x8)).toString(16);
	});
	
	return uuid;
}

function readFile(input_files){
	
	var file = input_files[0];
	
	var reader = new FileReader();

	reader.onload = function(progressEvent){
	  
		// Entire file
		var jsonData = JSON.parse(this.result);

		var nodes = jsonData['nodes'];
		var edges = jsonData['edges'];
			
		// set up simulations for force-directed graphs
		var ret_simulation = set_simulation(nodes.length);
		sync_node_style_data(ret_simulation);
		sync_simulation_data(ret_simulation);
		
		var ret_graph = draw(nodes, edges);
		sync_graph_data(ret_graph);
		
		// start simulation for displaying graphs
		simulation = restart_simulation(false);
	};

	reader.onerror = function(event){
		console.log("Fail to read the file:");
		console.log(event);
	};

	reader.readAsText(file);
	
	return reader;
}

function alertMessage(obj, msg){
	// if the edge connects between i-nodes(Info, Claim), shows an error message
	var alert_msg = $(".alert-danger span").html(msg);
	$(".alert-danger").show().css({
		"position": "absolute",
		"left": obj.pageX,
		"top": obj.pageY,
		"z-index": 1000,
		"width": "220px"
	}).on('click', 'a', function(obj) {
		$(".alert-danger").hide();
	});
	
	return alert_msg;
}

/**
 * global variables for cispaces
 */

/*
	data for svg
*/
var chart_data = {
  margin_width: 3,
  margin_height: 3,
  min_svg_height: 700,
  
  svg_width: null,
  svg_height: null,
  svg: null
}

/*
	synchronise returned values and chart_data variables
*/
function sync_chart_data(ret){
	if(ret.svg){
		chart_data.svg = ret.svg;
	}
	
	if(ret.svg_width || ret.svg_width == 0){
		chart_data.svg_width = ret.svg_width;
	}
	
	if(ret.svg_height || ret.svg_height == 0){
		chart_data.svg_height = ret.svg_height;
	}
}

var zoom = null;		// In order to make zoomable screen, zoom(g element) covers whole display in the beginning.

var link_from = null;	// flag used when making a new edge

/*
	data for nodes/edges
*/
var graph_data = {
	nodes: null,
	edges: null,
	
	node: null,
	edge: null
}

/*
	synchronise returned values and graph_data variables
*/
function sync_graph_data(ret){
	if(ret.nodes){
		graph_data.nodes = ret.nodes;
	}
	
	if(ret.edges){
		graph_data.edges = ret.edges;
	}
	
	if(ret.node){
		graph_data.node = ret.node;
	}
	
	if(ret.edge){
		graph_data.edge = ret.edge;
	}
}

/*
	data for styling each node
*/
var node_style_data = {
  i_width: 10,
  i_height: 10,
  a_width: 10,
  a_height: 10,
  font_size: 14
}

/*
	synchronise returned values and node_style_data variables
*/
function sync_node_style_data(ret){
	
	if(ret.i_width || ret.i_width == 0){
		node_style_data.i_width = ret.i_width;
	}
	
	if(ret.i_height || ret.i_height == 0){
		node_style_data.i_height = ret.i_height;
	}
	
	if(ret.a_width || ret.a_width == 0){
		node_style_data.a_width = ret.a_width;
	}
	
	if(ret.a_height || ret.a_height == 0){
		node_style_data.a_height = ret.a_height;
	}	
	
	if(ret.font_size || ret.font_size == 0){
		node_style_data.font_size = ret.font_size;
	}
}

/*
	data for simulating a force-directed graph
*/
var simulation_data = {
  distance: 60,
  charge_strength: -100
}

var simulation = null;	// the simulation used when drawing a force-directed graph

/*
	synchronise returned values and simulation_data variables
*/
function sync_simulation_data(ret){

	if(ret.distance || ret.distance == 0){
		simulation_data.distance = ret.distance;
	}

	if(ret.charge_strength || ret.charge_strength == 0){
		simulation_data.charge_strength = ret.charge_strength;
	}

	if(ret.simulation){
		simulation = ret.simulation;
	}
}