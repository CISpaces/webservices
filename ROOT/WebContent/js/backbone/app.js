var app = app || {};

app.toolBoxView;
app.infoBoxView;
app.workBoxView;
//app.reqBoxView;
app.evalBoxView;
app.vocabularyBoxView;
//app.prefBoxView;
//app.moiraBoxView;
//app.chatBoxView;

$(function(){
	// new app.AppView();
	app.workBoxView = new app.WorkBoxView();

	//app.reqBoxView = new app.ReqBoxView();
	app.toolBoxView = new app.ToolBoxView();
	app.infoBoxView = new app.InfoBoxView();
	app.evalBoxView = new app.EvalBoxView();
	app.vocabularyBoxView = new app.VocabularyBoxView();
	//app.prefBoxView = new app.PrefBoxView();
	//app.moiraBoxView = new app.MoiraBoxView();
	//app.chatBoxView = new app.ChatBoxView();
});

Backbone.ajax = function(){
	//Supply the JWT auth token
	arguments[0].headers = {
		'Authorization': localStorage.getItem('auth_token')
	};

	return Backbone.$.ajax.apply(Backbone.$, arguments);
};
