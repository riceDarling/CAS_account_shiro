package com.account.entity;

/**
 * 付款单
 */
public class AccountPayment {
	
	private String id;
	private String ordernum;		// 单据编号
	private String supplier;		// 供应商名称
	private double payamount;		// 付款金额
	private String payway;		// 付款方式(电汇/银承/商承/现金/网银)
	private String paybank;		// 付款银行
	private String paybanknum;		// 付款银行账号
	private String paycategory;		// 付款类别
	private String contractnum;		// 合同编号
	private String contracttitle;		// 合同名称
	private String paydate;		// 付款期限
	private String createdate;//制单日期
	private String beginDate;//开始日期
	private String endDate;//结束日期
	private String remarks;//备注
	private String delFlag="0";//是否删除
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
	/**
	 * @return the ordernum
	 */
	public String getOrdernum() {
		return ordernum;
	}
	/**
	 * @param ordernum the ordernum to set
	 */
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	/**
	 * @return the supplier
	 */
	public String getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	/**
	 * @return the payamount
	 */
	public double getPayamount() {
		return payamount;
	}
	/**
	 * @param payamount the payamount to set
	 */
	public void setPayamount(double payamount) {
		this.payamount = payamount;
	}
	/**
	 * @return the payway
	 */
	public String getPayway() {
		return payway;
	}
	/**
	 * @param payway the payway to set
	 */
	public void setPayway(String payway) {
		this.payway = payway;
	}
	/**
	 * @return the paybank
	 */
	public String getPaybank() {
		return paybank;
	}
	/**
	 * @param paybank the paybank to set
	 */
	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}
	/**
	 * @return the paybanknum
	 */
	public String getPaybanknum() {
		return paybanknum;
	}
	/**
	 * @param paybanknum the paybanknum to set
	 */
	public void setPaybanknum(String paybanknum) {
		this.paybanknum = paybanknum;
	}
	/**
	 * @return the paycategory
	 */
	public String getPaycategory() {
		return paycategory;
	}
	/**
	 * @param paycategory the paycategory to set
	 */
	public void setPaycategory(String paycategory) {
		this.paycategory = paycategory;
	}
	/**
	 * @return the contractnum
	 */
	public String getContractnum() {
		return contractnum;
	}
	/**
	 * @param contractnum the contractnum to set
	 */
	public void setContractnum(String contractnum) {
		this.contractnum = contractnum;
	}
	/**
	 * @return the paydate
	 */
	public String getPaydate() {
		return paydate;
	}
	/**
	 * @param paydate the paydate to set
	 */
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	/**
	 * @return the createdate
	 */
	public String getCreatedate() {
		return createdate;
	}
	/**
	 * @param createdate the createdate to set
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
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
	 * @return the contracttitle
	 */
	public String getContracttitle() {
		return contracttitle;
	}
	/**
	 * @param contracttitle the contracttitle to set
	 */
	public void setContracttitle(String contracttitle) {
		this.contracttitle = contracttitle;
	}

	
}