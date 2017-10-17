/**
 * global functions for cispaces
 */
function generateUUID() {
  var d = new Date().getTime();

  var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
    var r = (d + Math.random() * 16) % 16 | 0;
    d = Math.floor(d / 16);
    return (c == 'x' ? r : (r & 0x7 | 0x8)).toString(16);
  });

  return uuid;
}

function createCookie(name, value, days) {
  if (days) {
    var date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    var expires = "; expires=" + date.toGMTString();
  } else {
    var expires = "";
  }
  document.cookie = name + "=" + value + expires + "; path=/";
}

function readCookie(name) {
  var nameEQ = name + "=";
  var ca = document.cookie.split(';');
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ')
      c = c.substring(1, c.length);

    if (c.indexOf(nameEQ) == 0)
      return c.substring(nameEQ.length, c.length);
  }

  return null;
}

function validateFile(input_file){ // validate json format of the file

        var jv = new JSONValidation(); // It uses JSONValidate library

        // Get CIspaces schema
        var schemaFile = '/CISpaces.schema.json';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET", schemaFile, false);
        xmlhttp.send();
        if (xmlhttp.status==200) {
                schema = JSON.parse(xmlhttp.responseText);
                //validate the file
                result = jv.validate(input_file, schema);
                //console.log(result);
                if(result.ok){
                        return("success");
                }
                else{
                        console.log("JSON has the following errors: " + result.errors.join(", ") + " at path " + result.path);
                        return("Fail");
                }
        } else return("Fail");
}

function readFile(input_files){

       var file = input_files[0];
       var reader = new FileReader();

       reader.onload = function(progressEvent){

	        // Entire file
	        var jsonData = JSON.parse(this.result);
	        //call the Validate File funtion to validate json
	        var res = validateFile(jsonData);

	        if(res == 'success'){
		        var nodes = jsonData['nodes'];
	            var edges = jsonData['edges'];

	            if(!nodes && !edges){
	                nodes = jsonData['graph']['nodes'];
	                edges = jsonData['graph']['edges'];
	            }

	            // set up simulations for force-directed graphs
	            var ret_simulation = set_simulation(15, chart.svg_width, chart.svg_height);
	            push_node_style_data(ret_simulation);

	            // the simulation used when drawing a force-directed graph
	            chart.simulation = ret_simulation.simulation;

	            var ret_graph = draw(nodes, edges, chart);
	            push_graph_data(ret_graph);

	            // start simulation for displaying graphsv
	            chart.simulation = restart_simulation(chart.simulation, false);

              $("#saveProgress").attr("disabled", true);
	        }
	        else {
	            console.log("Invalid JSON format");
	            return("Fail");
	        }
        };

        reader.onerror = function(event){
                console.log("Fail to read the file:");
                console.log(event);
        };

        reader.readAsText(file);

        return reader;
}

function alertMessage(obj, msg) {
  // if the edge connects between i-nodes(Info, Claim), shows an error message
  var alert_msg = $(".alert-danger span").html(msg);
  $(".alert-danger").show().css({
    "position": "absolute",
    "left": obj.pageX,
    "top": obj.pageY,
    "z-index": 1000,
    "width": "220px"
  }).on('click', 'a', function(obj) {
    $(".alert-danger").hide();
  });

  return alert_msg;
}

function parseText(content) {

  var result = "";

  if (content) {
    if (content.length < 12) {
      result = content;
    } else {
      var split = content.split(' ');
      if (split.length == 1 || split.length == 2) {
        result = content;
      } else {
        result = split[0] + ' ' + split[1] + "...";
      }
    }
  }

  return result;
}
