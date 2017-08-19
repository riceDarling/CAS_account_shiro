package com.account.entity;

import org.hibernate.validator.constraints.Length;

import java.util.List;

import com.google.common.collect.Lists;


/**
 * 送检单主表
 */
public class AccountInspection {
	
	private String id;
	private String ordernum;		// 单据编号
	private String arrivalnum;		// 到货单编号
	private String inspectionman;		// 送检人
	private String checker;		// 检验人
	private String inspectiondate;		// 送检日期
	private String beginInspectiondate;		// 开始 送检日期
	private String endInspectiondate;		// 结束 送检日期
	private String status="1";	//送检状态 0:不合格，1:合格
	private String remarks;//备注
	private String delFlag="0";//是否删除
	private String contractId;	//合同ID
	private String contractTitle;	//合同名称
	private String title;	//标题
	private String materialname;		// 物资名称
	private String size;			//规格型号0:未完成1:完成
	private String inspectionDetailId;	//送检子表ID
	private String inspectionmode;		// 检验方式
	private String ingredient;		// 成分含量
	private String granularity;		// 粒度
	private String appearance;		// 外观
	private String inspectionDetailstatus;	//子表状态	
	List<AccountInspectionDetail> accountInspectionDetail;
	public String getInspectionDetailId() {
		return inspectionDetailId;
	}

	public void setInspectionDetailId(String inspectionDetailId) {
		this.inspectionDetailId = inspectionDetailId;
	}

	public String getMaterialname() {
		return materialname;
	}

	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContractTitle() {
		return contractTitle;
	}

	public void setContractTitle(String contractTitle) {
		this.contractTitle = contractTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AccountInspection() {
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

	@Length(min=1, max=64, message="单据编号长度必须介于 1 和 64 之间")
	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	
	@Length(min=1, max=64, message="到货单编号长度必须介于 1 和 64 之间")
	public String getArrivalnum() {
		return arrivalnum;
	}

	public void setArrivalnum(String arrivalnum) {
		this.arrivalnum = arrivalnum;
	}
	
	@Length(min=1, max=64, message="送检人长度必须介于 1 和 64 之间")
	public String getInspectionman() {
		return inspectionman;
	}

	public void setInspectionman(String inspectionman) {
		this.inspectionman = inspectionman;
	}
	
	@Length(min=0, max=64, message="检验人长度必须介于 0 和 64 之间")
	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
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

	public String getBeginInspectiondate() {
		return beginInspectiondate;
	}

	public void setBeginInspectiondate(String beginInspectiondate) {
		if(beginInspectiondate!=null&&!beginInspectiondate.equals("")) {
			beginInspectiondate=beginInspectiondate+" 00:00:00";}
		this.beginInspectiondate = beginInspectiondate;
	}

	public String getEndInspectiondate() {
		return endInspectiondate;
	}

	public void setEndInspectiondate(String endInspectiondate) {
		if(endInspectiondate!=null&&!endInspectiondate.equals("")) {
			endInspectiondate=endInspectiondate+" 23:59:59";}
		this.endInspectiondate = endInspectiondate;
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

	/**
	 * @return the inspectionmode
	 */
	public String getInspectionmode() {
		return inspectionmode;
	}

	/**
	 * @param inspectionmode the inspectionmode to set
	 */
	public void setInspectionmode(String inspectionmode) {
		this.inspectionmode = inspectionmode;
	}

	/**
	 * @return the ingredient
	 */
	public String getIngredient() {
		return ingredient;
	}

	/**
	 * @param ingredient the ingredient to set
	 */
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	/**
	 * @return the granularity
	 */
	public String getGranularity() {
		return granularity;
	}

	/**
	 * @param granularity the granularity to set
	 */
	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}

	/**
	 * @return the appearance
	 */
	public String getAppearance() {
		return appearance;
	}

	/**
	 * @param appearance the appearance to set
	 */
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	/**
	 * @return the inspectionDetailstatus
	 */
	public String getInspectionDetailstatus() {
		return inspectionDetailstatus;
	}

	/**
	 * @param inspectionDetailstatus the inspectionDetailstatus to set
	 */
	public void setInspectionDetailstatus(String inspectionDetailstatus) {
		this.inspectionDetailstatus = inspectionDetailstatus;
	}

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
	
}