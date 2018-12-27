<!-- 显示内容 -->
<#macro layout>
<!DOCTYPE html>
<html lang="cn">
<#include "/_layout/head.ftl"/>
<style type="text/css">
.content-wrapper{
margin-left:auto;
}
</style>
<body class="hold-transition skin-info dark-sidebar light sidebar-mini">
<div class="wrapper">

<#include "/_layout/header.ftl"/>
  
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

</body>
</html>
</#macro>
