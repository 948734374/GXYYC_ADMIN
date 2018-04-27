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
		
		var price1 = $tools.toMoney(data.price1);
		var price2 = $tools.toMoney(data.price2);
		var price3 = $tools.toMoney(data.price3);
		var price4 = $tools.toMoney(data.price4);
		var price5 = $tools.toMoney(data.price5);
		var price6 = $tools.toMoney(data.price6);
		
		$("#actionPriceName").val(data.name);
		$("#actionPrice1").val(price1);
		$("#actionPrice2").val(price2);
		$("#actionPrice3").val(price3);
		$("#actionPrice4").val(price4);
		$("#actionPrice5").val(price5);
		$("#actionPrice6").val(price6);
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
 * @param {Object} id
 */
function addPricePage(id){

	var name   = $("#actionPriceName").val();
	var price1 = $("#actionPrice1").val()*100;
	var price2 = $("#actionPrice2").val()*100;
	var price3 = $("#actionPrice3").val()*100;
	var price4 = $("#actionPrice4").val()*100;
	var price5 = $("#actionPrice5").val()*100;
	var price6 = $("#actionPrice6").val()*100;
	var comment= $("#actioncomment").val();

	var prices =[$("#actionPrice1").val(),
	             $("#actionPrice2").val(),
	             $("#actionPrice3").val(),
	             $("#actionPrice4").val(),
	             $("#actionPrice5").val(),
	             $("#actionPrice6").val()];
	
	var num=0;
	
	for(var i=0;i<6;i++){
		if(prices[i]==""||prices[i]==null){
			num++;
			prices[i]=0;
		}else{
		}
	}
	    if(num>3){
		    mizhu.toast("请至少填写三项", 1000);
		    return false;
	}
	
	
	var data = {
		name	: name,
		price1	: price1,
		price2	: price2,
		price3  : price3,
		price4  : price4,
		price5  : price5,
		price6  : price6,
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

	var name   = $("#actionPriceName").val();
	var price1 = $("#actionPrice1").val();
	var price2 = $("#actionPrice2").val();
	var price3 = $("#actionPrice3").val();
	var price4 = $("#actionPrice4").val();
	var price5 = $("#actionPrice5").val();
	var price6 = $("#actionPrice6").val();
	var comment= $("#actioncomment").val();

	price1=price1.slice(1,price1.length)*100;
	price2=price2.slice(1,price1.length)*100;
	price3=price3.slice(1,price1.length)*100;
	price4=price4.slice(1,price1.length)*100;
	price5=price5.slice(1,price1.length)*100;
	price6=price6.slice(1,price1.length)*100;
	
	var prices =[$("#actionPrice1").val(),
	             $("#actionPrice2").val(),
	             $("#actionPrice3").val(),
	             $("#actionPrice4").val(),
	             $("#actionPrice5").val(),
	             $("#actionPrice6").val()];
	
	var num=0;
	
	for(var i=0;i<6;i++){
		if(prices[i]==""||prices[i]==null){
			num++;
			prices[i]=0;
		}else{
		}	
	}
	    if(num>3){
		    mizhu.toast("请至少填写三项", 1000);
		    return false;
	}
	
	
	var data = {
		name	: name,
		price1	: price1,
		price2	: price2,
		price3  : price3,
		price4  : price4,
		price5  : price5,
		price6  : price6,
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
