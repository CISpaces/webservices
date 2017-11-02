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
    'click #saveProgress': 'save',
    'click #history': 'analysisHistory',
    'click #simulation': 'restartSimulation',

    'click #importFromFile': 'importFromFile',
    'click #exportToFile': 'exportToFile',

    // 'click .btn-sm': 'createNode',
    'dragstart .btn-sm': 'dataTransfer',
    'dragend .btn-sm': 'createNode'
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
    if(!Number.isInteger(sec)){
      sec = parseInt(sec);
    }

    var time = year + "-" + (month < 10 ? "0" + month : month) + "-" +
      (date < 10 ? "0" + date : date) + " " +
      (hour < 10 ? "0" + hour : hour) + ":" +
      (min < 10 ? "0" + min : min) + ":" +
      (sec < 10 ? "0" + sec : sec);

    var graphID = generateUUID();

    var object = {
      "graphID": graphID,
      "userID": readCookie('user_id'),
      "timest": time,
      "isshared": false,
      "parentgraphid": null
    };

    Backbone.ajax({
      type: 'POST',
      url: vm_server + '/VC/rest/new',
      //dataType: 'text',
      contentType: 'application/json', //Supply the JWT auth token
      data: JSON.stringify(object),
      success: function(result) {
        createCookie('graph_id', graphID, 2);

        /* -------------------- initialisation for drawing a graph -------------------- */
        var area_id = app.workBoxView.el.id;

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

        var ret_graph = draw([], [], chart);
        push_graph_data(ret_graph);

        chart.simulation = restart_simulation(chart.simulation, false);

      },
      error: function(result) {
        alert('Something went wrong. Please try again.');
      }
    });
  },

  importFromFile: function() {

    app.workBoxView.clearWorkBox();

    var input_file = $("#myFile").click();

    return input_file;
  },

  exportToFile: function(obj) {

    if((!app.Nodes && !app.Edges) || (app.Nodes.length < 1 && app.Edges.length < 1)){
      alert("There is no analysis in Work Box.");
      return;
    }

    var param = {
      "nodes": app.Nodes.toJSON(),
      "edges": app.Edges.toJSON()
    }

    var file = new Blob([JSON.stringify(param)], {
      type: 'text/plain'
    });
    obj.target.href = URL.createObjectURL(file);
    obj.target.download = "export_" + readCookie('graph_id') + ".cis";
  },

  createNode: function(obj) {
    var id = obj.currentTarget.id;

    // creates model of the node
    var attr = app.workBoxView.createNode(id);

    var restart = true;
    if (!chart.nodes || chart.nodes.length < 1)
      restart = false;

    var dot, eventDoc, doc, body, pageX, pageY;
    var ev = obj.originalEvent || window.event;

    if(ev.pageX == null && ev.clientX != null){
      eventDoc = (ev.target && ev.target.ownerDocument) || document;
      doc = eventDoc.documentElement;
      body = eventDoc.body;

      ev.pageX = ev.clientX + (doc && doc.scrollLeft || body && body.scrollLeft || 0) - (doc && doc.clientLeft || body && body.scrollLeft);
      ev.pageY = ev.clientY + (doc && doc.scrollTop || body && body.scrollTop || 0) - (doc && doc.clientTop || body && body.clientTop);
    }

    var x = ev.pageX;
    var y = ev.pageY;

    // draws a new node
    chart.node = addNewNode(attr, x, y);

    // re-start changed graph
    chart.simulation = restart_simulation(chart.simulation, restart);
  },

  save: function() {
    var title = prompt("Please enter a title", "Analysis1");
    if (title != null) {
      var graphID = readCookie('graph_id');
      var userID = readCookie('user_id');
      var object = {
        "graphID": graphID,
        "userID": userID,
        "title": title
      };

      Backbone.ajax({
        type: 'POST',
        url: vm_server + '/VC/rest/save',
        //dataType: 'text',
        contentType: 'application/json',
        data: JSON.stringify(object),
        success: function(result) {
          alert("Version " + title + " saved.");
        },
        error: function(result) {
          alert('Something went wrong. Please try again.');
        }
      });
    }
  },

  analysisHistory: function() {
    var graphID = readCookie('graph_id');
    var object = {
      "graphID": graphID
    };

    Backbone.ajax({
      type: 'GET',
      url: vm_server + '/VC/rest/history',
      contentType: 'application/json',
      data: JSON.parse(object),
      success: function(result) {
        if (result) {
          $("#history_list").html("");

          if (result.history) {
            var arr = result.history;
            arr.forEach(function(d) {

              var options = $("<label></label>", {
                "class": "list-group-item"
              }).appendTo($("#history_list"));

              var radio_btn = $("<input/>", {
                "type": "radio",
                "name": "history_options_radio",
                "id": d.title
              }).click(function(obj) {
                //display graph upon clicking on a radio button
                if (d.analysis) {
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
      },
      error: function(xhr, textStatus, errorThrown) {
        alert("Ajax failed: " + errorThrown);
      }
    });
  },

  importAnalysis: function() {
    var analysis = document.getElementById('selectedAnalysis').innerHTML;
    if (analysis) {
      var json = JSON.parse(analysis);
      var object = {
        "graphID": json.graphID,
        "nodes": json.nodes,
        "edges": json.edges
      };
      Backbone.ajax({
        type: 'POST',
        url: vm_server + '/VC/rest/updateAnalysis',
        contentType: 'application/json',
        data: JSON.stringify(object),
        success: function(result) {
          alert('success');
        },
        error: function(result) {
          alert('Error in the ajax request.');
          //callback(result);
        }
      });

      app.workBoxView.clearWorkBox();

      var ret_graph = draw(json.nodes, json.edges, chart);
      push_graph_data(ret_graph);

      chart.simulation = restart_simulation(chart.simulation, false);

      $('#history_result').modal('hide');
    }

  },

  restartSimulation: function() {

    var length = (chart.nodes) ? chart.nodes.length : 15;

    var ret_simulation = set_simulation(length, chart.svg.width, chart.svg.height);
    push_node_style_data(ret_simulation);

    chart.simulation = restart_simulation(ret_simulation.simulation, false);

    if (chart.nodes) {
      chart.nodes.forEach(function(d) {
        d.fx = null;
        d.fy = null;
      })
    }
  },

  dataTransfer: function(event){
    event.originalEvent.dataTransfer.setData('text/plain', null);
  }
});
