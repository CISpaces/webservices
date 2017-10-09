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

		// Brings a list of topics from FEWS services
		app.Topics.fetch({
			success: function(data){
				data.forEach(function(d){
					app.infoBoxView.addTopic(d.attributes);
				});
			},
			error: function(response){
				console.error(response);
			}
		});

		// Brings tweets related to listed topics periodically
		var timer = setInterval( "app.infoBoxView.submitTopic()", 10000 );
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
			'negated': -1,
			'genuine': -1
		};

		this.addTopic(param);

    $("#info_box .input-group input").val("");
	},

	addTopic: function(topic){

		var p = $("<p></p>").appendTo($("#info_box .topic-form"));

		var div = $("<div></div>", {
			"class": "form-group"
		}).appendTo(p);

		var alert_class = "alert-success";
		if(topic.negated == 0){
			alert_class = "alert-danger";
		} else if(topic.negated == -1){
			alert_class = "alert-warning";
		}

		var div_alert = $("<div></div>", {
			"class": "alert " + alert_class + " alert-infobox float_left",
			"text": topic.name
		}).appendTo(div);

		var button = $("<i></i>", {
			"class": "fa fa-minus"
		}).appendTo($("<button></button>", {
				"type": "button",
				"class": "btn btn-default"
			}).click(function(){
				p.remove();
			}).appendTo(div)
		);

		var div_negated = $("<div></div>", {
			"class": "form-group"
		}).appendTo(p);

		var negated_true = $("<input/>", {
			"type": "radio",
			"name": "negated-" + topic.name,
			"value": 1,
			"checked": (topic.negated == 1)
		}).click(function(obj){
			div_alert.addClass("alert-success");
			div_alert.removeClass("alert-danger");
			div_alert.removeClass("alert-warning");
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(div_negated)
			  .before($("<label></label>", {"text": "negated"}))
		).after($("<span></span>", {"text": "true"}));

		var negated_false = $("<input/>", {
			"type": "radio",
			"name": "negated-" + topic.name,
			"value": 0,
			"checked": (topic.negated == 0)
		}).click(function(){
			div_alert.removeClass("alert-success");
			div_alert.addClass("alert-danger");
			div_alert.removeClass("alert-warning");
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(div_negated)
		).after($("<span></span>", {"text": "false"}));

		var negated_unknown = $("<input/>", {
			"type": "radio",
			"name": "negated-" + topic.name,
			"value": -1,
			"checked": (topic.negated == -1)
		}).click(function(){
			div_alert.removeClass("alert-success");
			div_alert.removeClass("alert-danger");
			div_alert.addClass("alert-warning");
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(div_negated)
		).after($("<span></span>", {"text": "unknown"}));

		var div_genuine = $("<div></div>", {
			"class": "form-group"
		}).appendTo(p);

		var genuine_true = $("<input/>", {
			"type": "radio",
			"name": "genuine-" + topic.name,
			"value": 1,
			"checked": (topic.genuine == 1)
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(div_genuine)
			  .before($("<label></label>", {"text": "genuine"}))
		).after($("<span></span>", {"text":"true"}));

		var genuine_false = $("<input/>", {
			"type": "radio",
			"name": "genuine-" + topic.name,
			"value": 0,
			"checked": (topic.genuine == 0)
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(div_genuine)
		).after($("<span></span>", {"text":"false"}));

		var genuine_unknown = $("<input/>", {
			"type": "radio",
			"name": "genuine-" + topic.name,
			"value": -1,
			"checked": (topic.genuine == -1)
		}).appendTo(
			$("<label></label>", {
				"class": "radio-inline"
			}).appendTo(div_genuine)
		).after($("<span></span>", {"text": "unknown"}));
	},

	submitTopic: function(){
		var topic_list = [];

		var p = $(".topic-form p");
		for(var i = 0 ; i < p.length ; i++){
			var topic = p[i].children[0].innerText;

			var obj = {
				"name": topic,
				"negated": $('[name="negated-' + topic + '"]:checked').val(),
				"genuine": $('[name="genuine-' + topic + '"]:checked').val()
			};

			topic_list.push(obj);
		}

		// alert(JSON.stringify(topic_list));

		Backbone.ajax({
			type: "POST",
      url: "/fewsservlet/tweets",
      data: JSON.stringify(topic_list),
			dataType: 'json',
			contentType: "application/json",
			success: function(result){
          // console.log(result);

          $(".fews-form table tbody").empty();

          result.forEach(function(data){
              var tr = $("<tr></tr>").appendTo($(".fews-form table tbody"));

              var td_extract = $("<td></td>", {
                  "text": data.extract
              }).appendTo(tr)
							.click(function(){
								$("#details-node").hide();
								$("#details-tweet").show();

								var p = $("#details-tweet p");
								p[0].innerText = data.extract;
								p[1].innerText = data.uri;
							});

              var td_uri = $("<td></td>", {
                  "text": data.uri
              }).appendTo(tr)
							.click(function(){
								var tweet_popup = window.open(data.uri, parseText(data.extract), "height: 150px,width: 250px");
							});
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
