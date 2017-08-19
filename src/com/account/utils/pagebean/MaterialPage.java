package com.account.utils.pagebean;

import com.account.entity.Material;
import com.account.utils.PageUtil;

public class MaterialPage extends PageUtil<Material> {

	private String mName;	//仓库名称
	private String sTime;	//开始时间
	private String eTime;	//结束时间
	
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
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
