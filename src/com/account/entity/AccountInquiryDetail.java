package com.account.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;

/**
 * 询价单子表Entity
 * 
 * @author yang
 * @version 2017-07-13
 */
public class AccountInquiryDetail extends BaseModel {

	private String id;
	private String inquirydetailnum; // 询价单号
	private String ordernum; // 单据编号
	private String validdate; // 询价有效期限
	private String supplier; // 供应商名称
	private String materialname; // 物资名称
	private String size; // 规格型号
	private String unit; // 计量单位
	private String unitprice; // 单价(自动计算（保留两位）
	private String requisition; // 申请单号
	private String maker; // 制单人

	private String materialcode; // 物资编号
	private Date inquiryTime; // 询价时间
	private String suppliercode; // 供应商编号
	private String brand; // 商标

	private int state;// 是否选中进行审批

	private String remarks;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSuppliercode() {
		return suppliercode;
	}

	public void setSuppliercode(String suppliercode) {
		this.suppliercode = suppliercode;
	}

	public Date getInquiryTime() {
		return inquiryTime;
	}

	public void setInquiryTime(Date inquiryTime) {
		this.inquiryTime = inquiryTime;
	}

	public void setMaterialcode(String materialcode) {
		this.materialcode = materialcode;
	}

	public String getMaterialcode() {
		return materialcode;
	}

	public AccountInquiryDetail() {
		super();
	}

	@Length(min = 1, max = 37, message = "询价单号长度必须介于 1 和 37 之间")
	public String getInquirydetailnum() {
		return inquirydetailnum;
	}

	public void setInquirydetailnum(String inquirydetailnum) {
		this.inquirydetailnum = inquirydetailnum;
	}

	@Length(min = 1, max = 17, message = "单据编号长度必须介于 1 和 17 之间")
	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getValiddate() {
		return validdate;
	}

	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}

	@Length(min = 1, max = 35, message = "供应商名称长度必须介于 1 和 35 之间")
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Length(min = 1, max = 35, message = "物资名称长度必须介于 1 和 35 之间")
	public String getMaterialname() {
		return materialname;
	}

	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}

	@Length(min = 1, max = 35, message = "规格型号长度必须介于 1 和 35 之间")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Length(min = 1, max = 35, message = "计量单位长度必须介于 1 和 35 之间")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}

	@Length(min = 0, max = 255, message = "申请单号长度必须介于 0 和 255 之间")
	public String getRequisition() {
		return requisition;
	}

	public void setRequisition(String requisition) {
		this.requisition = requisition;
	}

	@Length(min = 1, max = 35, message = "制单人长度必须介于 1 和 35 之间")
	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

}