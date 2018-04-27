<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>报修申请</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="../dist/jquery/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="../dist/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="../dist/adminlte/AdminLTE.css">
<link rel="stylesheet" href="../dist/adminlte/skin-mcblue.css">
<link rel="stylesheet" href="../dist/jquery/caldate/caldate.css">
<link rel="stylesheet" href="../dist/datetimepicker/jquery.datetimepicker.css">
<link rel="stylesheet" href="../mcfish/css/mcfish.css">
</head>

<body class="hold-transition skin-blue sidebar-mini mc_body">
	<div class="wrapper">
		<div class="content-wrapper"
			style="margin-left: 0; padding-bottom: 10px">
			<section class="content-header bg-color-white">
			<ol class="mcbreadcrumb breadcrumb">
				<li><a
					href="${pageContext.request.contextPath}/shareRepairsController/RepairsPage.do"
					target="menuFrame"><i class="fa fa-dashboard"></i>报修管理</a></li>
			</ol>
			</section>
			<section class="content no-padding">
			<div class="nav-tabs-custom">
				<ul class="nav nav-tabs">
					<li class="active" onclick="getRepairsList();"><a
						href="#tab_1" data-toggle="tab" aria-expanded="false">报修申请</a></li>
					<li class="" onclick="getFaultStatistics();"><a
						href="#tab_2" data-toggle="tab" aria-expanded="false">故障统计</a></li>
				</ul>
				<div class="tab-content">

					<!-- 报修申请 -->
					<div class="tab-pane active" id="tab_1">
						<div class="box box-default no-border">
							<div class="box-header" style="line-height: 45px;">

								<div class="form-inline" style="float: left">
									<div class="form-group">
										<label>状态:</label> <select id="repairsStatus"
											class="form-control" onchange="getRepairsList()">
											<option value="">全部</option>
											<option value="0">待审核</option>
											<option value="1">已挂起</option>
											<option value="2">待处理</option>
											<option value="3">已修复</option>
											<option value="4">已报废</option>
											<option value="5">审核未通过</option>
										</select>
									</div>

									<div class="form-group">
										<input type="text" id="startFlagTime1" class="form-control"
											placeholder="开始时间" style="width: 120px;"
											onchange="getRepairsList()" />
									</div>

									<div class="form-group">
										<input type="text" id="endFlagTime1" class="form-control"
											placeholder="结束时间" style="width: 120px;"
											onchange="getRepairsList();" />
									</div>

									<div class="form-group">
										<input type="text" id="selectStr1" class="form-control"
											placeholder="车辆ID/车牌号搜索" style="width: 240px;"
											oninput="search(1,this)" />
									</div>
									<div class="form-group">
										<button class="btn  btn-info"
											onclick="search(1,'#selectStr1');">搜索</button>
									</div>
								</div>
								<div class="form-group" style="float: right;">
									<button class="btn  btn-info" onclick="openExportRepairs()">导出</button>
								</div>

							</div>
							<div class="box-body table-responsive">
								<table id="repairsList"
									class="table table-bordered table-hover;">
									<thead>
										<tr>
											<th>车牌号</th>
											<th>车型</th>
											<th>商家名称</th>
											<th>故障原因</th>
											<th>图片</th>
											<th>申请人</th>
											<th>状态</th>
											<th>维修人</th>
											<th>审核人</th>
											<th>操作</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>


					<!-- 故障统计 -->
					<div class="tab-pane" id="tab_2">
						<div class="box box-default no-border">
							<div class="box-header" style="line-height: 45px;">

								<div class="form-inline" style="float: left">
									<div class="form-group">
										<label>省份:</label> 
										<select id="province" class="province form-control"
											onchange="getFaultStatistics()">
											<option value="请选择"></option>
										</select>
									</div>

									<div class="form-group">
										<label>城市:</label> 
										<select id="city" class=" city form-control"
											onchange="getFaultStatistics()">
											<option value="请选择"></option>
										</select>
									</div>

									<div class="form-group">
										<label>地区:</label>
										 <select id="town" class="district form-control"
											onchange="getFaultStatistics()">
											<option value="请选择"></option>
										</select>
									</div>

									<div class="form-group">
										<input type="text" id="startFlagTime2" class="form-control"
											placeholder="开始时间" style="width: 120px;"
											onchange="getFaultStatistics();" />
									</div>

									<div class="form-group">
										<input type="text" id="endFlagTime2" class="form-control"
											placeholder="结束时间" style="width: 120px;"
											onchange="getFaultStatistics();" />
									</div>
									<div class="form-group">
										<button class="btn  btn-info"
											onclick="getFaultStatistics();">搜索</button>
									</div>
								</div>
								<div class="form-group" style="float: right;">
									<button class="btn  btn-info" onclick="openExportStatistics();">导出</button>
								</div>

							</div>
							<div class="box-body table-responsive">
								<table id="faultStatisticsList"
									class="table table-bordered table-hover;">
									<thead>
										<tr>
											<th>省份</th>
											<th>市区</th>
											<th>地区</th>
											<th>开始时间</th>
											<th>截止时间</th>
											<th>故障设备数量</th>
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


		<!-- 详情modal -->
		<div class="modal fade" id="DevDetail" tabindex="-1" role="dialog"
			aria-labelledby="SmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%; width: 45%;">
				<div class="modal-content">
					<div class="modal-header no-border">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
					</div>
					<div class="box-body table-responsive">
						<table id="devDetailList" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th class="text-center">车辆ID</th>
									<th class="text-center">车牌号</th>
									<th class="text-center">名称</th>
									<th class="text-center">颜色</th>
									<th class="text-center">版本号</th>
									<th class="text-center">功能</th>
									<th class="text-center">套餐</th>
								</tr>
								<tr>
									<th class="text-center" id="detail_id">未获取</th>
									<th class="text-center" id="detail_dno">未获取</th>
									<th class="text-center" id="detail_name">未获取</th>
									<th class="text-center" id="detail_color">未获取</th>
									<th class="text-center" id="detail_version">未获取</th>
									<th class="text-center" id="detail_funcs">未获取</th>
									<th class="text-center" id="detail_priceName">未获取</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
					</div>
				</div>
			</div>
		</div>


		<!-- 审核模态框 -->
		<div class="modal fade" id="checkRepairs" tabindex="-1" role="dialog"
			aria-labelledby="SmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%; ">
				<div class="modal-content">
					<div class="modal-header no-border">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center" id="lineShowBoxTitle">是否审核通过？</h4>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<input style="display:none;" id="checkRepairsIdInput" value="">
						<button type="button" class="btn btn-default"  onclick="checkRepairs(5)">不通过</button>
						<button type="button" id="" onclick="checkRepairs(2)"
							class="btn btn-info">通过</button>
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
	<script src="../dist/address/area.js"></script>
	<script src="../dist/address/select.js"></script>
	<script src="../mcfish/js/mcfish.js"></script>
	<script src="../dist/datetimepicker/jquery.datetimepicker.full.js"></script>
	<script src="../mcfish/js/repairs/repairs.js"></script>
</body>
</html>