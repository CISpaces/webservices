var app = app || {};

app.Tweet = Backbone.Model.extend({
    defaults: {
        extract: "",
        id: 0,
        text: "",
        uri: ""
    }
});