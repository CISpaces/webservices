//js/views/evalBox.js

var app = app || {};

/**
 * EvalBox
 * ---------------------------------
 * the UI for 'evalBox'
 */

app.EvalBoxView = Backbone.View.extend({
	el: '#evalBox',

	events: {
		'click #eval': 'eval',
		'click #clear': 'clear',
		'click #nlg': 'nlg',
		'click #close': 'close'
	},

	initialize: function(){
		// this.$el.attr('style', 'display: none');
	},

	render: function(){

	},

	eval: function(){
		alert('eval');
	},

	clear: function(){
		alert('clear');
	},

	nlg: function(){
		alert('nlg');
	},

	close: function(){
		alert('close');
	},

	showBox: function(val){
		this.$el.attr('style', val ? 'display: block' : 'display: none');
	}
});