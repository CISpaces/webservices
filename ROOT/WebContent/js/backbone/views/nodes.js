var app = app || {};

app.NodeView = Backbone.View.extend({

  tagName: 'div',
  className: 'modal fade',
  template: _.template($('#node-template').html()),

  events: {
    'click .btn-update': 'update'
  },

  initialize: function() {
    this.listenTo(this.collection, 'add', this.create);
    this.listenTo(this.model, 'destroy', this.remove);
  },

  render: function() {
    this.$el.html(this.template(this.model.attributes));

    this.$el.attr("id", "node_" + this.model.attributes['nodeID']);
    this.$el.attr("role", "dialog");
    this.$el.attr("style", "display: none");

    return this;
  },

  update: function() {

    var nodeID = this.model.get('nodeID');

    var origin_text = this.model.get('text');
    var updated_text = $("#node_" + nodeID + " textarea").val().trim();

    if (updated_text != origin_text) {
      this.model.save({
        'text': updated_text
      });

      // updates text in the graph
  	  $("#draw_" + nodeID + ' text').html(parseText(updated_text));
  	  $("#draw_" + nodeID + ' rect title').text(updated_text);

      // updates text in the detail box
      $("#details-node .details-text").text(updated_text);

      // updates text in the array of nodes
      chart.nodes.forEach(function(d){
        if(d.nodeID == nodeID){
          d.text = updated_text
        }
      });

      $("#saveProgress").attr("disabled", false);
    }

    $("#node_" + nodeID).modal('hide');

	  return this.model;
  }
});
