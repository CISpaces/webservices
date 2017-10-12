var app = app || {};

app.toolBoxView;
app.infoBoxView;
app.workBoxView;
//app.reqBoxView;
app.evalBoxView;
//app.prefBoxView;
//app.moiraBoxView;
//app.chatBoxView;
app.detailView;

$(function(){
	// new app.AppView();
	app.workBoxView = new app.WorkBoxView();

	//app.reqBoxView = new app.ReqBoxView();
	app.toolBoxView = new app.ToolBoxView();
	app.infoBoxView = new app.InfoBoxView();
	app.evalBoxView = new app.EvalBoxView();
	//app.prefBoxView = new app.PrefBoxView();
	//app.moiraBoxView = new app.MoiraBoxView();
	//app.chatBoxView = new app.ChatBoxView();
	app.detailView = new app.DetailView();
});

Backbone.ajax = function(){
	//Supply the JWT auth token
	arguments[0].headers = {
		'Authorization': localStorage.getItem('auth_token')
	};

	return Backbone.$.ajax.apply(Backbone.$, arguments);
};
