var app = app || {};

app.NodeView = Backbone.View.extend({

  className: 'modal fade',

  template: _.template($('#node-template').html()),

  events: {
    'click .modal-footer button': 'close'
  },

  initialize: function() {
    this.listenTo(this.model, 'destroy', this.remove);
  },

  render: function() {
    this.$el.html(this.template(this.model.attributes));

    this.$el.attr("id", "node_" + this.model.attributes['nodeID']);
    this.$el.attr("role", "dialog");

    return this;
  },

  close: function() {
    var nodeID = "node_" + this.model.get('nodeID');

    var origin_text = this.model.get('text');
    var updated_text = $('#' + nodeID + ' textarea').val().trim();

    if (updated_text != origin_text) {
      this.model.save({
        'text': updated_text
      // 'eval': $('#' + nodeID + ' .eval').val(),
      // 'commit': $('#' + nodeID + ' .commit').val(),
      // 'uncert': $('#' + nodeID + ' .uncert').val()
      });
      updateText(this.model.attributes);
    }

    this.$el.hide();
  }
});