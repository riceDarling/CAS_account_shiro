package com.account.utils.pagebean;

import com.account.entity.Warehouse;
import com.account.utils.PageUtil;

public class WarehousePage extends PageUtil<Warehouse> {

	private String whName;	//仓库名称
	private String sTime;	//开始时间
	private String eTime;	//结束时间
	
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
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
