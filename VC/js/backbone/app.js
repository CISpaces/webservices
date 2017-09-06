var app = app || {};

app.toolBoxView;
//app.infoBoxView;
app.workBoxView;
//app.reqBoxView;
app.evalBoxView;
//app.prefBoxView;
//app.moiraBoxView;
//app.chatBoxView;

$(function(){
	// new app.AppView();
	app.toolBoxView = new app.ToolBoxView();
	//app.infoBoxView = new app.InfoBoxView();
	app.workBoxView = new app.WorkBoxView();
	//app.reqBoxView = new app.ReqBoxView();
	app.evalBoxView = new app.EvalBoxView();
	//app.prefBoxView = new app.PrefBoxView();
	//app.moiraBoxView = new app.MoiraBoxView();
	//app.chatBoxView = new app.ChatBoxView();
});