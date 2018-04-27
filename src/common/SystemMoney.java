package com.mcfish.entity.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 台的收益记录与余额实体类
 * @author WangHaibo
 * @date 2018年4月23日 上午11:14:48
 * @version 1.0
 */
public class SystemMoney implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 7859178482558861042L;
	
	private int id;							//主键
	private String order_no;				//消费或者收益订单号
	private int type;						//变动类型：0-消费收益 1-消费补贴  2-奖励扣除 3-后台收益
	private int amount;						//变动的金额，可能为负值
	private int money;						//平台余额，可能为负值
	private String comment;					//备注
	private Date create_time;				//创建时间
	private Long total;						//统计数量时使用
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
		return "SystemMoney [id=" + id + ", order_no=" + order_no + ", type=" + type + ", amount=" + amount + ", money="
				+ money + ", comment=" + comment + ", create_time=" + create_time + ", total=" + total + "]";
	}
	
}
