
define(["dojo/_base/declare", 
		"dijit/_WidgetBase", 
		"dijit/_TemplatedMixin", 
		"app/easy/common/WFContentPane",
		'dojo/string',
		"dojo/text!./template/summary.html"], 
	function(declare, WidgetBase, TemplatedMixin, WFContentPane, 
			String, template){
		return declare([WFContentPane, WidgetBase, TemplatedMixin], {
			description: "",
			templateString:template,
			
			postCreate: function(){
			}
			
		});
});
