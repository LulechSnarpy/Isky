$(function(){
	
	$.extend($.fn.validatebox.defaults.rules, {    
	    et : {    
	        validator: function(value, param){  
	            return value == param[0];    
	        },    
	        message: '请输入{0},否则验证不通过.'   
	    }    
	});  

	
	$("#et").validatebox({
		
		required : true,
		validType : "et['et1707']"
		
	});
	
});