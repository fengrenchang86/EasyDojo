define([ "dojo/_base/declare", "dijit/_WidgetBase", "dijit/_TemplatedMixin",
		'dojo/_base/lang', 'dojox/grid/DataGrid',
		'dojo/data/ItemFileWriteStore', 'dojo/dom',"dojo/on",
		"dijit/form/RadioButton",
	    "dijit/form/Button",
		"app/easy/common/WFContentPane", 'dojo/string',
		"dojo/text!./template/radio.html" ], function(declare, WidgetBase,
		TemplatedMixin, lang, DataGrid, ItemFileWriteStore, dom, on, 
		RadioButton, Button,
		WFContentPane,
		String, template) {
	return declare([ WFContentPane, WidgetBase, TemplatedMixin ], {
		description : "",
		templateString : template,
		grid:null,
		postCreate : function() {
			var radioOne = new RadioButton({
		        checked: true,
		        value: "tea",
		        name: "drink",
		    }, "radioOne").startup();
		}

	});
});
