var app = app || {};

app.NodeView = Backbone.View.extend({

  tagName: 'form',
  template: _.template($('#node-template').html()),

  events: {
    'click .btn-outline': 'update'
  },

  initialize: function() {
    this.listenTo(this.collection, 'add', this.create);
    this.listenTo(this.model, 'destroy', this.remove);
  },

  render: function() {
    this.$el.html(this.template(this.model.attributes));

    this.$el.attr("id", "node_" + this.model.attributes['nodeID']);
    this.$el.attr("role", "form");
    this.$el.attr("style", "display: none");

    return this;
  },

  update: function() {

    var nodeID = "node_" + this.model.get('nodeID');

    var origin_text = this.model.get('text');
    var updated_text = $('#' + nodeID + ' textarea').val().trim();

    if (updated_text != origin_text) {
      this.model.save({
        'text': updated_text
      });

  	  $("#draw_" + this.model.get('nodeID') + ' text').html(parseText(updated_text));
  	  $("#draw_" + this.model.get('nodeID') + ' rect title').text(updated_text);
    }

    $("#saveProgress").attr("disabled", false);

	  return this.model;
  }
});
