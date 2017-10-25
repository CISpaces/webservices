/**
 * model of a vocabulary used in CISpaces
 */

var app = app || {};

app.Vocabulary = Backbone.Model.extend({
  defaults: {
    topic_name: '',
    topic_type: '',
    keywords: {}
  }
});
