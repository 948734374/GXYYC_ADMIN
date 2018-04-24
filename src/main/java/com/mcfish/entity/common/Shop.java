package com.mcfish.entity.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家实体类
 * @author WangHaibo
 * @date 2018年4月24日 下午4:18:19
 * @version 1.0
 */
public class Shop implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 4046520072943548917L;
	
	private Integer id;
	private Integer agent_id;		//所属代理商ID
	private String openid_wx;		//绑定的微信OpenID
	private String head;			
	private String name;			//代理商名称
	private String phone;			//手机号
	private String password;		//密码
	private int money;				//余额
	private int reward;				//励奖的金额（money中已包含此部分）
	private int total;			//累计收益
	private int proportion;			//分成比例 1-100
	private String prov;			//省
	private String city;			//市
	private String zone;			//区
	private String address;			//地址
	private String adds;			//
	private Long lng;				//经度
	private Long lat;				//纬度
	private String comment;			//备注
	private int status;				//态状：1-冻结 0-正常
	private Date create_time;
	private Long totalSize;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
	}
	public String getOpenid_wx() {
		return openid_wx;
	}
	public void setOpenid_wx(String openid_wx) {
		this.openid_wx = openid_wx;
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
	public Long getLng() {
		return lng;
	}
	public void setLng(Long lng) {
		this.lng = lng;
	}
	public Long getLat() {
		return lat;
	}
	public void setLat(Long lat) {
		this.lat = lat;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getAdds() {
		return adds;
	}
	public void setAdds(String adds) {
		this.adds = adds;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", agent_id=" + agent_id + ", openid_wx=" + openid_wx + ", head=" + head + ", name="
				+ name + ", phone=" + phone + ", password=" + password + ", money=" + money + ", reward=" + reward
				+ ", total=" + total + ", proportion=" + proportion + ", prov=" + prov + ", city=" + city + ", zone="
				+ zone + ", address=" + address + ", adds=" + adds + ", lng=" + lng + ", lat=" + lat + ", comment="
				+ comment + ", status=" + status + ", create_time=" + create_time + ", totalSize=" + totalSize + "]";
	}
	
}