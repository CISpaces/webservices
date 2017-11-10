var app = app || {};

/**
 * BrowseBox
 * ---------------------------------
 * the UI for 'browseBox'
 */

app.BrowseBoxView = Backbone.View.extend({
  el: '#browse_box',

  events: {
    'click #new_analysis': 'newWorkBox'
  },

  initialize: function() {
    // 'New' button is added

    // Gets the list of analysis from the server

    $("#panel-browsebox").hide();
  },

  render: function() {},

  newWorkBox: function() {
    // app.workBoxView.clearWorkBox();

    var time = generateDate();

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
      url: remote_server + '/VC/rest/new',
      //dataType: 'text',
      contentType: 'application/json', //Supply the JWT auth token
      data: JSON.stringify(object),
      success: function(result) {
        createCookie('graph_id', graphID, 2);

        $("#panel-workbox").show();

        app.workBoxView.initialize();

        $("#panel-workbox").show();
        $("#panel-browsebox").hide();
      },
      error: function(result) {
        alert('Something went wrong. Please try again.');
      }
    });
  },

  getAnalysisList: function(data) {
    var userID = readCookie('user_id');

    Backbone.ajax({
      type: 'post',
      url: remote_server + '/VC/rest/browseAnalysis',
      contentType: 'text/plain',
      data: userID,
      success: function(data){

      },
      error: function(xhr, txtStatus, errorThrown){
        console.error("Ajax failed: " + errorThrown);
      }
    })
  },

  getLatestAnalysis: function(data) {

    var userID = readCookie('user_id');

    Backbone.ajax({
      type: 'POST',
      url: remote_server + '/VC/rest/getAnalysis',
      contentType: 'text/plain',
      //Supply the JWT auth token
      // headers: {"Authorization": localStorage.getItem('auth_token')},
      data: userID,
      success: function(result) {
        // $("#modal_select_analysis").modal('show');

        // initiate the SVG on the work box for drawing a graph
        if (data.graphID && !_.isEmpty(data.graphID)) {
          createCookie('graph_id', data.graphID, 2);
        }

        var ret_graph = draw(data.nodes, data.edges, chart);
        push_graph_data(ret_graph);

        chart.simulation = restart_simulation(chart.simulation, false);
        /* ------------------------------------------------------------------------------- */
      },
      error: function(result) {
        alert('An error occurred fetching data.');
        //callback(result);
      }
    });
  }
});
