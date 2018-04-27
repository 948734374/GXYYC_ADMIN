const $tools = mcfish.Tools
const $api = mcfish.API

/** ********************************************************************************************************** */
/** **************************** 车辆库存信息列表页-start ***************************** */
/** ********************************************************************************************************** */
var commitRepertoryType;// 车辆库存信息模态框提交判定

$(function() {
	// 获取车辆库存列表
	getRepertoryList();
})

/**
 * 获取车辆库存信息
 */
function getRepertoryList() {

	var ajaxParams = {
		api : 'shareRepertoryController/getRepertoryList.do',
		type : 'GET',
		searching : true,
		data : {
			status : 0
		}
	}

	var colData = [
			{
				"data" : "id",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "dno",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "image",
				'sClass' : "text-center col-width-120",
				"render" : function(data, type, full, meta) {
					return "<img src='" + $tools.toHeadImage(data)
							+ "' class='userImg' />";
				}
			},
			{
				"data" : "name",
				'sClass' : "text-left col-width-120"
			},
			{
				"data" : "factory",
				'sClass' : "text-left col-width-120"
			},
			{
				"data" : "color",
				'sClass' : "text-center col-width-120"
			},
			{
				"data" : "funcs",
				'sClass' : "text-left col-width-120"
			},
			{
				"data" : "pwd",
				'sClass' : "text-left col-width-120"
			},
			{
				"data" : "secure",
				'sClass' : "text-center col-width-120"
			},
			{
				"data" : "version",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "id",
				'sClass' : "text-center col-width-120",
				"render" : function(data, type, full, meta) {
					var str = "";
					str += "<span class='tab_text_blue pointer' onclick=implementDev("
							+ data + ");>投放</span>&nbsp;&nbsp;";
					str += "<span class='tab_text_blue pointer' onclick=openEditReperstory("
							+ data + ");>编辑</span>&nbsp;&nbsp;";
					str += "<span class='tab_text_blue pointer' onclick=deleteRepertory("
							+ data + ");>删除</span>&nbsp;&nbsp;";
					return str;
				}
			}, ]

	repertoryTable = $api.getDataTable('#repertoryList', ajaxParams, colData);
}

/**
 * 添加/编辑入库信息 commitType=1 添加 commitType=2 编辑 TODO 图片上传未处理
 */
function addReperstory(id) {
	// 数据组装
	var data = {
		id : $("#formCarId").attr("carId"),
		dno : $("#dno").val(),
		name : $("#name").val(),
		color : $("#color").val(),
		image : $("#image").val(),
		factory : $("#factory").val(),
		pwd : $("#pwd").val(),
		secure : $("#secure").val(),
		version : $("#version").val(),
		funcs : $("#funcs").val()
	}
	var url = "";
	if (commitRepertoryType == 1) {
		url = "shareRepertoryController/addRepertory.do";
	} else if (commitRepertoryType == 2) {
		url = "shareRepertoryController/editRepertory.do"
	}
	$api.asyncRequest(url, "POST", data).then(function(res) {
		mizhu.toast(res.resmsg, 1000);
		repertoryTable.ajax.reload(null, false);
		$("#insertCarTxt").modal('hide');
	});
}

/**
 * open添加车辆信息弹窗 TODO 图片上传未处理
 */
function openAddReperstory() {
	commitRepertoryType = 1;
	// 清空表单信息
	$("#formCarId").attr("carId", "-1");
	$("#dno").val("");
	$("#name").val("");
	$("#color").val("");
	$("#image").val("");
	$("#factory").val("");
	$("#pwd").val("");
	$("#secure").val("");
	$("#version").val("");
	$("#funcs").val("");
	$("#insertCarTxt").modal('show');
}

/**
 * open编辑车辆信息弹窗 TODO 图片上传未处理
 */
function openEditReperstory(id) {
	commitRepertoryType = 2;
	// 拼装数据到表单
	$api.asyncRequest("shareRepertoryController/getRepertoryById.do", "POST", {
		devId : id
	}).then(function(res) {
		var data = res.data;
		$("#formCarId").attr("carId", data.id);
		$("#dno").val(data.dno);
		$("#name").val(data.name);
		$("#color").val(data.color);
		$("#image").val(data.image);
		$("#factory").val(data.factory);
		$("#pwd").val(data.pwd);
		$("#secure").val(data.secure);
		$("#version").val(data.version);
		$("#funcs").val(data.funcs);
	});
	$("#insertCarTxt").modal('show');
}

/**
 * 打开“导入”功能模态窗
 */
function openInsertConfig(type) {
	$("#insertConfig").modal('show');
}

/**
 * 选择导入的配置项 TODO
 */
function selectConfig() {

}

/**
 * 删除车辆库存信息
 */

function deleteRepertory(id) {
	parent.window.openTipsDialog("确定删除", "删除后数据将不存在", function() {
		$api.asyncRequest("shareRepertoryController/deleteRepertory.do",
				"POST", {
					carId : id
				}).then(function(res) {
			mizhu.toast(res.resmsg, 1000);
			repertoryTable.ajax.reload(null, false);
		});
	})
}

/**
 * open投放model
 */
function implementDev(id) {
	$("#implementDev").modal("show");
	$("#implementDevCommit").attr("devId", id);
	$("#devPriceSelect").html("");
	// 获取套餐信息
	$api.asyncRequest("shareRepertoryController/getAllDevPrice.do", "POST")
			.then(
					function(res) {
						var data = res.data;
						// 填充信息
						for (var i = 0; i < data.length; i++) {
							$("#devPriceSelect").append(
									"<option priceId='" + data[i].id + "'>"
											+ data[i].name + "</option>");
						}
					});
}
/**
 * 投放-选择商家
 */
function selectRelationShopper() {
	$("#shopView").modal("show");

	var ajaxParams = {
		api : 'shareRepertoryController/getAllShops.do',
		type : 'GET',
		searching : true
	}
	var colData = [
			{
				"data" : "id",
				'sClass' : "text-center col-width-oper1",
				"render" : function(data, type, full, meta) {
					var str = "";
					str += "<input type='radio' name='radio' shopName='"
							+ full.name + "' value='" + data + "'/>";
					return str;
				}
			}, {
				"data" : "name",
				'sClass' : "text-center col-width-160"
			}, {
				"data" : "phone",
				'sClass' : "text-center col-width-160"
			}, {
				"data" : "adds",
				'sClass' : "text-center col-width-220"
			}

	]
	shopList = $api.getDataTable('#shopList', ajaxParams, colData);
}

/**
 * 获取商家ID以及显示名称
 */
function getShopSelected() {
	$("#shopView").modal("hide");

	// 获取选中的值
	var shop_id = $("input[name='radio']:checked").val();
	// 记录所选商铺ID
	$("#implementDevCommit").attr("shopId", shop_id);
	// 更改显示
	$("#selectedShopName").val(
			$("input[name='radio']:checked").attr("shopName"));

}

/**
 * 确定投放
 */

function implementDevCommit() {
	if(typeof($("#implementDevCommit").attr("shopId"))=="undefined"|| $("#implementDevCommit").attr("shopId") == '') {
		parent.window.openTipsDialog("", "请选择商家", null)
        return;
	}
	var data = {
		devId : $("#implementDevCommit").attr("devId"),
		shopId : $("#implementDevCommit").attr("shopId"),
		priceId : $("#devPriceSelect option:selected").attr("priceId")
	}
	parent.window.openTipsDialog("确定投放", "是否确认投放该车辆？", function() {
		$api.asyncRequest("shareRepertoryController/updateImplementDev.do",
				"POST", data).then(function(res) {
			parent.window.openTipsDialog("", "投放成功", null)
			$("#implementDev").modal("hide");
			repertoryTable.ajax.reload(null, false);
		});
	})
}

/** ********************************************************************************************************** */
/** **************************** 车辆库存信息列表页-end ***************************** */
/** ********************************************************************************************************** */

/** ********************************************************************************************************** */
/** **************************** 报废车辆信息列表页-start ***************************** */
/** ********************************************************************************************************** */

/**
 * 获取报废车辆信息
 */
function getScrapRepertoryList() {
	var startTime = $("#startFlagTime3").val() == "" ? null : $tools
			.calculateDate($("#startFlagTime3").val(), -1);
	var endTime = $("#endFlagTime3").val() == "" ? null : $tools.calculateDate(
			$("#endFlagTime3").val(), 1);

	var ajaxParams = {
		api : 'shareRepertoryController/getScrapRepertoryList.do',
		type : 'GET',
		searching : true,
		data : {
			startTime : startTime,
			endTime : endTime,
			status : 4
		}
	}

	var colData = [ {
		"data" : "id",
		'sClass' : "text-left col-width-120"
	}, {
		"data" : "dno",
		'sClass' : "text-left col-width-120"
	}, {
		"data" : "name",
		'sClass' : "text-left col-width-120"
	}, {
		"data" : "color",
		'sClass' : "text-center col-width-120"
	}, {
		"data" : "factory",
		'sClass' : "text-center col-width-120"
	}, {
		"data" : "pwd",
		'sClass' : "text-center col-width-120"
	}, {
		"data" : "secure",
		'sClass' : "text-center col-width-120"
	}, {
		"data" : "version",
		'sClass' : "text-center col-width-120"
	}, {
		"data" : "create_time",
		'sClass' : "text-center col-width-120",
		"render" : function(data, type, full, meta) {
			var str = "";
			str = mcfish.Tools.getMyDate(data, 1);
			return str;
		}
	}, ]

	scrapRepertoryTable = $api.getDataTable('#scrapRepertoryTable', ajaxParams,
			colData);
}

/**
 * 报废库存信息导出提示窗
 * 
 * @param id
 * @returns
 */
function openExportScrapview() {
	parent.window
			.openTipsDialog(
					"报废库存信息",
					"确定导出报废库存信息？",
					function() {
						window.location.href = "shareRepertoryController/exportScrapRepertoryInfo.do";
					})
}

/** ********************************************************************************************************** */
/** **************************** 报废车辆信息列表页-end ****************************** */
/** ********************************************************************************************************** */

/** ********************************************************************************************************** */
/** **************************** 投放历史列表页-start ****************************** */
/** ********************************************************************************************************** */

// TODO
/** ********************************************************************************************************** */
/** **************************** 投放历史列表页-end ***************************** */
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
		if (repertoryTable) {
			repertoryTable.search(value).draw();
		}
		break;
	case 3:
		if (scrapRepertoryTable) {
			scrapRepertoryTable.search(value).draw();
		}
		break;
	case 4:
		if (shopList) {
			shopList.search(value).draw();
		}
		break;
	default:
		break;
	}
}