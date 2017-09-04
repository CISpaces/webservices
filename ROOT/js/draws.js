/**
 * draws.js: visualises graphs using JSON data
 */

/* scale functions for assigning node's sizes (width, height and font size) and distances between nodes */
var i_node_size_scales = d3.scaleLinear().domain([1, 250]).range([34, 17]);
var a_node_size_scales = d3.scaleLinear().domain([1, 250]).range([26, 13]);

var font_size_scales = d3.scaleLinear().domain([1, 250]).range([14, 10]);

var distance_scales = d3.scaleLinear().domain([1, 250]).range([50, 10]);
var charge_scales = d3.scaleLinear().domain([1, 250]).range([-200, -70]);

function init_chart_data(){
	var ret = {};
	
	ret.svg_width = $('#d3-area-chart').width();
	ret.svg_height = $('#d3-area-chart').height() < chart_data.min_svg_height ? chart_data.min_svg_height : $('#d3-area-chart').height();

	ret.svg = d3.select('svg')
	.attr('width', ret.svg_width + 'px')
	.attr('height', ret.svg_height + 'px');
	
	return ret;
}

function set_simulation(nodes_length){
	
	var ret = {};
	
	ret.i_width = i_node_size_scales(nodes_length);
	ret.i_height = i_node_size_scales(nodes_length);
	
	ret.a_width = a_node_size_scales(nodes_length);
	ret.a_height = a_node_size_scales(nodes_length);
	
	ret.font_size = font_size_scales(nodes_length);

	ret.distance = distance_scales(nodes_length);
	ret.charge_strength = charge_scales(nodes_length);

	ret.simulation = d3.forceSimulation()
	.force("link", d3.forceLink().id(function(d) { return d.nodeID; }).distance(ret.distance))
	.force("charge", d3.forceManyBody().theta(0.5).distanceMin(ret.min_distance).strength(ret.charge_strength))
	.force("center", d3.forceCenter(chart_data.svg_width / 2, chart_data.svg_height / 2));
	
	return ret;
}

function set_zoom(){	
	
	// add encompassing group for the zoom
	var ret = chart_data.svg.append("g")
	.attr("class", "zoom");
	
	// add zoom capabilities
	var zoom_handler = d3.zoom().on("zoom", function(){
		ret.attr("transform", d3.event.transform);
	});

	zoom_handler(chart_data.svg);
	
	return ret;
}

function draw(nodes, edges){
	
	var ret = {};
	
	ret.nodes = nodes;
	ret.edges = edges;
	
	ret.node = zoom.append("g")
	.attr("class", "nodes")
	.selectAll("g")
	.data(ret.nodes)
	.enter().append("g")
	.attr("id", function(d){
		return "draw_" + d['nodeID'];
	})
	.attr("class", "node")
	.call(d3.drag()
			.on("start", dragstarted)
			.on("drag", dragged)
			.on("end", dragended));

	ret.node.append("rect")
	.attr("x", -8)
	.attr("y", -8)
	.attr("width", function(d){
		if(d['type'] == "I"){
			return node_style_data.i_width;
		} else {
			return node_style_data.a_width;
		}
	})
	.attr("height", function(d){
		if(d['type'] == "I"){
			return node_style_data.i_height;
		} else {
			return node_style_data.a_height;
		}
	})
	.attr("rx", function(d){
		if(d['type'] == "I"){
			return node_style_data.i_width/8;
		} else if(d['type'] == "P"){
			return node_style_data.a_width/4;
		} else {
			return node_style_data.a_width/2;
		}
	})
	.attr("class", function(d){
		var className = null;
		if(d['type'] == "I"){
			className = d['input'].toLowerCase() + '-node';
		} else if(d['type'] == "P"){
			className = 'pref-node';
		} else {
			className = (d['type'] == "CA")? 'con-node' : 'pro-node';
		}
		
		if(d['eval'] == "V"){
			className += ' node-eval success';
		} else if(d['eval'] == "X"){
			className += ' node-eval fail';
		} else if(d['eval'] == "?"){
			className += ' node-eval question';
		}
		
		return className;
	})
	.append("title")
	.text(function(d) { return d['text']; });

	ret.node.append("text")
	.attr("dx", 12)
	.attr("dy", ".35em")
	.attr("font-size", node_style_data.font_size)
	.text(function(d) { return parseText(d['text']); });

	ret.node.each( function(d){
		// debugger;
		app.workBoxView.createNodeModelFromData(d);
	});	

	ret.edge = zoom.append("g")
	.attr("class", "links")
	.selectAll("line")
	.data(ret.edges)
	.enter().append("line")
	.attr("marker-end", "url(#triangle)")
	.attr("class", function(d){
		var className = app.workBoxView.createEdgeModelFromData(d);
		// debugger;
		if(className.includes('pref-')){
			this.setAttribute('marker-end', 'url(#pref-triangle)');
		} else if(className.includes('con-')){
			this.setAttribute('marker-end', 'url(#con-triangle)');
		} else if(className.includes('pro-')){
			this.setAttribute('marker-end', 'url(#pro-triangle)');
		}
		
		return className;
	});
	
	return ret;
}

function dragstarted(d) {
	if (!d3.event.active) simulation.alphaTarget(0.3).restart();
	d.fx = d.x;
	d.fy = d.y;
}

function dragged(d) {
	d.fx = d3.event.x;
	d.fy = d3.event.y;
}

function dragended(d) {
	if (!d3.event.active) simulation.alphaTarget(0);
	d.fx = null;
	d.fy = null;
}

function ticked() {
	graph_data.edge
	.attr("x1", function(d) { 
		return d.source.x + node_style_data.a_width/4; 
	})
	.attr("y1", function(d) { 
		return d.source.y + node_style_data.a_height/4; 
	})
	.attr("x2", function(d) { 
		if(d.source.x < d.target.x){
			return d.target.x;
		} else {
			return d.target.x + node_style_data.a_width/2;
		}		
	})
	.attr("y2", function(d) {		
		if(d.source.y < d.target.y){
			return d.target.y;
		} else {
			return d.target.y + node_style_data.a_height/2;
		}
	});

	graph_data.node
	.attr("x", function(d) { return d.x; })
	.attr("y", function(d) { return d.y; })
	.attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
}

function restart_simulation(restart){
	
	var ret_simulation = simulation;
	
	if(!restart){
		ret_simulation.nodes(graph_data.nodes)
		.on("tick", ticked);

		ret_simulation.force("link")
		.links(graph_data.edges);
	} else {
		// Update and restart the simulation.
		ret_simulation.nodes(graph_data.nodes);
		ret_simulation.force("link").links(graph_data.edges);
		
		ret_simulation.restart();
	}
	
	return ret_simulation;
}

function addNewNode(attr){
	
	var data = {
			"source": "user",
			"uncert":"Confirmed",
			"eval":"N/A",
			"text": attr['text'],
			"input": attr['input'],
			"dtg": attr['dtg'],
			"commit":"N/A",
			"type": attr['type'],
			"nodeID": attr['nodeID'],
			"annot": {
				"conc":{},
				"prem_assump":{}
			}
	}
	
	graph_data.nodes.push(data);
		
	// Apply the general update pattern to the nodes.
	graph_data.node = graph_data.node.data(graph_data.nodes, function(d) { return d.nodeID; });
	graph_data.node.exit().remove();

	var ret_node = graph_data.node.enter()
		.append("g")
		.attr("id", "draw_" + data['nodeID'])
		.attr("class", "node")
		.call(d3.drag()
		.on("start", dragstarted)
		.on("drag", dragged)
		.on("end", dragended))
		.merge(graph_data.node);

	var new_node = d3.select("#draw_" + data['nodeID']);

	new_node.append("rect")
	.attr("x", -8)
	.attr("y", -8)	
	.attr("width", function(d){
		if(d['type'] == "I"){
			return node_style_data.i_width;
		} else {
			return node_style_data.a_width;
		}
	})
	.attr("height", function(d){
		if(d['type'] == "I"){
			return node_style_data.i_height;
		} else {
			return node_style_data.a_height;
		}
	})
	.attr("rx", function(d){
		if(d['type'] == "I"){
			return node_style_data.i_width/8;
		} else if(d['type'] == "P"){
			return node_style_data.a_width/4;
		} else {
			return node_style_data.a_width/2;
		}
	})
	.attr("class", function(d){
		if(d['type'] == "I"){
			return d['input'].toLowerCase() + '-node';
		} else if(d['type'] == "P"){
			return 'pref-node';
		} else {
			return (d['type'] == "CA")? 'con-node' : 'pro-node';
		}
	})		
	.append("title")
	.text(function(d) { return d['text']; });

	new_node.append("text")
	.attr("dx", 12)
	.attr("dy", ".35em")
	.attr("font-size", node_style_data.font_size)
	.text(parseText(data['text']));
	
	return ret_node;
}

function deleteNode(index){

	var ret = graph_data.nodes.splice(index, 1);

	// Apply the general update pattern to the nodes.
	graph_data.node = graph_data.node.data(graph_data.nodes, function(d) { return d.nodeID; });
	graph_data.node.exit().remove();
	
	return ret;
}

function addNewEdge(attr){

	// debugger;

	var data = {
			"target": attr['target'],
			"source": attr['source'],
			"formEdgeID": null,
			"edgeID": attr['edgeID']
	}

	graph_data.edges.push(data);

	// Apply the general update pattern to the edges.
	graph_data.edge = graph_data.edge.data(graph_data.edges, function(d) { return d.edgeID; });
	graph_data.edge.exit().remove();
	
	var className = attr['className'];
	var markerClass = "url(#triangle)";
	
	if(className.includes('pref-')){
		markerClass = "url(#pref-triangle)";
	} else if(className.includes('con-')){
		markerClass = "url(#con-triangle)";
	} else if(className.includes('pro-')){
		markerClass = "url(#pro-triangle)";
	}
	
	var ret_edge = graph_data.edge.enter()
	.append("line")
	.attr("marker-end", markerClass)
	.attr("class", className)
	.merge(graph_data.edge);	
	
	return ret_edge;
}

function deleteEdge(id){

	var deleted_edges = [];

	graph_data.edges = graph_data.edges.filter(function(e){
		if(e['source']['nodeID'] == id || e['target']['nodeID'] == id){
			deleted_edges.push(e);
		}
		return (e['source']['nodeID'] != id && e['target']['nodeID'] != id);
	});

	// Apply the general update pattern to the links.
	graph_data.edge = graph_data.edge.data(graph_data.edges, function(d) { return d.edgeID; });
	graph_data.edge.exit().remove();

	return deleted_edges;
}
function parseText(content){

	var result = "";

	if(content){
		if(content.length < 12){
			result = content;
		} else {
			var split = content.split(' ');
			if(split.length == 1 || split.length == 2){
				result = content;
			} else {
				result = split[0] + ' ' + split[1] + "...";
			}
		}
	}

	return result;
}