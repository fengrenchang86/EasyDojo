define(["dojo/_base/declare", 
		"dijit/_WidgetBase", 
		"dijit/_TemplatedMixin", 
		"dijit/layout/ContentPane"], 
	function(declare, WidgetBase, TemplatedMixin, ContentPane){
		console.log("WFConentPane.define");
		return declare([ContentPane, WidgetBase, TemplatedMixin], {
			_parseAllItem: function() {
				var id = this.id;
//				console.log(dojo.query("#" + id));
				var htmlSrcNode = dojo.query("#" + id + " *[data-dojo-type]");
//				console.log(htmlSrcNode);
				var requireList = ["dojo/parser"];
				dojo.forEach(htmlSrcNode, function(item, index){
					var newRequire = dojo.attr(item, 'data-dojo-type');
					if (newRequire && dojo.indexOf(requireList, newRequire) < 0) {
						requireList.push(newRequire);
					}
				});
				console.log(requireList);
				require(requireList, function(parser){
					parser.parse(dojo.byId(id));
				});
			}
		});
});
