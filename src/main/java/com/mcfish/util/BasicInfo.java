package com.mcfish.util;
/**
 * 基本配置信息类
 * @author TangLin
 * @date 2017年9月6日 下午7:06:42 
 * @version 1.0
 */

public class BasicInfo {
	
	//七牛账号信息
	public static final String  ACCESS_KEY = "9qT5h5rj5SfBXpUC8vJKyIqJsGqTZBehaicrXzlQ";  // 账号的ACCESS_KEY
	public static final String SECRET_KEY = "eSacEh9VG9O6UxR70jPhiEwrDmaqZt5wDOry7s1e";  //账号的SECRET_KEY
	public static final String SPACE = "yuanjia";  //表空间
	
	
	/**支付宝账号信息配置**/
	
	// 商户appid
		public static String APPID = "2017072507886657";
		// 私钥 pkcs8格式的
		public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDC7So7lMJQrwtRou2PtZPg21Q11RJ+zRdgz7aHKh/MJIEStNqhk6ObsdAOp4gXwtf0qRoniJI+5LlAyFDfl0VwOFSaOUH8saWmng6NWvye29brXgUDEHAHG7YdX7XRluByk81PWzlr2EtFlbDZ9iFo276Xjtbk2fgCTEut1k3go/b42XExOV15wzuKaHqfuE4tJfeVMsXkh1EN7fw0UbGaMXrq4rLeD/vps107l8QTtaf43nazozQ048SgRouAutkB6SmaZTlXXIsHYmcq2lsrbgbFjFwn84aeOVQgBje8w6YMQIORhilEHyMG1tgzk54Hwx7VuTVkuEy3h7bOCoylAgMBAAECggEAMsk97qYUdpcUuOFdScsCS1x5tUjdd8IRrDySDudPv41nP6t1JxHjV6ZdUeQeViqCv5Drao9vowlOpu1J/OdZxSI4ELKIWcEjKqUVn4isNuuKNGqbna/DsGZs7XxJT+Eie1e870cST+HbwrZ8jF1PWRWfs7cYkCmmL1sXgKRMSBGbuCBMfxH3E5nSf5i7STTF9PX+gb7PoxGRO8M+MxXWx2sN3qV5ss/sgofT15SfngceD1S4Dn3pGmUW569kE36cEOoUXQTDM1dFY6aZkeCWftytRu7WSmdZUnUK/YXUeu/Xg1eQttZMv5g8Dg3AzFj7Gttq9uOB0WlUkGf+0Ti5xQKBgQDqHeggiwAOsfKqWgaNEjjtfHDCt3XFgO1P87Rs2+TzwYd0fuM2GiB7EpUOveTunfeYWj2XFCOedIYiGqlOcKkFQlA7esx6qLUQmg0jVwscDesQV/bFr2hxCfNe5oGE6HzXASSHbDOwXWDuDXbxBoAQOxzlKuNKIl8vYyiphPTtEwKBgQDVJXxoZGYp49pAPLupL+HkY9N8FdYMbhQR9tmXpXyPlw8GxWyVe+bB+ggBxHEptYKg87M/rY/fgsXf3ECh4BFanV3uCDDyftIL5vgFrPI4CDB8XQ+I7cqcxWYYcvFpEZeB8sKRWM6K++2LSFvjIGVY4K/LE6Rykb9Ck0mE4PtuZwKBgAXnrTQs7VpxiJJdZO7n98GdsuZmZDUQFGxA1FsujK7NQdJhZO+3ZvxTsqjFh2GxYE5acFVAL8nOXJe9nmmZE9pLGuT1KvUpDjAWAqDSkDgr7bLi1RmVXAgF3TqWi8vDZWqy363+v6sCH/DBLC/WHyLJqufo1gTHqyjx0lO8Q8U7AoGAMNYt8x1N6zsxvpYryVAXSeU1h7DZIm/2WUdeA8j/CUdrQfnqLzX8YWWQgBcqdowIKiisYWK7HFMyU2B7zpswXrq/0tI9pNI5/lAlc+d0eDIoKdaIwK77RYBVLDTp61EEjdm5iuP2LxIaE1e49gluLzcMEFOn0jhiwjZNGg0SjvECgYBGWxi9BO51JSpnrcFd67OV7ogIKUnx6/JayWwcuDUOYmUtE4tcpJaTJhfVcPzV8zXdhiayp57vNCdb/yciuoO/J8lbYMaaRhMcEP2xlTIsUnhL0Z9a5+IfYvAb8wsHs/SCpPuC/vcSKR2eJ91nr+qTvQkWcS8JtQzO81HKdF+eAg==";
		// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String notify_url = "http://api.gzjdian.com/api/callBackController/callBackAliPay";
		// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
		public static String return_url = "http://api.gzjdian.com/api/callBackController/callBackAliPay";
		// 请求网关地址https://openapi.alipay.com/gateway.do
		public static String URL = "https://openapi.alipay.com/gateway.do";
		// 编码
		public static String CHARSET = "GBK";
		// 返回格式
		public static String FORMAT = "json";
		// 支付宝公钥
		public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgsFfwA918dB0jm8wjgFd5TcxoF8mKYv+Pgu4x1Oe29t+XhKAsccAxt8KN/2AUZzKGdL22r11vomJXixd5zqNHL5JneEebDHy7aBhi1x+i0+LqmeiD2d9/6csFCcOa4qKK2tdtQtr90GE32PHix4jlsHDpitDYGHCbM41aPKKzGTalWoOraDZVW9pjW1IOyhJ+D1QIKYNS15tPVEBISmxsBCX8lbBoTHSmvylz8eaj0QOoD9Llm9lK5Hk1a0NJKEJJZb811uPDbAhgbBGXD5ysP2FVGBxqRxkG/PJl6C1bZTf/Ivm9lPkSteYt2pZszEByNlEYJ7aZT89c+4ht2OQ3QIDAQAB";
		// 日志记录目录
		public static String log_path = "/log";
		// RSA2
		public static String SIGNTYPE = "RSA2";
	
	
	/**微信账号信息配置**/
	
	//公众号appId
	public static final String appID = "wxe3eb5fcca19f2239";
	//公众号appSecret
	public static final String APP_AppSecret = "aafd8e15a3d579ce785f575926d622f7";
	
	//商户证书路径
	public static final String KeyPath = "/apiclient_cert.p12";
	//微信退款接口
	public static final String httpurl ="https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	//商户号
	public static final String MchId = "1493478542";
	//商户号秘钥
	public static final String MchKey = "FA0C8639FC396C1C8B922A1F7B32F23F";
	
	//商家名
	public static final String Send_Name = "佳电";
}
