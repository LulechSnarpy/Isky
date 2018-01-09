
$(function(){
	$('#login-dialog').dialog({    

    title: '登录',    
    width: 380,    
    height: 180,    
        
        
    modal: true,
    buttons:[
        {
	    	text:"登录",
	    	iconCls:"iocn-ok",
	    	handler:function(){
	    		$("#login-form").form("submit",{
    				url:pathContext+"/login/login",
    				onSubmit:function(){
    					//判断是否为空
    					return $(this).form("validate");
    				},
    				success:function(result){
    					var data = $.parseJSON(result);
    					if(data.code == 1){
    						//window.location.replace(""); 把记录  请求 转发   post get  session Cookie jquery
    						window.location.href = pathContext+"/index/index";
    					}else{
    						$.messager.show({
    							
    							title:'提示',
    							msg:data.code,
    							timeout:5000
    							
    						});

    					}
    				}
    			});
	    	}
    	},
    	{
    		text:"重置",
    		iconCls:"icon-cancel",
    		handler:function(){
    			
    		}
    	}
    ]
});
$("#username").textbox({
	width: 180,
	required:true,
	missingMessage:"请输入用户名！",
	iconCls:"icon-man"
	
});
$("#password").textbox({
	type:"password",
	width:180,
	required:true,
	missingMessage:"请输入密码！",
	iconCls:"icon-lock"
});
});