const $tools = mcfish.Tools
const $api = mcfish.API
const myurl = $tools.parseURL(window.location.href)
const uid = parseInt(myurl.params['id'])

$(function() {
	//获取用户详细信息
	getUserInfo();
})


/*************************************************************************************************************/
/******************************             基本资料页-start            ***************************************/
/*************************************************************************************************************/

/**
 * 获取用户详细信息
 * @returns
 */
function getUserInfo(){
	$("#editUserInfoBtn").show();
	$api.asyncRequest("shareUserController/getUserById.do","GET",{uid:uid}).then(function(res){
		//渲染用户信息到页面
		drawUserInfo(res.data);
	});
}


/**
 * 渲染用户信息到页面
 * @param {Object} data
 */
function drawUserInfo(data){
	
	$("#info-uid").html(data.id);
	$("#info-header").find("img").attr("src",data.head);
	$("#info-username").html(data.name);
	$("#user-sex").html(data.sex == 2?"女":"男");
	$("#info-phone").html(data.phone);
	switch (data.status){
		case 0:
			$("#info-status").html("正常");
			break;
		case 1:
			$("#info-status").html("冻结");
			break;
		default:
			break;
	}
	
	$("#info-create_time").html($tools.getMyDate(data.create_time,1));
}



/**
 * 打开用户编辑弹窗
 */
function openEditUserInfoView(){
	//编辑用户信息时获取用户信息
	getNewUserInfo();
	$("#editUserInfoView").modal("toggle");
}


/**
 * 编辑用户信息时获取用户信息
 */
function getNewUserInfo(){
	$api.asyncRequest("shareUserController/getUserById.do","GET",{uid:uid}).then(function(res){
		var data = res.data;
		
		//清除弹窗信息
		clearUserInfoView();
		
		//渲染用户信息到页面
		$("#edit-info-header").attr("src",data.head)
		$("#edit-info-userName").val(data.name)
		$("#edit-info-sex").val(data.sex)
		$("#edit-info-status").val(data.status)
		
	});
}


/**
 * 清除弹窗中的历史数据
 */
function clearUserInfoView(){

	$("#edit-info-header").attr("src","");
	$("#edit-info-userName").val("");
	$("#edit-info-sex").val("");
	$("#edit-info-status").val("");
}


/**
 * 保存新的用户信息
 */
function saveEditInfo(){
	
	var head		= $("#edit-info-header").attr("src")
	var name		= $("#edit-info-userName").val()
	var status		= $("#edit-info-status").val()
	var sex			= $("#edit-info-sex").val()
	
	
	if(name==''){
		mizhu.toast("请输入用户昵称",1000);
		return false;
	}
	
	var data = {
		id			:uid,
		head		:head,
		name		:name,
		status		:status,
		sex			:sex
	}
	
	$api.asyncRequest("shareUserController/updateUserInfo.do","POST", data).then(function(res){
		//获取用户详细信息
		getUserInfo();
		mizhu.toast(res.resmsg,1000);
		$("#editUserInfoView").modal("toggle");
	});
}


/**
 * 图片上传本地服务器
 * @returns
 */
$(function(){
	//获取服务管理列表
	getUserInfo();
	
	$("#picUrl").change(function(){
		
		var file = $(this)[0].files[0];
		
		if (!file) {
			mizhu.toast('上传文件不能为空')
			return
		}
		if (!$tools.fileTypeJudge(file, ["jpg","png","jpeg"])){
			mizhu.toast('请上传正确格式的文档')
			return
		}
		
		var form = new FormData();    // FormData 对象
		
		form.append("myfiles", file);    // 文件对象
		
		$api.processRequest('shareBasicController/fileUpload3','POST',form).then(function(res){
			
			$("#edit-info-header").attr("src",$tools.getBasicAddr() + res.data.filePath);
			console.log(res.data);
		})
	})
	
	
	$("#actionUserHeaderImageBtn").click(function(){
		$("#edit-info-header").attr("src","");
		$("#picUrl").val("");
	})
})



/*************************************************************************************************************/
/******************************             基本资料页-end          ******************************************/
/*************************************************************************************************************/



/*************************************************************************************************************/
/******************************             我的订单页-start            ***************************************/
/*************************************************************************************************************/

/**
 * 订单列表
 */
function getUserOrderList(){
	
	var pay_status = $("#userOrderStatus").val();
	var pay_way = $("#userOrderPay").val();
	var begin = $("#userOrderBegin").val() == "" ? null : $tools.calculateDate($("#userOrderBegin").val(),-1);
	var end = $("#userOrderEnd").val() == "" ? null : $tools.calculateDate($("#userOrderEnd").val(),1);
	
	var ajaxParams = {
			api: 'shareUserController/getUserOrderList.do',
			type: 'GET',
			searching:true,
			data: {
				uid			:uid,
				pay_status	:pay_status,
				pay_way		:pay_way,
				begin		:begin,
				end			:end
			}
	 }
	 var colData = [
					{"data" : "order_no",'sClass' : "text-center col-width-120"},
					{"data" : "amount",'sClass' : "text-left col-width-120",
						"render": function ( data, type, full, meta ) {
                        	return $tools.toMoney(data);
                  	     } 
					},
					{"data" : "dno",'sClass' : "text-center col-width-120",},
					{"data" : "amount_disc",'sClass' : "text-center col-width-120",
						"render": function ( data, type, full, meta ) {
                        	return $tools.toMoney(data);
                  	     } 
					},
					{"data" : "count",'sClass' : "text-center col-width-120"},
					{"data" : "address",'sClass' : "text-center col-min-width-80"},
					{"data" : "pay_way",'sClass' : "text-center col-width-120",
						"render": function ( data, type, full, meta ) {
							var str = "";
							if(data == 0){ 
								 str="<span>钱包</span> ";
							} 
							if(data == 1) {
								str="<span>微信支付</span>";
							}
							if(data == 2) {
								str="<span>体验券支付</span>";
							}
							if(data == 3) {
								str="<span>代金券支付</span>";
							}
                        	return str;
                  	     }
					},
					{"data" : "pay_status",'sClass' : "text-center col-width-120",
						"render": function ( data, type, full, meta ) {
							var str = "";
							if(data == 0){
								 str="<span class='label label-default'>未支付</span> ";
							} 
							if(data == 1) {
								str="<span class='label label-success'>已支付</span>";
							}
							if(data == 2) {
								str="<span class='label label-info'>已取消</span>";
							}
							if(data == 3) {
								str="<span class='label label-warning'>已退款</span>";
							}
							if(data == 4) {
								str="<span class='label label-danger'>已结束</span>";
							}
                        	return str;
                  	     } 
					},
					{"data" : "id",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
								var str = "";
								if(full.pay_status == 1){
									str += "<span class='tab_text_blue pointer' onclick=changeUserPayStatus(" + data +",3);>退款</span>&nbsp;&nbsp;";
								}
	                        	return str;
							}
					},
				]
	table = $api.getDataTable('#userOrderList',ajaxParams, colData);
}

/**
 * 修改订单状态
 * @param id
 * @param status
 * @returns
 */
function changeUserPayStatus(id ,status){
	parent.window.openTipsDialog("提示","确定要退款吗？",function(){
		$api.asyncRequest("shareUserController/updateUserOrderPayStatus.do","POST",{orderId:id,status:status}).then(function(res){
			mizhu.toast(res.resmsg,1000);
			table.ajax.reload(null,false);
		});
	})
}

/*************************************************************************************************************/
/******************************             用户订单页-end          ******************************************/
/*************************************************************************************************************/

/*************************************************************************************************************/
/******************************             用户钱包页-start          ******************************************/
/*************************************************************************************************************/

/**
 * 钱包列表
 */
function getUserMoneyList(){
	
	var ajaxParams = {
			api: 'shareUserController/getUserMoneyList.do',
			type: 'GET',
			searching:true,
			data: {
				uid	:uid
			}
	 }
	 var colData = [
					{"data" : "order_no",'sClass' : "text-center col-width-160"},
					{"data" : "create_time",'sClass' : "text-center col-width-160",
						"render": function ( data, type, full, meta ) {
                        	return $tools.getMyDate(data,1);
                  	     } 
					},
					{"data" : "amount_disc",'sClass' : "text-center col-width-160",
						"render": function ( data, type, full, meta ) {
                        	return $tools.toMoney(data);
                  	     } 
					},
					{"data" : "order_type",'sClass' : "text-center col-width-160",
						"render" : function(data, type, full, meta) {
							var str = "";
							if(data == 0){
								str +="<span>充值</span>";
							}
							if(data == 1){
								str +="<span>提现</span>";
							}
							if(data == 2){
								str +="<span>消费</span>";
							}
							if(data == 3){
								str +="<span>收益</span>";
							}
							if(data == 4){
								str +="<span>后台充值</span>";
							}
							if(data == 5){
								str +="<span>后台减扣</span>";
							}
							return str;
						}
					},
					{"data" : "order_type",'sClass' : "text-center col-width-160",
						"render" : function(data, type, full, meta) {
							var str = "";
							if(data == 4 || data == 5){
								str +="<span>管理员</span>";
							}else{
								str +="<span>用户</span>";
							}
							return str;
						}
					},
					{"data" : "id",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
								var str = "";
								if(full.order_type == 2){
									str += "<span class='tab_text_blue pointer' onclick=changeUserPayStatus(" + data +");>查看详情</span>&nbsp;&nbsp;";
								}
	                        	return str;
							}
					},
				]
	table = $api.getDataTable('#userAccountList',ajaxParams, colData);
}

/*************************************************************************************************************/
/******************************             用户钱包页-end          ******************************************/
/*************************************************************************************************************/


/*************************************************************************************************************/
/******************************             用户优惠券页-start          ******************************************/
/*************************************************************************************************************/

/**
 * 优惠券列表
 */
function getUserCouponList(){
	
	var ajaxParams = {
			api: 'shareUserController/getUserCouponList.do',
			type: 'GET',
			searching:true,
			data: {
				uid	:uid
			}
	 }
	 var colData = [
					{"data" : "order_no",'sClass' : "text-center col-width-120"},
					{"data" : "create_time",'sClass' : "text-left col-width-120",
						"render": function ( data, type, full, meta ) {
                        	return $tools.getMyDate(data,1);
                  	     } 
					},
					{"data" : "amount_disc",'sClass' : "text-center col-width-120",
						"render": function ( data, type, full, meta ) {
                        	return $tools.toMoney(data);
                  	     } 
					},
					{"data" : "order_type",'sClass' : "text-center col-width-120",
						"render" : function(data, type, full, meta) {
							var str = "";
							if(data == 0){
								str +="<span>充值</span>";
							}
							if(data == 1){
								str +="<span>提现</span>";
							}
							if(data == 2){
								str +="<span>消费</span>";
							}
							if(data == 3){
								str +="<span>收益</span>";
							}
							if(data == 4){
								str +="<span>后台充值</span>";
							}
							if(data == 5){
								str +="<span>后台减扣</span>";
							}
							return str;
						}
					},
					{"data" : "order_type",'sClass' : "text-center col-min-width-80",
						"render" : function(data, type, full, meta) {
							var str = "";
							if(data == 4 || data == 5){
								str +="<span>管理员</span>";
							}else{
								str +="<span>用户</span>";
							}
							return str;
						}
					},
					{"data" : "id",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
								var str = "";
								if(full.order_type == 2){
									str += "<span class='tab_text_blue pointer' onclick=changeUserPayStatus(" + data +");>查看详情</span>&nbsp;&nbsp;";
								}
	                        	return str;
							}
					},
				]
	table = $api.getDataTable('#userAccountList',ajaxParams, colData);
}

/*************************************************************************************************************/
/******************************             用户优惠券页-end          ******************************************/
/*************************************************************************************************************/


//日期插件相关
$.datetimepicker.setLocale('zh');
$("#userOrderBegin,#userOrderEnd").datetimepicker({
  	inline:false,	//true-显示，false - 隐藏
      format: 'Y-m-d',
      timepicker: false, //true-显示时间，false - 不显示时间
      height : "50px"
});


/**
 * 表格搜索
 */
/**
 * 表格搜索
 */
function search(obj){
	if(table){
		var value = $(obj).val();
		table.search(value).draw();
	}
}
