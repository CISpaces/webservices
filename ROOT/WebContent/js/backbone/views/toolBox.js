// js/views/toolBox.js

var app = app || {};

/**
 * ToolBox
 * ---------------------------------
 * the UI for 'toolBox'
 */

app.ToolBoxView = Backbone.View.extend({
  el: '#nav-toolbox',

  events: {
    'click #settings': 'settings',
    'click #help': 'help',

    // 'click #newWorkBox': 'newWorkBox',
    'click #browseAnalyses': 'callBrowseBox',
    'click #saveProgress': 'save',
    'click #history': 'analysisHistory',
    'click #simulation': 'restartSimulation',

    // 'click .btn-sm': 'createNode',
    'dragstart .btn-sm': 'dataTransfer',
    'dragend .btn-sm': 'createNode',

    'click #commitGraph': 'commitGraph',
    'click #checkoutGraph': 'checkoutGraph'
  },

  initialize: function() {
    this.$el.hide();
  },

  render: function() {

  },

  settings: function() {
    // alert('settings');
  },

  help: function() {
    // alert('help');
  },

  callBrowseBox: function(obj){
    $("#row-workbox").hide();
    $("#row-browsebox").show();
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
    $("#graph_info .modal-header span").text(chart.graphID);

    $("#graph_info .modal-body input").val(chart.title);
    $("#graph_info .modal-body textarea").val(chart.description);

    $("#graph_info .modal-footer .btn-create")
    .text("Save")
    .on("click", function(event){

      var title = $("#graph_info .modal-body input").val();
      var description = $("#graph_info .modal-body textarea").val();

      if (title != null) {
        var graphID = chart.graphID;
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
      "graphID": chart.graphID
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
  },

  commitGraph: function(event){
    view_flag = true;
    app.browseBoxView.changeMode();
  },

  checkoutGraph: function(event){
    view_flag = false;
    app.browseBoxView.changeMode();
  }
});
