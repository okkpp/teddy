<!-- 显示内容 -->
<#macro layout>
<!DOCTYPE html>
<html lang="cn">

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