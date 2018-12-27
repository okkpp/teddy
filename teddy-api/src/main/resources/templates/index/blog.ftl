<#include "/_layout/index.ftl"/>
<#macro blog post="">
			  <div class="col-md-6">
				<div class="box">
				  <figure class="img-hov-zoomin">
					<img src="/images/gallery/thumb/2.jpg" alt="...">
				  </figure>

				  <div class="box-body">
					<h4><a href="#">${post.title}</a></h4>
					<p>${post.created}</p>

					<p>${post.summary}</p>

					<div class="flexbox align-items-center mt-3">
					  <a class="btn btn-xs btn-round btn-bold btn-primary" href="#">Read more</a>

					  <div class="gap-items-4">
						<a class="text-muted" href="#">
						  <i class="fa fa-heart mr-1"></i> ${post.views}
						</a>
						<a class="text-muted" href="#">
						  <i class="fa fa-comment mr-1"></i> ${post.views}
						</a>
					  </div>
					</div>

				  </div>
				</div>
			  </div>
</#macro>
<@layout>
	  <div class="container-full">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="d-flex align-items-center">
				<div class="mr-auto">
					<h3 class="page-title">Blog widgets</h3>
					<div class="d-inline-block align-items-center">
						<nav>
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#"><i class="mdi mdi-home-outline"></i></a></li>
								<li class="breadcrumb-item" aria-current="page">widgets</li>
								<li class="breadcrumb-item active" aria-current="page">Blog widgets</li>
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
			<#list list as row>
				<@blog post=row></@blog>
			</#list>
		</div>
		</section>
	</div>
</@layout>
