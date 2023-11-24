package com.railworld.model;

public class Company {
	
	private int companyId;
	private String companyName;
	private int noOfEmployess;
	private int employed;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int companyId, String companyName, int noOfEmployess, int employed) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.noOfEmployess = noOfEmployess;
		this.employed = employed;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getNoOfEmployess() {
		return noOfEmployess;
	}
	public void setNoOfEmployess(int noOfEmployess) {
		this.noOfEmployess = noOfEmployess;
	}
	public int getEmployed() {
		return employed;
	}
	public void setEmployed(int employed) {
		this.employed = employed;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", noOfEmployess=" + noOfEmployess
				+ ", employed=" + employed + "]";
	}
	

}
