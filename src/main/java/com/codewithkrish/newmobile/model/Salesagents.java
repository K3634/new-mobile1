package com.codewithkrish.newmobile.model;

public class Salesagents {
    private int sId;
    private String sName;
    private String sAddress;
    private String mobileNo;
    private String branch;
	 public Salesagents() {
		
	}
	public Salesagents(String sName, String sAddress, String mobileNo, String branch) {
		super();
		this.sName = sName;
		this.sAddress = sAddress;
		this.mobileNo = mobileNo;
		this.branch = branch;
	}
	public Salesagents(int sId, String sName, String sAddress, String mobileNo, String branch) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sAddress = sAddress;
		this.mobileNo = mobileNo;
		this.branch = branch;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
    
    
 }
