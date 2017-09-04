//js/views/moiraBox.js

var app = app || {};

/**
 * MoiraBox
 * ---------------------------------
 * the UI for 'moiraBox'
 */

app.MoiraBoxView = Backbone.View.extend({
	el: '#moiraBox',

	events: {
		'click #ask': 'ask',
		'click #get': 'get',
		'click #open': 'open',
		'click #close': 'close'
	},

	initialize: function(){
		this.$el.attr('style', 'display: none');
	},

	render: function(){

	},

	ask: function(){
		alert('ask');
	},

	get: function(){
		alert('get');
	},

	open: function(){
		alert('open');
	},

	close: function(){
		alert('close');
	},

	showBox: function(val){
		this.$el.attr('style', val ? 'display: block' : 'display: none');
	}
});