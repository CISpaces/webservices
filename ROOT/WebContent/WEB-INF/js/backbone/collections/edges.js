/**
 * collection(list of models) for an edge which is used in cispaces
 */

var app = app || {};

var EdgeList = Backbone.Collection.extend({

  model: app.Edge,

  localStorage: new Backbone.LocalStorage('todos-backbone'),
/*
  url: function() {
      var url = '/api/edges';
      // if (this.get('edgeID').length > 0) url += '/'+this.get('edgeID');
      return url;
  } 
 */
});

app.Edges = new EdgeList();