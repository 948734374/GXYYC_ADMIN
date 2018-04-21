package com.mcfish.util.alipay;

public class test {
  
	
	
/*	  public static void main(String[] args) {
		//实例化客户端
		  AlipayClient alipayClient = new DefaultAlipayClient(
				  AlipayConfig.URL, 
				  AlipayConfig.APPID, 
				  AlipayConfig.RSA_PRIVATE_KEY, 
				  "json", 
				  AlipayConfig.CHARSET, 
				  AlipayConfig.ALIPAY_PUBLIC_KEY,
				  "RSA");
		  //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		  AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		  //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		  AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		  model.setBody("我是测试数据");
		  model.setSubject("App支付测试Java");
		  model.setOutTradeNo("dasdadasdasdasd");
		  model.setTimeoutExpress("30m");
		  model.setTotalAmount("0.01");
		  model.setProductCode("QUICK_MSECURITY_PAY");
		  System.out.println(JSON.toJSONString(model));

		  request.setBizModel(model);
		  request.setNotifyUrl("商户外网可以访问的异步地址");
		  try {
		          //这里和普通的接口调用不同，使用的是sdkExecute
		          AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
		          System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
		      } catch (AlipayApiException e) {
		          e.printStackTrace();
		  }
	}*/
	  
	  
/*	 public static void main(String[] args) throws AlipayApiException {
		  AlipayClient alipayClient = 
				  new DefaultAlipayClient(
						  "https://openapi.alipay.com/gateway.do",
						  AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,
						  AlipayConfig.FORMAT,
						  "GBK"
						  ,AlipayConfig.ALIPAY_PUBLIC_KEY,
						  AlipayConfig.SIGNTYPE);
		  AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
		  Map<String, String> map = new HashMap<>();
		  map.put("out_biz_no", "3142321423432");
		  map.put("payee_type", "ALIPAY_LOGONID");
		  map.put("payee_account", "abc@sina.com");
		  map.put("amount", "0.01");
		  map.put("payer_show_name", "上海交通卡退款");
		  map.put("payee_real_name", "张三");
		  map.put("remark", "转账备注");
		  
		  request.setBizContent("{" +
		  "\"out_biz_no\":\"3142321423432\"," +
		  "\"payee_type\":\"ALIPAY_LOGONID\"," +
		  "\"payee_account\":\"abc@sina.com\"," +
		  "\"amount\":\"12.23\"," +
		  "\"payer_show_name\":\"上海交通卡退款\"," +
		  "\"payee_real_name\":\"张三\"," +
		  "\"remark\":\"转账备注\"" +
		  "  }");
		  request.setBizContent(JSON.toJSONString(map));
		  AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
		  if(response.isSuccess()){
		      System.out.println("调用成功");
		  } else {
			  System.out.println(response.getCode());
			  System.out.println(response.getSubMsg());
			  System.out.println(response.getSubCode());
		      System.out.println("调用失败");
		  }
	} */
   
//	public static void main(String[] args){
//         try {
//        	 AlipayClient alipayClient = new DefaultAlipayClient(AlipayLifeConfig.URL,
//						AlipayLifeConfig.APPID,
//						AlipayLifeConfig.RSA_PRIVATE_KEY,
//						AlipayLifeConfig.FORMAT,
//						"utf-8",
//						AlipayLifeConfig.ALIPAY_PUBLIC_KEY,
//						AlipayLifeConfig.SIGNTYPE);
//        	 
//        	 
//        	 AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
//        	 request.setBizContent("{" +
//        	 "\"out_biz_no\":\"3142321423432\"," +
//        	 "\"payee_type\":\"ALIPAY_LOGONID\"," +
//        	 "\"payee_account\":\"15283238898\"," +
//        	 "\"amount\":\"0.1\"" +
//        	 "  }");
//        	 AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
//        	 if(response.isSuccess()){
//        	 System.out.println("调用成功");
//        	 } else {
//        	 System.out.println("调用失败");
//        	 }
//        	 
//         }catch (Exception e) {
//     			System.out.println(e);
//     		}
//   }
	
	
//	public static void main(String[] args){
//        try {
//      		AlipayClient alipayClient = 
//       				new DefaultAlipayClient(AlipayLifeConfig.URL,
//       						AlipayLifeConfig.APPID,
//       						AlipayLifeConfig.RSA_PRIVATE_KEY,
//       						AlipayLifeConfig.FORMAT,
//       						"utf-8",
//       						AlipayLifeConfig.ALIPAY_PUBLIC_KEY,
//       						AlipayLifeConfig.SIGNTYPE);
// /*      		AlipayClient alipayClient = 
//       				new DefaultAlipayClient(
//       						"https://openapi.alipay.com/gateway.do",
//       						AlipayLifeConfig.APPID,
//       						AlipayLifeConfig.RSA_PRIVATE_KEY,
//       						"json",
//       						"GBK",
//       						AlipayLifeConfig.ALIPAY_PUBLIC_KEY,
//       						"RSA2");*/
//       	 AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
//       	 request.setNotifyUrl(AlipayConfig.notify_url);	    	
///*         request.setBizContent("{" +
//       			"\"out_trade_no\":\"20150320010101001\"," +
//       			"\"total_amount\":88.88," +
//       			"\"discountable_amount\":8.88," +
//       			"\"subject\":\"Iphone6 16G\"," +
//       			"\"body\":\"Iphone6 16G\"," +
//       			"\"buyer_id\":\"2088802780919107\"," +
//       			"      \"goods_detail\":[{" +
//       			"        \"goods_id\":\"apple-01\"," +
//       			"\"goods_name\":\"ipad\"," +
//       			"\"quantity\":1," +
//       			"\"price\":2000," +
//       			"\"goods_category\":\"34543238\"," +
//       			"\"body\":\"特价手机\"," +
//       			"\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
//       			"        }]," +
//       			"\"operator_id\":\"Yx_001\"," +
//       			"\"store_id\":\"NJ_001\"," +
//       			"\"terminal_id\":\"NJ_T_001\"," +
//       			"\"extend_params\":{" +
//       			"\"sys_service_provider_id\":\"2088511833207846\"" +
//       			"    }," +
//       			"\"timeout_express\":\"90m\"," +
//       			"\"business_params\":\"{\\\"tableNumber\\\":\\\"xx001”}\"" +
//       			"  }");*/
//      
//       	 AlipayTradeCreateModel model = new AlipayTradeCreateModel();
//       	 model.setOut_trade_no("20150werw342342efszewffsdf4reedd");
//       	 model.setTotal_amount(88.88);
//       	 model.setSubject("Iphone6 16G");
//       	 model.setBody("Iphone616G");
//       	 model.setBuyer_id("2088802780919107");
//   /*    	 AlipayTradeCreateGoodModel goods = new AlipayTradeCreateGoodModel();
//       	 goods.setGoods_id("2333444");
//       	 goods.setQuantity(1);
//       	 goods.setGoods_name("Iphone616G");
//       	 goods.setPrice(88.88);
//      // 	 goods.setShow_url("http://www.alipay.com/xxx.jpg");
//       	 model.setGoods_detail(goods);*/
//       	 
//       	 request.setBizContent(JSON.toJSONString(model));
//       	 
//       	 
//       	 
//       	 AlipayTradeCreateResponse response = alipayClient.execute(request);
//       	 System.out.println(JSON.toJSONString(response));
//       	 System.out.println(response.getMsg()+":"+response.getCode()+"=="+response.getSubCode());
//       	 if(response.isSuccess()){
//       	 System.out.println("调用成功");
//       	 } else {
//       	 System.out.println("调用失败");
//       	 }
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//  }
	
	 
}
