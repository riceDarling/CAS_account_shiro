package com.account.entity;

import java.util.List;

/**
 * 退货单
 * 
 */
public class AccountReject extends BaseModel {
	private String id;

	private String ordernum;

	private String title;

	private String suppliernum;//供应商名称

	private String arrivalnum;

	private String remarks;

	private List<AccountRejectDetail> detailList;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AccountRejectDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<AccountRejectDetail> detailList) {
		this.detailList = detailList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getSuppliernum() {
		return suppliernum;
	}

	public void setSuppliernum(String suppliernum) {
		this.suppliernum = suppliernum;
	}

	public String getArrivalnum() {
		return arrivalnum;
	}

	public void setArrivalnum(String arrivalnum) {
		this.arrivalnum = arrivalnum;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}