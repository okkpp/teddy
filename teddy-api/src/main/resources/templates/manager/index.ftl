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
			<div class="col-xl-3 col-md-6 col-12 ">
				<div class="box box-inverse box-success">
				  <div class="box-body">
					<div class="flexbox">
					  <h5>Invoice</h5>
					  <div class="dropdown">
						<span class="dropdown-toggle no-caret" data-toggle="dropdown"><i class="ion-android-more-vertical rotate-90"></i></span>
						<div class="dropdown-menu dropdown-menu-right">
						  <a class="dropdown-item" href="#"><i class="ion-android-list"></i> Details</a>
						  <a class="dropdown-item" href="#"><i class="ion-android-add"></i> Add new</a>
						  <a class="dropdown-item" href="#"><i class="ion-android-refresh"></i> Refresh</a>
						</div>
					  </div>
					</div>

					<div class="text-center my-2">
					  <div class="font-size-60">2,064</div>
					  <span>Total Invoice</span>
					</div>
				  </div>
				</div>
			</div>
			<!-- /.col -->
			<div class="col-xl-3 col-md-6 col-12 ">
				<div class="box box-inverse box-primary">
				  <div class="box-body">
					<div class="flexbox">
					  <h5>Re Generate Invoice</h5>
					  <div class="dropdown">
						<span class="dropdown-toggle no-caret" data-toggle="dropdown"><i class="ion-android-more-vertical rotate-90"></i></span>
						<div class="dropdown-menu dropdown-menu-right">
						  <a class="dropdown-item" href="#"><i class="ion-android-list"></i> Details</a>
						  <a class="dropdown-item" href="#"><i class="ion-android-add"></i> Add new</a>
						  <a class="dropdown-item" href="#"><i class="ion-android-refresh"></i> Refresh</a>
						</div>
					  </div>
					</div>

					<div class="text-center my-2">
					  <div class="font-size-60">1,738</div>
					  <span>Re Generate Invoice</span>
					</div>
				  </div>				
				</div>
			</div>
			<!-- /.col -->

			<div class="col-xl-3 col-md-6 col-12">
				<div class="box box-inverse box-danger">
				  <div class="box-body">
					<div class="flexbox">
					  <h5>Overdue Payment Invoice</h5>
					  <div class="dropdown">
						<span class="dropdown-toggle no-caret" data-toggle="dropdown"><i class="ion-android-more-vertical rotate-90"></i></span>
						<div class="dropdown-menu dropdown-menu-right">
						  <a class="dropdown-item" href="#"><i class="ion-android-list"></i> Details</a>
						  <a class="dropdown-item" href="#"><i class="ion-android-add"></i> Add new</a>
						  <a class="dropdown-item" href="#"><i class="ion-android-refresh"></i> Refresh</a>
						</div>
					  </div>
					</div>

					<div class="text-center my-2">
					  <div class="font-size-60">1100</div>
					  <span>Overdue Payment Invoice</span>
					</div>
				  </div>

				</div>
			</div>
			<!-- /.col -->
			<div class="col-xl-3 col-md-6 col-12">
				<div class="box box-inverse box-warning">
				  <div class="box-body">
					<div class="flexbox">
					  <h5>Pending Invoice</h5>
					  <div class="dropdown">
						<span class="dropdown-toggle no-caret" data-toggle="dropdown"><i class="ion-android-more-vertical rotate-90"></i></span>
						<div class="dropdown-menu dropdown-menu-right">
						  <a class="dropdown-item" href="#"><i class="ion-android-list"></i> Details</a>
						  <a class="dropdown-item" href="#"><i class="ion-android-add"></i> Add new</a>
						  <a class="dropdown-item" href="#"><i class="ion-android-refresh"></i> Refresh</a>
						</div>
					  </div>
					</div>

					<div class="text-center my-2">
					  <div class="font-size-60">964</div>
					  <span>Pending</span>
					</div>
				  </div>
				</div>
			</div>
			<!-- /.col -->

		  </div>	

		  <div class="row">
				<div class="col-12">
					<div class="box">
						<div class="box-header with-border">						
							<h4 class="box-title">Invoice List</h4>
							<h6 class="box-subtitle">Export Invoice List to Copy, CSV, Excel, PDF &amp; Print</h6>
						</div>
						<div class="box-body">						
							<div class="table-responsive">
								
								<div id="example_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer"><div class="dt-buttons btn-group">          <button class="btn btn-secondary buttons-copy buttons-html5" tabindex="0" aria-controls="example"><span>Copy</span></button> <button class="btn btn-secondary buttons-csv buttons-html5" tabindex="0" aria-controls="example"><span>CSV</span></button> <button class="btn btn-secondary buttons-excel buttons-html5" tabindex="0" aria-controls="example"><span>Excel</span></button> <button class="btn btn-secondary buttons-pdf buttons-html5" tabindex="0" aria-controls="example"><span>PDF</span></button> <button class="btn btn-secondary buttons-print" tabindex="0" aria-controls="example"><span>Print</span></button> </div><div id="example_filter" class="dataTables_filter"><label>Search:<input type="search" class="form-control form-control-sm" placeholder="" aria-controls="example"></label></div><table id="example" class="table table-lg invoice-archive dataTable no-footer" role="grid" aria-describedby="example_info">
									<thead>
										<tr role="row"><th class="sorting_asc" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="#: activate to sort column descending" style="width: 53px;">#</th><th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Period: activate to sort column ascending" style="width: 134px;">Period</th><th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Issued to: activate to sort column ascending" style="width: 282px;">Issued to</th><th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: 143px;">Status</th><th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Issue date: activate to sort column ascending" style="width: 166px;">Issue date</th><th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Due date: activate to sort column ascending" style="width: 180px;">Due date</th><th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Amount: activate to sort column ascending" style="width: 106px;">Amount</th><th class="text-center sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: 85px;">Actions</th></tr>
									</thead>
									<tbody>
										

										

										

										

										

										

										

										

										

										

										

										

										
									<tr role="row" class="odd">
											<td class="sorting_1">#0013</td>
											<td>November 2017</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Liam</a>
													<span class="d-block text-muted">Payment method: Wire transfer</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending" selected="">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												February 25, 2018
											</td>
											<td>
												<span class="badge badge-success">Paid on Feb 15, 2018</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$985 <span class="d-block text-muted font-weight-normal">VAT $124</span></h6>
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
										</tr><tr role="row" class="even">
											<td class="sorting_1">#0014</td>
											<td>December 2017</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Elijah</a>
													<span class="d-block text-muted">Payment method: Paypal</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel" selected="">Canceled</option>
												</select>
											</td>
											<td>
												March 2, 2018
											</td>
											<td>
												<span class="badge badge-secondary">On hold</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$985 <span class="d-block text-muted font-weight-normal">VAT $458</span></h6>
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
										</tr><tr role="row" class="odd">
											<td class="sorting_1">#0015</td>
											<td>December 2017</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Matthew</a>
													<span class="d-block text-muted">Payment method: Payoneer</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid" selected="">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												March 23, 2018
											</td>
											<td>
												<span class="badge badge-warning">6 days</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$369 <span class="d-block text-muted font-weight-normal">VAT $85</span></h6>
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
										</tr><tr role="row" class="even">
											<td class="sorting_1">#0016</td>
											<td>December 2017</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Anthony</a>
													<span class="d-block text-muted">Payment method: Paypal</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue" selected="">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												March 7, 2018
											</td>
											<td>
												<span class="badge badge-primary">15 days</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$985 <span class="d-block text-muted font-weight-normal">VAT $365</span></h6>
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
										</tr><tr role="row" class="odd">
											<td class="sorting_1">#0017</td>
											<td>December 2017</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Daniel</a>
													<span class="d-block text-muted">Payment method: Wire transfer</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending" selected="">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												May 6, 2018
											</td>
											<td>
												<span class="badge badge-warning">2 days</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$687 <span class="d-block text-muted font-weight-normal">VAT $845</span></h6>
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
										</tr><tr role="row" class="even">
											<td class="sorting_1">#0018</td>
											<td>January 2018</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Aiden</a>
													<span class="d-block text-muted">Payment method: Skrill</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending" selected="">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												June 17, 2018
											</td>
											<td>
												<span class="badge badge-secondary">On hold</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$358 <span class="d-block text-muted font-weight-normal">VAT $652</span></h6>
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
										</tr><tr role="row" class="odd">
											<td class="sorting_1">#0019</td>
											<td>January 2018</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Alexander</a>
													<span class="d-block text-muted">Payment method: Paypal</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold" selected="">On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												December 26, 2017
											</td>
											<td>
												<span class="badge badge-success">Paid on Feb 25, 2018</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$958 <span class="d-block text-muted font-weight-normal">VAT $652</span></h6>
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
										</tr><tr role="row" class="even">
											<td class="sorting_1">#0020</td>
											<td>January 2018</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Ethan</a>
													<span class="d-block text-muted">Payment method: Wire transfer</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid" selected="">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												January 10, 2018
											</td>
											<td>
												<span class="badge badge-secondary">On hold</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$985 <span class="d-block text-muted font-weight-normal">VAT $548</span></h6>
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
										</tr><tr role="row" class="odd">
											<td class="sorting_1">#0021</td>
											<td>January 2018</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Noah</a>
													<span class="d-block text-muted">Payment method: Paypal</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue" selected="">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel">Canceled</option>
												</select>
											</td>
											<td>
												January 10, 2018
											</td>
											<td>
												<span class="badge badge-danger">- 3 days</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$845 <span class="d-block text-muted font-weight-normal">VAT $98</span></h6>
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
										</tr><tr role="row" class="even">
											<td class="sorting_1">#0022</td>
											<td>January 2018</td>
											<td>
												<h6 class="mb-0">
													<a href="#">Jayden</a>
													<span class="d-block text-muted">Payment method: Paypal</span>
												</h6>
											</td>
											<td>
												<select name="status" class="form-control" data-placeholder="Select status">
													<option value="overdue">Overdue</option>
													<option value="hold">On hold</option>
													<option value="pending">Pending</option>
													<option value="paid">Paid</option>
													<option value="invalid">Invalid</option>
													<option value="cancel" selected="">Canceled</option>
												</select>
											</td>
											<td>
												January 15, 2018
											</td>
											<td>
												<span class="badge badge-primary">12 days</span>
											</td>
											<td>
												<h6 class="mb-0 font-weight-bold">$458 <span class="d-block text-muted font-weight-normal">VAT $985</span></h6>
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
										</tr></tbody>
								</table><div class="dataTables_info" id="example_info" role="status" aria-live="polite">Showing 1 to 10 of 13 entries</div><div class="dataTables_paginate paging_simple_numbers" id="example_paginate"><ul class="pagination"><li class="paginate_button page-item previous disabled" id="example_previous"><a href="#" aria-controls="example" data-dt-idx="0" tabindex="0" class="page-link">Previous</a></li><li class="paginate_button page-item active"><a href="#" aria-controls="example" data-dt-idx="1" tabindex="0" class="page-link">1</a></li><li class="paginate_button page-item "><a href="#" aria-controls="example" data-dt-idx="2" tabindex="0" class="page-link">2</a></li><li class="paginate_button page-item next" id="example_next"><a href="#" aria-controls="example" data-dt-idx="3" tabindex="0" class="page-link">Next</a></li></ul></div></div>
																
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