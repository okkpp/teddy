<!DOCTYPE html>
<html lang="en">
<#include "/_layout/head.ftl"/>
<body class="hold-transition bg-img" style="background-image: url(../../images/auth-bg/banner.jpg);" data-overlay="1">
	
	<div class="container h-p100">
		<div class="row align-items-center justify-content-md-center h-p100">	
			
			<div class="col-12">
				<div class="row no-gutters">
					<div class="col-lg-4 col-md-5 col-12">
						<div class="content-top-agile p-10">
							<h2>Get started with Us</h2>
							<p class="text-white">Sign in to start your session</p>							
							<#if result??><p style="color:red">***${result.msg!}***</p></#if>
						</div>
						<div class="p-30 content-bottom rounded bg-img box-shadowed" style="background-image: url(../../images/auth-bg/bg-1.jpg);" data-overlay="8">
							<form action="/auth/auth" method="post">
								<div class="form-group">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text bg-transparent bt-0 bl-0 br-0 no-radius text-white"><i class="ti-user"></i></span>
										</div>
										<input type="text" class="form-control pl-15 bg-transparent bt-0 bl-0 br-0 text-white" placeholder="Username" name="username">
									</div>
								</div>
								<div class="form-group">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text  bg-transparent bt-0 bl-0 br-0 text-white"><i class="ti-lock"></i></span>
										</div>
										<input type="password" class="form-control pl-15 bg-transparent bt-0 bl-0 br-0 text-white" placeholder="Password" name="password">
									</div>
								</div>
								  <div class="row">
									<div class="col-6">
									  <div class="checkbox text-white">
										<input type="checkbox" id="basic_checkbox_1" name="rememberMe">
										<label for="basic_checkbox_1">Remember Me</label>
									  </div>
									</div>
									<!-- /.col -->
									<div class="col-6">
									 <div class="fog-pwd text-right">
										<a href="javascript:void(0)" class="text-white hover-info"><i class="ion ion-locked"></i> Forgot pwd?</a><br>
									  </div>
									</div>
									<!-- /.col -->
									<div class="col-12 text-center">
									  <button type="submit" class="btn btn-info btn-block margin-top-10">SIGN IN</button>
									</div>
									<!-- /.col -->
								  </div>
							</form>														

							<div class="text-center text-white">
							  <p class="mt-20">- Sign With -</p>
							  <p class="gap-items-2 mb-20">
								  <a class="btn btn-social-icon btn-outline btn-facebook" href="#"><i class="fa fa-facebook"></i></a>
								  <a class="btn btn-social-icon btn-outline btn-twitter" href="#"><i class="fa fa-twitter"></i></a>
								  <a class="btn btn-social-icon btn-outline btn-google" href="#"><i class="fa fa-google-plus"></i></a>
								  <a class="btn btn-social-icon btn-outline btn-instagram" href="#"><i class="fa fa-instagram"></i></a>
								</p>	
							</div>
							
							<div class="text-center">
								<p class="mt-15 mb-0 text-white">Don't have an account? <a href="auth_register.html" class="text-info ml-5">Sign Up</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- jQuery 3 -->
	<script src="../../assets/vendor_components/jquery-3.3.1/jquery-3.3.1.js"></script>
	
	<!-- popper -->
	<script src="../../assets/vendor_components/popper/dist/popper.min.js"></script>
	
	<!-- Bootstrap 4.0-->
	<script src="../../assets/vendor_components/bootstrap/dist/js/bootstrap.min.js"></script>

<#if user??>
<script type="text/javascript">
location.href = "/manager/index";
</script>
</#if>

</body>
</html>
