<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>套餐设置</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link rel="stylesheet" href="../dist/jquery/dataTables.bootstrap.min.css">
		<link rel="stylesheet" href="../dist/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="../dist/adminlte/AdminLTE.css">
		<link rel="stylesheet" href="../dist/adminlte/skin-mcblue.css">
		<link rel="stylesheet" href="../mcfish/css/mcfish.css">
		
</head>
<body class="hold-transition skin-blue sidebar-mini mc_body">

        			<div class="content-wrapper" style="margin-left: 0;">
				<section class="content no-padding">
					<div class="box box-default">
						<div class="box-header" style="line-height: 45px;">
							<h3 class="box-title text-blue box-header-text">套餐设置</h3>
							<div class="form-inline" style="margin: 10px 0 0 0;">
								<div class="form-group">
									<label class="text-color-999">状态:</label>
									<select id="documentStatus" class="form-control" onchange="getDocumentList();">
										<option value="">全部</option>
										<option value="0">制度</option>
										<option value="1">通知</option>
									</select>
								</div>
								<div class="form-group pull-right">
									<button class="btn  btn-info" onclick="openAddPricePage();">新建套餐</button>
								</div>
							</div>
						</div>
						<div class="box-body table-responsive">
							<table id="pricepageList" class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>套餐名称  </th>
										<th>1次（元）</th>
										<th>2次（元）</th>
										<th>3次（元）</th>
										<th>4次（元）</th>
										<th>5次（元）</th>
										<th>6次（元）</th>
										<th>备注信息   </th>
										<th>创建时间   </th>
										<th>操作</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</section>
			</div>
		</div>

        <!-- 编辑/添加弹窗 -->
		<div class="modal fade" id="actionPriceView" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
						<h4 class="modal-title text-center" id="pricepageBoxTitle"></h4>
					</div>
					<div class="modal-body">
						<div class="addInputs" style="width: 100%;">
							<div class="inputs">
								<span class="text-color-999">套餐名称</span>
								<input id="actionPriceName" class="form-control" placeholder="请输入套餐名称">
							</div>
							<div class="inputs">
								<span class="text-color-999">1次（元）</span>
								<input id="actionPrice1" class="form-control" placeholder="请输入1次的价格">
							</div>
							<div class="inputs">
								<span class="text-color-999">2次（元）</span>
								<input id="actionPrice2" class="form-control" placeholder="请输入2次的价格">
							</div>
							<div class="inputs">
								<span class="text-color-999">3次（元）</span>
								<input id="actionPrice3" class="form-control" placeholder="请输入3次的价格">
							</div>
							<div class="inputs">
								<span class="text-color-999">4次（元）</span>
								<input id="actionPrice4" class="form-control" placeholder="请输入4次的价格">
							</div>
							<div class="inputs">
								<span class="text-color-999">5次（元）</span>
								<input id="actionPrice5" class="form-control" placeholder="请输入5次的价格">
							</div>
							<div class="inputs">
								<span class="text-color-999">6次（元）</span>
								<input id="actionPrice6" class="form-control" placeholder="请输入6次的价格">
							</div>
							<div class="inputs">
								<span class="text-color-999">备注信息</span>
								<input id="actioncomment" class="form-control" placeholder="请输入备注信息">
							</div>
							
						</div>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
						<button type="button" id="actionPriceBtn" class="btn btn-info">保存</button>
					</div>
				</div>
			</div>
		</div>
        

        <script src="../dist/jquery/jquery.min.js"></script>
		<script src="../dist/bootstrap/bootstrap.min.js"></script>
		<script src="../dist/adminlte/adminlte.min.js"></script>
		<script src="../dist/jquery/jquery.dataTables.js"></script>
		<script src="../dist/jquery/ui.js"></script>
		<script src="../mcfish/js/mcfish.js"></script>
		<script src="../mcfish/js/pricepage/pricepage.js"></script>
</body>
</html>