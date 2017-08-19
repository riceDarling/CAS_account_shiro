/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.account.entity;

import java.util.Date;

import com.account.utils.PageUtil;

/**
 * 询价单Entity
 * 
 * @author 宿通
 * @version 2017-06-25
 */
public class AccountInquiry extends BaseModel {

	private String id;
	private String inquirynum; // 询价单号
	private String ordernum; // 单据编号
	private Date validdate; // 询价有效期限
	private String inquiry;// 询价人

	private String requisition; // 申请编号
	private String maker; // 制单人

	private String status; // 状态值
	private String title; // 标题

	private String comment;// 流程过程中的意见

	private String conclusion;// 流程同意是否
	private String checker; // 审核人


	private PageUtil<AccountInquiry> page;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public PageUtil<AccountInquiry> getPage() {
		return page;
	}

	public void setPage(PageUtil<AccountInquiry> page) {
		this.page = page;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInquiry() {
		return inquiry;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

	public String getInquirynum() {
		return inquirynum;
	}

	public void setInquirynum(String inquirynum) {
		this.inquirynum = inquirynum;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public Date getValiddate() {
		return validdate;
	}

	public void setValiddate(Date validdate) {
		this.validdate = validdate;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getRequisition() {
		return requisition;
	}

	public void setRequisition(String requisition) {
		this.requisition = requisition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}