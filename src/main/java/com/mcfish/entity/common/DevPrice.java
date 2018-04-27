package com.mcfish.entity.common;

import java.util.Date;

/**
 * 设备价格策略实体类
 * @author ZengWeihan
 * @date 2018年4月25日 下午6:00:25 
 * @version 1.0
 */
public class DevPrice {
	
	private int id;				//主键
	private String name;		//价格策略的名称
	private int price1;			//1次的价格
	private int price2;			//2次的价格		
	private int price3;			//3次的价格
	private int price4;			//4次的价格
	private int price5;			//5次的价格
	private int price6;			//6次的价格
	private String comment;		//备注信息
	private Date create_time;	//添加时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice1() {
		return price1;
	}
	public void setPrice1(int price1) {
		this.price1 = price1;
	}
	public int getPrice2() {
		return price2;
	}
	public void setPrice2(int price2) {
		this.price2 = price2;
	}
	public int getPrice3() {
		return price3;
	}
	public void setPrice3(int price3) {
		this.price3 = price3;
	}
	public int getPrice4() {
		return price4;
	}
	public void setPrice4(int price4) {
		this.price4 = price4;
	}
	public int getPrice5() {
		return price5;
	}
	public void setPrice5(int price5) {
		this.price5 = price5;
	}
	public int getPrice6() {
		return price6;
	}
	public void setPrice6(int price6) {
		this.price6 = price6;
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
	@Override
	public String toString() {
		return "DevPrice [id=" + id + ", name=" + name + ", price1=" + price1 + ", price2=" + price2 + ", price3="
				+ price3 + ", price4=" + price4 + ", price5=" + price5 + ", price6=" + price6 + ", comment=" + comment
				+ ", create_time=" + create_time + "]";
	}
}
