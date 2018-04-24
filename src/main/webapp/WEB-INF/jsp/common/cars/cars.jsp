<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>车辆管理</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link rel="stylesheet" href="../dist/jquery/dataTables.bootstrap.min.css">
		<link rel="stylesheet" href="../dist/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="../dist/adminlte/AdminLTE.css">
		<link rel="stylesheet" href="../dist/adminlte/skin-mcblue.css">
		<link rel="stylesheet" href="../dist/jquery/caldate/caldate.css">
		<link rel="stylesheet" href="../mcfish/css/mcfish.css">
	</head>

	<body class="hold-transition skin-blue sidebar-mini mc_body">
		<div class="wrapper">
			<div class="content-wrapper" style="margin-left: 0;padding-bottom: 10px">
				<section class="content-header bg-color-white">
			      <ol class="mcbreadcrumb breadcrumb">
			        <li><a href="${pageContext.request.contextPath}/shareCarsController/CarsPage.do" target="menuFrame"><i class="fa fa-dashboard"></i>车辆管理</a></li>
			      </ol>
			    </section>
				<section class="content no-padding">
					<div class="nav-tabs-custom">
						<ul class="nav nav-tabs">
							<li class="active" onclick="getAllCarsList();">
								<a href="#tab_1" data-toggle="tab" aria-expanded="false">车辆列表</a>
							</li>
							<li class="" onclick="getAllCarsApplyList();">
								<a href="#tab_2" data-toggle="tab" aria-expanded="false">投放申请</a>
							</li>
						</ul>
						<div class="tab-content">
						
							<!-- 车辆列表 -->
							<div class="tab-pane active" id="tab_1">
								<div class="box no-border no-shadow">
									<div class="box-header">
						              <form class="form-inline">
						              	   <div class="form-group">
							                      <label>状态:</label>   
							                     <select id="online" class="form-control" onchange="getAllCarsList()">
							                        <option value="">全部</option>
							                        <option value="1">在线</option>
							                        <option value="0">离线</option>
							                        <option value="2">报修</option>
							                     </select>               
							               </div>
							               <div class="form-group">
												<input type="text" id="carsFlag" class="form-control" placeholder="车辆ID/车牌号搜索" style="width: 240px;" oninput="search(this)"/>
											</div>
											<div class="form-group">
												<button class="btn  btn-info" onclick="search('#carsFlag');">搜索</button>
											</div>
						              </form>
						            </div>
									  <div class="box-body table-responsive">
						              <table id="carsList" class="table table-bordered table-hover;" >
						                <thead>
							                <tr>
							                  <th>车辆ID</th>
							                  <th>车牌号</th>
							                  <th>名称</th>
							                  <th>颜色</th>
							                  <th>版本号</th>
							                  <th>功能</th>
							                  <th>套餐</th>
							                  <th>信号</th>
							                  <th>二维码</th>
							                  <th>状态</th>
							                  <th>操作</th>
							                </tr>
						                </thead>
						              </table>
						            </div>
								</div>
							</div>

							<!-- 投放申请 -->
							<div class="tab-pane" id="tab_2">
								<div class="box box-default no-border">
									<div class="box-header" style="line-height: 45px;">
										<div class="form-inline">
											<div class="form-group" style="float: right;">
												<button class="btn  btn-info" onclick="openExportview();" id="exportModel">导出</button>
											</div>
										</div>
									</div>
									<div class="box-body table-responsive">
										<table id=carsApplyList class="table table-bordered table-hover;" >
							                <thead>
								                <tr>
								                  <th>申请人</th>
								                  <th>商家/代理</th>
								                  <th>电话</th>
								                  <th>地点</th>
								                  <th>台数</th>
								                  <th>备注</th>
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
		</div>

		<!-- 车辆列表-移机弹窗 -->
		<div class="modal fade" id="moveCarsView" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center">移机</h4>
					</div>
					<div class="modal-body">
						<div class="addInputs" style="width: 100%;">
							<div class="inputs">
								<span class="text-color-999">关联商家:</span>
								<input type="text" id="shopId" class="form-control" placeholder="请输入关联商家手机号/名称""/>
								<button type="button" id="shopSearch" class="btn btn-info" style="width: 60px;">查找</button>
							</div>
						</div>
						<div class="modal-footer" style="text-align: center;">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="button" id="saveShopForCar" class="btn btn-info">保存</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 搜索商家弹窗 -->
		<div class="modal fade" id="shopView" tabindex="-1" role="dialog" aria-labelledby="SmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%; width:45%;">
				<div class="modal-content">
					<div class="modal-header no-border">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center mar10">搜索商家</h4>
						<div class="form-inline">
							<div class="form-group">
								<input type="text" id="shopFlag" class="form-control" placeholder="请输入代理/商家手机号/名称" oninput="search(this)"/>
							</div>
							<div class="form-group">
								<button class="btn  btn-info" onclick="search('#shopFlag');">搜索</button>
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
						<button type="button" id="selectShop" class="btn btn-info">保存</button>
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
		<script src="../mcfish/js/cars/cars.js"></script>
	</body>
</html>