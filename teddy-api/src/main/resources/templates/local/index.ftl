<#include "/_layout/manager.ftl"/>
<@layout>
		<section class="content">
			<div id="panel" class="row">
				<#list images as row>
					<div class="col-md-6">
						<div class="box">
							<figure class="img-hov-zoomin">
							<img src="${row}">
							</figure>
						</div>
					</div>
				</#list>
				<#list dirs as row>
					<div class="col-md-6">
						<div class="box">
							<figure class="img-hov-zoomin">
							<a href="/local/index?path=${row}">${row}</a>
							</figure>
						</div>
					</div>
				</#list>
			</div>
		</section>
</@layout>

<script type="text/template" id="image">
			  <div class="col-md-6">
				<div class="box">
				  <figure class="img-hov-zoomin">
					<img src="/img/test.jpg">
				  </figure>
				</div>
			  </div>
</script>
<script type="text/javascript">
//$("#panel").html($("#image").html());
</script>