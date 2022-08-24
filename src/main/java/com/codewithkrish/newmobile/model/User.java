package com.codewithkrish.newmobile.model;

public class User {
	   private int userID;
	   private String userName;
	   private String address;
	   private String contactNo;
	   private String branchNo;
	   private String userPassword;
	   private int roleID;

	   public User() {
		
	   }

		public User(String userName, String address, String contactNo, String branchNo, String userPassword, int roleID) {
			super();
			this.userName = userName;
			this.address = address;
			this.contactNo = contactNo;
			this.branchNo = branchNo;
			this.userPassword = userPassword;
			this.roleID = roleID;
		}

		public User(int userID, String userName, String address, String contactNo, String branchNo, String userPassword,
				int roleID) {
			super();
			this.userID = userID;
			this.userName = userName;
			this.address = address;
			this.contactNo = contactNo;
			this.branchNo = branchNo;
			this.userPassword = userPassword;
			this.roleID = roleID;
		}

		public int getUserID() {
			return userID;
		}

		public void setUserID(int userID) {
			this.userID = userID;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getContactNo() {
			return contactNo;
		}

		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}

		public String getBranchNo() {
			return branchNo;
		}

		public void setBranchNo(String branchNo) {
			this.branchNo = branchNo;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

		public int getRoleID() {
			return roleID;
		}

		public void setRoleID(int roleID) {
			this.roleID = roleID;
		}
	   
		
	   
	   
	   
	}
