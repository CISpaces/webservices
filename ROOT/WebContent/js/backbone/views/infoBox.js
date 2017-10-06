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

        $("#info_box .input-group input").val("");
	},

	submitTopic: function(){
		var topic_list = [];

		var p = $(".topic-form p");
		for(var i = 0 ; i < p.length ; i++){
			var topic = p[i].children[0].innerText;

			var obj = {
				"name": topic,
				// "negated": $('[name="negated-' + topic + '"]:checked').val(),
				// "genuine": $('[name="genuine-' + topic + '"]:checked').val()
                "negated": -1,
				"genuine": -1
			};

			topic_list.push(obj);
		}

		// alert(JSON.stringify(topic_list));

		var tweetList = new app.TweetList();

        // TODO can this use an actual Backbone Model instead
		Backbone.ajax({
			type: "POST",
            url: "/fewsservlet/tweets",
            data: JSON.stringify(topic_list),
			dataType: 'json',
			contentType: "application/json",
			success: function(result){
                console.log(result);

                $(".fews-form table tbody").empty();

                result.forEach(function(data){
                    var tr = $("<tr></tr>").appendTo($(".fews-form table tbody"));

                    var td_extract = $("<td></td>", {
                        "text": data.extract
                    }).appendTo(tr);

                    var td_uri = $("<td></td>", {
                        "text": data.uri
                    }).appendTo(tr);
                });
			},
			error: function(xhr, textStatus, errorThrown){
				alert("AJAX failed: " + errorThrown);
			}
		});
	},

	clearTopic: function(){
		$(".topic-form").html(" ");
		$(".fews-form tbody").html(" ");
	}
});
