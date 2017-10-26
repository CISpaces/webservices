/**
 * collection of Vocabularies for CISpaces
 */

var app = app || {};

var VocabularyList = Backbone.Collection.extend({
  model: app.Vocabulary,
  url: '/fewsservlet/vocab'
});

app.Vocabularies = new VocabularyList();
