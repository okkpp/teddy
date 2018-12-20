<#include "/_layout/manager.ftl"/>
<@layout>
	  <div class="container-full">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="d-flex align-items-center">
				<div class="mr-auto">
					<h3 class="page-title">Invoice List</h3>
					<div class="d-inline-block align-items-center">
						<nav>
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#"><i class="mdi mdi-home-outline"></i></a></li>
								<li class="breadcrumb-item" aria-current="page">Invoice</li>
								<li class="breadcrumb-item active" aria-current="page">Invoice List</li>
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
									<table id="mytable2" class="table table-lg invoice-archive">
									<thead>
										<tr>
											<th>#</th>
											<th>h1</th>
											<th>h2</th>
											<th>h3</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
									</table>
</div>
		  <div class="row">
				<div class="col-12">
					<div class="box">
						<div class="box-header with-border">						
							<h4 class="box-title">Invoice List</h4>
							<h6 class="box-subtitle">Export Invoice List to Copy, CSV, Excel, PDF & Print</h6>
						</div>
						<div class="box-body">						
							<div class="table-responsive">
								
								<table id="mytable" class="table table-lg invoice-archive">
									<thead>
										<tr>
											<th>#</th>
											<th>Period</th>
											<th>Issued to</th>
											<th>Status</th>
											<th>Issue date</th>
											<th>Due date</th>
											<th>Amount</th>
											<th class="text-center">Actions</th>
										</tr>
									</thead>
									<tbody>
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

										<tr>
											<td>#0024</td>
											<td>February 2018</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Mason</a>
													<span class="d-block text-muted">Payment method: Wire transfer</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending">Pending</option>
													<option value="paid" selected>Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												April 17, 2018
											</td>
											<td>
												<span class="badge badge-warning">5 days</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$8,854 <span class="d-block text-muted font-weight-normal">VAT $4,785</span></h6>
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
<script type="text/javascript">

columns = [
    { "data": "d1" },
    { "data": "d2" },
    { "data": "d3" }
];
okkpp.tableInit('#mytable2', columns, "/json/table.json", null);
</script>