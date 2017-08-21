/**
 * loads data from json file and visualises graphs
 */

var svg_width = $('#d3-area-chart').width();
var svg_height = $('#d3-area-chart').height() < chart_const.min_svg_height ? chart_const.min_svg_height : $('#d3-area-chart').height();

var svg = d3.select('svg')
.attr('width', svg_width + 'px')
.attr('height', svg_height + 'px');

var i_node_size_scales = d3.scaleLinear().domain([1, 250]).range([34, 17]);
var a_node_size_scales = d3.scaleLinear().domain([1, 250]).range([26, 13]);

var font_size_scales = d3.scaleLinear().domain([1, 250]).range([14, 10]);

var distance_scales = d3.scaleLinear().domain([1, 250]).range([50, 10]);
var charge_scales = d3.scaleLinear().domain([1, 250]).range([-100, -10]);

var simulation = null;

var nodes = null;
var edges = null;

var node = null;
var edge = null;

var zoom = null;

var link_from = null;

function draw(dataset){

	if(!dataset){
		alert("There is no dataset!");
		return null;
	}	

	nodes = dataset['nodes'];
	edges = dataset['edges'];

	node_const.i_width = i_node_size_scales(nodes.length);
	node_const.i_height = i_node_size_scales(nodes.length);
	
	node_const.a_width = a_node_size_scales(nodes.length);
	node_const.a_height = a_node_size_scales(nodes.length);
	
	node_const.font_size = font_size_scales(nodes.length);

	sim_const.distance = distance_scales(nodes.length);
	sim_const.charge_strength = charge_scales(nodes.length);

	simulation = d3.forceSimulation()
	.force("link", d3.forceLink().id(function(d) { return d.nodeID; }).distance(sim_const.distance))
	.force("charge", d3.forceManyBody().theta(0.5).distanceMin(sim_const.min_distance).strength(sim_const.charge_strength))
	.force("center", d3.forceCenter(svg_width / 2, svg_height / 2));

	// add encompassing group for the zoom
	zoom = svg.append("g")
	.attr("class", "zoom");

	node = zoom.append("g")
	.attr("class", "nodes")
	.selectAll("g")
	.data(nodes)
	.enter().append("g")
	.attr("id", function(d){
		return "draw_" + d['nodeID'];
	})
	.attr("class", "node")
	.call(d3.drag()
			.on("start", dragstarted)
			.on("drag", dragged)
			.on("end", dragended));

	node.append("rect")
	.attr("x", -8)
	.attr("y", -8)
	.attr("width", function(d){
		if(d['type'] == "I"){
			return node_const.i_width;
		} else {
			return node_const.a_width;
		}
	})
	.attr("height", function(d){
		if(d['type'] == "I"){
			return node_const.i_height;
		} else {
			return node_const.a_height;
		}
	})
	.attr("rx", function(d){
		if(d['type'] == "I"){
			return node_const.i_width/8;
		} else if(d['type'] == "P"){
			return node_const.a_width/4;
		} else {
			return node_const.a_width/2;
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

	node.append("text")
	.attr("dx", 12)
	.attr("dy", ".35em")
	.attr("font-size", node_const.font_size)
	.text(function(d) { return parseText(d['text']); });

	node.each( function(d){
		// debugger;
		app.workBoxView.createNodeFromFile(d);
	});	

	edge = zoom.append("g")
	.attr("class", "links")
	.selectAll("line")
	.data(edges)
	.enter().append("line")
	.attr("marker-end", "url(#triangle)")
	.attr("class", function(d){
		var className = app.workBoxView.createEdgeFromFile(d);
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

	simulation.nodes(nodes)
	.on("tick", ticked);

	simulation.force("link")
	.links(edges);

	// add zoom capabilities
	var zoom_handler = d3.zoom()
	.on("zoom", zoom_actions);

	zoom_handler(svg); 
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
	edge
	.attr("x1", function(d) { 
		return d.source.x + node_const.a_width/4; 
	})
	.attr("y1", function(d) { 
		return d.source.y + node_const.a_height/4; 
	})
	.attr("x2", function(d) { 
		if(d.source.x < d.target.x){
			return d.target.x;
		} else {
			return d.target.x + node_const.a_width/2;
		}		
	})
	.attr("y2", function(d) {		
		if(d.source.y < d.target.y){
			return d.target.y;
		} else {
			return d.target.y + node_const.a_height/2;
		}
	});

	node
	.attr("x", function(d) { return d.x; })
	.attr("y", function(d) { return d.y; })
	.attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
}

// Zoom functions
function zoom_actions(){
	zoom.attr("transform", d3.event.transform);
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

	nodes.push(data);

	// Apply the general update pattern to the nodes.
	node = node.data(nodes, function(d) { return d.nodeID; });
	node.exit().remove();

	node = node.enter()
	.append("g")
	.attr("id", "draw_" + data['nodeID'])
	.attr("class", "node")
	.call(d3.drag()
			.on("start", dragstarted)
			.on("drag", dragged)
			.on("end", dragended))
			.merge(node);

	var new_node = d3.select("#draw_" + data['nodeID']);

	new_node.append("rect")
	.attr("x", -8)
	.attr("y", -8)	
	.attr("width", function(d){
		if(d['type'] == "I"){
			return node_const.i_width;
		} else {
			return node_const.a_width;
		}
	})
	.attr("height", function(d){
		if(d['type'] == "I"){
			return node_const.i_height;
		} else {
			return node_const.a_height;
		}
	})
	.attr("rx", function(d){
		if(d['type'] == "I"){
			return node_const.i_width/8;
		} else if(d['type'] == "P"){
			return node_const.a_width/4;
		} else {
			return node_const.a_width/2;
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
	.attr("font-size", node_const.font_size)
	.text(parseText(data['text']));

	// Update and restart the simulation.
	simulation.nodes(nodes);
	simulation.force("link").links(edges);
	simulation.restart();
}

function deleteNode(index){

	nodes.splice(index, 1);

	// Apply the general update pattern to the nodes.
	node = node.data(nodes, function(d) { return d.nodeID; });
	node.exit().remove();

	// Update and restart the simulation.
	simulation.nodes(nodes);
	simulation.force("link").links(edges);
	simulation.restart();
}

function addNewEdge(attr){

	// debugger;

	var data = {
			"target": attr['target'],
			"source": attr['source'],
			"formEdgeID": null,
			"edgeID": attr['edgeID']
	}

	edges.push(data);

	// Apply the general update pattern to the edges.
	edge = edge.data(edges, function(d) { return d.edgeID; });
	edge.exit().remove();
	
	var className = attr['className'];
	var markerClass = "url(#triangle)";
	
	if(className.includes('pref-')){
		markerClass = "url(#pref-triangle)";
	} else if(className.includes('con-')){
		markerClass = "url(#con-triangle)";
	} else if(className.includes('pro-')){
		markerClass = "url(#pro-triangle)";
	}
	

	edge = edge.enter()
	.append("line")
	.attr("marker-end", markerClass)
	.attr("class", className)
	.merge(edge);		

	/*
   * var new_node = d3.select("#draw_" + data['nodeID']);
   * 
   * new_node.append("rect") .attr("x", -8) .attr("y", -8) .attr("width",
   * node_const.width) .attr("height", node_const.height) .attr("rx",
   * function(d){ if(d['type'] == "I"){ return node_const.width/8; } else
   * if(d['type'] == "P"){ return node_const.width/4; } else { return
   * node_const.width/2; } }) .attr("class", function(d){ if(d['type'] == "I"){
   * return d['input'].toLowerCase() + '-node'; } else if(d['type'] == "P"){
   * return 'pref-node'; } else { return (d['type'] == "CA")? 'con-node' :
   * 'pro-node'; } }) .append("title") .text(function(d) { return d['text']; });
   * 
   * new_node.append("text") .attr("dx", 12) .attr("dy", ".35em")
   * .attr("font-size", node_const.font_size) .text(parseText(data['text']));
   */

	// Update and restart the simulation.
	simulation.nodes(nodes);
	simulation.force("link").links(edges);
	simulation.restart();
}

function deleteEdge(id){

	var deleted_edges = [];

	edges = edges.filter(function(e){
		if(e['source']['nodeID'] == id || e['target']['nodeID'] == id){
			deleted_edges.push(e);
		}
		return (e['source']['nodeID'] != id && e['target']['nodeID'] != id);
	});

	// Apply the general update pattern to the links.
	edge = edge.data(edges, function(d) { return d.edgeID; });
	edge.exit().remove();

	// Update and restart the simulation.
	simulation.nodes(nodes);
	simulation.force("link").links(edges);
	simulation.restart();

	return deleted_edges;
}

function drawOneEdge(data){

	var g = d3.select('svg')
	.append('g')		
	.attr('id', 'draw_' + data['nodeID']);

	var node = null;

	if(data['type'] == "I"){	
		node = g.append('rect')
		.attr('width', graph.width + 'px')
		.attr('height', graph.height + 'px')
		.attr('class', data['input'].toLowerCase() + 'Node node')
		.call(d3.drag()
				.on("start", dragstarted)
				.on("drag", dragged)
				.on("end", dragended));
	} else if(data['type'] == "P"){
		/*
     * node = g.append('polygon') .attr('points', function(d){ if(x == 0){ x =
     * graph.width/2; } if(y == 0){ y = graph.height/2; }
     * 
     * var first = x + " " + (y - graph.height/2); var second = (x -
     * graph.width/2) + " " + y; var third = x + " " + (y + graph.height/2); var
     * fourth = (x + graph.width/2) + " " + y;
     * 
     * return first + ", " + second + ", " + third + ", " + fourth; })
     * .attr('class', 'prefNode node');
     */
	} else {
		node = g.append('circle')
		.attr('r', graph.radius + 'px')
		.attr('class', (data['type'] == "CA")? 'conNode node' : 'proNode node')
		.call(d3.drag()
				.on("start", dragstarted)
				.on("drag", dragged)
				.on("end", dragended));
	}

	// node.append('title').text(data.text);

	/*
   * var tspan = graph.parseText(data['text'], data['x'], data['y']);
   * 
   * g.append('text') .attr('x', graph.margin_width + x) .attr('y',
   * graph.margin_height + y) .attr('width', graph.width + 'px') .attr('height',
   * graph.height + 'px') .html(tspan);
   */
}

function updateText(data){

	d3.select('#draw_' + data['nodeID'] + ' text').html(parseText(data['text']));
	d3.select('#draw_' + data['nodeID'] + ' rect title').text(data['text']);
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

function readFile(input_files){
	// console.log(input_files);
	
	var file = input_files[0];
		
		var data = null;
		
		 var reader = new FileReader();
		 
		  reader.onload = function(progressEvent){
			  
			// Entire file
			// console.log(this.result);
			data = this.result;	
	  
			// console.log(data);
			
			var jsonData = JSON.parse(data);

			draw(jsonData);
		  };
		  
		 reader.onerror = function(event){
			 console.log(event);
		 };
		 
		 reader.onloadend = function(event){
			 console.log("onloadend");
		 };
		 
		 reader.onprogress = function(event){
			 console.log("onprogress");
		 };
		 
		  reader.readAsText(file);
}