const $tools = mcfish.Tools
const $api = mcfish.API

/** ********************************************************************************************************** */
/** ****************************			 代理列表-start 						***************************** */
/** ********************************************************************************************************** */


$(function() {
	getAgentList();
})

/**
 * 获取代理商列表
 */
function getAgentList() {

	var province;
	var city;
	if($("#province option:selected").val()!="" && $("#province option:selected").val()!="" && $("#province option:selected").val()!="请选择"){
		province = $("#province option:selected").val();
	}
	if($("#city option:selected").val()!="" && $("#city option:selected").val()!="" && $("#city option:selected").val()!="请选择"){
		city = $("#city option:selected").val();
	}

	var ajaxParams = {
		api : 'shareAgentController/getAgentList.do',
		type : 'GET',
		searching : true,
		data : {
			city : city,
			province : province
		}
	}

	var colData = [
			{
				"data" : "name",
				'sClass' : "text-center col-width-120"
			},
			{
				"data" : "prov",
				'sClass' : "text-center col-width-120"
			},
			{
				"data" : "city",
				'sClass' : "text-center col-width-120"
			},
			{
				"data" : "phone",
				'sClass' : "text-center col-width-180"
			},
			{
				"data" : "proportion",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "level",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "shop_total",
				'sClass' : "text-center col-width-80"
			},
			{
				"data" : "status",
				'sClass' : "text-center col-width-80",
				"render" : function(data, type, full, meta) {
					switch (data){
						case 0:
							return '<span class="label label-primary">正常</span>'
						case 1:
							return '<span class="label label-warning">冻结</span>'
					}
					return "未识别状态";
				}
			},
			{
				"data" : "id",
				'sClass' : "text-center col-width-180",
				"render" : function(data, type, full, meta) {
					var str = "";
					str += "<span class='tab_text_blue pointer'>编辑</span>&nbsp;&nbsp;";
					str += "<span class='tab_text_blue pointer'>冻结</span>&nbsp;&nbsp;";
					str += "<span class='tab_text_blue pointer'>删除</span>&nbsp;&nbsp;";
					str += "<span class='tab_text_blue pointer' onclick=showDevDetail("
							+ full.dev_id + ");>详情</span>&nbsp;&nbsp;";
					return str;
				}
			}]
	agentList = $api.getDataTable('#agentList', ajaxParams, colData);
}


/**
 * 打开代理模态框
 * type = 1新增 type = 2编辑
 */
function openAgentTxt(type){
	if(type == 1){
		$("#submitTxt").attr("onclick","addAgent(1)");
		$("#lineShowBoxTitle").html("新增代理");
		//清空表单信息
		$(".agentTxtInput").val("");
	}else if(type == 2){
		$("#submitTxt").attr("onclick","addAgent(2)")
		$("#lineShowBoxTitle").html("编辑代理");
		//清空表单信息
		$(".agentTxtInput").val("");
		//填充表单信息
	}
	$("#insertAgentTxt").modal("show");
}


/**
 * 添加/编辑入库信息 commitType=1 添加 commitType=2 编辑 TODO 图片上传未处理
 */
function addAgent(commitType) {
	// 数据组装
	var data = {
		id : $("#submitTxt").attr("agentId"),
		name : $("#agent_name").val(),
		level : $("#agent_level").val(),
		phone : $("#agent_phone").val(),
		parent_id : $("#agent_header").val(),
		proportion : $("#agent_proportion").val(),
		prov : $("#province1").val(),
		city : $("#city1").val(),
		password : $("#agent_pwd").val()
	}
	var url = "";
	if (commitType == 1) {
		url = "shareAgentController/addAgent.do";
	} else if (commitType == 2) {
		url = "shareAgentController/editAgent.do"
	}
	$api.asyncRequest(url, "POST", data).then(function(res) {
		mizhu.toast(res.resmsg, 1000);
		repertoryTable.ajax.reload(null, false);
	});
	$("#insertAgentTxt").modal('hide');
}
/** ********************************************************************************************************** */
/** **************************** 			 代理列表-end	    					***************************** */
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
		if (agentList) {
			agentList.search(value).draw();
		}
		break;
	}
}