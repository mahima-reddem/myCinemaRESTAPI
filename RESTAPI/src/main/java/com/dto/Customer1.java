package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Customer1 {
	
	@Id@GeneratedValue
	private int customerId;
	private String custName;
	private String custMobileno;
	private String custEmail;
	private String password;
	private int otp;
	
	
	private List<Ticket> ticketList =new ArrayList<Ticket>();
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMobileno() {
		return custMobileno;
	}

	public void setCustMobileno(String custMobileno) {
		this.custMobileno = custMobileno;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer1 [customerId=" + customerId + ", custName=" + custName + ", custMobileno=" + custMobileno
				+ ", custEmail=" + custEmail + ", password=" + password + ",otp=" + otp + ", ticketList=" + ticketList
				+ "]";
	}
}
