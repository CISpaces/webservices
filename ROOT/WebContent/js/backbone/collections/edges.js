/**
 * collection(list of models) for an edge which is used in cispaces
 */

var app = app || {};

var EdgeList = Backbone.Collection.extend({

  model: app.Edge,

  // localStorage: new Backbone.LocalStorage('edges-backbone'),
  url: vm_server + '/VC/rest/edge'
  
});

app.Edges = new EdgeList();
