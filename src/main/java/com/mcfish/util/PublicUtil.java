package com.mcfish.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PublicUtil {
	public static void main(String[] args) {
		System.out.println("本机的ip=" + PublicUtil.getIp());
		System.out.println(PublicUtil.getRandomChar());
	}

	public static String getPorjectPath() {
		String nowpath = "";
		nowpath = System.getProperty("user.dir") + "/";

		return nowpath;
	}

	/**
	 * 获取本机ip
	 * 
	 * @return
	 */
	public static String getIp() {
		String ip = "";
		try {
			InetAddress inet = InetAddress.getLocalHost();
			ip = inet.getHostAddress();
			// System.out.println("本机的ip=" + ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return ip;
	}

	/**
	 * 获取ip 如果服务器使用nginx做反向代理 ，需要配置nginx的nginx.conf才能获取真实ip
	 * 
	 * @author ZhouXiaobing 2017年7月27日 下午9:57:33
	 * @version Mcfish 1.0
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 两个数组中去掉重复的
	 */
	public static String[] arrContrast(String[] arr1, String[] arr2) {
		List<String> list = new LinkedList<String>();
		for (String str : arr1) { // 处理第一个数组,list里面的值为1,2,3,4
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		for (String str : arr2) { // 如果第二个数组存在和第一个数组相同的值，就删除
			if (list.contains(str)) {
				list.remove(str);
			}
		}
		String[] result = {}; // 创建空数组
		return list.toArray(result); // List to Array
	}


	/**
	 * 随机生成7位大小写字母、数字组合的字符串
	 * 
	 * @author TangLin
	 * @date 2017年9月5日 上午11:29:58
	 * @param @return
	 * @return String
	 */
	public static String getRandomChar() {
		String a = "0123456789abcdefghjklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
		char[] rands = new char[7];
		for (int i = 0; i < rands.length; i++) {
			int rand = (int) (Math.random() * a.length());
			rands[i] = a.charAt(rand);
		}
		String res = String.valueOf(rands);
		return res;
	}

}
