const $tools = mcfish.Tools;
const $api = mcfish.API;

$(function(){
	//获取套餐列表数据
	getpricepageList();
})


/**
 * 获取套餐列表数据
 */
function getpricepageList(){
	
	
	var ajaxParams = {
			api: 'sharePriceController/getAllPricepage.do',
			type: 'GET',
			searching:true,
			data: {
			
			}
	 }
	 var colData = [
	 			
					{"data" : "name",'sClass' : "text-center col-width-100",
						"render": function ( data, type, full, meta ) {
						    return data;
                  	     } 
					},
					{"data" : "price1",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							return $tools.toMoney(data);
						}
					},
					{"data" : "price2",'sClass' : "text-center col-width-oper1",
						"render": function ( data, type, full, meta ) {
							return $tools.toMoney(data);
		                } 
					},
					{"data" : "price3",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							return $tools.toMoney(data);
							}
					},
					{"data" : "price4",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							return $tools.toMoney(data);
							}
					},
					{"data" : "price5",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							return $tools.toMoney(data);
							}
					},
					{"data" : "price6",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							return $tools.toMoney(data);
							}
					},
					{"data" : "comment",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							return data;
							}
					},
					{"data" : "create_time",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							return mcfish.Tools.getMyDate(data,1);
							}
					},
					{"data" : "id",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							var str = "<span class='tab_text_blue pointer' onclick=openEditPricePage(" + data +");>编辑</span>&nbsp;&nbsp;"
							return str += "<span class='tab_text_blue pointer' onclick=deletePricePage(" + data +");>删除</span>";
							}
					},
				]
	table = $api.getDataTable('#pricepageList',ajaxParams, colData);
}
	

/**
 * 表格搜索
 */
function search(obj){
	if(table){
		var value = $(obj).val();
		table.search(value).draw();
	}
}


/**
 * 打开编辑弹窗
 * @param {Object} id
 */
function openEditPricePage(id){
	
	//清除原有数据
	clearActionPriceView();
	
	$api.asyncRequest("sharePriceController/getPricePage.do","POST",{id:id}).then(function(res){
		var data = res.data;
		
		var price1 = $tools.toMoney(data.price1).replace("￥","");
		var price2 = $tools.toMoney(data.price2).replace("￥","");
		var price3 = $tools.toMoney(data.price3).replace("￥","");
		var price4 = $tools.toMoney(data.price4).replace("￥","");
		var price5 = $tools.toMoney(data.price5).replace("￥","");
		var price6 = $tools.toMoney(data.price6).replace("￥","");
		
		$("#actionPriceName").val(data.name);
		$("#actionPrice1").val(price1==0?"":price1);
		$("#actionPrice2").val(price2==0?"":price2);
		$("#actionPrice3").val(price3==0?"":price3);
		$("#actionPrice4").val(price4==0?"":price4);
		$("#actionPrice5").val(price5==0?"":price5);
		$("#actionPrice6").val(price6==0?"":price6);
		$("#actioncomment").val(data.comment);
		
		$("#pricepageBoxTitle").html("编辑套餐");
		$("#actionPriceBtn").attr("onclick","editPricePage("+id+")");
		$("#actionPriceBtn").html("保存");
		$("#actionPriceView").modal("toggle");
	});
	
}
	

/**
 * 打开新增套餐弹窗
 */
function openAddPricePage(){
	
	//清除原有数据
	clearActionPriceView();
	
	$("#pricepageBoxTitle").html("新建套餐");
	$("#actionPriceBtn").attr("onclick","addPricePage()");
	$("#actionPriceBtn").html("保存");
	$("#actionPriceView").modal("toggle");
}

	
/**
 * 新增套餐
 * @param {Object} 
 */
function addPricePage(){

	var name   = $("#actionPriceName").val();
	
	var comment= $("#actioncomment").val();

	var price1 = $("#actionPrice1").val();
	var price2 = $("#actionPrice2").val();
	var price3 = $("#actionPrice3").val();
	var price4 = $("#actionPrice4").val();
	var price5 = $("#actionPrice5").val();
	var price6 = $("#actionPrice6").val();
	
	var num=0;
	
	var prices =[price1*100,price2*100,price3*100,
	             price4*100,price5*100,price6*100];
	
	for(var i=0;i<6;i++){
		if(prices[i]==""||prices[i]==null){
			num++;
			prices[i]=0;
		}else{
		}
	}
	if(num!=3){
		    mizhu.toast("请任选三项填写", 1000);
		    return false;
	}
	
	if(name == ""||name == null){
		   mizhu.toast("请填写套餐名称", 1000);
		   return false;
	}    
	
	var data = {
		name	: name,
		price1	: prices[0],
		price2	: prices[1],
		price3  : prices[2],
		price4  : prices[3],
		price5  : prices[4],
		price6  : prices[5],
		comment : comment
	}
	
		url = "sharePriceController/addPricePage.do";
	
	$api.asyncRequest(url,"POST",data).then(function(res){
		$("#actionPriceView").modal("toggle");
		mizhu.toast(res.resmsg,1000);
		table.ajax.reload(null,false);
	});
	
}
	
/**
 * 编辑套餐
 * @param {Object} id
 */
function editPricePage(id){
	var num=0;
	
	var name = $("#actionPriceName").val();
	var price1 = $("#actionPrice1").val();
	var price2 = $("#actionPrice2").val();
	var price3 = $("#actionPrice3").val();
	var price4 = $("#actionPrice4").val();
	var price5 = $("#actionPrice5").val();
	var price6 = $("#actionPrice6").val();
	var comment = $("#actioncomment").val();
	
	var prices =[price1,price2,price3,
	             price4,price5,price6];
	
	for(var i=0;i<6;i++){

		if(prices[i]==""||prices[i]==null){
			num++;
			prices[i]=0;
		}else{
			prices[i] = prices[i]*100;
		}
		
		}

	if(num!=3){
		    mizhu.toast("请任选三项填写", 1000);
		    return false;
	}
	
    if(name == ""||name == null){
		   mizhu.toast("请填写套餐名称", 1000);
		   return false;
	}    
	    
    
	var data = {
		name	: name,
		price1	: prices[0],
		price2	: prices[1],
		price3  : prices[2],
		price4  : prices[3],
		price5  : prices[4],
		price6  : prices[5],
		comment : comment
	}
	
		data.id = id;
		url = "sharePriceController/updatePricePage.do";
	
	$api.asyncRequest(url,"POST",data).then(function(res){
		$("#actionPriceView").modal("toggle");
		mizhu.toast(res.resmsg,1000);
		table.ajax.reload(null,false);
	});
	
}

/**
 * 删除套餐
 * @param id
 * @returns
 */
function deletePricePage(id){
	parent.window.openTipsDialog("提示","确定要删除吗？",function(){
		$api.asyncRequest("sharePriceController/deletePricePage.do","POST",{id:id}).then(function(res){
			mizhu.toast(res.resmsg,1000);
			table.ajax.reload(null,false);
		});
	})
}


/**
 * 判断是否为正数
 * @param id
 * @returns
 *//*
function isIntNum(val){
    var regPos = / ^\d+$/; // 非负整数
    var regNeg = /^\-[1-9][0-9]*$/; // 负整数
    var a=/^[\d\s]+$/;
    if(regPos.test(val) || regNeg.test(val)|| a.test(val)){
        return true;
    }else{
        return false;
    }
}*/

	
/**
 * 清除数据
 */
function clearActionPriceView(){
	$("#actionPriceName").val("");
	$("#actionPrice1").val("");
	$("#actionPrice2").val("");
	$("#actionPrice3").val("");
	$("#actionPrice4").val("");
	$("#actionPrice5").val("");
	$("#actionPrice6").val("");
	$("#actioncomment").val("");
}
