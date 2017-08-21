//js/views/chatBox.js

var app = app || {};

/**
 * ChatBox
 * ---------------------------------
 * the UI for 'chatBox'
 */

app.ChatBoxView = Backbone.View.extend({
	el: '#chatBox',

	events: {
		'click #join': 'join',
		'click #leave': 'leave',
		'click #submit': 'submit'
	},

	initialize: function(){

	},

	render: function(){

	},

	join: function(){
		alert('join');
	},

	leave: function(){
		alert('leave');
	},

	submit: function(){
		alert('submit');
	}
});