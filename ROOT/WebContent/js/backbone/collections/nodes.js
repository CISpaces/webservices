/**
 * collection(list of models) for a node which is used in cispaces
 */

var app = app || {};

var NodeList = Backbone.Collection.extend({

  model: app.Node,

  // localStorage: new Backbone.LocalStorage('nodes-backbone'),
  headers: {"Authorization": localStorage.getItem('auth_token')},

  url: function() {
      var url = '/VC/rest/node';
      // if (this.get('nodeID').length > 0) url += '/'+this.get('nodeID');
      return url;
  }

});

app.Nodes = new NodeList();
