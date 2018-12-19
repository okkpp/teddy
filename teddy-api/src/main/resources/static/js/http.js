var okkpp = okkpp || {
	version : '1.0'
};
okkpp.post = function(url, param, callback, failureCallback){
	$.ajax({
        url: url,
        data: param,
        type: "POST",
        success: function (data) {
        	if(data.code != -200){
        		if (callback != undefined) callback(data);
        		return;
        	}else{
        		if (failureCallback != undefined) failureCallback(data);
        		return;
        	}
        },
        error: function (request) {
            if (failureCallback != undefined) failureCallback();
            else {
            	if(typeof request != 'undefined' && request){
            		if(request.response){
            			alert(request.response);
            		}else{
            			alert("服务端没有响应......");
            		}
            	}
            }
        }
        });
};
okkpp.get = function(url, param, callback, failureCallback){
	$.ajax({
        url: url,
        data: param,
        type: "GET",
        success: function (data) {
        	if(data.code != -200){
        		if (callback != undefined) callback(data);
        		return;
        	}else{
        		if (failureCallback != undefined) failureCallback(data);
        		return;
        	}
        },
        error: function (request) {
            if (failureCallback != undefined) failureCallback();
            else {
            	if(typeof request != 'undefined' && request){
            		if(request.response){
            			alert(request.response);
            		}else{
            			alert("服务端没有响应......");
            		}
            	}
            }
        }
        });
};


/**
 * 一个用作js模板替换的代码 template格式和数组格式如下 var template = "<div>
 * <h1>{title}</h1>
 * <p>
 * {content}
 * </p>
 * </div>"; var data =
 * [{title:"a",content:"aaaa"},{title:"b",content:"bbb"},{title:"c",content:"ccc"}];
 * 只需要数据格式对应
 */

okkpp.dataTemplate4list = function(template, data, dec) {
	var outPrint = "";
	for ( var i = 0; i < data.length; i++) {
		var matchs = template.match(/\{[a-zA-Z0-9\.\$_-]+\}/gi);
		var temp = "";
		for ( var j = 0; j < matchs.length; j++) {
			if (temp == "")
				temp = template;
			var re_match = matchs[j].replace(/[\{\}]/gi, "");
			if(dec && isFloat(data[i][re_match])){
				temp = temp.replace(matchs[j], data[i][re_match].toFixed(dec));
			}
			else{
				temp = temp.replace(matchs[j], data[i][re_match]);
			}
			
		}
		outPrint += temp;
	}
	return outPrint;
};

okkpp.dataTemplate = function(template, obj, dec){
	var matchs = template.match(/\{[a-zA-Z0-9\.\$_-]+\}/gi);
	var temp = "";
	for ( var j = 0; j < matchs.length; j++) {
		if (temp == "")
			temp = template;
		var re_match = matchs[j].replace(/[\{\}]/gi, "");
		if(dec && isFloat(obj[re_match])){
			temp = temp.replace(matchs[j], obj[re_match].toFixed(dec));
		}
		else{
			temp = temp.replace(matchs[j], obj[re_match]?obj[re_match]:"");
		}
		
	}
	return temp;
}

function isFloat(n) {
	return ((typeof n==='number')&&(n%1!==0));
}