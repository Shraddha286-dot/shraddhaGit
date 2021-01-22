package com.capg.onlineservices.models;

import javax.persistence.Column;

public class PaymentSlip {

	private double hra,coupon,PF,anotherPF,tax,profftax ,others,basicsal,monthsal,ctc,netsal;
	//private int employeeId;
	//private String employeeFname, employeeLname , employeeAddress;
	
	public PaymentSlip(double hra, double coupon, double pF, double anotherPF, double tax, double profftax,
			double others, double basicsal, double monthsal, double ctc, double netsal) {
		super();
		this.hra = hra;
		this.coupon = coupon;
		PF = pF;
		this.anotherPF = anotherPF;
		this.tax = tax;
		this.profftax = profftax;
		this.others = others;
		this.basicsal = basicsal;
		this.monthsal = monthsal;
		this.ctc = ctc;
		this.netsal = netsal;
	}
	
	/*public PaymentSlip( int employeeId,String employeeFname, String employeeLname, String employeeAddress) {
		this.employeeId = employeeId;
		this.employeeFname = employeeFname;
		this.employeeLname = employeeLname;
		this.employeeAddress = employeeAddress;
	}*/
	
	/*
	 * public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFname() {
		return employeeFname;
	}

	public void setEmployeeFname(String employeeFname) {
		this.employeeFname = employeeFname;
	}

	public String getEmployeeLname() {
		return employeeLname;
	}

	public void setEmployeeLname(String employeeLname) {
		this.employeeLname = employeeLname;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	 */
	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getCoupon() {
		return coupon;
	}

	public void setCoupon(double coupon) {
		this.coupon = coupon;
	}

	

	public double getPF() {
		return PF;
	}

	public void setPF(double pF) {
		PF = pF;
	}

	public double getAnotherPF() {
		return anotherPF;
	}

	public void setAnotherPF(double anotherPF) {
		this.anotherPF = anotherPF;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getProfftax() {
		return profftax;
	}

	public void setProfftax(double profftax) {
		this.profftax = profftax;
	}

	public double getOthers() {
		return others;
	}

	public void setOthers(double others) {
		this.others = others;
	}

	public double getBasicsal() {
		return basicsal;
	}

	public void setBasicsal(double basicsal) {
		this.basicsal = basicsal;
	}

	public double getMonthsal() {
		return monthsal;
	}

	public void setMonthsal(double monthsal) {
		this.monthsal = monthsal;
	}

	public double getCtc() {
		return ctc;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

	public double getNetsal() {
		return netsal;
	}

	public void setNetsal(double netsal) {
		this.netsal = netsal;
	}

	
	
}