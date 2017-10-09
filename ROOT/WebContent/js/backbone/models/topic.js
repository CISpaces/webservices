/**
 * model of a topic used in CISpaces
 */

var app = app || {};

app.Topic = Backbone.Model.extend({
    defaults:{
        name: '',
        negated: -1,
        genuine: -1
    }
});