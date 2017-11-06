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

    // Brings a list of vocab from FEWS service
    app.Vocabularies.fetch({
      success: function(data) {
        if (data) {
          data.forEach(function(d) {
            app.vocabularyBoxView.addTopic(d.attributes);
          });
        }
      },
      error: function(response) {
        alert("Your JWT is probably out of date, please relog");
        console.error("Could not get vocabulary");
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
    var topic = this.$(".input-group input").val();

    if (!topic || typeof(topic) == "undefined" || topic == "") {
      alert("Please, enter a topic");
      return;
    }

    // TODO get schema and keywords from user
    var param = {
        'topic': topic,
        'schema': topic,
        'keywords': [topic]
    };

    if (app.Vocabularies.where({"topic": topic}).length) {
        // Topic already exists so flash an error
        this.$(".input-group input").addClass("alert-danger");
        this.$(".input-group input").val("Topic already exists in vocabulary");
        setTimeout(function(){
            this.$(".input-group input").val("");
            this.$(".input-group input").removeClass("alert-danger");
        }, 1500);

    } else {

        var self = this; // This is a hack

        Backbone.ajax({
            type: "POST",
            url: remote_server + "/fewsservlet/vocab/" + param.topic + "/schema/" + param.schema,
            success: function(result) {
                Backbone.ajax({
                    type: "POST",
                    url: remote_server + "/fewsservlet/vocab/" + param.topic + "/keywords/" + param.keywords[0],
                    success: function(result) {
                        self.addTopic(param);
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        alert("AJAX failed: " + errorThrown);
                    }
                });
            },
            error: function(xhr, textStatus, errorThrown) {
                alert("AJAX failed: " + errorThrown);
            }
        });

        this.$(".input-group input").val("");
    }
  },

  addTopic: function(topic) {

    var p = $("<p></p>").appendTo(this.$(".topic-form"));

    var div_vocab = $("<div></div>", {
      "class": "form-group"
    }).appendTo(p);

    var div_alert = $("<div></div>", {
      "class": "alert alert-info alert-infobox float_left",
      "text": topic.topic
    }).appendTo(div_vocab);

    var button = $("<i></i>", {
      "class": "fa fa-minus"
    }).appendTo($("<button></button>", {
      "type": "button",
      "class": "btn btn-default"
    }).click(function() {
      Backbone.ajax({
          type: "DELETE",
          url: remote_server + "/fewsservlet/vocab/" + topic.topic,
          success: function(result) {
              p.remove();
          },
          error: function(xhr, textStatus, errorThrown) {
              alert("AJAX failed: " + errorThrown);
          }
      });
    }).appendTo(div_vocab));

    var div_keywords = $("<div></div>", {
      "class": "form-group"
    }).appendTo(p);

    var label = $("<label></label>", {
      "text": "Keywords"
    }).appendTo(div_keywords);

    var span = $("<span></span>", {
      "text": topic.keywords ? topic.keywords : "Here is for keywords"
    }).appendTo($("<label></label>").appendTo(div_keywords));
  },

  clearTopic: function() {
    this.$(".topic-form").html(" ");
  }
});
