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
    'click #checkoutGraph': 'checkoutGraph',
    'click #blockGraph': 'blockGraph',        //aggiunta della nuova funzione per bloccare il grafo
    'click #customization': 'customization'   //aggiunta della nuova funzione per la personalizzazione
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

    // Gets the list of analysis from the server
    app.browseBoxView.getAnalysisList();

    $("#nav-toolbox").hide();
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
    
    if (attr.type == "I"){
    	app.workBoxView.popupNodeView({currentTarget : {id : "draw_" + attr.id}});
    }
  },

  save: function() {
    $("#graph_info .modal-header span").text(chart.graphID);

    $("#graph_info .modal-body input").val(chart.title);
    $("#graph_info .modal-body textarea").val(chart.description);

    $("#graph_info .modal-footer .btn-create")
    .text("Save")
    .one("click", function(event){
        //We need to use one(), rather than on(), else the click event is associated multiple times.
      event.preventDefault();
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
          url: 'VC/rest/save',
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
      url: 'VC/rest/history',
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
        url: 'VC/rest/updateAnalysis',
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
    app.browseBoxView.toggleViewMode(true);
  },

  checkoutGraph: function(event){
    app.browseBoxView.toggleViewMode(false);
  },

  //Aggiunta della funzione del blocco del grafo: da sviluppare
  blockGraph: function() {
    /**
     Estrae il codice html relativo alla sezione svg. Questo verrà salvato su DB
     */

    var graph_blocked = $("#myGraph").html();
    console.log(graph_blocked);
    /**
    $("#graph_info .modal-header span").text(chart.graphID);

    $("#graph_info .modal-body input").val(chart.title);
    $("#graph_info .modal-body textarea").val(chart.description);

    $("#graph_info .modal-footer .btn-create")
        .text("Block Graph")
        .one("click", function(event){
          //We need to use one(), rather than on(), else the click event is associated multiple times.
          event.preventDefault();
          var title = $("#graph_info .modal-body input").val();
          var description = $("#graph_info .modal-body textarea").val();

          if (title != null) {
            var graphID = chart.graphID;
            var userID = readCookie('user_id');
            var object = {
              "graphID": graphID,
              "userID": userID,
              "title": title.trim(),
              "description": description.trim(),
              "graph": graph_blocked.trim()
            };

            Backbone.ajax({
              type: 'POST',
              url: 'VC/rest/blocked',
              //dataType: 'text',
              contentType: 'application/json',
              data: JSON.stringify(object),
              success: function(result) {
                alert("Version " + title + " blocked.");

                $("#graph_info").modal('hide');
              },
              error: function(result) {
                alert('Something went wrong. Please try again.');
              }
            });
          }
        });

    $("#graph_info").modal('show');*/
  },

  /*
    Aggiunta della funzione customization: sviluppo completato
   */
  customization: function() {
    $("#graph_customization .modal-header span").text("CUSTOMIZATION");

    $("#graph_customization .modal-footer .btn-create").text("Custom Now").on("click", function(event) {

      var info_button_color = $("#info_node_draw").val();
      var claim_button_color = $("#claim_node_draw").val();
      var con_button_color = $("#con_node_draw").val();
      var pro_button_color = $("#pro_node_draw").val();

      if (info_button_color == "#ffffff" ||
          claim_button_color == "#ffffff" ||
          con_button_color == "#ffffff" ||
          pro_button_color == "#ffffff") {
        alert("White isn't a valid color for node. Please change it");
      } else {
        $('.btn-info').css('background-color', info_button_color);
        $('.btn-claim').css('background-color', claim_button_color);
        $('.btn-danger').css('background-color', con_button_color);
        $('.btn-success').css('background-color', pro_button_color);

        $('head').append(
            $('<style/>', {
              id : 'my-customization',
              html :  '.info-node   {fill: '+info_button_color+'; ' + 'stroke: '+info_button_color+'}'+
                      '.claim-node  {fill: '+claim_button_color+'; ' + 'stroke: '+claim_button_color+'}'+
                      '.con-node    {fill: '+con_button_color+'; ' + 'stroke: '+con_button_color+'}'+
                      '.pro-node    {fill: '+pro_button_color+'; ' + 'stroke: '+pro_button_color+'}'
            })
        );

        $("#graph_customization").modal('hide');
      }
    });

    $("#graph_customization").modal('show');
  }
});
