/**
 * collection of Topics for CISpaces
 */

var app = app || {};

var TopicList = Backbone.Collection.extend({
    model: app.Topic,
    url: vm_server + '/fewsservlet/topics'
});

app.Topics = new TopicList();
