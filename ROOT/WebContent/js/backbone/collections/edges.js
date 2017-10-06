/**
 * collection(list of models) for an edge which is used in cispaces
 */

var app = app || {};

var EdgeList = Backbone.Collection.extend({

  model: app.Edge,

  // localStorage: new Backbone.LocalStorage('edges-backbone'),
  headers: {"Authorization": localStorage.getItem('auth_token')},

  url: function() {
      var url = '/VC/rest/edge';
      // if (this.get('edgeID').length > 0) url += '/'+this.get('edgeID');
      return url;
  }

});

app.Edges = new EdgeList();
