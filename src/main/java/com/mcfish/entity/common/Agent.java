package com.mcfish.entity.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 代理商实体类
 * @author Zengweihan
 * @date 2018年4月27日16:18:19
 * @version 1.0
 */
public class Agent implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3515086176733848344L;
	
	private Integer id;
	private Integer parent_id;		//父级ID
	private Integer parent_name;	//父级名称
	private String openid_wx;		//绑定的微信OpenID
	private int level;				//理代级别: 1-一级 2-二级 3-三级
	private String head;			
	private String name;			//代理商名称
	private String phone;			//手机号
	private String password;		//密码
	private int money;				//余额
	private int reward;				//励奖的金额（money中已包含此部分）
	private int totalMoney;			//累计收益
	private int proportion;			//分成比例 1-100
	private String prov;			//省
	private String city;			//市
	private String zone;			//区
	private String address;			//详细地址
	private String contract;		//同合编号
	private String comment;			//备注
	private int status;				//态状：1-冻结 0-正常
	private Date create_time;		//驻入时间
	private int shop_total;			//商家数量
	private Long total_page;		//总条数统计
	private Integer total;
	public Long getTotal_page() {
		return total_page;
	}
	public Integer getParent_name() {
		return parent_name;
	}
	public void setParent_name(Integer parent_name) {
		this.parent_name = parent_name;
	}
	public void setTotal_page(Long total_page) {
		this.total_page = total_page;
	}
	public int getShop_total() {
		return shop_total;
	}
	public void setShop_total(int shop_total) {
		this.shop_total = shop_total;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getOpenid_wx() {
		return openid_wx;
	}
	public void setOpenid_wx(String openid_wx) {
		this.openid_wx = openid_wx;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getProportion() {
		return proportion;
	}
	public void setProportion(int proportion) {
		this.proportion = proportion;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
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
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Agent [id=" + id + ", parent_id=" + parent_id + ", parent_name=" + parent_name + ", openid_wx="
				+ openid_wx + ", level=" + level + ", head=" + head + ", name=" + name + ", phone=" + phone
				+ ", password=" + password + ", money=" + money + ", reward=" + reward + ", totalMoney=" + totalMoney
				+ ", proportion=" + proportion + ", prov=" + prov + ", city=" + city + ", zone=" + zone + ", address="
				+ address + ", contract=" + contract + ", comment=" + comment + ", status=" + status + ", create_time="
				+ create_time + ", shop_total=" + shop_total + ", total_page=" + total_page + ", total=" + total + "]";
	}
	
}