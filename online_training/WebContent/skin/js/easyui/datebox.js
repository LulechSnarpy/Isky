$(function(){
	
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return m+'@'+d+'#'+y;
	}
	
	/*$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	}*/




	
	$("#et").datebox({
		panelWidth : 300,
		panelHeight : 300,
		editable : false,
		currentText : "et1707"
		//disabled : true
	});
	
});