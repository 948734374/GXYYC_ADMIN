<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>用户详情</title>
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
			<div class="content-wrapper" style="margin-left: 0;padding-bottom: 10px">
				<section class="content-header bg-color-white">
			      <ol class="mcbreadcrumb breadcrumb">
			        <li><a href="${pageContext.request.contextPath}/shareUserController/UserPage.do" target="menuFrame"><i class="fa fa-dashboard"></i>用户管理</a></li>
			        <li class="active">用户详情</li>
			      </ol>
			    </section>
				<section class="content no-padding">
					<div class="nav-tabs-custom">
						<ul class="nav nav-tabs">
							<li class="active" onclick="getUserInfo();">
								<a href="#tab_1" data-toggle="tab" aria-expanded="false">基本资料</a>
							</li>
							<li class="" onclick="getUserOrderList();">
								<a href="#tab_2" data-toggle="tab" aria-expanded="false">我的订单</a>
							</li>
							<li class="" onclick="getUserMoneyList();">
								<a href="#tab_3" data-toggle="tab" aria-expanded="false">我的钱包</a>
							</li>
							<li class="" onclick="getUserCouponList();">
								<a href="#tab_4" data-toggle="tab" aria-expanded="false">我的优惠券</a>
							</li>
						</ul>
						<div class="tab-content">
						
							<!-- 基本资料 -->
							<div class="tab-pane active" id="tab_1">
								<div class="box no-border no-shadow">
									<div class="box-body table-responsive no-padding">
										<div class="info-container">
											<div class="info-container_left">
			
												<div class="item">
													<div class="item_left">
														<span>用户ID</span>
													</div>
													<div class="item_right">
														<div id="info-uid"></div>
													</div>
												</div>
			
												<div class="item">
													<div class="item_left">
														<span>头像</span>
													</div>
													<div class="item_right">
														<div id="info-header">
															<img />
														</div>
													</div>
												</div>
												<div class="item">
													<div class="item_left">
														<span>用户昵称</span>
													</div>
													<div class="item_right">
														<div id="info-username"></div>
													</div>
												</div>
												<div class="item">
													<div class="item_left">
														<span>性别</span>
													</div>
													<div class="item_right">
														<div id="user-sex"></div>
													</div>
												</div>
												<div class="item">
													<div class="item_left">
														<span>联系方式</span>
													</div>
													<div class="item_right">
														<div id="info-phone"></div>
													</div>
												</div>
												<div class="item">
													<div class="item_left">
														<span>用户状态</span>
													</div>
													<div class="item_right">
														<div id="info-status"></div>
													</div>
												</div>
												<div class="item">
													<div class="item_left">
														<span>注册时间</span>
													</div>
													<div class="item_right">
														<div id="info-create_time"></div>
													</div>
												</div>
												
											</div>
											
											<div class="info-container_right">
												<div class="item">
													<div onclick="openEditUserInfoView();" class="btn  btn-info">
														<span>编辑资料</span>
													</div>
												</div>
											</div>
											
										</div>
									</div>
								</div>
							</div>

							<!-- 我的订单 -->
							<div class="tab-pane" id="tab_2">
								<div class="box box-default no-border">
									<div class="box-header" style="line-height: 45px;">
										<div class="form-inline">
											<div class="form-group">
						                      <label class="text-color-999">状态:</label>      
						                      <select id="userOrderStatus" class="form-control" onchange="getUserOrderList()">
						                        <option value="">全部</option>
						                        <option value="0">未支付</option>
						                        <option value="1">已支付</option>
						                        <option value="2">已取消</option>
						                        <option value="3">已退款</option>
						                        <option value="4">已结束</option>
						                      </select>     
						                      <label class="text-color-999">支付过滤:</label>      
						                      <select id="userOrderPay" class="form-control" onchange="getUserOrderList();">
						                        <option value="">全部</option>
						                        <option value="0">钱包</option>
						                        <option value="1">微信支付</option>
						                        <option value="2">体验券支付</option>
						                        <option value="3">代金券支付</option>
						                      </select>              
						                   </div>
						                   <div class="form-group">
												<input type="text" id="userOrderBegin" class="form-control" placeholder="开始时间" style="width: 240px;" onchange="getUserOrderList();"/>
											</div>
											<div class="form-group">
												<input type="text" id="userOrderEnd" class="form-control" placeholder="结束时间" style="width: 240px;" onchange="getUserOrderList();"/>
											</div>
											<div class="form-group">
												<input type="text" id="userOrderFlag" class="form-control" placeholder="订单编号搜索" style="width: 240px;" oninput="search(this)"/>
											</div>
											<div class="form-group">
												<button class="btn  btn-info" onclick="search('#userOrderFlag');">搜索</button>
											</div>
										</div>
									</div>
									<div class="box-body table-responsive">
										<table id="userOrderList" class="table table-bordered table-hover">
											<thead>
												<tr>
													<th>订单号</th>
													<th>订单价格（元）</th>
													<th>车牌号</th>
													<th>抵扣金额（元）</th>
													<th>使用次数</th>
													<th>地址</th>
													<th>付款方式</th>
													<th>状态</th>
													<th>操作</th>
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>

							<!-- 我的钱包 -->
							<div class="tab-pane" id="tab_3">
								<div class="box box-default no-border">
									<div class="box-header" style="line-height: 45px;">
										<div class="form-inline">
												<div class="form-group">
													<label class="text-color-999">账户余额:</label>
													<span id="userAccount" class="text-color-red"></span>
												</div>
												<div class="form-group" style="float: right; margin-right: 10px;" >
													<button class="btn  btn-info" onclick="openAddAndReduceView(1);">充值</button>
												</div>
												<div class="form-group" style="float: right; margin-right: 10px;" >
													<button class="btn  btn-info" onclick="openAddAndReduceView(2)">减扣</button>
												</div>
										</div>
										<div class="box-body table-responsive">
											<table id="userAccountList" class="table table-bordered table-hover">
												<thead>
													<tr>
														<th>订单号</th>
														<th>时间</th>
														<th>金额</th>
														<th>用途</th>
														<th>操作人</th>
														<th>操作</th>
													</tr>
												</thead>
											</table>
										</div>
									</div>
								</div>
							</div>
							
							<!-- 我的优惠券-->
							<div class="tab-pane" id="tab_4">
								<div class="box box-default no-border">
									<div class="box-header" style="line-height: 45px;">
										<div class="form-inline">
											<div class="form-group">
						                      <label class="text-color-999">类型:</label>      
						                      <select id="userCouponType" class="form-control" onchange="getUserCouponList();">
						                        <option value="">全部</option>
						                        <option value="0">体验券</option>
						                        <option value="1">代金券</option>
						                      </select>     
						                      <label class="text-color-999">状态:</label>      
						                      <select id="userCouponStatus" class="form-control" onchange="getUserCouponList();">
						                        <option value="">全部</option>
						                        <option value="0">未使用</option>
						                        <option value="1">已使用</option>
						                        <option value="2">已过期</option>
						                      </select>              
						                   </div>
											<div class="form-group">
												<input type="text" id="userCouponFlag" class="form-control" placeholder="优惠券编号搜索" style="width: 240px;" oninput="search(this)"/>
											</div>
											<div class="form-group">
												<button class="btn  btn-info" onclick="search('#userCouponFlag');">搜索</button>
											</div>
										</div>
									</div>
									<div class="box-body table-responsive">
										<table id="userCouponList" class="table table-bordered table-hover">
											<thead>
												<tr>
													<th>优惠券类型</th>
													<th>优惠券编号</th>
													<th>优惠券额度（元）</th>
													<th>备注列</th>
													<th>状态</th>
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
							
					</div>
				</section>
			</div>
		</div>


		<!-- 编辑用户详情弹窗 -->
		<div class="modal fade" id="editUserInfoView" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center">编辑用户资料</h4>
					</div>
					<div class="modal-body">
						<div class="addInputs" style="width: 100%;">
							<div class="inputs">
								<span class="text-color-999">头像</span>
								<div>
									<div class="uploadImg">
										<img id="edit-info-header" src="http://p.qlogo.cn/bizmail/EYpKfaTucnc9cmico9IQALvL628bCoZgtubJ6RoqGhl8ndXdtnZ6OYA/0">
										<p id="actionMsgImgTool">
											<span>
												<a href="javascript:;" id="pickfiles" class="file">
													选择文件
						 							<input type="file" name="picUrl" id="picUrl" class="btn btn-primary">
						                        </a>
					 							<button class="btn btn-default" id="actionUserHeaderImageBtn">删除</button>
											</span>
											<font>仅限png、jpg格式图片</font>
										</p>
									</div>
								</div>
							</div>
							<div class="inputs">
								<span class="text-color-999">用户昵称</span>
								<input id="edit-info-userName" class="form-control" placeholder="请输入用户昵称"></input>
							</div>
							<div class="inputs">
								<span class="text-color-999">性别</span>
								<select id="edit-info-sex" class="form-control">
									<option value="">请选择</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</div>
							<div class="inputs">
								<span class="text-color-999">状态</span>
								<select id="edit-info-status" class="form-control">
									<option value="">请选择</option>
									<option value="0">正常</option>
									<option value="1">冻结</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="modal-footer" style="text-align: center;">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-info" onclick="saveEditInfo();">保存</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 查看详情弹窗 -->
		<div class="modal fade" id="userOrderInfoView" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title text-center">订单详情</h4>
					</div>
					<div class="modal-body">
						<div class="info-container" style="margin-left: 100px; min-width: 450px;">
								<div class="item">
									<div class="item_left">
										<span>订单编号</span>
									</div>
									<div class="item_right">
										<div id="infoOrderId"></div>
									</div>
								</div>

								<div class="item">
									<div class="item_left">
										<span>订单金额</span>
									</div>
									<div class="item_right">
										<div id="infoOrderMoney"></div>
									</div>
								</div>
								<div class="item">
									<div class="item_left">
										<span>车牌号</span>
									</div>
									<div class="item_right">
										<div id="infoCarNo"></div>
									</div>
								</div>
								<div class="item">
									<div class="item_left">
										<span>用途</span>
									</div>
									<div class="item_right">
										<div id="infoUseTo"></div>
									</div>
								</div>
								<div class="item">
									<div class="item_left">
										<span>下单时间</span>
									</div>
									<div class="item_right">
										<div id="infoCreateTime"></div>
									</div>
								</div>
						</div>
					</div>
					
					<div class="modal-footer" style="text-align: center;">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 充值、减扣弹窗 -->
		<div class="modal fade" id="addAndReduceView" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top: 10%;margin-left: 38%;">
				<div class="modal-content" style="width: 400px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 id="addAndReduceTitle" class="modal-title text-center"></h4>
					</div>
					<div class="modal-body">
						<div class="addInputs" style="width: 100%;">
							<div id="addAndReduceInput" class="inputs">
							</div>
						</div>
					</div>
					
					<div class="modal-footer" style="text-align: center;">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" id="saveAddAndReduceInfo" class="btn btn-info">保存</button> 
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
		<script src="../mcfish/js/user/detail.js"></script>
	</body>
</html>