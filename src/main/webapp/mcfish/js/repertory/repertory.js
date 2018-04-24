const $tools = mcfish.Tools
const $api = mcfish.API


/*************************************************************************************************************/
/******************************             车辆库存列表页-start            **********************************/
/*************************************************************************************************************/


$(function(){
    //获取车辆库存列表
    getRepertoryList(1);
})

/**
 * 获取车辆
 * 参数说明 type = 1 库存列表 type = 2 投放历史  type = 3 已报废列表
 */
function getRepertoryList(type) {
    //获取搜索开始时间
    var startTime = $("#startFlagTime" + type + "").val();
    //获取搜索结束时间
    var endTime = $("#endFlagTime" + type + "").val();
    //获取搜索字符串
    var selectStr = $("#selectStr" + type + "").val()
    //type对应的数据库标志status
    var status;
    //数据填充
    var colData;
    switch (type) {
        case 1:
            status = 0;
            colData = [
                {"data" : "id",'sClass' : "text-left col-width-120"},
                {"data" : "dno",'sClass' : "text-left col-width-120"},
                {"data" : "image",'sClass' : "text-left col-width-120"},
                {"data" : "name",'sClass' : "text-center col-width-120"},
                {"data" : "factory",'sClass' : "text-center col-width-120"},
                {"data" : "color",'sClass' : "text-center col-width-120"},
                {"data" : "funcs",'sClass' : "text-center col-width-120"},
                {"data" : "pwd",'sClass' : "text-center col-width-120"},
                {"data" : "secure",'sClass' : "text-center col-width-120"},
                {"data" : "version",'sClass' : "text-center col-width-120"},
                {"data" : "id",'sClass' : "text-center col-width-oper3",
                    "render" : function(data, type, full, meta) {
                        var str = "";
                        str += "<span class='tab_text_blue pointer' onclick=changeCarStatus(" + data +",1);>投放</span>&nbsp;&nbsp;";
                        str += "<span class='tab_text_blue pointer' onclick=changeCarStatus(" + data +",0);>编辑</span>&nbsp;&nbsp;";
                        str += "<span class='tab_text_blue pointer' onclick=deleteCarId(" + data +");>删除</span>&nbsp;&nbsp;";
                        return str;
                    }
                }
            ]
            break;
        case 2:
            status = 101;//此处为标志
            colData = [
                {"data" : "name",'sClass' : "text-left col-width-120"},
                {"data" : "id",'sClass' : "text-left col-width-120"},
                {"data" : "address",'sClass' : "text-center col-width-120"},
                {"data" : "create_time",'sClass' : "text-center col-width-120",
                    "render" : function(data, type, full, meta) {
                    var str = "";
                    str = mcfish.Tools.getMyDate(data,1);
                    return str;
                }},
                {"data" : "id",'sClass' : "text-center col-width-oper3",
                    "render" : function(data, type, full, meta) {
                        var str = "";
                        str += "<span class='tab_text_blue pointer' onclick=changeCarStatus(" + data +",1);>详细</span>&nbsp;&nbsp;";
                        return str;
                    }
                }
            ]
            break;
        case 3:
            status = 4;
            colData = [
                {"data" : "id",'sClass' : "text-left col-width-120"},
                {"data" : "dno",'sClass' : "text-left col-width-120"},
                {"data" : "name",'sClass' : "text-left col-width-120"},
                {"data" : "color",'sClass' : "text-center col-width-120"},
                {"data" : "factory",'sClass' : "text-center col-width-120"},
                {"data" : "pwd",'sClass' : "text-center col-width-120"},
                {"data" : "secure",'sClass' : "text-center col-width-120"},
                {"data" : "version",'sClass' : "text-center col-width-120"},
                {"data" : "create_time",'sClass' : "text-center col-width-120",
                    "render" : function(data, type, full, meta) {
                        var str = "";
                        str = mcfish.Tools.getMyDate(data,1);
                        return str;
                    }},
            ]
            break;
    }

    var ajaxParams = {
        api: '/getRepertoryList.do',
        type: 'GET',
        searching:true,
        data:{
            startTime : startTime,
            endTime : endTime,
            selectStr : selectStr,
            status : status
        }
    }

    table = $api.getDataTable('#repertoryList'+type+'',ajaxParams, colData);
}


/*************************************************************************************************************/
/******************************             车辆库存列表页-end             ***********************************/
/*************************************************************************************************************/


//日期插件相关
$.datetimepicker.setLocale('zh');
$("input[id^=startFlag],input[id^=endFlag]").datetimepicker({
    inline:false,	//true-显示，false - 隐藏
    format: 'Y-m-d',
    timepicker: false, //true-显示时间，false - 不显示时间
    height : "50px"
});

