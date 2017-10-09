/**
 * model for an edge which is used in cispaces
 */

var app = app || {};

app.Edge = Backbone.Model.extend({
	defaults:{
		target: '',
		source: '',
		formEdgeID: '',
		edgeID: '',
		className: 'edge',
		graphID: ''
	}
});
