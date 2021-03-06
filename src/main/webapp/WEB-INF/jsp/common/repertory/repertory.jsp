<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>车辆库存</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="../dist/jquery/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="../dist/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="../dist/adminlte/AdminLTE.css">
<link rel="stylesheet" href="../dist/adminlte/skin-mcblue.css">
<link rel="stylesheet" href="../dist/jquery/caldate/caldate.css">
<link rel="stylesheet"
	href="../dist/datetimepicker/jquery.datetimepicker.css">
<link rel="stylesheet" href="../mcfish/css/mcfish.css">
</head>

<body class="hold-transition skin-blue sidebar-mini mc_body">
	<div class="wrapper">
		<div class="content-wrapper"
			style="margin-left: 0; padding-bottom: 10px">
			<section class="content-header bg-color-white">
			<ol class="mcbreadcrumb breadcrumb">
				<li><a
					href="${pageContext.request.contextPath}/shareRepertoryController/RepertoryPage.do"
					target="menuFrame"><i class="fa fa-dashboard"></i>车辆库存</a></li>
			</ol>
			</section>
			<section class="content no-padding">
			<div class="nav-tabs-custom">
				<ul class="nav nav-tabs">
					<li class="active" onclick="getRepertoryList();"><a
						href="#tab_1" data-toggle="tab" aria-expanded="false">库存列表</a></li>
					<li class="" onclick=""><a href="#tab_2" data-toggle="tab"
						aria-expanded="false">投放历史</a></li>
					<li class="" onclick="getScrapRepertoryList();"><a
						href="#tab_3" data-toggle="tab" aria-expanded="false">报废库存</a></li>
				</ul>
				<div class="tab-content">


					<!--  库存列表 -->
					<div class="tab-pane active" id="tab_1">
						<div class="box box-default no-border">
							<div class="box-header" style="line-height: 45px;">

								<div class="form-inline" style="float: left;">
									<div class="form-group">查询：</div>
									<div class="form-group">
										<input type="text" id="selectStr1" class="form-control"
											placeholder="车辆ID/车牌号搜索" style="width: 240px;"
											oninput="search(1,this);" />
									</div>
									<div class="form-group">
										<button class="btn  btn-info"
											onclick="search(1,'#selectStr1');">搜索</button>
									</div>
								</div>
								<div class="form-group" style="float: right;">
									<button class="btn  btn-info" onclick="openAddReperstory()">入库</button>
								</div>


							</div>
							<div class="box-body table-responsive">
								<table id="repertoryList"
									class="table table-bordered table-hover;">
									<thead>
										<tr>
											<th>车辆ID</th>
											<th>车牌号</th>
											<th>图片</th>
											<th>型号名</th>
											<th>厂家</th>
											<th>颜色</th>
											<th>功能描述</th>
											<th>终端密码</th>
											<th>车辆保险</th>
											<th>硬件版本</th>
											<th>操作</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>

					<!-- 投放历史 -->
					<div class="tab-pane" id="tab_2">
						<div class="box box-default no-border">
							<div class="box-header" style="line-height: 45px;">


								<div class="form-inline" style="float: left">
									<div class="form-group">查询：</div>

									<div class="form-group">
										<input type="text" id="startFlagTime2" class="form-control"
											placeholder="开始时间" style="width: 240px;" onchange="" />
									</div>

									<div class="form-group">
										<input type="text" id="endFlagTime2" class="form-control"
											placeholder="结束时间" style="width: 240px;" onchange="" />
									</div>

									<div class="form-group">
										<input type="text" id="selectStr2" class="form-control"
											placeholder="商家名称/ID" style="width: 240px;" oninput="" />
									</div>
									<div class="form-group">
										<button class="btn  btn-info" onclick="">搜索</button>
									</div>
								</div>

								<div class="form-group" style="float: right;">
									<button class="btn  btn-info" onclick="">导出</button>
								</div>
							</div>
							<div class="box-body table-responsive">
								<table id="repertoryList2"
									class="table table-bordered table-hover;">
									<thead>
										<tr>
											<th>商家名称</th>
											<th>商家ID</th>
											<th>地址</th>
											<th>投放时间</th>
											<th>操作</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>

					<!-- 报废库存 -->
					<div class="tab-pane" id="tab_3">
						<div class="box box-default no-border">
							<div class="box-header" style="line-height: 45px;">

								<div class="form-inline" style="float: left">
									<div class="form-group">查询：</div>

									<div class="form-group">
										<input type="text" id="startFlagTime3" class="form-control"
											placeholder="开始时间" style="width: 240px;"
											onchange="getScrapRepertoryList()" />
									</div>

									<div class="form-group">
										<input type="text" id="endFlagTime3" class="form-control"
											placeholder="结束时间" style="width: 240px;"
											onchange="getScrapRepertoryList();" />
									</div>

									<div class="form-group">
										<input type="text" id="selectStr3" class="form-control"
											placeholder="车辆ID/车牌号搜索" style="width: 240px;"
											oninput="search(3,this)" />
									</div>
									<div class="form-group">
										<button class="btn  btn-info"
											onclick="search(3,'#selectStr3');">搜索</button>
									</div>
								</div>
								<div class="form-group" style="float: right;">
									<button class="btn  btn-info" onclick="openExportScrapview()">导出</button>
								</div>

							</div>
							<div class="box-body table-responsive">
								<table id="scrapRepertoryTable"
									class="table table-bordered table-hover;">
									<thead>
										<tr>
											<th>车辆ID</th>
											<th>车牌号</th>
											<th>名称</th>
											<th>颜色</th>
											<th>终端ID</th>
											<th>终端密码</th>
											<th>车辆保险号</th>
											<th>硬件版本</th>
											<th>报废时间</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
		</div>


		<!-- 车辆库存信息模态框（Modal）START -->
		<div class="modal fade" id="insertCarTxt" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="left: -50px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center" id="lineShowBoxTitle">车辆入库</h4>
					</div>
					<div class="modal-body">
						<form class="bs-example bs-example-form" role="form">
							<input value="" style="display: none" id="formCarId">
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">车牌号</span> <input
									type="text" id="dno" class="form-control"> <span
									class="input-group-addon" style="width: 40px; border: none">
									<button type="button" id="import" onclick="openInsertConfig(1)"
										class="btn btn-info">导入</button>
								</span>
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">名称</span> <input type="text"
									id="name" class="form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">颜色</span> <input type="text"
									id="color" class="form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">图片</span>
								<div class="inputs">
									<div>
										<div class="uploadImg">
											<img id="actionServerImage" src="">
											<p id="actionMsgImgTool">
												<span> <a href="javascript:;" id="pickfiles"
													class="file"> 选择文件 <input type="file" name="picUrl"
														id="picUrl" class="btn btn-primary">
												</a>
													<button class="btn btn-default" id="actionServerImageBtn">删除</button>
												</span> <font>仅限png、jpg格式图片</font>
											</p>
										</div>
									</div>
								</div>
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">厂家信息</span> <input
									type="text" id="factory" class="form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">终端密码</span> <input
									type="text" id="pwd" class="form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">车辆保险号</span> <input
									type="text" id="secure" class="form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">物联名称</span> <input
									type="text" class="form-control"> <span
									class="input-group-addon" style="width: 40px; border: none">
									<button type="button" id="import" onclick="openInsertConfig(2)"
										class="btn btn-info">导入</button>
								</span>
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">版本号</span> <input
									type="text" id="version" class="form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">功能描述</span> <input
									type="text" id="funcs" class="form-control">
							</div>
						</form>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
						<button type="button" onclick="addReperstory()"
							class="btn btn-info">确定</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<!-- 车辆库存信息模态框（Modal）end -->

		<!-- 车辆库存信息导入功能模态框（Modal）START -->
		<div class="modal fade" id="insertConfig" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 15%; left: -50px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center" id="lineShowBoxTitle">导入配置</h4>
					</div>
					<div class="modal-body">
						<form class="bs-example bs-example-form" role="form">
							<select class="form-control">
								<option>配置A</option>
								<option>配置B</option>
								<option>配置C</option>
							</select>
						</form>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
						<button type="button" onclick="" class="btn btn-info">确定</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<!-- 车辆库存信息导入功能模态框（Modal）end -->


		<!-- 投放功能模态框（Modal）START -->
		<div class="modal fade" id="implementDev" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 15%; left: -50px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center" id="lineShowBoxTitle">投放</h4>
					</div>
					<div class="modal-body">
						<form class="bs-example bs-example-form" role="form">
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">关联商家</span> <input
									id="selectedShopName" class="form-control" readonly="readonly"
									placeholder="点击选择商家" onclick="selectRelationShopper()">
							</div>
							<br />
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">选择套餐</span> <select
									id="devPriceSelect" class="form-control">
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
						<button type="button" id="implementDevCommit"
							onclick="implementDevCommit()" class="btn btn-info">确定</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<!-- 投放功能模态框（Modal）end -->


		<!-- 搜索商家弹窗 -->
		<div class="modal fade" id="shopView" tabindex="-1" role="dialog"
			aria-labelledby="SmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%; width: 45%;">
				<div class="modal-content">
					<div class="modal-header no-border">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center mar10">搜索商家</h4>
						<div class="form-inline">
							<div class="form-group">
								<input type="text" id="shopSelectFlag" class="form-control"
									placeholder="请输入代理/商家手机号/名称" oninput="search(4,this)" />
							</div>
							<div class="form-group">
								<button class="btn  btn-info"
									onclick="search(4,'#shopSelectFlag');">搜索</button>
							</div>
						</div>
					</div>
					<div class="box-body table-responsive">
						<table id="shopList" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th></th>
									<th>名称</th>
									<th>手机号</th>
									<th>地址</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" id="selectShop" onclick="getShopSelected()"
							class="btn btn-info">确定</button>
					</div>
				</div>
			</div>
		</div>



	</div>


	<script src="../dist/jquery/jquery.min.js"></script>
	<script src="../dist/bootstrap/bootstrap.min.js"></script>
	<script src="../dist/adminlte/adminlte.min.js"></script>
	<script src="../dist/jquery/jquery.dataTables.js"></script>
	<script src="../dist/jquery/ui.js"></script>
	<script src="../dist/jquery/caldate/caldate.js"></script>
	<script src="../mcfish/js/mcfish.js"></script>
	<script src="../dist/datetimepicker/jquery.datetimepicker.full.js"></script>
	<script src="../mcfish/js/repertory/repertory.js"></script>
</body>
</html>