package com.dto;

//import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class CancelBooking {
	
	private String currentDate;
	private LocalDate currentTime;
	private boolean cancelStatus;
	private double refund;
	
	public CancelBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public boolean isCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(boolean cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public LocalDate getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(LocalDate currentTime) {
		this.currentTime = currentTime;
	}
	
	
	public double getRefund() {
		return refund;
	}

	public void setRefund(double refund) {
		this.refund = refund;
	}

}
