const $tools = mcfish.Tools;
const $api = mcfish.API;

$(function(){
	//获取消息列表数据
	getDocumentList();
})

/**
 * 获取消息列表数据
 */
function getDocumentList(){
	
	var type = $("#documentStatus").val();
	
	var ajaxParams = {
			api: 'shareDocumentController/getAllDocument.do',
			type: 'GET',
			searching:true,
			data: {
				type:type
			}
	 }
	 var colData = [
	 			
					{"data" : "type",'sClass' : "text-center col-width-238",
						"render": function ( data, type, full, meta ) {
                        	return data == 0 ? "制度":"通知";
                  	     } 
					},
					{"data" : "title",'sClass' : "text-center col-width-217",
						"render" : function(data, type, full, meta) {
							
   		    			    data = data.replace(/\s/g,""); //去掉所有空格
							return data;
						}
					},
					{"data" : "create_time",'sClass' : "text-center col-width-201",
						"render": function ( data, type, full, meta ) {
		                    return mcfish.Tools.getMyDate(data,1);
		                } 
					},
					{"data" : "id",'sClass' : "text-center col-width-oper1",
						"render" : function(data, type, full, meta) {
							var str="";
							//type为0时代表详情
							str += "<a href='"+ $tools.getBasicUrl() + "shareDocumentController/toDocDetail.do?id=" + full.id +"&type=0" +  "' target='menuFrame' class='tab_text_blue pointer'>详情</a>&nbsp;&nbsp;";
							str += "<a href='"+ $tools.getBasicUrl() + "shareDocumentController/toDocDetail.do?id=" + full.id +"' target='menuFrame' class='tab_text_blue pointer'>编辑</a>&nbsp;&nbsp;";
							return str;
							
							}
					},
				]
	table = $api.getDataTable('#documentList',ajaxParams, colData);
}
	

	//编辑文件
    function toUpdatedoc(id){
    	var href = $tools.getBasicUrl() + "shareDocumentController/toDocDetail.do?id=" + full.id+"&type=0";
    }

	//打开新增页面
	function openAddDocument(){
		window.location.href = $tools.getBasicUrl() + "shareDocumentController/toDocbuild.do";
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

