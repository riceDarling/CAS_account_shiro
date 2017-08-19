/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.account.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * 申请单Entity
 * 
 * @author admin
 * @version 2017-07-24
 */
public class AccountRequisitionDetail extends BaseModel {

	private String id;
	private AccountRequisition parent; // parent_id 父类
	private String materialcode; // 物资编码
	private String quantitiy; // 申请数量
	private Integer units; // 计量单位
	private String remarks;// 备注

	private String unit;// 计量单位字符串

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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public AccountRequisitionDetail() {
		super();
	}

	public AccountRequisitionDetail(AccountRequisition parent) {
		this.parent = parent;
	}

	@JsonBackReference
	@NotNull(message = "parent_id不能为空")
	public AccountRequisition getParent() {
		return parent;
	}

	public void setParent(AccountRequisition parent) {
		this.parent = parent;
	}

	@Length(min = 1, max = 35, message = "物资编码长度必须介于 1 和 35 之间")
	public String getMaterialcode() {
		return materialcode;
	}

	public void setMaterialcode(String materialcode) {
		this.materialcode = materialcode;
	}

	@Length(min = 1, max = 11, message = "申请数量长度必须介于 1 和 11 之间")
	public String getQuantitiy() {
		return quantitiy;
	}

	public void setQuantitiy(String quantitiy) {
		this.quantitiy = quantitiy;
	}

}