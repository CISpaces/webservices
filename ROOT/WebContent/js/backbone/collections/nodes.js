/**
 * collection(list of models) for a node which is used in cispaces
 */

var app = app || {};

var NodeList = Backbone.Collection.extend({

  model: app.Node,

  // localStorage: new Backbone.LocalStorage('nodes-backbone'),
  url: 'VC/rest/node'
  
});

app.Nodes = new NodeList();
