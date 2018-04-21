package com.mcfish.entity.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户钱包实体类
 * @author WangHaibo
 * @date 2018年4月20日 下午4:12:38
 * @version 1.0
 */
public class UserMoney implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -1618481470263457756L;
	
	
	private int id;							//主键
	private int user_id;					//用户id
	private String order_no;				//支付订单号
	private int order_type;					//方式：0-充值 1-提现  2-消费  3-收益 4-后台充值 5-后台减扣
	private int pay_way;					//付款方式
	private int amount;						//订单价格
	private int amount_disc;				//抵扣金额
	private int money;						//用户余额
	private String coupon;					//户用的体验券或抵扣券ID
	private String comment;					//备注
	private int status;						//0-未支付 1-已支付 2-已取消 3-已退款 4-已结束
	private Date create_time;				//创建时间
	private Long total;						//统计数量时使用
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
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getOrder_type() {
		return order_type;
	}
	public void setOrder_type(int order_type) {
		this.order_type = order_type;
	}
	public int getPay_way() {
		return pay_way;
	}
	public void setPay_way(int pay_way) {
		this.pay_way = pay_way;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAmount_disc() {
		return amount_disc;
	}
	public void setAmount_disc(int amount_disc) {
		this.amount_disc = amount_disc;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
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
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserMoney [id=" + id + ", user_id=" + user_id + ", order_no=" + order_no + ", order_type=" + order_type
				+ ", pay_way=" + pay_way + ", amount=" + amount + ", amount_disc=" + amount_disc + ", money=" + money
				+ ", coupon=" + coupon + ", comment=" + comment + ", status=" + status + ", create_time=" + create_time
				+ ", total=" + total + "]";
	}

}
