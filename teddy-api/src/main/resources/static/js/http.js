var okkpp = okkpp || {
	version : '2.0'
};
function post(url, param, callback, failureCallback){
	$.ajax({
        url: url,
        data: param,
        type: "POST",
        success: function (data) {
        	if(data.code != -200){
        		if (callback != undefined){
        			okkpp.handleResult(data);
        			callback(data);
        		}
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
okkpp.post = post;

function get(url, param, callback, failureCallback){
	$.ajax({
        url: url,
        data: param,
        type: "GET",
        success: function (data) {
        	if(data.code != -200){
        		if (callback != undefined){
        			okkpp.handleResult(data);
        			callback(data);
        		}
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
okkpp.get = get;

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

function dataTemplate4list(template, data, dec) {
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
okkpp.dataTemplate4list = dataTemplate4list;

function dataTemplate(template, obj, dec){
	var matchs = template.match(/\{[a-zA-Z0-9\.\$_-]+\}/gi);
	if(null==obj){
		obj = {};
	}
	if(null==matchs){
		return template;
	}
	var temp = "";
	for ( var j = 0; j < matchs.length; j++) {
		if (temp == "")
			temp = template;
		var re_match = matchs[j].replace(/[\{\}]/gi, "");
		if(dec && isFloat(obj[re_match])){
			temp = temp.replace(matchs[j], obj[re_match].toFixed(dec));
		}
		else{
			temp = temp.replace(matchs[j], obj[re_match]!=null?obj[re_match]:"");
		}
	}
	return temp;
}
okkpp.dataTemplate = dataTemplate;

// 表格汉化列表
var table_lang = {
  "sProcessing": "处理中...",
  "sLengthMenu": "每页 _MENU_ 项",
  "sZeroRecords": "没有匹配结果",
  "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
  "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
  "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
  "sInfoPostFix": "",
  "sSearch": "搜索:",
  "sUrl": "",
  "sEmptyTable": "表中数据为空",
  "sLoadingRecords": "载入中...",
  "sInfoThousands": ",",
  "oPaginate": {
    "sFirst": "首页",
    "sPrevious": "上一页",
    "sNext": "下一页",
    "sLast": "末页",
    "sJump": "跳转"
  },
  "oAria": {
    "sSortAscending": ": 以升序排列此列",
    "sSortDescending": ": 以降序排列此列"
  }
};

function tableInit(selector, columns, url, param, funcs){
	var add = {};
	add.render = function(data,type,full,meta){
		return okkpp.dataTemplate($("#action").html(),meta);
	}
	columns.push(add);
	$(selector).DataTable({
		dom: 'Bfrtip',
		buttons: [
			'copy', 'csv', 'excel', 'pdf', 'print', 
			{text:"添加",action: funcs[0]}
		],
		language:table_lang,
		lengthMenu: [5, 10, 15],
		stripeClasses: ["odd", "even"],
		processing: true,
		serverSide: true,
        ordering: false,//是否启用排序
        searching: false,//搜索
		ajax: function (data, callback, settings) {
			if(null==param){
				param = new Object;
			}
			param.pageSize = data.length;
			param.pageNo = (data.start / data.length)+1;
			//ajax请求数据
			okkpp.get(url, param, function(result){
				result.recordsTotal = result.totalRow;
				result.recordsFiltered = result.totalRow;
				callback(result);
			});
		},
		columns:columns
	});
	$(selector+' tbody').on('click', 'a#edit', funcs[0]);
	$(selector+' tbody').on('click', 'a#del', funcs[1]);
}
okkpp.tableInit = tableInit;

function tableReload(selector){
	var table = $(selector).DataTable();
	table.ajax.reload(null,false);
}
okkpp.tableReload = tableReload;

function handleResult(result){
	if(result.code==200){
//		alert(result.msg);
	}else if(result.code==-200){
		alert(result.msg);
	}else{
//		alert("unknown msg");
	}
}
okkpp.handleResult = handleResult;

function isFloat(n) {
	return ((typeof n==='number')&&(n%1!==0));
}