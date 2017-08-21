//js/views/prefBox.js

var app = app || {};

/**
 * PrefBox
 * ---------------------------------
 * the UI for 'prefBox'
 */

app.PrefBoxView = Backbone.View.extend({
	el: '#prefBox',

	events: {
		'click #get': 'get',
		'click #accept': 'accept',
		'click #updElems': 'updElems',
		'click #updPrefs': 'updPrefs'
	},

	initialize: function(){
		this.$el.attr('style', 'display: none');
	},

	render: function(){

	},

	get: function(){
		alert('get');
	},

	accept: function(){
		alert('accept');
	},

	updElems: function(){
		alert('updElems');
	},

	updPrefs: function(){
		alert('updPrefs');
	},

	showBox: function(val){
		this.$el.attr('style', val ? 'display: block' : 'display: none');
	}
});