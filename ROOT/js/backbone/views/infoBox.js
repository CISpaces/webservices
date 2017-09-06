//js/views/infoBox.js

var app = app || {};

/**
 * InfoBox
 * ---------------------------------
 * the UI for 'infoBox'
 */

app.InfoBoxView = Backbone.View.extend({
	el: '#infoBox',

	events: {
	},

	initialize: function(){
		// example
		this.$el.html('<h2 class="center">InfoBox</h2><div class="infoNode node">Everything normal in Kish, UK</div>');
	},

	render: function(){

	}
});