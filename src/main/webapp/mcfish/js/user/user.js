const $tools = mcfish.Tools
const $api = mcfish.API


$(function(){
	//获取用户列表
	getUserList();
})

/**
 * 获取用户列表
 */
function getUserList(){
	
	var status = $("#userStatus").val();
	var begin = $("#userFlagTime1").val() == "" ? null : $tools.calculateDate($("#userFlagTime1").val(),-1);
	var end = $("#userFlagTime2").val() == "" ? null : $tools.calculateDate($("#userFlagTime2").val(),1);
	
	var ajaxParams = {
			api: 'shareUserController/getAllUserList.do',
			type: 'GET',
			searching:true,
			data: {
				status	:status,
				begin	:begin,
				end		:end
			}
	 }
	 var colData = [
					{"data" : "id",'sClass' : "text-center col-width-120"},
					{"data" : "head",'sClass' : "text-center col-width-120",
						"render": function ( data, type, full, meta ) {
                        	return "<img src='" + $tools.toHeadImage(data)+ "' class='userImg' />";
                  	     } 
					},
					{"data" : "name",'sClass' : "text-left col-width-120"},
					{"data" : "sex",'sClass' : "text-center col-width-80",
						"render": function ( data, type, full, meta ) {
                        	return data == 1?"男":"女";
                  	     } 
					},
					{"data" : "phone",'sClass' : "text-center col-min-phone"},
					{"data" : "money",'sClass' : "text-center col-width-100",
						"render": function ( data, type, full, meta ) {
							return $tools.toMoney(data);
                  	     } 
					},
					{"data" : "user_coupon",'sClass' : "text-center col-width-100"},
					{"data" : "order_number",'sClass' : "text-center col-width-80"},
					{"data" : "status",'sClass' : "text-center col-width-80",
						"render": function ( data, type, full, meta ) {
							var str = "";
							if(data== 0){
								 str="<span class='label label-success'>正常</span> ";
							} 
							if(data == 1) {
								str="<span class='label label-danger'>冻结</span>";
							}
                        	return str;
                  	     } 
					},
					{"data" : "id",'sClass' : "text-center col-width-oper3",
						"render" : function(data, type, full, meta) {
								var str = "";
								if(full.status == 0){
									str += "<span class='tab_text_blue pointer' onclick=changeUserStatus(" + data +",1);>冻结</span>&nbsp;&nbsp;";
								}
								if(full.status == 1){
									str += "<span class='tab_text_blue pointer' onclick=changeUserStatus(" + data +",0);>启用</span>&nbsp;&nbsp;";
								}
								var href = $tools.getBasicUrl() + "shareUserController/toUserDetail.do?id=" + full.id;
								str += "<a href='"+ href +"' target='menuFrame' class='tab_text_blue pointer'>详情</a>&nbsp;&nbsp;";
								str += "<span class='tab_text_blue pointer' onclick=deleteUserId(" + data +");>删除</span>&nbsp;&nbsp;";
	                        	return str;
							}
					},
				]
	table = $api.getDataTable('#userList',ajaxParams, colData);
}


/**
 * 删除用户
 * @param id 用户id
 * @returns
 */
function deleteUserId(id){
	parent.window.openTipsDialog("确定删除","删除后数据将不存在",function(){
		$api.asyncRequest("shareUserController/deleteUser.do","POST",{userId:id}).then(function(res){
			mizhu.toast(res.resmsg,1000);
			table.ajax.reload(null,false);
		});
	})
}


/**
 * 修改用户状态
 * @param id 用户id
 * @param status 目标状态
 * @returns
 */
function changeUserStatus(id,status){
	parent.window.openTipsDialog("提示","确定更改用户状态吗？",function(){
		$api.asyncRequest("shareUserController/updateUserStatus.do","POST",{id:id,status:status}).then(function(res){
			mizhu.toast(res.resmsg,1000);
			table.ajax.reload(null,false);
		});
	})
}


//日期插件相关
$.datetimepicker.setLocale('zh');
$("#userFlagTime1,#userFlagTime2").datetimepicker({
  	inline:false,	//true-显示，false - 隐藏
      format: 'Y-m-d',
      timepicker: false, //true-显示时间，false - 不显示时间
      height : "50px"
});


/**
 * 表格搜索
 */
function search(obj){
	if(table){
		var value = $(obj).val();
		table.search(value).draw();
	}
}
