<#include "/_layout/manager.ftl"/>
<@layout>
	  <div class="container-full">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="d-flex align-items-center">
				<div class="mr-auto">
					<h3 class="page-title">用户列表</h3>
					<div class="d-inline-block align-items-center">
						<nav>
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#"><i class="mdi mdi-home-outline"></i></a></li>
								<li class="breadcrumb-item" aria-current="page">用户管理</li>
								<li class="breadcrumb-item active" aria-current="page">用户列表</li>
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
							<h4 class="box-title">用户管理列表</h4>
							<h6 class="box-subtitle">仅展示</h6>
						</div>
						<div class="box-body">						
							<div class="table-responsive">
								
									<@mytable id="user_table">
											<th>#</th>
											<th>用户名</th>
											<th>手机号</th>
											<th>邮箱</th>
											<th>Mood</th>
											<th>性别</th>
											<th>生日</th>
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

<@mymodal tableId="user_table" savePath="/manager/user/save">
</@mymodal>

<@modaltpl tableId="user_table">
					<input hidden="true" name="id" value="{id}"/>
					<div class="form-group row">
						<label class="col-form-label col-md-2">username</label>
						<div class="col-md-10">
							<input class="form-control" type="text" name="username" value="{username}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-md-2">phone</label>
						<div class="col-md-10">
							<input class="form-control" type="text" name="phone" value="{phone}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-md-2">email</label>
						<div class="col-md-10">
							<input class="form-control" type="text" name="email" value="{email}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-md-2">mood</label>
						<div class="col-md-10">
							<input class="form-control" type="text" name="mood" value="{mood}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-md-2">sex</label>
						<div class="col-md-10">
							<input class="form-control" type="text" name="sex" value="{sex}">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-md-2">enable</label>
						<div class="col-md-10">
							<input class="form-control" type="number" name="enable" value="{enable}">
						</div>
					</div>
</@modaltpl>
<@tablejs tableId="user_table" dataList="/manager/user/list" del="/manager/user/del">
{ "data": "id"},
{ "data": "username" },
{ "data": "phone" },
{ "data": "email" },
{ "data": "mood" },
{ "data": "sex" },
{ "data": "birthday" }
</@tablejs>

