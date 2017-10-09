/**
 * collection of Topics for CISpaces
 */

var app = app || {};

var TopicList = Backbone.Collection.extend({
    model: app.Topic,
    url: '/fewsservlet/topics'
});

app.Topics = new TopicList();
