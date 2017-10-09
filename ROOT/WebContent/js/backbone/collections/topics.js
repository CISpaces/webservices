/**
 * collection of Topics for CISpaces
 */

var app = app || {};

var TopicList = Backbone.Collection.extend({
    model: app.Topic,
    url: '/fewsservlet/topics',
    headers: {"Authorization": localStorage.getItem('auth_token')}
});

app.Topics = new TopicList();
