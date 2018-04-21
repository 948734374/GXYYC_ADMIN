package com.mcfish.entity.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户订单
 * @author WangHaibo
 * @date 2018年4月20日 下午2:12:22
 * @version 1.0
 */
public class UserRecord implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -3128143946623218199L;
	
	private int id;							//主键
	private int user_id;					//用户id
	private int shop_id;					//所属商家ID
	private String shop_name;				//使用的网点名
	private String order_no;				//支付订单号，tb_user_money.order_no
	private String dno;						//车牌号
	private int price;						//套餐价格
	private int count;						//套餐次数   作为使用次数
	private String comment;					//备注
	private int status;						//0-初始化 1-使用中 2-已结束
	private Date create_time;				//创建时间
	
	private int amount;						//订单价格
	private int amount_disc;				//抵扣金额
	private String Address;					//地址
	private int pay_way;					//付款方式
	private int pay_status;					//支付状态
	private int money;						//用户余额
	
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

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPay_way() {
		return pay_way;
	}

	public void setPay_way(int pay_way) {
		this.pay_way = pay_way;
	}

	public int getPay_status() {
		return pay_status;
	}

	public void setPay_status(int pay_status) {
		this.pay_status = pay_status;
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

	@Override
	public String toString() {
		return "UserRecord [id=" + id + ", user_id=" + user_id + ", shop_id=" + shop_id + ", shop_name=" + shop_name
				+ ", order_no=" + order_no + ", dno=" + dno + ", price=" + price + ", count=" + count + ", comment="
				+ comment + ", status=" + status + ", create_time=" + create_time + ", amount=" + amount
				+ ", amount_disc=" + amount_disc + ", Address=" + Address + ", pay_way=" + pay_way + ", pay_status="
				+ pay_status + ", money=" + money + ", total=" + total + "]";
	}

	
}
