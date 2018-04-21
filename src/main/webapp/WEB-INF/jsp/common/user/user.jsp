<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>用户管理</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link rel="stylesheet" href="../dist/jquery/dataTables.bootstrap.min.css">
		<link rel="stylesheet" href="../dist/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="../dist/adminlte/AdminLTE.css">
		<link rel="stylesheet" href="../dist/adminlte/skin-mcblue.css">
		<link rel="stylesheet" href="../dist/datetimepicker/jquery.datetimepicker.css">
		<link rel="stylesheet" href="../mcfish/css/mcfish.css">
	</head>

	<body class="hold-transition skin-blue sidebar-mini mc_body">
		<div class="wrapper">
			<div class="content-wrapper" style="margin-left: 0;padding-bottom: 10px">
				<section class="content no-padding">
					<div class="box box-default">
						<div class="box-header" style="line-height: 45px;">
							<h3 class="box-title text-blue box-header-text">用户管理</h3>
							<div class="form-inline" style="margin: 10px 0 0 0;">
							  <div class="form-group">
			                      <label class="text-color-999">状态:</label>      
			                      <select id="userStatus" class="form-control" onchange="getUserList();">
			                        <option value="">全部</option>
			                        <option value="0">正常</option>
			                        <option value="1">冻结</option>
			                      </select>              
			                   </div>
			                   <div class="form-group">
									<input type="text" id="userFlagTime1" class="form-control" placeholder="注册时间开始" style="width: 240px;" onchange="getUserList();"/>
								</div>
								<div class="form-group">
									<input type="text" id="userFlagTime2" class="form-control" placeholder="注册时间结束" style="width: 240px;" onchange="getUserList();"/>
								</div>
								<div class="form-group">
									<input type="text" id="userFlag" class="form-control" placeholder="用户ID、昵称、手机号搜索" style="width: 240px;" oninput="search(this)"/>
								</div>
								<div class="form-group">
									<button class="btn  btn-info" onclick="search('#userFlag');">搜索</button>
								</div>
							</div>
						</div>
						<div class="box-body table-responsive">
							<table id="userList" class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>用户ID</th>
										<th>用户头像</th>
										<th>用户昵称</th>
										<th>性别</th>
										<th>手机号</th>
										<th>钱包</th>
										<th>优惠券</th>
										<th>订单数</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</section>
			</div>
		</div>

		<script src="../dist/jquery/jquery.min.js"></script>
		<script src="../dist/bootstrap/bootstrap.min.js"></script>
		<script src="../dist/adminlte/adminlte.min.js"></script>
		<script src="../dist/jquery/jquery.dataTables.js"></script>
		<script src="../dist/jquery/ui.js"></script>
		<script src="../mcfish/js/mcfish.js"></script>
		<script src="../dist/datetimepicker/jquery.datetimepicker.full.js"></script>
		<script src="../mcfish/js/user/user.js"></script>
	</body>

</html>