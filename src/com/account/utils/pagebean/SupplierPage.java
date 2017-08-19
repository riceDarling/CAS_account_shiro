package com.account.utils.pagebean;

import com.account.entity.AccountSupplier;
import com.account.utils.PageUtil;

public class SupplierPage extends PageUtil<AccountSupplier> {

	private String sName;	//供应商名称
	private String sTime;	//开始时间
	private String eTime;	//结束时间
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
}
