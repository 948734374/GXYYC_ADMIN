const $tools = mcfish.Tools
const $api = mcfish.API

/** ********************************************************************************************************** */
/** ****************************			 报修申请-start 						***************************** */
/** ********************************************************************************************************** */

$(function() {
	getRepairsList();
})

/**
 * 获取报修申请列表
 */
function getRepairsList() {

	var startTime = $("#startFlagTime1").val() == "" ? null : $tools
			.calculateDate($("#startFlagTime1").val(), -1);
	var endTime = $("#endFlagTime1").val() == "" ? null : $tools.calculateDate(
			$("#endFlagTime1").val(), 1);
	var status = $("#repairsStatus option:selected").attr("value");

	var ajaxParams = {
		api : 'shareRepairsController/getRepairsList.do',
		type : 'GET',
		searching : true,
		data : {
			startTime : startTime,
			endTime : endTime,
			status : status
		}
	}

	var colData = [
			{
				"data" : "dno",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "dev_name",
				'sClass' : "text-left col-width-120"
			},
			{
				"data" : "shop_name",
				'sClass' : "text-left col-width-120"
			},
			{
				"data" : "content",
				'sClass' : "text-left col-width-120"
			},
			{
				"data" : "image",
				'sClass' : "text-center col-width-80",
				"render" : function(data, type, full, meta) {
					return "<img src='" + $tools.toHeadImage(data)
							+ "' class='userImg' />";
				}
			},
			{
				"data" : "creator",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "status",
				'sClass' : "text-center col-width-80",
				"render" : function(data, type, full, meta) {
					switch (data) {
					case 0:
						return '<span class="label label-primary">待审核</span>'
						break;
					case 1:
						return '<span class="label label-info">已挂起</span>'
						break;
					case 2:
						return '<span class="label label-warning">待处理</span>'
						break;
					case 3:
						return '<span class="label label-success">已修复</span>'
						break;
					case 4:
						return '<span class="label label-danger">已报废</span>'
						break;
					case 5:
						return '<span class="label label-default">审核未通过</span>'
						break;
					}
					return "无";
				}
			},
			{
				"data" : "admin_name_repair",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "admin_name_leader",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "id",
				'sClass' : "text-center col-width-200",
				"render" : function(data, type, full, meta) {
					var str = "";
					if (full.status == 0) {
						str += "<span class='tab_text_blue pointer' onclick=openCheckRepairsModal("
								+ data + ",2);>审核</span>&nbsp;&nbsp;";
						str += "<span class='tab_text_blue pointer' onclick=editRepairStatus("
								+ data + ",1);>挂起</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>已修复</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>已报废</span>&nbsp;&nbsp;";
						str += "<span class='tab_text_blue pointer' onclick=showDevDetail("
								+ full.dev_id + ");>详情</span>&nbsp;&nbsp;";
					}
					if (full.status == 1) {
						str += "<span class='tab_text_blue pointer' onclick=openCheckRepairsModal("
								+ data + ",2);>审核</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>挂起</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>已修复</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>已报废</span>&nbsp;&nbsp;";
						str += "<span class='tab_text_blue pointer' onclick=showDevDetail("
								+ full.dev_id + ");>详情</span>&nbsp;&nbsp;";
					} else if (full.status == 2) {
						str += "<span class='pointer'>审核</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>挂起</span>&nbsp;&nbsp;";
						str += "<span class='tab_text_blue pointer' onclick=editRepairStatus("
								+ data + ",3);>已修复</span>&nbsp;&nbsp;";
						str += "<span class='tab_text_blue pointer' onclick=editRepairStatus("
								+ data + ",4);>已报废</span>&nbsp;&nbsp;";
						str += "<span class='tab_text_blue pointer' onclick=showDevDetail("
								+ full.dev_id + ");>详情</span>&nbsp;&nbsp;";
					} else if (full.status == 4 || full.status == 5
							|| full.status == 3) {
						str += "<span class='pointer'>审核</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>挂起</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>已修复</span>&nbsp;&nbsp;";
						str += "<span class='pointer'>已报废</span>&nbsp;&nbsp;";
						str += "<span class='tab_text_blue pointer' onclick=showDevDetail("
								+ full.dev_id + ");>详情</span>&nbsp;&nbsp;";
					}
					return str;
				}
			}, ]
	repairsList = $api.getDataTable('#repairsList', ajaxParams, colData);
}

/**
 * 打开审核模态框
 */
function openCheckRepairsModal(id){
	$("#checkRepairsIdInput").attr("value",id);
	$("#checkRepairs").modal("show");
}
/**
 * 审核
 */
function checkRepairs(type){
	var id = $("#checkRepairsIdInput").attr("value");
	var status = type;
	$api.asyncRequest("shareRepairsController/updateRepairStatus.do",
			"POST", {
				id : id,
				status : status
			}).then(function(res) {
		mizhu.toast(res.resmsg, 1000);
		$("#checkRepairs").modal("hide");
		repairsList.ajax.reload(null, false);
	});
}

/**
 * 挂起/已修复/已报废
 */
function editRepairStatus(id, status) {
	var titleInfo = "";
	var contentInfo = "";
	switch (status) {
	case 1:
		titleInfo = "挂起";
		contentInfo = "是否将该条信息挂起？";
		break;
	case 3:
		titleInfo = "已修复";
		contentInfo = "确定该设备已修复？";
		break;
	case 4:
		titleInfo = "已报废";
		contentInfo = "确定该设备已报废？";
		break;
	}
	parent.window.openTipsDialog(titleInfo, contentInfo, function() {
		$api.asyncRequest("shareRepairsController/updateRepairStatus.do",
				"POST", {
					id : id,
					status : status
				}).then(function(res) {
			mizhu.toast(res.resmsg, 1000);
			repairsList.ajax.reload(null, false);
		});
	})
}

/**
 * 报修信息导出提示窗
 * 
 * @param id
 * @returns
 */
function openExportRepairs() {
	parent.window.openTipsDialog("报废库存信息", "确定导出报废库存信息？", function() {
		window.location.href = "shareRepairsController/exportRepairsInfo.do";
	})
}

/**
 * 打开详情
 */
function showDevDetail(id) {
	// 获取该车辆的数据
	$api.asyncRequest("shareRepairsController/getDevById.do", "POST", {
		id : id
	}).then(function(res) {
		if(res.data.id != 0){
			$("#detail_id").html(res.data.id);
			$("#detail_dno").html(res.data.dno);
			$("#detail_name").html(res.data.name);
			$("#detail_color").html(res.data.color);
			$("#detail_version").html(res.data.version);
			$("#detail_funcs").html(res.data.funcs);
			$("#detail_priceName").html(res.data.price_name);
			// 显示模态框
			$("#DevDetail").modal("show");
		}
		else{
			mizhu.toast("未找到该车辆信息", 2000);
		}
	});
}

/** ********************************************************************************************************** */
/** **************************** 				报修申请-end 						***************************** */
/** ********************************************************************************************************** */


/** ********************************************************************************************************** */
/** **************************** 				故障统计-start 						************************** */
/** ********************************************************************************************************** */

/**
 * 获取报修申请列表
 */
function getFaultStatistics() {

	var startTime = $("#startFlagTime2").val() == "" ? null : $tools
			.calculateDate($("#startFlagTime2").val(), -1);
	var endTime = $("#endFlagTime2").val() == "" ? null : $tools.calculateDate(
			$("#endFlagTime2").val(), 1);
	var province;
	var city;
	var zone;
	if($("#province option:selected").val()!="" && $("#province option:selected").val()!="" && $("#province option:selected").val()!="请选择"){
		province = $("#province option:selected").val();
	}
	if($("#city option:selected").val()!="" && $("#city option:selected").val()!="" && $("#city option:selected").val()!="请选择"){
		city = $("#city option:selected").val();
	}
	if($("#town option:selected").val()!="" && $("#town option:selected").val()!="" && $("#town option:selected").val()!="请选择"){
		zone = $("#town option:selected").val();
	}

	var ajaxParams = {
		api : 'shareRepairsController/getFaultStatistics.do',
		type : 'GET',
		searching : true,
		data : {
			startTime : startTime,
			endTime : endTime,
			province : province,
			city : city,
			zone : zone
		}
	}

	var colData = [
			{
				"data" : "shop_prov",
				'sClass' : "text-center col-width-120"
			},
			{
				"data" : "shop_city",
				'sClass' : "text-center col-width-120"
			},
			{
				"data" : "shop_zone",
				'sClass' : "text-center col-width-120"
			},
			{
				"data" : "min_time",
				'sClass' : "text-center col-width-180",
				"render" : function(data, type, full, meta) {
					var str = "";
					str = mcfish.Tools.getMyDate(data, 1);
					return str;
				}
			},
			{
				"data" : "max_time",
				'sClass' : "text-center col-width-180",
				"render" : function(data, type, full, meta) {
					var str = "";
					str = mcfish.Tools.getMyDate(data, 1);
					return str;
				}
			},
			{
				"data" : "repairs_total",
				'sClass' : "text-center col-width-80"
			}]
	faultStatisticsList = $api.getDataTable('#faultStatisticsList', ajaxParams, colData);
}

/**
 * 报修信息导出提示窗
 * 
 * @param id
 * @returns
 */
function openExportStatistics() {
	parent.window.openTipsDialog("故障统计信息列表", "确定导出故障统计信息列表信息？", function() {
		window.location.href = "shareRepairsController/exportRepairsStatistics.do";
	})
}
/** ********************************************************************************************************** */
/** **************************** 				故障统计-end 						***************************** */
/** ********************************************************************************************************** */


// 日期插件相关
$.datetimepicker.setLocale('zh');
$("input[id^=startFlag],input[id^=endFlag]").datetimepicker({
	inline : false, // true-显示，false - 隐藏
	format : 'Y-m-d',
	timepicker : false, // true-显示时间，false - 不显示时间
	height : "50px"
});

/**
 * 表格搜索
 */
function search(flag, obj) {
	var value = $(obj).val();
	switch (flag) {
	case 1:
		if (repairsList) {
			repairsList.search(value).draw();
		}
		break;
	}
}