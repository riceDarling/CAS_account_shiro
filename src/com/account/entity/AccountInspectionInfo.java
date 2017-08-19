package com.account.entity;

import java.util.List;

public class AccountInspectionInfo {
	private String ordernum;		// 单据编号
	private String arrivalnum;		// 到货单编号
	private String inspectiondate;		// 送检日期
	private String inspectionman;		// 送检人
	private String checker;		// 检验人
	private String materialname;		// 物资名称
	private String inspectionmode;		// 检验方式
	private String status;	//送检状态 0:不合格，1:合格
	private String remarks;//送检主表备注
	private String ingredient;		// 成分含量
	private String granularity;		// 粒度
	private String appearance;		// 外观
	private String size;			//规格型号
	
	List<AccountInspectionDetail> accountInspectionDetail;
	
	/**
	 * @return the accountInspectionDetail
	 */
	public List<AccountInspectionDetail> getAccountInspectionDetail() {
		return accountInspectionDetail;
	}
	/**
	 * @param accountInspectionDetail the accountInspectionDetail to set
	 */
	public void setAccountInspectionDetail(List<AccountInspectionDetail> accountInspectionDetail) {
		this.accountInspectionDetail = accountInspectionDetail;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getArrivalnum() {
		return arrivalnum;
	}
	public void setArrivalnum(String arrivalnum) {
		this.arrivalnum = arrivalnum;
	}
	public String getInspectionman() {
		return inspectionman;
	}
	public void setInspectionman(String inspectionman) {
		this.inspectionman = inspectionman;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getMaterialname() {
		return materialname;
	}
	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}
	public String getInspectionmode() {
		return inspectionmode;
	}
	public void setInspectionmode(String inspectionmode) {
		this.inspectionmode = inspectionmode;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getGranularity() {
		return granularity;
	}
	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}
	public String getAppearance() {
		return appearance;
	}
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}
	/**
	 * @return the inspectiondate
	 */
	public String getInspectiondate() {
		return inspectiondate;
	}
	/**
	 * @param inspectiondate the inspectiondate to set
	 */
	public void setInspectiondate(String inspectiondate) {
		this.inspectiondate = inspectiondate;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
}
