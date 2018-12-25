<!-- 显示内容 -->
<#macro layout>
<!DOCTYPE html>
<html lang="cn">
<#if user??>
<#else>
<script type="text/javascript">
location.href = "/auth/login";
</script>
</#if>
<#include "/_layout/head.ftl"/>

<body class="hold-transition skin-info dark-sidebar light sidebar-mini">
<div class="wrapper">

<#include "/_layout/header.ftl"/>
  
<#include "/_layout/aside.ftl"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

  		<#nested>

  </div>
  <!-- /.content-wrapper -->
	
<#include "/_layout/footer.ftl"/>

<#include "/_layout/control-aside.ftl"/>
  
</div>
<!-- ./wrapper -->
  	
<!-- 默认js -->
<#include "/_layout/loadjs.ftl"/>	
	
<script type="text/template" id="aside_tpl">
        <li class="header nav-small-cap">{title}</li>
		
		<li class="treeview">
          <a href="#">
            <i class="ti-pencil-alt"></i>
            <span>{name}</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            	{list}
          </ul>
        </li>
</script>
<script type="text/template" id="aside_li_tpl">
			<li><a href="{url}"><i class="ti-more"></i>{name}</a></li>
</script>
<script type="text/javascript">
okkpp.get("/json/sidebar.json", null, function(data){
	for(var i=0;i<data.length;i++){
		var li = okkpp.dataTemplate4list($("#aside_li_tpl").html(), data[i].list);
		data[i].list = li;
	}
	var tpl = okkpp.dataTemplate4list($("#aside_tpl").html(), data);
	$("#sidebar").html(tpl);
});
</script>

</body>
</html>
</#macro>

<#macro mytable id="mytable">
								<table id="${id}" class="table table-lg invoice-archive">
									<thead>
										<tr>
											<#nested>
											<th class="text-center">Actions</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
</#macro>

<#macro mymodal tableId="mytable" savePath="">
  <!-- modal Area -->              
  <!-- Notice-->
  <!-- modal id = ${tableId}_modal -->
  <!-- modal form id = ${tableId}_modal_form -->
  <!-- modal save button id = ${tableId}_modal_save -->
  <div class="modal fade" id="${tableId}_modal">
	  <div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<h4 class="modal-title">修改</h4>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span></button>
		  </div>
		  <div class="modal-body">
		  <form id="${tableId}_modal_form">

		  </form>
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			<button id="${tableId}_modal_save" type="button" class="btn btn-primary float-right">保存</button>
		  </div>
		</div>
		<!-- /.modal-content -->
	  </div>
	  <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->
  <script type="text/javascript">
  $("#${tableId}_modal_save").on('click', function(){
		$("#${tableId}_modal").modal('hide');
		okkpp.post("${savePath}", $("#${tableId}_modal_form").serialize(), function(data){
			okkpp.tableReload("#${tableId}");
		});
	});
  </script>
</#macro>
<#macro modaltpl tableId="">
<script type="text/template" id="${tableId}_tpl">
	<#nested>
</script>
</#macro>
<#macro tablejs tableId="mytable" dataList="" del="">
  <!-- Notice-->
  <!-- modal id = ${tableId}_modal -->
  <!-- modal form id = ${tableId}_modal_form -->
  <!-- modal save button id = ${tableId}_modal_save -->
<script type="text/javascript">
function ${tableId}_edit(){
	var data = {};
	var table = $('#${tableId}').DataTable();
	data = table.row($(this).parents('tr')).data();
	var f = okkpp.dataTemplate($("#${tableId}_tpl").html(), data);
	$("#${tableId}_modal_form").html(f);
	$("#${tableId}_modal").modal('show');
}
function ${tableId}_del(){
	var table = $('#${tableId}').DataTable();
	var data = table.row($(this).parents('tr')).data();
	okkpp.post("${del}", data, function(data){
		okkpp.tableReload("#${tableId}");
	});
}
var ${tableId}_funcs = [];
${tableId}_funcs.push(${tableId}_edit);
${tableId}_funcs.push(${tableId}_del);

var ${tableId}_param;
${tableId}_columns = [
	<#nested>
];
okkpp.tableInit('#${tableId}', ${tableId}_columns, "${dataList}", ${tableId}_param, ${tableId}_funcs);
</script>
</#macro>