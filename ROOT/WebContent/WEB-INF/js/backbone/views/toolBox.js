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

	/*
    'click #nProv': 'nProv',
    'click #aProv': 'aProv',
	*/
	
    'click #newWorkBox': 'newWorkBox',
    'click #callFile': 'file',

    'click .btn-sm': 'createNode'
  },

  initialize: function() {

  },

  render: function() {

  },

  settings: function() {
    alert('settings');
  },

  help: function() {
    alert('help');
  },

  /*
  nProv: function() {
    alert('nProv');
  },

  aProv: function() {
    alert('aProv');
  },
	*/
  newWorkBox: function() {
    app.workBoxView.clearWorkBox();
  },

  file: function() {
	  
    app.workBoxView.clearWorkBox();
	  
    var input_file = $("#myFile").click();
	
  },

  createNode: function(obj) {
    var id = obj.currentTarget.id;

    app.workBoxView.createNode(id);
  }
});