package com.account.utils.pagebean;

import com.account.entity.ParaInfo;
import com.account.utils.PageUtil;

public class ParaInfoPage extends PageUtil<ParaInfo> {

	private String pName;	//单位名称
	private String pId;	//父级ID
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
}
