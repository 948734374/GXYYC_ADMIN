

/**

 * Alipay.com Inc.

 * Copyright (c) 2004-2014 All Rights Reserved.

 */

package com.mcfish.util.alipay;


/**
 * 支付宝服务窗环境常量（demo中常量只是参考，需要修改成自己的常量值）
 * 
 * @author taixu.zqq
 * @version $Id: AlipayServiceConstants.java, v 0.1 2014年7月24日 下午4:33:49 taixu.zqq Exp $
 */
public class AlipayServiceEnvConstants {

    /**支付宝公钥-从支付宝生活号详情页面获取*/
	public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgsFfwA918dB0jm8wjgFd5TcxoF8mKYv+Pgu4x1Oe29t+XhKAsccAxt8KN/2AUZzKGdL22r11vomJXixd5zqNHL5JneEebDHy7aBhi1x+i0+LqmeiD2d9/6csFCcOa4qKK2tdtQtr90GE32PHix4jlsHDpitDYGHCbM41aPKKzGTalWoOraDZVW9pjW1IOyhJ+D1QIKYNS15tPVEBISmxsBCX8lbBoTHSmvylz8eaj0QOoD9Llm9lK5Hk1a0NJKEJJZb811uPDbAhgbBGXD5ysP2FVGBxqRxkG/PJl6C1bZTf/Ivm9lPkSteYt2pZszEByNlEYJ7aZT89c+4ht2OQ3QIDAQAB";
    
    /**签名编码-视支付宝服务窗要求*/
    public static final String SIGN_CHARSET      = "GBK";

    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "GBK";

    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA2";
    
    /**开发者账号PID*/
    public static final String PARTNER           = "2088721440610463";

    /** 服务窗appId  */
    //TODO !!!! 注：该appId必须设为开发者自己的生活号id  
    public static final String APP_ID            = "2017072507886657";

    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患 
    public static final String PRIVATE_KEY       = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDscYvOXmPX9rOd"
	+"dbAYZg/9Lyxskzlzd+RKVjCI7rGkf8q/Dr3RKAFWwTMrThbat26ooiSIhoC1hoWE"
	+"izZrKoEUbw1eAUaB6dZd/Ymj37nsHBStapoS7zp1BF8J6x7snMdNd0d766PCeV96"
	+"Ia6KIW46CHq5uqHK4VhuLX+aghzshLkFjQj8TbmbDuCv30primTulovd6a8vdKyk"
	+"c6z5WAi5aUgYqQYs1OKXAlr5Ai2lOwm2k4Qc22l2+642LfOIOGtDXD5S6UNln0eP"
	+"/HffjHrbyciO0Xr9UeeUZpYA8tIaQe0NolFKcWaoYm9B1ui0g7aewDEM5V2H2IvA"
	+"oV7PphIzAgMBAAECggEBALmzNCqQ17n2eHtiwztmbYhcVHex6Z1WvGXl65igX8Ti"
	+"2UnVOh/bW7HXa2jHnAuLpc2sCyVu/geT76l57POeHmL+FXGPbuD51vNa/Y9HV66p"
	+"H1RUNU5JtY/SLxKLJ26Oc7nTxMD/AU7sJKC3c23pc7kAj+LvQcMl2V4vPdkL98uJ"
	+"r29rYFpl3sT0+GGraKGTPaXD4N46ireUKFVK6+8g+dKxyNzdy7CkmD7zATcc51gh"
	+"taHJj+9+WNXs34eIQg0c9m9Oc+XczateynDBG1LQaId09HmSlCyW5rKC56KfaCdV"
	+"R02DryPDgnGf3OzI1JsiyYQK2sHxNifyIMIm4BZd0wECgYEA/I/4SrsFNVASALDm"
	+"JcUCAQNoFDc7h9M1o0QxwgjfKOD0zATlnIHiflOxTNWSFOddtDyVxlJIBN5CAo8q"
	+"lVM4ZeVWvhLaXFhOgBZLzId5MFEy23SG8K9q4mnv4P0GFB8UT1URgn+SJNNGjKur"
	+"6TA/L/+Nv902ksLmQms26l5GWMsCgYEA76lpX+1gvgMcZpuP+GuqiGZcCDuDN5Vj"
	+"Z2OpwosvigsCJ35Ivd5F0u/xe21f3t0sSR/p6waV5eNrf5/P/jXM/orMllnq1iQX"
	+"nSR8KvdpBN9FsrNIe4HPsA0NS93FshczwBWdy6bj133he4z86n0RpyKOrZnwPm3Z"
	+"BGYCb66URzkCgYBkarWUuOEsPka6IZuP/tF6J6mVCBTSPya/YFjMRgy8SxzplTTZ"
	+"0kaEZbBD1VJ8nzUBeWkvbf2WeewS6mtK7cipstKXRhWty6qCgNroWiDUFiS7Xoxc"
	+"W9KKbQZkFRX6oBTKKg+JLEGmBJ6zRXpXf8hPxDLOyxxso7M7SzeNXahomwKBgENp"
	+"QYyL9oQ718c8xng3wJXxRL3ED5qY2IcCT4O7JroLcqWtLcTKOpWkjCYNk8PaLlS7"
	+"N062YX9yQpB5YUW92FVYsUcxL47gRAwdcRec09tc+fvT1fV3g/WfFjhavvri79l9"
	+"uw7HeJrqe3wHIjTKzSZX4A4QmLTWrQ5BqznCv05xAoGAMA1WbcMyaeybnQb/nEqt"
	+"tE+ktZL3AkfY/JBgOR4VM0+6Npx8QxML7IgIMRveUqFfP1rR8piMBu3rAhzAuQsl"
	+"3Rj60kIBgyHTatXEWoHsu8sVNSd8dgek5+SJceXSF3i70ELRNv+DWJmIVUQUnFly"
	+"ZbScgBYxwtTbPCvpMnJIu+k=";
    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7HGLzl5j1/aznXWwGGYP/S8sbJM5c3fkSlYwiO6xpH/Kvw690SgBVsEzK04W2rduqKIkiIaAtYaFhIs2ayqBFG8NXgFGgenWXf2Jo9+57BwUrWqaEu86dQRfCese7JzHTXdHe+ujwnlfeiGuiiFuOgh6ubqhyuFYbi1/moIc7IS5BY0I/E25mw7gr99Ka4pk7paL3emvL3SspHOs+VgIuWlIGKkGLNTilwJa+QItpTsJtpOEHNtpdvuuNi3ziDhrQ1w+UulDZZ9Hj/x334x628nIjtF6/VHnlGaWAPLSGkHtDaJRSnFmqGJvQdbotIO2nsAxDOVdh9iLwKFez6YSMwIDAQAB";
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";

    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";
}