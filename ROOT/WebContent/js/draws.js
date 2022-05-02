/**
 * draws.js: visualises graphs using JSON data
 */

/* scale functions for assigning node's sizes (width, height and font size) and distances between nodes */

var i_node_size_scales = d3.scaleLinear().domain([1, 250]).range([34, 17]);
var a_node_size_scales = d3.scaleLinear().domain([1, 250]).range([26, 13]);

var font_size_scales = d3.scaleLinear().domain([1, 250]).range([14, 10]);

var distance_scales = d3.scaleLinear().domain([1, 250]).range([50, 10]);
var charge_scales = d3.scaleLinear().domain([1, 250]).range([-400, -70]); /* da cambiare gli scale per non far sovrapporre gli elementi svg*/

function init_chart_data(area_id, min_svg_height) {
  var ret = {};

  ret.svg_width = $('#' + area_id).width();
  ret.svg_height = $('#' + area_id).height() < min_svg_height ? min_svg_height : $('#' + area_id).height();

  ret.svg = d3.select('svg')
    .attr('viewBox', '0 0 '+ret.svg_width+' '+ret.svg_height)  //modifica con attributo viewBox
    //.attr('width', ret.svg_width + 'px')
    //.attr('height', ret.svg_height + 'px')

  return ret;
}

function set_simulation(nodes_length, svg_width, svg_height) {

  var ret = {};

  ret.i_width = i_node_size_scales(nodes_length);
  ret.i_height = i_node_size_scales(nodes_length);

  ret.a_width = a_node_size_scales(nodes_length);
  ret.a_height = a_node_size_scales(nodes_length);

  ret.font_size = font_size_scales(nodes_length);

  var distance = distance_scales(nodes_length);
  var charge_strength = charge_scales(nodes_length);

  ret.simulation = d3.forceSimulation()
    .force("link", d3.forceLink().id(function(d) {
      return d.nodeID;
    }).distance(distance))
    .force("charge", d3.forceManyBody().theta(0.5).strength(charge_strength))
    .force("center", d3.forceCenter(svg_width / 2, svg_height / 2))
    .on("end", function() {
      if (chart.nodes) {
        chart.nodes.forEach(function(d) {
          d.fx = d.x;
          d.fy = d.y;
        })
      }
    });

  return ret;
}

function set_zoom(svg) {

  // add encompassing group for the zoom
  var ret = svg.append("g")
    .attr("class", "zoom");

  // add zoom capabilities
  var zoom_handler = d3.zoom().on("zoom", function() {
    ret.attr("transform", d3.event.transform);
  });

  zoom_handler(svg);

  svg.on("dblclick.zoom", null);

  return ret;
}

/** OLD VERSION

function draw(nodes, edges, chart) {

  var ret = {};

  ret.nodes = nodes;
  ret.edges = edges;

  ret.node = chart.zoom.append("g")
    .attr("class", "nodes")
    .selectAll("g")
    .data(ret.nodes)
    .enter().append("g")
    .attr("id", function(d) {
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
    .attr("width", function(d) {
      if (d['type'] == "I") {
        return chart.node_style_data.i_width;   //anche qui i valori di larghezza devono essere modificati
      } else {
        return chart.node_style_data.a_width;   //anche qui i valori di larghezza devono essere modificati
      }
    })
    .attr("height", function(d) {
      if (d['type'] == "I") {
        return chart.node_style_data.i_height;
      } else {
        return chart.node_style_data.a_height;
      }
    })
    .attr("rx", function(d) {
      if (d['type'] == "I") {
        return chart.node_style_data.i_width / 8;
      } else if (d['type'] == "P") {
        return chart.node_style_data.a_width / 4;
      } else {
        return chart.node_style_data.a_width / 2;
      }
    })
    .attr("class", function(d) {
      var className = null;
      if (d['type'] == "I") {
        className = d['input'].toLowerCase() + '-node';
      } else if (d['type'] == "P") {
        className = 'pref-node';
      } else {
        className = (d['type'] == "CA") ? 'con-node' : 'pro-node';
      }
      return className;
    })
    .append("title")
    .text(function(d) {
      return d['text'];
    });

  ret.node.append("text")
    .attr("dx", -5)
    //.attr("dx", 12) //valore precedente 12
    .attr("dy", ".90em")
    //.attr("dy", "0.35em")//valore precedente .35em
    .attr("font-size", chart.node_style_data.font_size)
    .attr("class", function(d) {
      if (d['eval'] == "V") {
        return 'success';
      } else if (d['eval'] == "X") {
        return 'fail';
      } else if (d['eval'] == "?") {
        return 'question';
      }
    })
    .text(function(d) {
      return parseText(d['text']);
    });

  ret.node.each(function(data) {
    // debugger;
    var attr = app.workBoxView.createNodeModelFromData(data);
  });

  ret.edge = chart.zoom.append("g")
    .attr("class", "links")
    .selectAll("line")
    .data(ret.edges)
    .enter().append("line")
    .attr("marker-end", "url(#triangle)")
    .attr("class", function(d) {
      var className = app.workBoxView.createEdgeModelFromData(d);
      // debugger;
      if (className.includes('pref-')) {
        this.setAttribute('marker-end', 'url(#pref-triangle)');
      } else if (className.includes('con-')) {
        this.setAttribute('marker-end', 'url(#con-triangle)');
      } else if (className.includes('pro-')) {
        this.setAttribute('marker-end', 'url(#pro-triangle)');
      }

      return className;
    }).attr("style", "pointer-events: none");

  $("#pref-triangle").attr("refX", chart.node_style_data.a_width/2);
  $("#con-triangle").attr("refX", chart.node_style_data.a_width/2);
  $("#pro-triangle").attr("refX", chart.node_style_data.a_width/2);

  return ret;
}*/

function draw(nodes, edges, chart) {

  var ret = {};

  ret.nodes = nodes;
  ret.edges = edges;

  ret.node = chart.zoom.append("g")
      .attr("class", "nodes")
      .selectAll("g")
      .data(ret.nodes)
      .enter().append("g")
      .attr("id", function(d) {
        return "draw_" + d['nodeID'];
      })
      .attr("class", "node")
      .call(d3.drag()
          .on("start", dragstarted)
          .on("drag", dragged)
          .on("end", dragended));

  ret.node.append("rect")
      //.attr("x", -8)
      //.attr("y", -8)
      .attr("width", function(d) {
        if (d['type'] == "I") {
          return chart.node_style_data.i_width*4;     //da modificare la larghezza
        } else {
          return chart.node_style_data.a_width*2;
        }
      })
      .attr("height", function(d) {
        if (d['type'] == "I") {
          return chart.node_style_data.i_height*3;
        } else {
          return chart.node_style_data.a_height*2;
        }
      })
      .attr("rx", function(d) {
        if (d['type'] == "I") {
          if(d['input'].toLowerCase() === "info")         //Se l'input è di tipo info --> bordi arrotondati
            return chart.node_style_data.i_width;
        } else if (d['type'] == "P") {
          return chart.node_style_data.a_width;
        } else {
          return chart.node_style_data.a_width;
        }
      })
      .attr("class", function(d) {
        var className = null;
        if (d['type'] == "I") {
          className = d['input'].toLowerCase() + '-node';
        } else if (d['type'] == "P") {
          className = 'pref-node';
        } else {
          className = (d['type'] == "CA") ? 'con-node' : 'pro-node';
        }
        return className;
      })
      .append("title")
      .text(function(d) {
        return d['text'];
      });

  ret.node.append("foreignObject")
      .attr("x", function(d) {
        if (d['type'] == "I") {
          return 17;
        } else if (d['type'] == "P") {
          return 12;
        }else {
          return 12;
        }
      })
      .attr("y", function(d) {
        if (d['type'] == "I") {
          return 15;
        } else if (d['type'] == "P") {
          return 15;
        }else {
          return 15;
        }
      })
      .attr("width", function(d) {
        if (d['type'] == "I") {
          return chart.node_style_data.i_width*3.5;
        } else if (d['type'] == "P") {
          return chart.node_style_data.a_width*2;
        }else {
          return chart.node_style_data.a_width*2;
        }
      })
      .attr("height", function(d) {
        if (d['type'] == "I") {
          return chart.node_style_data.i_height*2.5;
        } else if (d['type'] == "P") {
          return chart.node_style_data.a_height*2;
        }else {
          return chart.node_style_data.a_height*2;
        }
      })
      .append("xhtml:div")
      .attr("class", "myDiv-node")
      .attr("class", function(d) {
        if (d['eval'] == "V") {
          return 'success';
        } else if (d['eval'] == "X") {
          return 'fail';
        } else if (d['eval'] == "?") {
          return 'question';
        }
      })
      .append("text")
      //.attr("dx", -5)
      //.attr("dx", 12) //valore precedente 12
      //.attr("dy", ".90em")
      //.attr("dy", "0.35em")//valore precedente .35em
      //.attr("font-size", chart.node_style_data.font_size)
      .text(function(data) {
        return parseText(data['text']);
      });

  ret.node.each(function(data) {
    // debugger;
    var attr = app.workBoxView.createNodeModelFromData(data);
  });

  ret.edge = chart.zoom.append("g")
      .attr("class", "links")
      .selectAll("line")
      .data(ret.edges)
      .enter().append("line")
      .attr("marker-end", "url(#triangle)")
      .attr("class", function(d) {
        var className = app.workBoxView.createEdgeModelFromData(d);
        // debugger;
        if (className.includes('pref-')) {
          this.setAttribute('marker-end', 'url(#pref-triangle)');
        } else if (className.includes('con-')) {
          this.setAttribute('marker-end', 'url(#con-triangle)');
        } else if (className.includes('pro-')) {
          this.setAttribute('marker-end', 'url(#pro-triangle)');
        }

        return className;
      }).attr("style", "pointer-events: none");

  $("#pref-triangle").attr("refX", chart.node_style_data.a_width/2);
  $("#con-triangle").attr("refX", chart.node_style_data.a_width/2);
  $("#pro-triangle").attr("refX", chart.node_style_data.a_width/2);

  return ret;
}

function dragstarted(d) {
  if (!d3.event.active) chart.simulation.alphaTarget(0.3).restart();
  d.fx = d.x;
  d.fy = d.y;
}

function dragged(d) {
  d.fx = d3.event.x;
  d.fy = d3.event.y;
}

function dragended(d) {
  if (!d3.event.active) chart.simulation.alphaTarget(0);
  // d.fx = null;
  // d.fy = null;
}

/*
*   MODIFICATO:    x1 y1 coordinate di partenza del link
*                  x2 y2 coordinate di arrivo del link
*   Poichè le dimansioni delle box sono state modificate anche le coordinate da cui partono e arrivano i link
*   devono essere modificati. In partocolare quelli di partenza partiranno dal centro delle box.
*   Le coordinate di arrivo corrispondono invece agli angoli delle box
* */
function ticked() {
  if (chart.edge) {
    chart.edge
      .attr("x1", function(d) {
        if(d.source.type == 'I')
          return d.source.x + chart.node_style_data.a_width * 2.5;  // se sorgente del link è info o claim
        else
          return d.source.x + chart.node_style_data.a_width * 0.9;  // se sorgente del link è pro o con
      })
      .attr("y1", function(d) {
        if(d.source.type == 'I')
          return d.source.y + chart.node_style_data.a_height * 2.5; // se sorgente del link è info o claim
        else
          return d.source.y + chart.node_style_data.a_height * 0.9; // se sorgente del link è pro o con
      })
      .attr("x2", function(d) {
        if (d.source.x < d.target.x) {
          return d.target.x;
        } else {
          if(d.source.type == 'I')
            return d.target.x + chart.node_style_data.a_width * 2;  // se sorgente del link è info o claim target è pro o con
          else
            return d.target.x + chart.node_style_data.a_width * 5;  // se sorgente del link è pro o con target è info o claim
        }
      })
      .attr("y2", function(d) {
        if (d.source.y < d.target.y) {
          return d.target.y;
        } else {
          if(d.source.type == 'I')
            return d.target.y + chart.node_style_data.a_height * 2;   // se sorgente del link è info o claim target è pro o con
          else
            return d.target.y + chart.node_style_data.a_height * 3.5; // se sorgente del link è pro o con target è info o claim
        }
      });
  }

  if (chart.node) {
    chart.node
      .attr("x", function(d) {
        return d.x;
      })
      .attr("y", function(d) {
        return d.y;
      })
      .attr("transform", function(d) {
        return "translate(" + d.x + "," + d.y + ")";
      });
  }
}

function restart_simulation(simulation, restart) {

  if (!restart) {
    simulation.nodes(chart.nodes)
      .on("tick", ticked);

    simulation.force("link")
      .links(chart.edges);
  } else {
    // Update and restart the simulation.
    simulation.nodes(chart.nodes);
    simulation.force("link").links(chart.edges);

    simulation.restart();
  }

  return simulation;
}

function addNewNode(attr, x, y) {

  var transform = $(".zoom").attr("transform");

  var scale = 1;
  var translate_x = 0;
  var translate_y = 0;
  if (transform) {
    var arr = transform.split(" ");
    arr.forEach(function(d) {
      if (d.indexOf("translate") > -1) {
        var translate = d.substring(10, d.length - 1);
        translate_x = Number(translate.split(',')[0]);
        translate_y = Number(translate.split(',')[1]);
      }
      if (d.indexOf("scale") > -1) {
        scale = Number(d.substring(6).split(")")[0]);
      }
    });
  }

  var data = {
    "source": "user",
    "uncert": "Confirmed",
    "eval": "N/A",
    "text": attr['text'],
    "input": attr['input'],
    "dtg": attr['dtg'],
    "commit": "N/A",
    "type": attr['type'],
    "nodeID": attr['nodeID'],
    "annot": {
      "conc": {},
      "prem_assump": {}
    },
    "x": ((x - 60 - translate_x) / scale),
    "y": ((y - 190 - translate_y) / scale),
    "fx": ((x - 60 - translate_x) / scale),
    "fy": ((y - 190 - translate_y) / scale)
  }

  chart.nodes.push(data);

  // Apply the general update pattern to the nodes.
  chart.node = chart.node.data(chart.nodes, function(d) {
    return d.nodeID;
  });
  chart.node.exit().remove();

  var ret_node = chart.node.enter()
    .append("g")
    .attr("id", "draw_" + data['nodeID'])
    .attr("class", "node")
    .attr("x", data.x)
    .attr("y", data.y)
    .attr("transform", "translate(" + data.x + ", " + data.y + ")")
    .call(d3.drag()
      .on("start", dragstarted)
      .on("drag", dragged)
      .on("end", dragended))
    .merge(chart.node);

  var new_node = d3.select("#draw_" + data['nodeID']);

  /**
   * Modifica: inserire il testo all'interno di una box
   * Es:
   * <g>
   *  <rect x="0" y="0" width="100" height="100" fill="red"></rect>
   *  <text x="0" y="50" font-family="Verdana" font-size="35" fill="blue">Hello</text>
   * </g>
   */
  new_node.append("rect")
      //.attr("x", -8)
      //.attr("y", -8)
      .attr("width", function(d) {
        if (d['type'] == "I") {
          return chart.node_style_data.i_width*4;
        } else if (d['type'] == "P") {
          return chart.node_style_data.a_width*2;
        }else {
          return chart.node_style_data.a_width*2;
        }
      })
      .attr("height", function(d) {
        if (d['type'] == "I") {
          return chart.node_style_data.i_height*3;
        } else if (d['type'] == "P") {
          return chart.node_style_data.a_height*2;
        }else {
          return chart.node_style_data.a_height*2;
        }
      })
      .attr("rx", function(d) {
        if (d['type'] == "I") {
          if(d['input'].toLowerCase() === "info")         //Se l'input è di tipo info --> bordi arrotondati
            return chart.node_style_data.i_width;
        } else if (d['type'] == "P") {
          return chart.node_style_data.a_width;
        } else {
          return chart.node_style_data.a_width;
        }
      })
      .attr("class", function(d) {
        if (d['type'] == "I") {
          return d['input'].toLowerCase() + '-node';
        } else if (d['type'] == "P") {
          return 'pref-node';
        } else {
          return (d['type'] == "CA") ? 'con-node' : 'pro-node';
        }
      })
      .append("title")
      .text(function(d) {
        return d['text'];
      });


  /**
   *  foreignObject: l'utilizzo di foreignObject consente di fare .append di elementi html come il div
   *  per risolvere la visualizzazione del testo all'interno del div è stato utilizzato il tag xhtml
   */

  new_node.append("foreignObject")
      .attr("x", function(d) {
        if (d['type'] == "I") {
          return 17;
        } else if (d['type'] == "P") {
          return 12;
        }else {
          return 12;
        }
      })
      .attr("y", function(d) {
        if (d['type'] == "I") {
          return 15;
        } else if (d['type'] == "P") {
          return 15;
        }else {
          return 15;
        }
      })
      .attr("width", function(d) {
        if (d['type'] == "I") {
          return chart.node_style_data.i_width*3.5;
        } else if (d['type'] == "P") {
          return chart.node_style_data.a_width*2;
        }else {
          return chart.node_style_data.a_width*2;
        }
      })
      .attr("height", function(d) {
        if (d['type'] == "I") {
          return chart.node_style_data.i_height*2.5;
        } else if (d['type'] == "P") {
          return chart.node_style_data.a_height*2;
        }else {
          return chart.node_style_data.a_height*2;
        }
      })
      .append("xhtml:div")
      .attr("class", "myDiv-node")
      .append("text")
      .text(parseText(data['text']));

  /**
   * Questa soluzione porta il testo all'interno del box, ma se il testo è
   * troppo lungo esce dal box
   */
  /*new_node.append("text")
      .attr("x", function(d) {
        if (d['type'] == "I") {
          return 20;
        } else if (d['type'] == "P") {
          return 12;
        }else {
          return 12;
        }
      })
      .attr("y", function(d) {
        if (d['type'] == "I") {
          return 20;
        } else if (d['type'] == "P") {
          return ;
        }else {
          return 30;
        }
      })
      .text(parseText(data['text']));*/

  return ret_node;
}
/**OLD VERSION
 *   new_node.append("rect")
 *     .attr("x", -8)
 *     .attr("y", -8)
 *     .attr("width", function(d) {
 *       if (d['type'] == "I") {
 *         return chart.node_style_data.i_width;
 *       } else {
 *         return chart.node_style_data.a_width;
 *       }
 *     })
 *     .attr("height", function(d) {
 *       if (d['type'] == "I") {
 *         return chart.node_style_data.i_height;
 *       } else {
 *         return chart.node_style_data.a_height;
 *       }
 *     })
 *     .attr("rx", function(d) {
 *       if (d['type'] == "I") {
 *         return chart.node_style_data.i_width / 8;
 *       } else if (d['type'] == "P") {
 *         return chart.node_style_data.a_width / 4;
 *       } else {
 *         return chart.node_style_data.a_width / 2;
 *       }
 *     })
 *     .attr("class", function(d) {
 *       if (d['type'] == "I") {
 *         return d['input'].toLowerCase() + '-node';
 *       } else if (d['type'] == "P") {
 *         return 'pref-node';
 *       } else {
 *         return (d['type'] == "CA") ? 'con-node' : 'pro-node';
 *       }
 *     })
 *     .append("title")
 *     .text(function(d) {
 *       return d['text'];
 *     });
 *
 *   new_node.append("text")
 *     .attr("dx", 12)
 *     .attr("dy", ".35em")
 *     .attr("font-size", chart.node_style_data.font_size)
 *     .text(parseText(data['text']));
 *
 *   return ret_node;
 * }
 */
function deleteNode(index) {

  var ret = chart.nodes.splice(index, 1);

  // Apply the general update pattern to the nodes.
  chart.node = chart.node.data(chart.nodes, function(d) {
    return d.nodeID;
  });
  chart.node.exit().remove();

  return ret;
}

function addNewEdge(attr) {

  // debugger;

  var data = {
    "target": attr['target'],
    "source": attr['source'],
    "formEdgeID": null,
    "edgeID": attr['edgeID']
  }

  chart.edges.push(data);

  // Apply the general update pattern to the edges.
  chart.edge = chart.edge.data(chart.edges, function(d) {
    return d.edgeID;
  });
  chart.edge.exit().remove();

  var className = attr['className'];
  var markerClass = "url(#triangle)";

  if (className.includes('pref-')) {
    markerClass = "url(#pref-triangle)";
  } else if (className.includes('con-')) {
    markerClass = "url(#con-triangle)";
  } else if (className.includes('pro-')) {
    markerClass = "url(#pro-triangle)";
  }

  var ret_edge = chart.edge.enter()
    .append("line")
    .attr("marker-end", markerClass)
    .attr("class", className)
    .merge(chart.edge);

  return ret_edge;
}

function deleteEdge(id) {

  var deleted_edges = [];

  chart.edges = chart.edges.filter(function(e) {
    if (e['source']['nodeID'] == id || e['target']['nodeID'] == id) {
      deleted_edges.push(e);
    }
    return (e['source']['nodeID'] != id && e['target']['nodeID'] != id);
  });

  // Apply the general update pattern to the links.
  chart.edge = chart.edge.data(chart.edges, function(d) {
    return d.edgeID;
  });
  chart.edge.exit().remove();

  return deleted_edges;
}
