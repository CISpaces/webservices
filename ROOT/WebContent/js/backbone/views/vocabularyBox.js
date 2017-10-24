var app = app || {};

/**
 * VocabularyBox
 * -----------------------------------------
 * the UI for 'vocabularyBox'
 */

app.VocabularyBoxView = Backbone.View.extend({
  el: '#vocabulary_box',

  events: {
    'click .input-group-btn': 'createTopic'
  },

  initialize: function() {
    this.$el.attr("style", "height: " + (chart.svg.height - 60) / 2 + "px");

    // Brings a list of topics from FEWS services
    app.Topics.fetch({
      // headers: {'Authorization': localStorage.getItem('auth_token')},
      success: function(data) {
        if (data) {
          data.forEach(function(d) {
            app.vocabularyBoxView.addTopic(d.attributes);
          });
        }
      },
      error: function(response) {
        console.error("Could not get Topics");
        console.error(response);
      }
    });

    this.$el.find("input").on("keydown", function(event) {
      if (event.which == 13 || event.keyCode == 13) {
        app.vocabularyBoxView.createTopic();
      }
    });
  },

  render: function() {},

  createTopic: function() {
    var topic = $("#vocabulary_box .input-group input").val();

    if (!topic || typeof(topic) == "undefined" || topic == "") {
      alert("Please, enter a topic");
      return;
    }

    var param = {
      'name': topic,
      'keyword': '-1'
    };

    this.addTopic(param);

    $("#vocabulary_box .input-group input").val("");
  },

  addTopic: function(topic) {

    var p = $("<p></p>").appendTo($("#vocabulary_box .topic-form"));

    var div_vocab = $("<div></div>", {
      "class": "form-group"
    }).appendTo(p);

    var div_alert = $("<div></div>", {
      "class": "alert alert-info alert-infobox float_left",
      "text": topic.name
    }).appendTo(div_vocab);

    var button = $("<i></i>", {
      "class": "fa fa-minus"
    }).appendTo($("<button></button>", {
      "type": "button",
      "class": "btn btn-default"
    }).click(function() {
      p.remove();
    }).appendTo(div_vocab));

    var div_keywords = $("<div></div>", {
      "class": "form-group"
    }).appendTo(p);

    var label = $("<label></label>", {
      "text": "Keywords"
    }).appendTo(div_keywords);

    var span = $("<span></span>", {
      "text": topic.keyword ? topic.keyword : "Here is for keywords"
    }).appendTo($("<label></label>").appendTo(div_keywords));
  }
});
