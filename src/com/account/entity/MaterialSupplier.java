package com.account.entity;

public class MaterialSupplier {
	private Integer id;

	private String supplierid;

	private String material;

	private String supplier;// 供应商名称，只做查询

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid == null ? null : supplierid.trim();
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material == null ? null : material.trim();
	}
}