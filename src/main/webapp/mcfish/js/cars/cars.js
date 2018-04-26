const $tools = mcfish.Tools
const $api = mcfish.API


/*************************************************************************************************************/
/******************************             车辆列表页-start            ***************************************/
/*************************************************************************************************************/

$(function(){
	//获取车辆管理列表
	getAllCarsList();
})

/**
 * 获取车辆管理列表
 */
function getAllCarsList(){
	
	var online = $("#online").val();
	
	var ajaxParams = {
			api: 'shareCarsController/getAllCarsList.do',
			type: 'GET',
			searching:true,
			data: {
				online	:online
			}
	 }
	 var colData = [ 
		
					{"data" : "id",'sClass' : "text-left col-width-120"},
					{"data" : "dno",'sClass' : "text-left col-width-120"},
					{"data" : "name",'sClass' : "text-left col-width-120"},
					{"data" : "color",'sClass' : "text-center col-width-80"},
					{"data" : "version",'sClass' : "text-center col-width-120"},
					{"data" : "funcs",'sClass' : "text-center col-width-120"},
					{"data" : "price_name",'sClass' : "text-center col-width-120"},
					{"data" : "signal",'sClass' : "text-center col-width-80",
						"render": function ( data, type, full, meta ) {
							var str = "";
							if(data == 0){
								str = "弱";
							}
							if (data == 1){
								str = "中";
							}
							if(data == 2){
								str = "强";
							}
							return str;
						}		
					},
					{"data" : "image",'sClass' : "text-center col-width-80",
						"render": function ( data, type, full, meta ) {
			            	return "<img src='" + $tools.toHeadImage(data)+ "' class='userImg' />";
			      	     }
					},
					{"data" : "online",'sClass' : "text-center col-width-80",
						"render": function ( data, type, full, meta ) {
							var str = "";
							if(data== 0){
								 str="<span class='label label-danger'>离线</span> ";
							} 
							if(data == 1) {
								str="<span class='label label-success'>正常</span>";
							}
							if(data == 2) {
								str="<span class='label label-warning'>报修</span>";
							}
                        	return str;
                  	     } 
					},
					{"data" : "id",'sClass' : "text-center col-width-oper3",
						"render" : function(data, type, full, meta) {
								var str = "";
								str += "<span class='tab_text_blue pointer' onclick=updateCars(" + data +",1,0);>撤机</span>&nbsp;&nbsp;";
								str += "<span class='tab_text_blue pointer' onclick=openMoveCarsView(" + data +");>移机</span>&nbsp;&nbsp;";
								str += "<span class='tab_text_blue pointer' onclick=updateCars(" + data +",3);>报修</span>&nbsp;&nbsp;";
								str += "<span class='tab_text_blue pointer' onclick=updateCars(" + data +",4);>重启</span>&nbsp;&nbsp;";
	                        	return str;
							}
					},
				]
	table = $api.getDataTable('#carsList',ajaxParams, colData);
}


/**
 * 删除用户
 * @param id 用户id
 * @returns
 */
function deleteUserId(id,type,status){
	parent.window.openTipsDialog("确定删除","删除后数据将不存在",function(){
		$api.asyncRequest("shareUserController/deleteUser.do","POST",{userId:id}).then(function(res){
			mizhu.toast(res.resmsg,1000);
			table.ajax.reload(null,false);
		});
	})
}


/**
 * 更新车辆管理
 * @param id 用户id
 * @param status 目标状态
 * @returns
 */
function updateCars(id,type,status){
	
	//判断具体操作
	if(type == 1){
		//撤机
		//设置离线状态
		online = 0;
		parent.window.openTipsDialog("提示","是否要撤走此设备？",function(){
			$api.asyncRequest("shareCarsController/updateCars.do","POST",{id:id,type:type,online:online,status:status}).then(function(res){
				mizhu.toast(res.resmsg,1000);
				table.ajax.reload(null,false);
			});
		})
	}
	
}

/**
 * 打开移机窗口
 * @returns
 */
function openMoveCarsView(id){
	//将id传入弹出框
	$("#shopSearch").attr("onclick","openShopView(" + id + ")");
	$("#moveCarsView").modal("toggle");
}

function openShopView(carId){
	
	var ajaxParams = {
			api			: 'shareCarsController/selectAllShops.do',
			type		: 'GET',
			searching	: true
	 }
	 var colData = [
				 	{"data" : "id",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							var str = "";
							str += "<input type='radio' name='radio' value='"+ data + "'/>";
		                 	return str;
						}
					},
		 			{"data" : "name",'sClass' : "text-center col-width-160"},
		 			{"data" : "phone",'sClass' : "text-center col-width-160"},
		 			{"data" : "adds",'sClass' : "text-center col-width-220"}
					
				]
	table = $api.getDataTable('#shopList',ajaxParams, colData);
	
	$("#selectShop").attr("onclick","saveSelectShop(" + carId + ")");
	
	$("#shopView").modal("toggle");
}

/**
 * 当选中商家时
 * @param id
 * @returns
 */
function saveSelectShop(carId){
	//获取单选框中的值
	var shop_id = $("input[name='radio']:checked").val();
	
	//将选中的值填入商家input
	$api.asyncRequest("shareShopController/getShopInfo.do","POST",{id:shop_id}).then(function(res){
		$("#shopId").val(res.data.name);
		
		$("#saveShopForCar").attr("onclick","saveShopInfo(" + carId + "," + shop_id + ")")
		
		$("#shopView").modal("toggle");
	});
}


/**
 * 保存选中信息
 * @returns
 */
function saveShopInfo(carId,shop_id){
	
	if(carId == null || carId == ''){
		mizhu.toast("未获取到当前车辆ID，请重新选择车辆！",1000);
		return false;
	}
	if(shop_id == null || shop_id == ''){
		mizhu.toast("未获取到商家，请重新选择商家！",1000);
		return false;
	}
	
	$api.asyncRequest("shareCarsController/updateCarsShop.do","POST",{id:carId,shop_id:shop_id}).then(function(res){
		mizhu.toast(res.resmsg,1000);
		$("#moveCarsView").modal("toggle");
	});
	
}
/*************************************************************************************************************/
/******************************             车辆列表页-end            ***************************************/
/*************************************************************************************************************/


/*************************************************************************************************************/
/******************************             投放申请页-start            ***************************************/
/*************************************************************************************************************/

/**
 * 获取投放列表
 */
function getAllCarsApplyList(){

	var ajaxParams = {
			api: 'shareCarsController/getAllCarsApplyList.do',
			type: 'GET',
			searching:true,
	 	}
	
	 var colData = [ 
		
					{"data" : "name",'sClass' : "text-center col-width-160"},
					{"data" : "type",'sClass' : "text-center col-width-160",
						"render" : function(data, type, full, meta) {
							var str = "";
							if(data == 0){
								str = "代理商";
							}
							if(data == 1){
								str = "商家";
							}
							return str;
						}
					},
					{"data" : "phone",'sClass' : "text-center col-width-160"},
					{"data" : "adds",'sClass' : "text-center col-width-160"},
					{"data" : "count",'sClass' : "text-center col-width-160"},
					{"data" : "comment",'sClass' : "text-center col-min-width-160"},
					{"data" : "status",'sClass' : "text-center col-width-160",
						"render" : function(data, type, full, meta) {
							var str = "";
							if(data == 0){
								str = "未审核";
							}
							if(data == 1){
								str = "已拒绝";
							}
							if(data == 2){
								str = "已采纳";
							}
							if(data == 3){
								str = "铺设中";
							}
							if(data == 4){
								str = "已完成";
							}
							return str;
						}
					},
					{"data" : "id",'sClass' : "text-center col-width-oper2",
						"render" : function(data, type, full, meta) {
								var str = "";
								if(full.status == 0){
									str += "<span class='tab_text_blue pointer' onclick=changeCarsStatus(" + data +",2);>采纳</span>&nbsp;&nbsp;";
									str += "<span class='tab_text_blue pointer' onclick=changeCarsStatus(" + data +",1);>拒绝</span>&nbsp;&nbsp;";
								}
								if(full.status == 1){
									str += "<span class='tab_text_gary'>已完成</span>&nbsp;&nbsp;";
								}
								if(full.status == 2){
									str += "<span class='tab_text_gary'>已完成</span>&nbsp;&nbsp;";
								}
								if(full.status == 3){
									str += "<span class='tab_text_gary'>铺设中</span>&nbsp;&nbsp;";
								}
								
	                        	return str;
							}
					},
				]
	table = $api.getDataTable('#carsApplyList',ajaxParams, colData);
}


/**
 * 更新设备状态
 * @param id
 * @param status
 * @returns
 */
function changeCarsStatus(id,status){
	
	var str = "";
	
	if(status == 2){
		str = "确定采纳吗？";
	}
	if(status == 1){
		str = "确认拒绝吗？";
	}
	
	parent.window.openTipsDialog("提示",str,function(){
		$api.asyncRequest("shareCarsController/updateCarsApply.do","POST",{id:id,status:status}).then(function(res){
			mizhu.toast(res.resmsg,1000);
			table.ajax.reload(null,false);
		});
	})
}


/**
 * 导出提示窗
 * @param id
 * @returns
 */
function openExportview() {
	parent.window.openTipsDialog("导出用户信息","确定导出用户信息？",function(){
		window.location.href="shareCarsController/exportCarsInfo.do" ;
	})
}


/*************************************************************************************************************/
/******************************             投放申请页-end            ***************************************/
/*************************************************************************************************************/

/*
//日期插件相关
$.datetimepicker.setLocale('zh');
$("#userFlagTime1,#userFlagTime2").datetimepicker({
  	inline:false,	//true-显示，false - 隐藏
      format: 'Y-m-d',
      timepicker: false, //true-显示时间，false - 不显示时间
      height : "50px"
});*/


/**
 * 表格搜索
 */
function search(obj){
	if(table){
		var value = $(obj).val();
		table.search(value).draw();
	}
}
