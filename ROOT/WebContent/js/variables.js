/**
 * global variables for cispaces
 */

/*
	object for chart
*/
var chart = null;

/*
	push new chart data
*/
function push_chart_data(area_id, ret){

  var obj = {
    id: area_id,
    svg: ret.svg,
    svg_width: ret.svg_width,
    svg_height: ret.svg_height
  }

  chart = obj;
}

var link_from = null;	// flag used when making a new edge

/*
	push nodes, edges into chart
*/
function push_graph_data(ret){
	if(ret.nodes){
		chart.nodes = ret.nodes;
	}

	if(ret.edges){
		chart.edges = ret.edges;
	}

	if(ret.node){
		chart.node = ret.node;
	}

	if(ret.edge){
		chart.edge = ret.edge;
	}
}

/*
	push node_style_data values into chart
*/
function push_node_style_data(ret){

  //	data for styling each node
  var node_style_data = {
    i_width: 10,
    i_height: 10,
    a_width: 10,
    a_height: 10,
    font_size: 14
  }

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

  chart.node_style_data = node_style_data;
}
