var app = app || {};

/**
 * BrowseBox
 * ---------------------------------
 * the UI for 'browseBox'
 */

app.BrowseBoxView = Backbone.View.extend({
  el: '#browse_box',

  events: {
    'click .btn-create': 'newWorkBox',
    'click .btn-view': 'viewAnalysis',
    'click .btn-checkout': 'checkoutAnalysis'
  },

  initialize: function() {

    // Gets the list of analysis from the server
    this.getAnalysisList();

    $("#panel-browsebox").show();
  },

  render: function() {},

  newWorkBox: function() {
    // app.workBoxView.clearWorkBox();

    var graphID = generateUUID();

    $("#graph_info .modal-header span").text(graphID);

    $("#graph_info .modal-body input").val("");
    $("#graph_info .modal-body textarea").val("");

    $("#graph_info .modal-footer .btn-create").on("click", function(event) {

      var title = $("#graph_info .modal-body input").val();
      var description = $("#graph_info .modal-body textarea").val();

      if(_.isEmpty(title)){
        alert("Please, enter a title");
      } else {
        var object = {
          "graphID": graphID,
          "userID": readCookie('user_id'),
          "timest": generateDate(),
          "title": title.trim(),
          "description": description.trim(),
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

            // saves the meta data of the graph
            chart.graph_id = graphID;
            chart.title = object.title;
            chart.desciption = object.description;
            chart.date = object.timest;

            $("#panel-workbox").show();

            app.workBoxView.initialize();

            $("#panel-workbox").show();
            $("#panel-browsebox").hide();

            $("#graph_info").modal('hide');
          },
          error: function(xhr) {
            console.error("Ajax failed: " + xhr.statusText);
            alert('Something went wrong. Please try again.');
          }
        });
      }
    });

    $("#graph_info").modal('show');
  },

  getAnalysisList: function(data) {
    var userID = readCookie('user_id');

    
    Backbone.ajax({
      type: 'GET',
      url: remote_server + 'VC/rest/analyses/user/'+ userID +'/meta',
      success: function(data){
        data.forEach(function(analysis) {

        var div_panel = $("<div></div>", {
          'class': "panel panel-green"
        }).appendTo(
          $("<div></div>", {
            'class': "col-lg-3 col-md-6"
          }).appendTo($("#browse_box"))
        );

        var div_heading = $("<div></div>", {
          'class': "panel-heading"
        }).appendTo(div_panel);

        d3.keys(analysis).forEach(function(data) {
          var span = analysis[data];

          $("<label></label>", {
            'text': data,
            'style': "margin: 5px 10px"
          }).appendTo(
            $("<div></div>", {
              'class': "row"
            }).appendTo(div_heading)
          ).after(
            $("<span></span>", {
              'text': span
            })
          );
        });

        var btn = $("<span></span>", {
          'class': "pull-right btn-checkout",
          'name': "btn_" + analysis.graph_id,
          'text': "Checkout"
        }).appendTo(
          $("<div></div>", {
            'class': "panel-footer"
          }).appendTo(
            $("<a></a>", {
              'href': "#"
            }).appendTo(div_panel)
          )
        ).before(
          $("<span></span>", {
            'class': "pull-left btn-view",
            'name': "btn_" + analysis.graph_id,
            'text': "View"
          })
        ).after(
          $("<div></div>", {
            'class': "clearfix"
          })
        );
      });
        },
        error: function(xhr){
          console.error("Ajax failed: " + xhr.statusText);
        }
      });    
  },

  viewAnalysis: function(event) {

    var graphID = event.target.attributes.name.value.replace("btn_", "");

    Backbone.ajax({
      type: 'GET',
      url: remote_server + '/analysis/' + graphID,
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
      error: function(xhr) {
        console.error("Ajax failed: " + xhr.statusText);
        alert('An error occurred fetching data.');
      }
    });
  },

  checkoutAnalysis: function(event) {
    var graphID = event.target.attributes.name.value.replace("btn_", "");
  }
});
