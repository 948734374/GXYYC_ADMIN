package com.mcfish.entity.common;

import java.util.Date;

/**
 * 报修信息实体类
 * @author ZengWeihan
 * @date 2018年4月27日11:01:26
 * @version 1.0
 */
public class Repairs {
	
	//tb_dev_error表字段
	private int id;				//主键
	private int shop_id;		//商家ID
	private int agent_id;		//代理ID
	private int user_id;		//用户ID
	private int admin_id_repair;//维修人ID
	private	int admin_id_leader;//审批人ID
	private	String dno;			//设备车牌号
	private	String title;		//故障名称
	private	String content;		//故障描述
	private	String image;		//图片地址
	private	int status;			//0-待审批(管理员默认是这个状态) 1-已挂起 2-待处理（用户默认是这个状态） 3-已修复  4-已报废  5-拒绝（审核未通过）
	private String creator;		//申请人名称
	private	Date create_time;		//创建时间
	
	//新增字段
	private int dev_id;			//车辆ID
	private String dev_name;	//车辆型号
	private String shop_name;	//商家名称
	private String shop_prov;	//商家省份
	private String shop_city;	//商家城市
	private String shop_zone;	//商家区域
	private String admin_name_repair;//维修人名
	private	String admin_name_leader;//审批人名
	private Date min_time;		//最小时间（统计用）
	private Date max_time;		//最大时间（统计用）
	private int repairs_total;		//维修数量
	private Long total;			//统计数量
	
	public int getRepairs_total() {
		return repairs_total;
	}
	public void setRepairs_total(int repairs_total) {
		this.repairs_total = repairs_total;
	}
	public String getShop_prov() {
		return shop_prov;
	}
	public void setShop_prov(String shop_prov) {
		this.shop_prov = shop_prov;
	}
	public String getShop_city() {
		return shop_city;
	}
	public void setShop_city(String shop_city) {
		this.shop_city = shop_city;
	}
	public String getShop_zone() {
		return shop_zone;
	}
	public void setShop_zone(String shop_zone) {
		this.shop_zone = shop_zone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAdmin_id_repair() {
		return admin_id_repair;
	}
	public void setAdmin_id_repair(int admin_id_repair) {
		this.admin_id_repair = admin_id_repair;
	}
	public int getAdmin_id_leader() {
		return admin_id_leader;
	}
	public void setAdmin_id_leader(int admin_id_leader) {
		this.admin_id_leader = admin_id_leader;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getDev_id() {
		return dev_id;
	}
	public void setDev_id(int dev_id) {
		this.dev_id = dev_id;
	}
	public String getDev_name() {
		return dev_name;
	}
	public void setDev_name(String dev_name) {
		this.dev_name = dev_name;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getAdmin_name_repair() {
		return admin_name_repair;
	}
	public void setAdmin_name_repair(String admin_name_repair) {
		this.admin_name_repair = admin_name_repair;
	}
	public String getAdmin_name_leader() {
		return admin_name_leader;
	}
	public void setAdmin_name_leader(String admin_name_leader) {
		this.admin_name_leader = admin_name_leader;
	}
	public Date getMin_time() {
		return min_time;
	}
	public void setMin_time(Date min_time) {
		this.min_time = min_time;
	}
	public Date getMax_time() {
		return max_time;
	}
	public void setMax_time(Date max_time) {
		this.max_time = max_time;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Repairs [id=" + id + ", shop_id=" + shop_id + ", agent_id=" + agent_id + ", user_id=" + user_id
				+ ", admin_id_repair=" + admin_id_repair + ", admin_id_leader=" + admin_id_leader + ", dno=" + dno
				+ ", title=" + title + ", content=" + content + ", image=" + image + ", status=" + status + ", creator="
				+ creator + ", create_time=" + create_time + ", dev_id=" + dev_id + ", dev_name=" + dev_name
				+ ", shop_name=" + shop_name + ", shop_prov=" + shop_prov + ", shop_city=" + shop_city + ", shop_zone="
				+ shop_zone + ", admin_name_repair=" + admin_name_repair + ", admin_name_leader=" + admin_name_leader
				+ ", min_time=" + min_time + ", max_time=" + max_time + ", repairs_total=" + repairs_total + ", total="
				+ total + "]";
	}
	
	
	
}
