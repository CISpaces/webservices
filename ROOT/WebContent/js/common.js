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

function generateDate(){
  // generates created time using format string type
  var now = new Date();

  var year = now.getFullYear();
  var month = now.getMonth() + 1;
  var date = now.getDate();
  var hour = now.getHours();
  var min = now.getMinutes();

  var sec = now.getSeconds();
  if (!Number.isInteger(sec)) {
    sec = parseInt(sec);
  }

  var time = year + "-" + (month < 10 ? "0" + month : month) + "-" +
    (date < 10 ? "0" + date : date) + " " +
    (hour < 10 ? "0" + hour : hour) + ":" +
    (min < 10 ? "0" + min : min) + ":" +
    (sec < 10 ? "0" + sec : sec);

  return time;
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

  return '';
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
                        return("The uploaded file failed validation and could not be opened:\n\n"+result.errors.join(", "));
                }
        } else return("Fail");
}

function readFile(input_files, callback) {

  var file = input_files[0];
  var reader = new FileReader();

  reader.onload = function(progressEvent) {

    // Entire file
    try {
        var jsonData = JSON.parse(this.result);
    }
    catch(err) {
        console.log("The uploaded file was not valid JSON");
        alert("The uploaded file was not valid JSON and could not be opened");
        return("Fail");
     }
    //call the Validate File funtion to validate json
    var res = validateFile(jsonData);

    if (res == 'success') {
      callback(jsonData);
    } else {
      alert(res);
      return ("Fail");
    }
  };

  reader.onerror = function(event) {
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

function parseText(content, length) {

  if(!length && typeof(length) == "undefined"){
    length = slider_wb.slider('getValue');
  }

  if (content && length != 0) {
    if (content.length <= length) {
      return content;
    } else {
      return content.substring(0, length) + "...";
    }
  } else {
    return "";
  }
}
