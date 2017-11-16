var app = app || {};

/**
 * BrowseBox
 * ---------------------------------
 * the UI for 'browseBox'
 */

app.BrowseBoxView = Backbone.View.extend({
  el: '#browse_box',

  events: {
    'click #new_analysis': 'newWorkBox',

    'click #importFromFile': 'selectFile',
    'change #myFile': 'importFromFile',

    'click .btn-view': 'viewAnalysis',
    'click .btn-checkout': 'checkoutAnalysis',

    'click .btn-export': 'exportToFile',
  },

  initialize: function() {

    // Gets the list of analysis from the server
    this.getAnalysisList();

    $("#row-browsebox").show();
  },

  render: function() {},

  newWorkBox: function() {
    // app.workBoxView.clearWorkBox();

    var graphID = generateUUID();

    $("#graph_info .modal-header span").text(graphID);

    $("#graph_info .modal-body input").val("");
    $("#graph_info .modal-body textarea").val("");

    $("#graph_info .modal-footer .btn-create").text("Create").on("click", function(event) {

      var title = $("#graph_info .modal-body input").val();
      var description = $("#graph_info .modal-body textarea").val();

      if (_.isEmpty(title)) {
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

            $("#row-workbox").show();

            app.workBoxView.clearWorkBox();

            $("#row-workbox").show();
            $("#row-browsebox").hide();

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
      url: remote_server + '/VC/rest/analyses/user/' + userID + '/meta'
      success: function(data){
        data.forEach(function(analysis) {

      },
      error: function(xhr){
        console.error("Ajax failed: " + xhr.statusText);
      }
    });
    */

    var example = [{
      graph_id: 'graphID_0',
      title: 'graphTitle_0',
      user: 'user_0',
      date: '2017-00-00',
      description: 'description_0'
    }, {
      graph_id: 'graphID_1',
      title: 'graphTitle_1',
      user: 'user_1',
      date: '2017-00-00',
      description: 'description_1'
    }, {
      graph_id: 'graphID_2',
      title: 'graphTitle_2',
      user: 'user_2',
      date: '2017-00-00',
      description: 'description_2'
    }, {
      graph_id: 'graphID_3',
      title: 'graphTitle_3',
      user: 'user_3',
      date: '2017-00-00',
      description: 'description_3'
    }, {
      graph_id: 'graphID_4',
      title: 'graphTitle_4',
      user: 'user_4',
      date: '2017-00-00',
      description: 'description_4'
    }, {
      graph_id: 'graphID_5',
      title: 'graphTitle_5',
      user: 'user_5',
      date: '2017-00-00',
      description: 'description_5'
    }, {
      graph_id: 'graphID_6',
      title: 'graphTitle_6',
      user: 'user_6',
      date: '2017-00-00',
      description: 'description_6'
    }];

    var self = this;
    example.forEach(function(d) {
      self.makeGraphElement(d);
    });
  },

  makeGraphElement: function(analysis) {
    var div_panel = $("<div></div>", {
      'class': "panel panel-green"
    }).appendTo($("<div></div>", {
      'class': "col-lg-2 col-md-4"
    }).appendTo($("#browse_box")));

    var div_heading = $("<div></div>", {
      'class': "panel-heading"
    }).appendTo(div_panel);

    d3.keys(analysis).forEach(function(data) {
      var span = analysis[data];

      $("<label></label>", {
        'text': data,
        'style': "margin: 5px 10px"
      }).appendTo($("<div></div>", {
        'class': "row"
      }).appendTo(div_heading)).after($("<span></span>", {
        'text': span
      }));
    });

    var btn = $("<button></button>", {
      'class': "pull-right btn btn-outline btn-success btn-export",
      'name': "btn_" + analysis.graph_id,
      'text': "Export"
    }).appendTo($("<div></div>", {
      'class': "panel-footer"
    }).appendTo(div_panel)).before($("<button></button>", {
      'class': "pull-left btn btn-outline btn-success btn-view",
      'name': "btn_" + analysis.graph_id,
      'text': "View"
    })).before($("<button></button>", {
      'class': "pull-left btn btn-outline btn-success btn-checkout",
      'style': "margin-left: 5px",
      'name': "btn_" + analysis.graph_id,
      'text': "Checkout"
    })).after($("<div></div>", {
      'class': "clearfix"
    }));
  },

  viewAnalysis: function(event) {

    var graphID = event.target.attributes.name.value.replace("btn_", "");

    Backbone.ajax({
      type: 'GET',
      url: remote_server + '/VC/rest/analysis/' + graphID,
      success: function(data) {

        // validates the json data
        var result = validateFile(data);

        if (result == 'success') {
          // initialises a workbox
          $("#row-workbox").show();
          $("#row-browsebox").hide();

          app.workBoxView.clearWorkBox();

          // saves the meta data of the graph
          chart.graph_id = data['graphID'];
          chart.title = data['title'];
          chart.desciption = data['description'];
          chart.date = data['date'];

          var nodes = data['nodes'];
          var edges = data['edges'];

          // set up simulations for force-directed graphs
          var ret_simulation = set_simulation(15, chart.svg.width, chart.svg.height);
          push_node_style_data(ret_simulation);

          // the simulation used when drawing a force-directed graph
          chart.simulation = ret_simulation.simulation;

          var ret_graph = draw(nodes, edges, chart);
          push_graph_data(ret_graph);

          // start simulation for displaying graphsv
          chart.simulation = restart_simulation(chart.simulation, false);

          $("#saveProgress").attr("disabled", true);
        } else {
          alert(result);
          return ("Fail");
        }
      },
      error: function(xhr) {
        console.error("Ajax failed: " + xhr.statusText);
        alert('An error occurred fetching data.');
      }
    });
  },

  checkoutAnalysis: function(event) {
    var graphID = event.target.attributes.name.value.replace("btn_", "");
  },

  selectFile: function() {

    // app.workBoxView.clearWorkBox();

    var input_file = $("#myFile").click();

    return input_file;
  },

  importFromFile: function(event) {
    readFile(event.target.files, function(data) {
      var jsonData = JSON.parse(data);

      var graphID = jsonData['graphID'];

      if (_.isEmpty(graphID)) {
        alert("There is no id for this graph in a file");
        return null;
      }

      var existing_flag = true;

      // 1. Check this graph belongs to the user or not
      Backbone.ajax({
        type: 'GET',
        url: remote_server + "/VC/rest/analyses/user/" + readCookie('user_id') + "/meta",
        success: function(data) {
          if (data) {
            var existing = data.find(function(d) {
              return d.graphID == graphID;
            });

            if (existing) {
              alert("A graph exists with this id.");
              return null;
            } else {
              existing_flag = false;
            }
          }
        },
        error: function(xhr) {
          console.error(xhr);
          alert("An error occurred fetching data");
        }
      });

      // 2. Check this graph is saved in database
      Backbone.ajax({
        type: 'GET',
        url: remote_server + "/VC/rest/analysis/" + graphID + "/meta",
        success: function(data) {
          if (data) {
            alert("A graph exists with this id in database.");
            return null;
          } else {
            existing_flag = false;
          }
        },
        error: function(xhr) {
          console.error(xhr);
          alert("An error occurred fetching data");
        }
      });

      if (!existing_flag) {
        // 3. Registers a new graph using jsonData
        var title = jsonData['title'];
        var description = jsonData['description'];

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
          contentType: 'application/json',
          data: JSON.stringify(object),
          success: function(result) {

            // 4. The graph is drawn in workBox invisually
            // initialises a workbox
            $("#row-workbox").show();

            app.workBoxView.clearWorkBox();

            // saves the meta data of the graph
            var nodes = jsonData['nodes'];
            var edges = jsonData['edges'];

            var ret_graph = draw(nodes, edges, chart);
            push_graph_data(ret_graph);

            // 5. Saves the graph in database
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

            // 6. Creates a button in the browsebox
            var analysis = {
              'graph_id': graphID,
              'title': title,
              'user': jsonData['user'],
              'date': jsonData['date'],
              'description': description
            };

            this.makeGraphElement(analysis);
          },
          error: function(xhr) {
            console.error("Ajax failed: " + xhr.statusText);
            alert('Something went wrong. Please try again.');
          }
        });
      }
    });
  },

  exportToFile: function(event) {

    var graphID = event.target.attributes.name.value.replace("btn_", "");

    Backbone.ajax({
      type: 'GET',
      url: remote_server + "/VC/rest/analysis/" + graphID,
      success: function(data) {
        if (data) {
          var file = new Blob([JSON.stringify(data)], {
            type: 'text/plain'
          });
          obj.target.href = URL.createObjectURL(file);
          obj.target.download = "export_" + graphID + ".cis";
        }
      },
      error: function(xhr) {
        console.error(xhr);
        alert("An error occurred fetching data");
      }
    });
  }
});
