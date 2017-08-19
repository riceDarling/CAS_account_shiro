package com.account.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

/**
 * 订货供应商Entity
 * 
 * @author admin
 * @version 2017-07-26
 */
public class AccountPurchaseSupplier extends BaseModel {

	private Integer id;
	private AccountPurchase parent; // parent_id
	private String supplier;// 供应商名称
	private Date deadline; // 付款期限
	private String payway; // 付款方式

	private String payways;// 付款方式字符串

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayways() {
		return payways;
	}

	public void setPayways(String payways) {
		this.payways = payways;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public AccountPurchaseSupplier() {
		super();
	}

	public AccountPurchase getParent() {
		return parent;
	}

	public void setParent(AccountPurchase parent) {
		this.parent = parent;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Length(min = 0, max = 11, message = "付款方式长度必须介于 0 和 11 之间")
	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

}