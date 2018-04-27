<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>代理管理</title>
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
					target="menuFrame"><i class="fa fa-dashboard"></i>代理管理</a></li>
			</ol>
			</section>
			<section class="content no-padding">
			<div class="nav-tabs-custom">
				<ul class="nav nav-tabs">
					<li class="active" onclick="getAgentList()"><a
						href="#tab_1" data-toggle="tab" aria-expanded="false">代理列表</a></li>
					<li class="" onclick=""><a
						href="#tab_2" data-toggle="tab" aria-expanded="false">佣金管理</a></li>
				</ul>
				<div class="tab-content">
					<!-- 代理列表 -->
					<div class="tab-pane active" id="tab_1">
						<div class="box box-default no-border">
							<div class="box-header" style="line-height: 45px;">

								<div class="form-inline" style="float: left">
									<div class="form-group">
										<label>省份:</label> 
										<select id="province" class="province form-control"
											onchange="getAgentList()">
											<option value="请选择"></option>
										</select>
									</div>

									<div class="form-group">
										<label>城市:</label> 
										<select id="city" class=" city form-control"
											onchange="getAgentList()">
											<option value="请选择"></option>
										</select>
									</div>
									<div class="form-group">
										<input type="text" id="selectStr1" class="form-control"
											placeholder="请输入手机号/名称" style="width: 240px;"
											oninput="search(1,this);" />
									</div>
									<div class="form-group">
										<button class="btn  btn-info"
											onclick="search(1,'#selectStr1');">搜索</button>
									</div>
								</div>
								<div class="form-group" style="float: right;">
									<button class="btn  btn-info" onclick="openAgentTxt(1)">代理创建</button>
								</div>

							</div>
							<div class="box-body table-responsive">
								<table id="agentList"
									class="table table-bordered table-hover;">
									<thead>
										<tr>
											<th>代理名称</th>
											<th>所在省份</th>
											<th>所在城市</th>
											<th>电话</th>
											<th>提成比例</th>
											<th>级别</th>
											<th>商家总数</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
					<!-- 佣金管理 -->
					<div class="tab-pane" id="tab_2">
						<div class="box box-default no-border">
							<div class="box-header" style="line-height: 45px;">

								<div class="form-inline" style="float: left">
									
									<div class="form-group">
										<label>日期:</label> 
										<input type="text" id="startFlagTime3" class="form-control"
											style="width: 240px;"
											onchange="getScrapRepertoryList()" />
									</div>

									<div class="form-group">
										<input type="text" id="selectStr1" class="form-control"
											placeholder="请输入手机号模糊查询" style="width: 240px;"
											oninput="search(1,this);" />
									</div>
									<div class="form-group">
										<button class="btn  btn-info"
											onclick="getFaultStatistics();">搜索</button>
									</div>
								</div>

							</div>
							<div class="box-body table-responsive">
								<table id="faultStatisticsList"
									class="table table-bordered table-hover;">
									<thead>
										<tr>
											<th>日期</th>
											<th>代理名称</th>
											<th>本月收益</th>
											<th>状态</th>
											<th>操作</th>
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


	

	<!-- 代理信息编辑模态框（Modal）START -->
		<div class="modal fade" id="insertAgentTxt" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="left: -50px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center" id="lineShowBoxTitle">代理</h4>
					</div>
					<div class="modal-body">
						<form class="bs-example bs-example-form" role="form">
							<input value="" style="display: none" id="formCarId">
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">代理名称</span> <input
									type="text" id="agent_name" class="agentTxtInput form-control"> 
								</span>
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">绑定电话</span> 
									<input type="text" id="agent_phone" class="agentTxtInput form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">代理级别</span> 
									<input type="text" id="agent_level" class="agentTxtInput form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">上级代理</span>
									<input type="text" id="agent_header" class="agentTxtInput form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">比例分成</span> 
									<input type="text" id="agent_proportion" class="agentTxtInput form-control">
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">代理省份</span> 
									<select  id="province1" class="form-control">
										<option value="请选择" selected ></option>
									</select>
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">代理城市</span> 
									<select  id="city1" class="form-control"></select>
							</div>
							<br>
							<div class="input-group input-group-lg" style="width: 90%">
								<span class="input-group-addon"
									style="width: 120px; border: none">设置密码</span> 
									<input type="password" id="agent_pwd" class="agentTxtInput form-control">
							</div>
						</form>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
						<button type="button" onclick="" id="submitTxt" agentId="" class="btn btn-info">确定</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<!--  代理信息编辑模态框（Modal）end -->
		
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
	<script src="../mcfish/js/agent/agent.js"></script>
</body>
</html>