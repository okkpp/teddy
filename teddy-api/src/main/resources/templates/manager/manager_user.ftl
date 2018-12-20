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
								
								<table id="mytable" class="table table-lg invoice-archive">
									<thead>
										<tr>
											<th>#</th>
											<th>用户名</th>
											<th>手机号</th>
											<th>邮箱</th>
											<th>Mood</th>
											<th>性别</th>
											<th>生日</th>
											<th class="text-center">Actions</th>
										</tr>
									</thead>
									<tbody>
<!-- 										<tr>
											<td>#0025</td>
											<td>February 2018</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Jacob</a>
													<span class="d-block text-muted">Payment method: Skrill</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold" selected>On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												April 18, 2018
											</td>
											<td>
												<span class="badge badge-success">Paid on Mar 16, 2018</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$36,890 <span class="d-block text-muted font-weight-normal">VAT $4,859</span></h6>
											</td>
											<td class="text-center">
												<div class="list-icons d-inline-flex">
													<a href="#" class="list-icons-item mr-10"><i class="fa fa-eye-slash"></i></a>
													<div class="list-icons-item dropdown">
														<a href="#" class="list-icons-item dropdown-toggle" data-toggle="dropdown"><i class="fa fa-file-text"></i></a>
														<div class="dropdown-menu dropdown-menu-right">
															<a href="#" class="dropdown-item"><i class="fa fa-download"></i> Download</a>
															<a href="#" class="dropdown-item"><i class="fa fa-print"></i> Print</a>
															<div class="dropdown-divider"></div>
															<a href="#" class="dropdown-item"><i class="fa fa-pencil"></i> Edit</a>
															<a href="#" class="dropdown-item"><i class="fa fa-remove"></i> Remove</a>
														</div>
													</div>
												</div>
											</td>
										</tr> -->
									</tbody>
								</table>
																
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
<script type="text/template" id="tr">
										<tr>
											<td>#0025</td>
											<td>February 2018</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Jacob</a>
													<span class="d-block text-muted">Payment method: Skrill</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold" selected>On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												April 18, 2018
											</td>
											<td>
												<span class="badge badge-success">Paid on Mar 16, 2018</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$36,890 <span class="d-block text-muted font-weight-normal">VAT $4,859</span></h6>
											</td>
											<td class="text-center">
												<div class="list-icons d-inline-flex">
													<a href="#" class="list-icons-item mr-10"><i class="fa fa-eye-slash"></i></a>
													<div class="list-icons-item dropdown">
														<a href="#" class="list-icons-item dropdown-toggle" data-toggle="dropdown"><i class="fa fa-file-text"></i></a>
														<div class="dropdown-menu dropdown-menu-right">
															<a href="#" class="dropdown-item"><i class="fa fa-download"></i> Download</a>
															<a href="#" class="dropdown-item"><i class="fa fa-print"></i> Print</a>
															<div class="dropdown-divider"></div>
															<a href="#" class="dropdown-item"><i class="fa fa-pencil"></i> Edit</a>
															<a href="#" class="dropdown-item"><i class="fa fa-remove"></i> Remove</a>
														</div>
													</div>
												</div>
											</td>
										</tr>
</script>
<script type="text/template" id="action">
<div class="list-icons d-inline-flex">
<!--<a href="#" class="list-icons-item mr-10"><i class="fa fa-eye-slash"></i></a>-->
<div class="list-icons-item dropdown">
	<a href="#" class="list-icons-item dropdown-toggle" data-toggle="dropdown"><i class="fa fa-file-text"></i></a>
	<div class="dropdown-menu dropdown-menu-right">
		<a href="#" class="dropdown-item"><i class="fa fa-download"></i> Download</a>
		<a href="#" class="dropdown-item"><i class="fa fa-print"></i> Print</a>
		<div class="dropdown-divider"></div>
		<a href="#" class="dropdown-item"><i class="fa fa-pencil"></i> Edit</a>
		<a href="#" class="dropdown-item"><i class="fa fa-remove"></i> Remove</a>
	</div>
</div>
</div>
</script>
<script type="text/javascript">
columns = [
	{ "data": "id"},
    { "data": "username" },
    { "data": "phone" },
    { "data": "email" },
    { "data": "mood" },
    { "data": "sex" },
    { "data": "birthday" },
    { "orderable":false,"render":function(data){return $("#action").html();} }
];
okkpp.tableInit('#mytable', columns, "/manager/user/list", null);
</script>