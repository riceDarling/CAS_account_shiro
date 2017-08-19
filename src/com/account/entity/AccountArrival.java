package com.account.entity;
/**
 * 到货单
 */
public class AccountArrival {
	
	private String id;
	private String ordernum;//到货单号
	private String contractId;		// 合同ID
	private String materialId;		// 采购商品ID
	private String  arrivalDate;		// 到货日期
	private String tobeNum;		// 应到数量
	private String arrivalNum;		// 实到数量
	private String contractTitle; //合同名称
	private String supplier;  //供应商名称
	private String materialName; //采购物资名称
	private String status;	//合同状态
	private String size;	//规格型号
	private String arrivalId; //到货ID（仅查询使用）
	private String contractnum;		// 合同编号
	private String purchasenum;		//采购订货单编号
	private String quantity;	//合同签订物资数量
	private String delFlag="0";//是否删除
	private String arrivalstatus="0";//到货状态 是否已送检
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
	 * @return the contractId
	 */
	public String getContractId() {
		return contractId;
	}
	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	/**
	 * @return the materialId
	 */
	public String getMaterialId() {
		return materialId;
	}
	/**
	 * @param materialId the materialId to set
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	
	
	/**
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * @return the tobeNum
	 */
	public String getTobeNum() {
		return tobeNum;
	}
	/**
	 * @param tobeNum the tobeNum to set
	 */
	public void setTobeNum(String tobeNum) {
		this.tobeNum = tobeNum;
	}
	/**
	 * @return the arrivalNum
	 */
	public String getArrivalNum() {
		return arrivalNum;
	}
	/**
	 * @param arrivalNum the arrivalNum to set
	 */
	public void setArrivalNum(String arrivalNum) {
		this.arrivalNum = arrivalNum;
	}
	/**
	 * @return the contractTitle
	 */
	public String getContractTitle() {
		return contractTitle;
	}
	/**
	 * @param contractTitle the contractTitle to set
	 */
	public void setContractTitle(String contractTitle) {
		this.contractTitle = contractTitle;
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
	 * @return the materialName
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * @param materialName the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
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
	/**
	 * @return the arrivalId
	 */
	public String getArrivalId() {
		return arrivalId;
	}
	/**
	 * @param arrivalId the arrivalId to set
	 */
	public void setArrivalId(String arrivalId) {
		this.arrivalId = arrivalId;
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
	 * @return the purchasenum
	 */
	public String getPurchasenum() {
		return purchasenum;
	}
	/**
	 * @param purchasenum the purchasenum to set
	 */
	public void setPurchasenum(String purchasenum) {
		this.purchasenum = purchasenum;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
	 * @return the arrivalstatus
	 */
	public String getArrivalstatus() {
		return arrivalstatus;
	}
	/**
	 * @param arrivalstatus the arrivalstatus to set
	 */
	public void setArrivalstatus(String arrivalstatus) {
		this.arrivalstatus = arrivalstatus;
	}
	
	
	
}