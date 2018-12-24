<#include "/_layout/manager.ftl"/>
<@layout>
	  <div class="container-full">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="d-flex align-items-center">
				<div class="mr-auto">
					<h3 class="page-title">角色列表</h3>
					<div class="d-inline-block align-items-center">
						<nav>
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#"><i class="mdi mdi-home-outline"></i></a></li>
								<li class="breadcrumb-item" aria-current="page">角色管理</li>
								<li class="breadcrumb-item active" aria-current="page">角色列表</li>
							</ol>
						</nav>
					</div>
				</div>
				<div class="right-title">
					<div class="dropdown">
						<button class="btn btn-outline dropdown-toggle no-caret" type="button" data-toggle="dropdown"><i class="mdi mdi-dots-horizontal"></i></button>
						<div class="dropdown-menu dropdown-menu-right">
						  <a class="dropdown-item" href="#"><i class="mdi mdi-share"></i>Activity</a>
						  <a class="dropdown-item" href="#"><i class="mdi mdi-email"></i>Messages</a>
						  <a class="dropdown-item" href="#"><i class="mdi mdi-help-circle-outline"></i>FAQ</a>
						  <a class="dropdown-item" href="#"><i class="mdi mdi-settings"></i>Support</a>
						  <div class="dropdown-divider"></div>
						  <button type="button" class="btn btn-success">Submit</button>
						</div>
					  </div>

				</div>
			</div>
		</div>

		<!-- Main content -->
		<section class="content">
		  <div class="row">
				<div class="col-12">
					<div class="box">
						<div class="box-header with-border">						
							<h4 class="box-title">角色管理列表</h4>
							<h6 class="box-subtitle">仅展示</h6>
						</div>
						<div class="box-body">						
							<div class="table-responsive">
									<@mytable id="mytable">
											<th>#</th>
											<th>角色名</th>
									</@mytable>
							</div>
						</div>
					</div>
				</div>
			</div>
		  <!-- /.row -->

		</section>
		<!-- /.content -->
	  </div>

</@layout>

<@mymodal fromId="edit_from" savePath="/manager/role/save" tableReload="#mytable">
</@mymodal>

<script type="text/template" id="form">
					<input hidden="true" name="id" value="{id}"/>
					<div class="form-group row">
						<label class="col-form-label col-md-2">role</label>
						<div class="col-md-10">
							<input class="form-control" type="text" name="role" value="{role}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-md-2">created</label>
						<div class="col-md-10">
							<input class="form-control" type="date" name="createdDate" value="{created}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-md-2">enable</label>
						<div class="col-md-10">
							<input class="form-control" type="number" name="enable" value="{enable}">
						</div>
					</div>
</script>
<script type="text/template" id="action">
<div class="list-icons d-inline-flex">
		<a href="#" class="dropdown-item" id="edit"><i class="fa fa-pencil"></i>修改</a>
		<a href="#" class="dropdown-item" id="del"><i class="fa fa-remove"></i>删除</a>
</div>
</script>
<script type="text/javascript">
function edit(){
	var data = {};
	var table = $('#mytable').DataTable();
	data = table.row($(this).parents('tr')).data();
	var f = okkpp.dataTemplate($("#form").html(), data);
	$("#edit_from").html(f);
	$("#modal-default").modal('show');
}
function del(){
	console.log("del");
//	var table = $('#mytable').DataTable();
//	var data = table.row($(this).parents('tr')).data();
//	okkpp.post("/manager/role/del", data, function(data){
//		okkpp.tableReload("#mytable");
//	});
}
var funcs = [];
funcs.push(edit);
funcs.push(del);

var param;
columns = [
	{ "data": "id"},
    { "data": "role"}
];
okkpp.tableInit('#mytable', columns, "/manager/role/list", param, funcs);
</script>