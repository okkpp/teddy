<#macro loadjs>
<#nested>
</#macro>

<#macro layout>
<!DOCTYPE html>
<html lang="en">

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
  	
<#include "/_layout/loadjs.ftl"/>	
	
</body>
</html>
</#macro>