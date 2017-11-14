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

    // 'click #newWorkBox': 'newWorkBox',
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
      "graph_id": chart.graph_id,
      "title": chart.title,
      "description": chart.description,
      "nodes": app.Nodes.toJSON(),
      "edges": app.Edges.toJSON()
    }

    var file = new Blob([JSON.stringify(param)], {
      type: 'text/plain'
    });
    obj.target.href = URL.createObjectURL(file);
    obj.target.download = "export_" + chart.graph_id + ".cis";
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
    $("#graph_info .modal-header span").text(chart.graph_id);

    $("#graph_info .modal-body input").val("");
    $("#graph_info .modal-body textarea").val("");

    $("#graph_info .modal-footer .btn-create").on("click", function(event){

      var title = $("#graph_info .modal-body input").val();
      var desciption = $("#graph_info .modal-body textarea").val();

      if (title != null) {
        var graphID = chart.graph_id;
        var userID = readCookie('user_id');
        var object = {
          "graphID": graphID,
          "userID": userID,
          "title": title.trim(),
          "description": description.trim()
        };

        Backbone.ajax({
          type: 'POST',
          url: remote_server + '/VC/rest/save',
          //dataType: 'text',
          contentType: 'application/json',
          data: JSON.stringify(object),
          success: function(result) {
            alert("Version " + title + " saved.");

            $("#graph_info").modal('hide');
          },
          error: function(result) {
            alert('Something went wrong. Please try again.');
          }
        });
      }
    });

    $("#graph_info").modal('show');
  },

  analysisHistory: function() {
    var object = {
      "graphID": chart.graph_id
    };

    Backbone.ajax({
      type: 'GET',
      url: remote_server + '/VC/rest/history',
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
        url: remote_server + '/VC/rest/updateAnalysis',
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
