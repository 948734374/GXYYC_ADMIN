package com.mcfish.util.alipay;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2017072507886780";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEr82ibiCieP63dXm0LL8mhejyeGZIEdY8I+AcqUuhgvSkFuvIyiQ+gq4HTlBf/w8AXLHCN3aEwLZah36TJheCb/pu6XyguspVjoEsdV/vUzy5PewdWFggLtyUiY76V8lluJu5Jc4mtYlUEaIIPbH6CX1/AO8O256a6rpaDoSPQ4qL+eurCYzkXuBq/1QLaRDB6Ug4bkzlmdVaIus6XAYNjKE+59Zg3yp9hA9aN0uasggR85hsvtIYG2t6eh2hySm0y+vhNR6eq6l6vMrwxoA1ZGFNSZH8zkauwActs5UQfMruW/RjYaLL8lWUlDamxC8NjmgjALQgjX3WHHfo4eDzAgMBAAECggEAY0XJO3Lb1dNi983b3bLw3RipXeg41kkKGXrZ7Xe4j0GUWcSQamzayy4omGy+c+Q3zBSOJnoqoU4x4O+pAt0oD75KB3uHdBXs1jBFcwbqXPvQ3eN3ack0PffxruxwXdsaYpHJaK/hWlLOSWjb6wCFzUYWb9Q6B8rHEq719/UOtsREtAy8IgB+SBnNaszn17zWEbPY1HEUe9Ty2w+IZr/v+1NWxCTVYo77FB7XuaQ8saUqZpirQAExqBhQlbbwc8JSXy79IUryTHc15h8LywHMAb2jJi5eGetnLcwuAOXVZctSr9oS362MKEYJewVBJRaBJmAJuys5WzD7xTlZGHMnuQKBgQDAcwY24BRdqHUfCbtdlrMzs1P2BEYHOxLHafkun9OTASw9QIHwHCeMNvY50gNc0wU509vB9NyUDpJSliKKYQqXN9Z5UMU6y+gQZ+0bHRCPX82XuW2vqa81ZHE2NqoPCAUs24iYIRQqdtLghNAaxsF4DIskwX0bCQmTYMupka8j5wKBgQCwgKoRk3tMpVmotoGyhxWuCLh3Rr/qa2yzWqyREy1wVQJQOtaPY65SVK6yGu7s5VS06WCSa3n12xRXny6trtx01egYiZjhxkcuJBfN+P2X5GnIf26I10b4jrYROW2OThckTcmOjHg1tWbe/AGMZqFI96PeyDil8EHMMkhvZJ65FQKBgCbn2gzD9joM8UiKDh/YdHfyO/oTWRjjH2PDD8YWN46TgR8M6HfjKTeWcOa1h0p/uqG7K8UlPGaOH5Skl20EO0Dg3/H8mzLMwCh46h0+HffuNUEEEqGdmzcfDCgamvyY8XrlEtM2dL408WLEVtHi9n/PgV235BPQGuh5fBLWyeJnAoGATRj2sNS+MB2uC18lSiltk+alRRy3ahtgkPuTk49P8th/OTJqVJoTJE1vPcc8BGisVpX2pB6kWHtI6HlU93MBQ1vIlSdNi5mDsCj96O/RPg79EiJv0wBONPaJmv5914JO44HDACxlufgyJkboGj8eRnQ9tWu6KunGo/5224mVN30CgYAw5hKlak/mQ+l9mzXg1sXvwd5dThe8T9ro/gxQsv5lAsAD6viroaG9pNIpu+XocBqdY21TOVKbFVWP+m+aZUFhvL609JocY8r76QX5R8y4xUXEOoWO6ZF7i/9SfqaC6dkqJSe8HWHFnIsPDPLebQO/McLQccaZxp1UZ2JB+6YAHQ==";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://39.108.83.186/api/callBackController/callBackAliPay";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://39.108.83.186/api/callBackController/callBackAliPay";
	// 请求网关地址https://openapi.alipay.com/gateway.do
	public static String URL = "https://openapi.alipay.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjILfbERstQS5PtghuaUx+/38i1AJWJeL5nt8t8eqTI/HrA5tP4Tlh0TGga5aOoyxSjz7Ma9RqaAW7OlDLIKsq3vMMyLrSC3K+7+I+dKhAOyCJ/Jrt8/W9EOYzqWd44EzZe+fDbE5NOJU5fMQVVf6Chbkl3cTvVD9vj9NnuUkjWzhqHeSWImVoHZz1hh+gnGzQ0NSUMdxiYPYsMiqfKPp8aZofhXiC2ZbMNyD+DqJigFRJkSLZ7rG0Jhy7w71HDUcGyyX9taivkL26vcIa+IR2coiXqHcdlKxNmwRAYdeGxK50yFLjw61NZECaIVo6VW+xgH/D1rpRjgubz9fjSdSCwIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
