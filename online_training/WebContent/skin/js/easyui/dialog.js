$(function(){
	
	$("#et").dialog({
		
		title : "窗口",
		width : 500,
		height : 350,
		modal: true,
		toolbar : "#dialog-toolbar",
		buttons : [
		           {
		        	   text : "保存",
		        	   iconCls : "icon-ok",
		        	   handler : function(){
		        		   alert("保存");
		        	   }
		           },
		           {
		        	   text : "取消",
		        	   iconCls : "icon-cancel",
		        	   handler : function(){
		        		   alert("取消");
		        	   }
		           }
		           ]
	});
	
});