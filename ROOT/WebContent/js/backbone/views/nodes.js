var app = app || {};

app.NodeView = Backbone.View.extend({

  tagName: 'div',
  className: 'modal fade',
  template: _.template($('#node-template').html()),

  events: {
    'click .btn-update': 'update',
    'click .btn-create': 'createCriticalQuestions'
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

    if (this.model.attributes.type == "RA") { // If a node is 'pro' link
      var nodeID = this.model.attributes.nodeID;

      d3.json("./cqs.json", function(data) {
        d3.keys(data["L"]).forEach(function(d) {
          var option = $("<option></option>", {
            'value': d,
            'text': d + " - " + data["L"][d]
          }).appendTo($("#node_" + nodeID + " .row-link select"));
        });

        $("#node_" + nodeID + " .row-link select").change(function(d) {
          var selected = $("#node_" + nodeID + " .row-link select option:selected").val();
          $("#node_" + nodeID + " .row-text textarea").text(selected);
        });
      });

      this.$(".row-critical").hide();
    } else {
      this.$(".row-link").hide();
      this.$(".row-critical").hide();
    }

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
      chart.nodes.forEach(function(d) {
        if (d.nodeID == nodeID) {
          d.text = updated_text
        }
      });

      $("#saveProgress").attr("disabled", false);
    }

    $("#node_" + nodeID).modal('hide');

    return this.model;
  },

  createCriticalQuestions: function(event) {

    var nodeID = this.model.id;

    // gets information on a critical question and an answer of the question
    var cq = $("#node_" + nodeID + " .row-critical select[name=" + event.target.name.replace("btn", "sel") + "] option:selected").val();
    var link = cq.replace("CQ", "L").substring(0, 3);

    var cqansw = "";
    d3.json("./schema.json", function(data) {
      cqansw = data[link]["CQANSW"][cq];

      if (cqansw) {
        // add hypotheses using the question and the answer

        // temparary postion -> centre of workBox
        var x = chart.svg.width / 2;
        var y = chart.svg.height / 2;

        // creates model of the con node labelled using cq
        var cq_con_node = app.workBoxView.createNode("con", null, cq);

        // draws a new node
        chart.node = addNewNode(cq_con_node, x, y);

        // make a link between current node and created con node
        // create a new model of edge
        var link_current_con = app.workBoxView.createEdge(cq_con_node.nodeID, nodeID);

        // draw the node
        chart.edge = addNewEdge(link_current_con);

        // creates model of the claim node labelled using cqansw
        var cqansw_claim_node = app.workBoxView.createNode("claim", null, cqansw);

        // draws a new node
        chart.node = addNewNode(cqansw_claim_node, x, y);

        // make a link between created con node and created claim node
        // create a new model of edge
        link_con_claim = app.workBoxView.createEdge(cqansw_claim_node.nodeID, cq_con_node.nodeID);

        // draw the node
        chart.edge = addNewEdge(link_con_claim);

        // re-start changed graph
        app.toolBoxView.restartSimulation();
      }

      $("#node_" + nodeID + " .row-critical button[name=" + event.target.name + "]").toggleClass("disabled");
    });

    // $("#node_" + nodeID).modal('hide');
  }
});
