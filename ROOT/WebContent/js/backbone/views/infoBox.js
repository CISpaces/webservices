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
		this.topics = app.Topics;
		this.topics.fetch({
			success: function(collection, response) {
                collection.each(function(model){
                    console.log(model);
                    // alert(model.attributes["name"]);
                    var p = $("<p></p>").appendTo($("#info_box .topic-form"));
                    var div = $("<div></div>", {
                        "class": "alert alert-success alert-infobox",
                        "text": model.attributes["name"]
                    }).appendTo(p);
                });
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
		$(".fews-form table tbody").empty();
	}
});
