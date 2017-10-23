var app = app || {};

/**
 * VocabularyBox
 * -----------------------------------------
 * the UI for 'vocabularyBox'
 */

app.VocabularyBoxView = Backbone.View.extend({
  el: '#vocabulary_box',

  events: {

  },

  initialize: function(){
    this.$el.attr("style", "height: " + (chart.svg.height - 60)/2 + "px");

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

    // Brings tweets related to listed topics periodically(30s)
    // var timer = setInterval( "app.infoBoxView.submitTopic()", 30000 );
  },

  render: function(){},

  addTopic: function(topic) {

    var p = $("<p></p>").appendTo($("#vocabulary_box .topic-form"));

    var div = $("<div></div>", {
      "class": "form-group"
    }).appendTo(p);

    var alert_class = "alert-success";
    if (topic.negated == 0) {
      alert_class = "alert-danger";
    } else if (topic.negated == -1) {
      alert_class = "alert-warning";
    }

    var div_alert = $("<div></div>", {
      "class": "alert " + alert_class + " alert-infobox float_left",
      "text": topic.name
    }).appendTo(div);

    var button = $("<i></i>", {
      "class": "fa fa-minus"
    }).appendTo($("<button></button>", {
      "type": "button",
      "class": "btn btn-default"
    }).click(function() {
      p.remove();
    }).appendTo(div));

    var div_negated = $("<div></div>", {
      "class": "form-group"
    }).appendTo(p);

    var negated_true = $("<input/>", {
      "type": "radio",
      "name": "negated-" + topic.name,
      "value": 1,
      "checked": (topic.negated == 1)
    }).click(function(obj) {
      div_alert.addClass("alert-success");
      div_alert.removeClass("alert-danger");
      div_alert.removeClass("alert-warning");
    }).appendTo(
      $("<label></label>", {
        "class": "radio-inline"
      }).appendTo(div_negated)
      .before($("<label></label>", {
        "text": "negated"
      }))
    ).after($("<span></span>", {
      "text": "true"
    }));

    var negated_false = $("<input/>", {
      "type": "radio",
      "name": "negated-" + topic.name,
      "value": 0,
      "checked": (topic.negated == 0)
    }).click(function() {
      div_alert.removeClass("alert-success");
      div_alert.addClass("alert-danger");
      div_alert.removeClass("alert-warning");
    }).appendTo(
      $("<label></label>", {
        "class": "radio-inline"
      }).appendTo(div_negated)
    ).after($("<span></span>", {
      "text": "false"
    }));

    var negated_unknown = $("<input/>", {
      "type": "radio",
      "name": "negated-" + topic.name,
      "value": -1,
      "checked": (topic.negated == -1)
    }).click(function() {
      div_alert.removeClass("alert-success");
      div_alert.removeClass("alert-danger");
      div_alert.addClass("alert-warning");
    }).appendTo(
      $("<label></label>", {
        "class": "radio-inline"
      }).appendTo(div_negated)
    ).after($("<span></span>", {
      "text": "unknown"
    }));

    var div_genuine = $("<div></div>", {
      "class": "form-group"
    }).appendTo(p);

    var genuine_true = $("<input/>", {
      "type": "radio",
      "name": "genuine-" + topic.name,
      "value": 1,
      "checked": (topic.genuine == 1)
    }).appendTo(
      $("<label></label>", {
        "class": "radio-inline"
      }).appendTo(div_genuine)
      .before($("<label></label>", {
        "text": "genuine"
      }))
    ).after($("<span></span>", {
      "text": "true"
    }));

    var genuine_false = $("<input/>", {
      "type": "radio",
      "name": "genuine-" + topic.name,
      "value": 0,
      "checked": (topic.genuine == 0)
    }).appendTo(
      $("<label></label>", {
        "class": "radio-inline"
      }).appendTo(div_genuine)
    ).after($("<span></span>", {
      "text": "false"
    }));

    var genuine_unknown = $("<input/>", {
      "type": "radio",
      "name": "genuine-" + topic.name,
      "value": -1,
      "checked": (topic.genuine == -1)
    }).appendTo(
      $("<label></label>", {
        "class": "radio-inline"
      }).appendTo(div_genuine)
    ).after($("<span></span>", {
      "text": "unknown"
    }));
  }
});
