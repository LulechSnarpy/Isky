$(function(){
	$("#tree_perm").tree({
		url : pathContext + "/tree",
		method : "post",
		animate : true,
		lines : true,
		//checkbox : true,
		onClick: function(node){
			var url = node.attributes.url;
			if(url != null && url != ""){
				var options = {
						id : node.id,
						text : node.text,
						content : '<iframe src="' + pathContext + url + '" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>'
				};
				tabs(options);
			}
		}
	});
	
});

function tabs(options){
	
	//通过标题判断选项卡是否存在
	var exists = $("#tabs_content").tabs("exists",options.text);
	if(exists){ //存在  选中当前选项卡 更新
		$("#tabs_content").tabs("select",options.text);
		var tab = $("#tabs_content").tabs("getTab",options.text);
		//var tab = $('#tt').tabs('getSelected');
		$("#tabs_content").tabs("update",{
			tab : tab,
			options : {
				id : options.id,
				title : options.text,
				content : options.content,
				closable : true
			}
		});
	}else{//不存在 添加新的选项卡
		$("#tabs_content").tabs("add",{
			id : options.id,
			title : options.text,
			content : options.content,
			closable : true
		});
	}
	
}






