package com.account.entity;


import java.util.List;

import org.hibernate.validator.constraints.Length;

/**
 * 入库单主表
 */
public class AccountInput {
	
	private String id;
	private String inputnum;		// 入库单号
	private String inputdate;		// 入库日期
	private String category="无";		// 入库类别
	private String inspectionnum;		//送检单号
	private String contracttitle;		// 合同名称
	private String beginDate;//开始日期
	private String endDate;//结束日期
	private String remarks;//备注信息
	private String delFlag="0";//是否删除
	List<AccountInputDetail> accountInputDetail;
	public AccountInput() {
		super();
	}

	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	@Length(min=1, max=37, message="入库单号长度必须介于 1 和 37 之间")
	public String getInputnum() {
		return inputnum;
	}

	public void setInputnum(String inputnum) {
		this.inputnum = inputnum;
	}
	

	/**
	 * @return the inputdate
	 */
	public String getInputdate() {
		return inputdate;
	}



	/**
	 * @param inputdate the inputdate to set
	 */
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}



	@Length(min=0, max=255, message="入库类别长度必须介于 0 和 255 之间")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

	public String getInspectionnum() {
		return inspectionnum;
	}

	public void setInspectionnum(String inspectionnum) {
		this.inspectionnum = inspectionnum;
	}

	public String getContracttitle() {
		return contracttitle;
	}

	public void setContracttitle(String contracttitle) {
		this.contracttitle = contracttitle;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		if(beginDate!=null&&!beginDate.equals("")) {
			beginDate=beginDate+" 00:00:00";}
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		if(endDate!=null&&!endDate.equals("")) {
			endDate=endDate+" 23:59:59";}
		this.endDate = endDate;
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
	 * @return the accountInputDetail
	 */
	public List<AccountInputDetail> getAccountInputDetail() {
		return accountInputDetail;
	}



	/**
	 * @param accountInputDetail the accountInputDetail to set
	 */
	public void setAccountInputDetail(List<AccountInputDetail> accountInputDetail) {
		this.accountInputDetail = accountInputDetail;
	}



	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}



	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	
}