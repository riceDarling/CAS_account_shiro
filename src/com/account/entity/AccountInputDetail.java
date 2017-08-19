package com.account.entity;
import org.hibernate.validator.constraints.Length;


/**
 * 入库单子表
 */
public class AccountInputDetail{
	
	private String id;
	private String parent_id;		// 主表ordernum
	private String warehouse;		// 仓库
	private String materialname;		// 物资名称
	private String location;		// 货位编码
	private String size;		// 规格型号
	private String quantity;		// 入库数量
	private String remarks;//备注信息
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

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	@Length(min=1, max=37, message="仓库长度必须介于 1 和 37 之间")
	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
	@Length(min=1, max=35, message="物资名称长度必须介于 1 和 35 之间")
	public String getMaterialname() {
		return materialname;
	}

	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}
	
	@Length(min=0, max=255, message="货位编码长度必须介于 0 和 255 之间")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Length(min=1, max=35, message="规格型号长度必须介于 1 和 35 之间")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	@Length(min=1, max=11, message="入库数量长度必须介于 1 和 11 之间")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
	
}