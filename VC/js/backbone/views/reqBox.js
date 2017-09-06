//js/views/reqBox.js

var app = app || {};

/**
 * ReqBox
 * ---------------------------------
 * the UI for 'reqBox'
 */

app.ReqBoxView = Backbone.View.extend({
	el: '#reqBox',

	events: {
		'click #create': 'create',
		'click #crowd': 'crowd',
		'click #get': 'get',
		'click #ans': 'ans',
		'click #term': 'term',
		'click #delReq': 'delReq',
		'click #stats': 'stats'
	},

	initialize: function(){

	},

	render: function(){

	},

	create: function(){
		alert('create');
	},

	crowd: function(){
		alert('crowd');
	},

	get: function(){
		alert('get');
	},

	ans: function(){
		alert('ans');
	},

	term: function(){
		alert('term');
	},

	delReq: function(){
		alert('delReq');
	},

	stats: function(){
		alert('stats');
	},

	showBox: function(val){
		this.$el.attr('style', val ? 'display: block' : 'display: none');
	}
});