package com.mcfish.entity.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户优惠券实体类
 * @author WangHaibo
 * @date 2018年4月23日 上午9:09:43
 * @version 1.0
 */
public class Coupon implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 580295419800928818L;

	private int id;				//主键
	private int user_id;		//用户id
	private int coupon_id;		//优惠券/抵扣券id
	private int type;			//券类型 0-体验券 1-代金券
	private String code;		//代金券/体验券 使用码 （保留）
	private int money;			//代金券金额
	private int status;			//0-未使用 1-已使用
	private String comment;		//备注
	private Date expire;		//有效期至
	private Date create_time;	//领取时间
	private Long total;			//统计数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getExpire() {
		return expire;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "UserCoupon [id=" + id + ", user_id=" + user_id + ", coupon_id=" + coupon_id + ", type=" + type
				+ ", code=" + code + ", money=" + money + ", status=" + status + ", comment=" + comment + ", expire="
				+ expire + ", create_time=" + create_time + ", total=" + total + "]";
	}
	
	
	
}
