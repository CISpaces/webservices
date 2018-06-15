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
    'click .btn-checkout': 'viewAnalysis',

    'click .btn-export': 'exportToFile',
    'click .btn-delete': 'deleteAnalysis'
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
          url: 'VC/rest/new',
          //dataType: 'text',
          contentType: 'application/json', //Supply the JWT auth token
          data: JSON.stringify(object),
          success: function(result) {

            $("#row-workbox").show();

            app.workBoxView.clearWorkBox();

            var ret_graph = draw([], [], chart);
            push_graph_data(ret_graph);

            $("#saveProgress").attr("disabled", true);

            // saves the meta data of the graph
            chart.graphID = graphID;
            chart.title = object.title;
            chart.desciption = object.description;
            chart.date = object.timest;
            $("#span-graphTitle").text("[" + chart.title + "]");

            $("#row-browsebox").hide();
            app.toolBoxView.$el.show();

            app.browseBoxView.toggleViewMode(false);

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

  getAnalysis: function(graphID, callback) {
    Backbone.ajax({
      type: 'GET',
      url: 'VC/rest/analysis/' + graphID,
      success: function(response, status, xhr) {
        // change the type of annot
        if(response.nodes){
          response.nodes.forEach(function(d){
            try{
            d.annot = JSON.parse(d.annot);
          } catch(error){
            console.log(error);
          }
          });
        }
        callback(response, status, xhr);
      },
      error: function(xhr) {
        console.error("Ajax failed: " + xhr.statusText);
        alert('An error occurred fetching data.');
      }
    });
  },

  getAnalysisList: function() {
    var userID = readCookie('user_id');
    var self = this;

    Backbone.ajax({
      type: 'GET',
      url: 'VC/rest/analyses/user/' + userID + '/meta',
      success: function(data) {
        $(".existing-analysis").remove();
        data.forEach(function(analysis) {
          self.makeGraphElement(analysis);
        });
      },
      error: function(xhr) {
        console.error("Ajax failed: " + xhr.statusText);
      }
    });
  },
    
  makeGraphElement: function(analysis) {
    var div_panel = $("<div></div>", {
      'class': "panel panel-green"
    }).appendTo($("<div></div>", {
      'class': "existing-analysis col-lg-2 col-md-4",
      'id': "panel_"+analysis.graphID
    }).appendTo($("#browse_box")));

    var div_heading = $("<div></div>", {
      'class': "panel-heading"
    }).appendTo(div_panel);

    /*
    $("<label></label>", {
      'text': "graphID",
      'style': "margin: 5px 10px"
    }).appendTo($("<div></div>", {
      'class': "row"
    }).appendTo(div_heading)).after($("<span></span>", {
      'text': analysis.graphID
    }));
    */

    $("<label></label>", {
      'text': "Title:",
      'style': "margin: 5px 10px"
    }).appendTo($("<div></div>", {
      'class': "row"
    }).appendTo(div_heading)).after($("<span></span>", {
      'text': analysis.title
    }));

    $("<label></label>", {
      'text': "Description:",
      'style': "margin: 5px 10px"
    }).appendTo($("<div></div>", {
      'class': "row"
    }).appendTo(div_heading)).after($("<span></span>", {
      'text': analysis.description
    }));

    $("<label></label>", {
      'text': "Date:",
      'style': "margin: 5px 10px"
    }).appendTo($("<div></div>", {
      'class': "row"
    }).appendTo(div_heading)).after($("<span></span>", {
      'text': analysis.timest
    }));

    var btn = $("<button></button>", {
      'class': "pull-right btn btn-xs btn-outline btn-info btn-export",
      'name': "btn_" + analysis.graphID,
      'text': "Export",
      'title': "Export this analysis to file"
    }).appendTo($("<div></div>", {
      'class': "panel-footer"
    }).appendTo(div_panel)).before($("<button></button>", {
      'class': "pull-left btn btn-xs btn-outline btn-success btn-view",
      'name': "btn_" + analysis.graphID,
      'text': "View",
      'title': "View this analysis (read-only)"
    })).before($("<button></button>", {
      'class': "pull-left btn btn-xs btn-outline btn-success btn-checkout",
      'style': "margin-left: 5px",
      'name': "btn_" + analysis.graphID,
      'text': "Checkout",
      'title': "Checkout this analysis for editing"
    })).before($("<button></button>", {
      'class': "btn btn-xs btn-outline btn-danger btn-delete",
      'name': "btn_" + analysis.graphID,
      'style': "margin-left: 5px",
      'text': "Delete",
      'title': "Permanently delete this analysis"
    })).after($("<div></div>", {
      'class': "clearfix"
    }));
  },

  toggleViewMode: function(_view_flag) {

    view_flag = _view_flag;

    if (view_flag) {
      // If a user click [View] button, the user should not be able to edit the graph
      $("#info").hide();
      $("#claim").hide();
      $("#pref").hide();
      $("#con").hide();
      $("#pro").hide();

      $("#delete-node").addClass("disabled");
      $("#link-from").addClass("disabled");
      $("#link-to").addClass("disabled");
      $("#cancel-link").addClass("disabled");

      $("#commitGraph").hide();
      $("#checkoutGraph").show();

      $("#span-viewMode").text("(View Only)");
    } else {
      $("#info").show();
      $("#claim").show();
      $("#pref").show();
      $("#con").show();
      $("#pro").show();

      $("#delete-node").removeClass("disabled");
      $("#link-from").removeClass("disabled");
      $("#cancel-link").removeClass("disabled");

      $("#commitGraph").show();
      $("#checkoutGraph").hide();

      $("#span-viewMode").text("");
    }
  },

  viewAnalysis: function(event) {

    var graphID = event.target.attributes.name.value.replace("btn_", "");

    this.toggleViewMode((event.target.attributes.class.value.indexOf("view") > 0));

    this.getAnalysis(graphID, function(data) {
      // validates the json data
      // var result = validateFile(data);
      var result = "success";
      if (result == 'success') {
        // initialises a workbox
        $("#row-workbox").show();
        $("#row-browsebox").hide();
        app.toolBoxView.$el.show();

        app.workBoxView.clearWorkBox();

        // saves the meta data of the graph
        chart.graphID = data['graphID'];
        chart.title = data['title'];
        chart.desciption = data['description'];
        chart.date = data['timest'];

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

        $("#span-graphTitle").text("[" + chart.title + "]");
      } else {
        alert(result);
        return ("Fail");
      }
    });
  },

  selectFile: function() {

    // app.workBoxView.clearWorkBox();

    var input_file = $("#myFile").click();

    return input_file;
  },

  importFromFile: function(event) {
    readFile(event.target.files, function(jsonData) {
      var graphID = jsonData['graphID'];
      var userID = readCookie('user_id');

      var existing = null;

      // 1. Check this graph belongs to the user or not
      Backbone.ajax({
        type: 'GET',
        url: "VC/rest/analyses/user/" + userID + "/meta",
        success: function(data) {
          if (data) {
            existing = data.find(function(d) {
              return d.graphID == graphID;
            });

            if(!_.isEmpty(existing)){
              alert("A graph exists with this id.");
            }
          }
        },
        error: function(xhr) {
          console.error(xhr);
          alert("An error occurred fetching data");
        },
        complete: function(xhr){

          if(_.isEmpty(existing)){
            // 2. Check this graph is saved in database
            Backbone.ajax({
              type: 'GET',
              url: "VC/rest/analysis/" + graphID + "/meta",
              success: function(data) {
                if (data) {
                  alert("A graph exists with this id in database.");
                }
              },
              error: function(xhr) {
                console.log(xhr);
              },
              complete: function(xhr) {
                if (xhr.status == 404) {
                  // 3. Registers a new graph using jsonData
                  var title = jsonData['title'];
                  var description = jsonData['description'];

                  var object = {
                    "graphID": graphID,
                    "userID": userID,
                    "timest": generateDate(),
                    "title": title.trim(),
                    "description": description.trim(),
                    "isshared": false,
                    "parentgraphid": null
                  };

                  Backbone.ajax({
                    type: 'POST',
                    url: 'VC/rest/new',
                    contentType: 'application/json',
                    data: JSON.stringify(object),
                    success: function(result) {

                      // 4. The graph is drawn in hidden workBox in order to call the endpoint of every node and edge
                      // initialises a workbox
                      $("#row-workbox").show();

                      app.workBoxView.clearWorkBox();

                      $("#row-workbox").hide();

                      // saves the meta data of the graph
                      var nodes = jsonData['nodes'];
                      var edges = jsonData['edges'];

                      var ret_graph = draw(nodes, edges, chart);
                      push_graph_data(ret_graph);
                    },
                    error: function(xhr) {
                      console.error("Ajax failed: " + xhr.statusText);
                      alert('Something went wrong. Please try again.');
                    }
                  });

                  // 5. Saves the graph in database
                  Backbone.ajax({
                    type: 'POST',
                    url: 'VC/rest/save',
                    //dataType: 'text',
                    contentType: 'application/json',
                    data: JSON.stringify(object),
                    success: function(result) {
                      confirm("Analysis [" + title + "] saved.");
                    },
                    error: function(xhr) {
                      alert('Something went wrong. Please try again.');
                      console.log(xhr);
                    }
                  });

                  // 6. Creates a panel in the browsebox
                  app.browseBoxView.makeGraphElement(object);
                }
              }
            });
          }
        }
      });
    });
  },

  exportToFile: function(event) {

    var graphID = event.target.attributes.name.value.replace("btn_", "");

    this.getAnalysis(graphID, function(fileContent, status, xhr) {

      // check for a filename
      var fileName = event.target.parentElement.parentElement.firstElementChild.firstElementChild.getElementsByTagName("span")[0].innerText;
      if (_.isEmpty(fileName)) {
        fileName = graphID;
      }

      fileName = "export_" + fileName + ".cis";

      var disposition = xhr.getResponseHeader('Content-Disposition');
      if (disposition && disposition.indexOf('attachment') !== -1) {
        var fileNameRegex = /fileName[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
        var matches = fileNameRegex.exec(disposition);
        if (matches != null && matches[1]) {
          fileName = matches[1].replace(/['"]/g, '');
        }
      }

      var type = 'text/plain;charset=utf-8'; // xhr.getResponseHeader('Content-type');
      var blob = new Blob([JSON.stringify(fileContent)], {
        type: type
      });

      if (typeof window.navigator.msSaveBlob !== 'undefined') {
        window.navigator.msSaveBlob(blob, fileName);
      } else {
        var URL = window.URL || window.webkitURL;
        var downloadUrl = URL.createObjectURL(blob);

        if (fileName) {
          var a = document.createElement("a");
          if (typeof a.download === 'undefined') {
            window.location = downloadUrl;
          } else {
            a.href = downloadUrl;
            a.download = fileName;
            document.body.appendChild(a);
            a.click();
          }
        } else {
          window.location = downloadUrl;
        }

        setTimeout(function() {
          URL.revokeObjectURL(downloadUrl);
        }, 100);
      }
    });
  },
  
  deleteAnalysis: function(event) {
      if(confirm("Permanently delete this analysis?")) {
      var graphID = event.target.attributes.name.value.replace("btn_", "");
      Backbone.ajax({
      type: 'DELETE',
      url: 'VC/rest/analysis/' + graphID,
      success: function(data) {
          $("#panel_"+graphID).remove();
      },
      error: function(xhr) {
        console.error("Deleting graph failed: " + xhr.statusText);
      }
    });
      }
  }
});
