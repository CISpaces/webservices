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
		this.$el.attr("style", "height: " + (chart.svg_height - 60) + "px");

		$.ajax({
			type: "GET",
			contentType: "application/json",
			headers: {"Authorization": localStorage.getItem('auth_token')},
			url: "/fewsservlet/topics",
			success: function(data){
				data.forEach(function(d){
					app.infoBoxView.addTopic(d);
				});
			},
			error: function(data){
				console.error(data);
			}
		});
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

		var param = {
			'name': topic,
			'negated': true,
			'genuine': true
		};

		this.addTopic(param);
	},

	addTopic: function(topic){

		var p = $("<p></p>").appendTo($("#info_box .topic-form"));

		var div = $("<div></div>", {
			"class": "alert alert-success alert-infobox",
			"text": topic.name
		}).appendTo(p);

		var negated_true = $("<input/>", {
			"type": "radio",
			"name": "negated-" + topic.name,
			"value": "true",
			"checked": topic.negated
		}).click(function(obj){
			div.addClass("alert-success");
			div.removeClass("alert-danger");
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(p)
			  .before(
				$("<label></label>", {"text": "Negated"})
			)
		).after(
			$("<span></span>", {"text":"T"})
		);

		var negated_false = $("<input/>", {
			"type": "radio",
			"name": "negated-" + topic.name,
			"value": "false",
			"checked": !topic.negated
		}).click(function(){
			div.addClass("alert-danger");
			div.removeClass("alert-success");
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(p)
		);

		negated_false.after(
			$("<span></span>", {"text":"F"})
		);

		var genuine_true = $("<input/>", {
			"type": "radio",
			"name": "genuine-" + topic.name,
			"value": "true",
			"checked": topic.genuine
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(p)
			  .before(
				$("<label></label>", {"text": "Genuine"})
			)
		);

		genuine_true.after(
			$("<span></span>", {"text":"T"})
		);

		var genuine_false = $("<input/>", {
			"type": "radio",
			"name": "genuine-" + topic.name,
			"value": "false",
			"checked": !topic.genuine
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(p)
		);

		genuine_false.after(
			$("<span></span>", {"text":"F"})
		);
	},

	submitTopic: function(){
		/*
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
		*/

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
		$(".fews-form tbody").html(" ");
	}
});
