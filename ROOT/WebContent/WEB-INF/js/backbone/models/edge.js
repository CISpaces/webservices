/**
 * model for an edge which is used in cispaces
 */

var app = app || {};

app.Edge = Backbone.Model.extend({
	defaults:{
		targete: '',
		source: '',
		formEdgeID: '',
		edgeID: '',
		className: 'edge'
	}
});