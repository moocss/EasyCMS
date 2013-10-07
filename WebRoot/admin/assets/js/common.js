(function(window) {
	var Pony = {version : '1.0'};
	
	/**
	 * 获取路径参数
	 */
	Pony.getParam = function(key) {
		var kv,params = location.search.substr(1).split('&');
		for (var i = 0;i < params.length; i++) {
			kv = params[i].split('=');
			if (kv[0] == key) {
				return kv[1];
			}
		}
	};

	/**
	 * 选中复选框.
	 */
	Pony.checkboxSlt = function(name, checked) {
		var cks = document.getElementsByName(name);
		var len = cks.length;
		if(checked == true){
			for(var i=0; i<len; i++) { 
				if((cks[i].type == "checkbox") && (cks[i].name == name)) { 
					cks[i].checked = true; 
				} 
			}
		}else{
			for(var i=0; i<len; i++) { 
				if((cks[i].type == "checkbox") && (cks[i].name == name)) { 
					cks[i].checked = false; 
				} 
			}
		}
	};
	/**
	 * 复选框选中的个数
	 */
	Pony.checkedCount = function(name) {
		var batchChecks = document.getElementsByName(name);
		var count = 0;
		for (var i = 0;i < batchChecks.length; i++) {
			if (batchChecks[i].checked) {
				count++;
			}
		}
		return count;
	};
	/**
	 * 多个复选框的值
	 */
	Pony.checkIn = function(name){
		var batchChecks = document.getElementsByName(name);
		var cks = [];
		for (var i = 0;i < batchChecks.length; i++) {
			if (batchChecks[i].checked) {
			    cks.push(batchChecks[i].value);
			}
		}
		return cks;
	};
	
	window.Pony = Pony;
})(window);