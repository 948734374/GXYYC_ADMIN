package com.mcfish.entity.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆实体类
 * @author WangHaibo
 * @date 2018年4月23日 下午1:51:18
 * @version 1.0
 */
public class Cars implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 2656106975673701949L;
	
	private int id;				//主键
	private String dno;			//车牌号
	private int shop_id;		//商家id
	private int price_id;		//格价策略ID
	private String price_name;	//套餐名称
	private String name;		//型号名
	private String image;		//二维码
	private String color;		//颜色
	private String version;		//硬件版本号
	private String funcs;		//能功描述,如可投币、支持扫码
	private String factory;		//生产厂家
	private int online;			//0-离线 1-在线
	private int signal;			//信号：  0-弱    1-中    2-强
	private String pwd;			//终端密码
	private String secure;		//辆车保险号
	private String comment;		//备注信息
	private int status;			//状态0-库存中 1-营业总 2-使用中 3-维修中 4-已报废
	private Date heart_time;	//上次心跳时间
	private Date create_time;	//创建时间
	private Long total;			//统计数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getPrice_id() {
		return price_id;
	}
	public void setPrice_id(int price_id) {
		this.price_id = price_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getFuncs() {
		return funcs;
	}
	public void setFuncs(String funcs) {
		this.funcs = funcs;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSecure() {
		return secure;
	}
	public void setSecure(String secure) {
		this.secure = secure;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getHeart_time() {
		return heart_time;
	}
	public void setHeart_time(Date heart_time) {
		this.heart_time = heart_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPrice_name() {
		return price_name;
	}
	public void setPrice_name(String price_name) {
		this.price_name = price_name;
	}
	public int getSignal() {
		return signal;
	}
	public void setSignal(int signal) {
		this.signal = signal;
	}
	@Override
	public String toString() {
		return "Cars [id=" + id + ", dno=" + dno + ", shop_id=" + shop_id + ", price_id=" + price_id + ", price_name="
				+ price_name + ", name=" + name + ", image=" + image + ", color=" + color + ", version=" + version
				+ ", funcs=" + funcs + ", factory=" + factory + ", online=" + online + ", signal=" + signal + ", pwd="
				+ pwd + ", secure=" + secure + ", comment=" + comment + ", status=" + status + ", heart_time="
				+ heart_time + ", create_time=" + create_time + ", total=" + total + "]";
	}
	
}
