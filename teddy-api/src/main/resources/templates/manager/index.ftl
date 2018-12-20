<#include "/_layout/manager.ftl"/>
<@layout>
		<section class="content">
			<div class="row">
			
				<div class="col-xl-4 col-12"> 
				  <div class="box">
					<div class="box-header with-border">
					  <h4 class="box-title">Visit By Traffic Types</h4>
					</div>
					<div class="box-body">
					  <div id="e_chart_1" class="" style="height:213px;"></div>
					  <div class="flexbox py-10 bt-1">                
						  <div>
							  <span>New Users</span><br>
							<span>
							  <i class="ion-ios-arrow-up text-success"></i>
							  <span class="font-size-18 ml-1">113</span>
							</span>
						  </div>
						  <div id="linechart"><canvas width="100" height="38" style="display: inline-block; width: 100px; height: 38px; vertical-align: top;"></canvas></div>
					  </div>
					  <div class="flexbox py-10 bt-1">
							<div>
							  <span>Monthly Sale</span><br>
							  <span>
								<i class="ion-ios-arrow-up text-success"></i>
								<span class="font-size-18 ml-1">%80</span>
							  </span>
						   </div>
						  <div id="barchart">1,4,3,7,6,4,8,9,6,8,12</div>
					  </div>
					  <div class="flexbox py-10 bt-1">
							<div>
							  <span>Impressions</span><br>
							  <span>
								<i class="ion-ios-arrow-up text-success"></i>
								<span class="font-size-18 ml-1">%80</span>
							  </span>
							</div>
						<div id="discretechart">1,4,3,7,6,4,8,9,6,8,12</div>
					  </div>	
					</div>
					<!-- /.box-body -->
				  </div>
				  <!-- /.box -->
				</div>
				
				   <div class="col-xl-5 col-12">
					  <!-- Default box -->
					  <div class="box bg-img box-inverse" style="background-image: url(../images/gallery/thumb/4.jpg);" data-overlay="5">			
						<div class="box-body">
						  <div class="p-5">
							  <h3 class="white">
								<span class="font-size-30">City, </span>Country
							  </h3>
							  <p class="weather-day-date mb-70">
								<span class="mr-5">MONDAY</span> May 11, 2017
							  </p>
							  <div class="mb-25 weather-icon">
								<canvas class="mr-40 text-top" id="icon1" width="90" height="90"></canvas>
								<div class="inline-block">
								  <span class="font-size-50">29°
									<span class="font-size-40">C</span>
								  </span>
								  <p class="text-left">DAY RAIN</p>
								</div>
							  </div>
							  <div class="row no-space">
								<div class="col-2">
								  <div>
									<div class="mb-10">TUE</div>
									<i class="wi-day-sunny font-size-30 mb-10"></i>
									<div>24°
									  <span class="font-size-12">C</span>
									</div>
								  </div>
								</div>
								<div class="col-2">
								  <div>
									<div class="mb-10">WED</div>
									<i class="wi-day-cloudy font-size-30 mb-10"></i>
									<div>21°
									  <span class="font-size-12">C</span>
									</div>
								  </div>
								</div>
								<div class="col-2">
								  <div>
									<div class="mb-10">THU</div>
									<i class="wi-day-sunny font-size-30 mb-10"></i>
									<div>25°
									  <span class="font-size-12">C</span>
									</div>
								  </div>
								</div>
								<div class="col-2">
								  <div>
									<div class="mb-10">FRI</div>
									<i class="wi-day-cloudy-gusts font-size-30 mb-10"></i>
									<div>20°
									  <span class="font-size-12">C</span>
									</div>
								  </div>
								</div>
								<div class="col-2">
								  <div>
									<div class="mb-10">SAT</div>
									<i class="wi-day-lightning font-size-30 mb-10"></i>
									<div>18°
									  <span class="font-size-12">C</span>
									</div>
								  </div>
								</div>
								<div class="col-2">
								  <div>
									<div class="mb-10">SUN</div>
									<i class="wi-day-storm-showers font-size-30 mb-10"></i>
									<div>14°
									  <span class="font-size-12">C</span>
									</div>
								  </div>
								</div>
							  </div>
							</div>
						</div>
						<!-- /.box-body -->
					  </div>
					  <!-- /.box --> 
					</div>
			</div>
		</section>
</@layout>