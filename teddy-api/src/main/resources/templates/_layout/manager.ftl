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

<#macro mymodal fromId="edit_from" savePath="" tableReload="#mytable">
  <!-- modal Area -->              
  <div class="modal fade" id="modal-default">
	  <div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<h4 class="modal-title">修改</h4>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span></button>
		  </div>
		  <div class="modal-body">
		  <form id="${fromId}">

		  </form>
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			<button id="${fromId}_save" type="button" class="btn btn-primary float-right">保存</button>
		  </div>
		</div>
		<!-- /.modal-content -->
	  </div>
	  <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->
  <script type="text/javascript">
  $("#${fromId}_save").on('click', function(){
		$("#modal-default").modal('hide');
		okkpp.post("${savePath}", $("#${fromId}").serialize(), function(data){
			okkpp.tableReload("${tableReload}");
		});
	});
  </script>
</#macro>