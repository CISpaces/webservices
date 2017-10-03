//js/views/infoBox.js

var app = app || {};

/**
 * InfoBox
 * ---------------------------------
 * the UI for 'infoBox'
 */

app.InfoBoxView = Backbone.View.extend({
	el: '#info_box',

	events: {
		'click .input-group-btn': 'createTopic',
		'click .btn-submit': 'submitTopic',
		'click .btn-clear': 'clearTopic'
	},

	initialize: function(){
		// example
	},

	render: function(){

	},

	createTopic: function(obj){
		var topic = $("#info_box .input-group input").val();

		if(!topic || typeof(topic) == "undefined" || topic == ""){
			alert("Please, enter a topic");
			return;
		}

		if($('[name="negated-' + topic + '"]').length > 0){
			alert("This topic is already listed");
			return;
		}

		var p = $("<p></p>").appendTo($("#info_box .topic-form"));

		var div = $("<div></div>", {
			"class": "alert alert-success alert-infobox",
			"text": topic
		}).appendTo(p);

		var negated_and = $("<input/>", {
			"type": "radio",
			"name": "negated-" + topic,
			"value": "and",
			"checked": "true"
		}).click(function(obj){
			div.addClass("alert-success");
			div.removeClass("alert-danger");
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(p)
		);

		negated_and.after(
			$("<span></span>", {"text":"And"})
		);

		var negated_not = $("<input/>", {
			"type": "radio",
			"name": "negated-" + topic,
			"value": "not"
		}).click(function(){
			div.addClass("alert-danger");
			div.removeClass("alert-success");
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(p)
		);

		negated_not.after(
			$("<span></span>", {"text":"Not"})
		);

		var genuine_true = $("<input/>", {
			"type": "radio",
			"name": "genuine-" + topic,
			"value": "true",
			"checked": "true"
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(p)
		);

		genuine_true.after(
			$("<span></span>", {"text":"True"})
		);

		var genuine_fake = $("<input/>", {
			"type": "radio",
			"name": "genuine-" + topic,
			"value": "fake"
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(p)
		);

		genuine_fake.after(
			$("<span></span>", {"text":"Fake"})
		);

	},

	submitTopic: function(){
		var topic_list = [];

		var p = $(".topic-form p");
		for(var i = 0 ; i < p.length ; i++){
			var topic = p[i].children[0].innerText;

			var obj = {
				"topic": topic,
				"negated": $('[name="negated-' + topic + '"]:checked').val(),
				"genuine": $('[name="genuine-' + topic + '"]:checked').val()
			}

			topic_list.push(obj);
		}

		alert(JSON.stringify(topic_list));

		var sample = '{"lastUIUpdate":1506525529305,"tweetList":[{"id":22,"text":"","extract":"it was a false report on virus outbreak doing an occupy wall st and rioting the nyse","uri":"https://twitter.com/Mokamsingh/status/263218154279407616"},{"id":23,"text":"","extract":"report on virus outbreak doing an occupy wall st and rioting the nyse it has nt happened","uri":"https://twitter.com/Mokamsingh/status/263218154279407616"},{"id":26,"text":"","extract":"rt @breakingnews rumors of nyse trading floor rioting are not true says","uri":"https://twitter.com/LasiewickiAnn/status/263222115120082945"},{"id":11,"text":"","extract":"looks like south rioting well into wall street and east rioting","uri":"https://twitter.com/ericisbeautiful/status/263067953761751040"}]}';

		var jsonData = JSON.parse(sample).tweetList;
		jsonData.forEach(function(data){
			var tr = $("<tr></tr>").appendTo($(".fews-form table tbody"));

			var td_extract = $("<td></td>", {
				"text": data.extract
			}).appendTo(tr);

			var td_uri = $("<td></td>", {
				"text": data.uri
			}).appendTo(tr);
		});
		
	},

	clearTopic: function(){
		$(".topic-form").html(" ");
	}
});
