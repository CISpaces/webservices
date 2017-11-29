/**
 * model for a node which is used in cispaces
 */

var app = app || {};

app.Node = Backbone.Model.extend({
  defaults: {
    source: '',
    uncert: 'Confirmed',
    eval: 'N/A',
    text: '',
    input: '',
    dtg: '',
    commit: 'N/A',
    type: '',
    nodeID: '',
    graphID: '',
    islocked: 'false',    
    annot: {
      conc: {},
      prem_assump: {}
    }
  }
});
