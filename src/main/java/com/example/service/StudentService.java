package com.example.service;

import com.example.constants.AdditionalFees;
import com.example.entities.Student;
import com.example.entities.Coupon.ICoupon;
import com.example.entities.Programme.IProgramme;

public class StudentService {

	private Student student;

	public StudentService(Student student) {
		this.student = student;
	}

	public void addProgramme(IProgramme programme) {
		student.addProgramme(programme);
	}

	public void applyCoupon(ICoupon coupon) {
		student.applyCoupon(coupon);
	}

	public void buyProMemberShip() {
		student.buyProMembership();
	}

	public String printBill() {

		double proMembershipFee = 0;
		double proMembershipDiscount = 0;
		double subTotal = 0;
		double enrollmenrFee = 0;

		double totalProgrammeCost = calculateTotalProgramCost();

		if (student.isProMembership()) {
			proMembershipFee = AdditionalFees.PRO_MEMBERSHIP_FEE;
			double totalProgrammeAfterProMembershipDiscount = calculateProMembershipDiscount();
			proMembershipDiscount = totalProgrammeCost - totalProgrammeAfterProMembershipDiscount;
			totalProgrammeCost = totalProgrammeAfterProMembershipDiscount;
		}
		StringBuilder finalOutput = new StringBuilder("");
		subTotal = totalProgrammeCost + proMembershipFee;
		finalOutput.append(printStatement("SUB_TOTAL", subTotal));

		if (totalProgrammeCost < AdditionalFees.ENROLLMENT_FEE_LIMIT) {
			enrollmenrFee = AdditionalFees.ENROLLMENT_FEE;
		}

		double discount = calculatePrintCouponDiscount(proMembershipFee,finalOutput);

		finalOutput.append(printStatement("TOTAL_PRO_DISCOUNT", proMembershipDiscount));
		finalOutput.append(printStatement("PRO_MEMBERSHIP_FEE", proMembershipFee));
		finalOutput.append(printStatement("ENROLLMENT_FEE", enrollmenrFee));
		finalOutput.append(printStatement("TOTAL", subTotal + enrollmenrFee - discount));
		
		System.out.println(finalOutput.toString());
		
		return finalOutput.toString();
		
	}

	public double calculateTotalProgramCost() {
		double totalProgrammeCost = 0;
		for (IProgramme programme : student.getCart()) {
			totalProgrammeCost += programme.getProgrammeCost();
		}
		return totalProgrammeCost;
	}

	public double calculateProMembershipDiscount() {
		double totalProgrammeAfterProMembershipDiscount = 0;
		for (IProgramme programme : student.getCart()) {
			programme.applyProMemberShipDiscount();
			totalProgrammeAfterProMembershipDiscount += programme.getProgrammeCost();
		}

		return totalProgrammeAfterProMembershipDiscount;
	}

	public double calculatePrintCouponDiscount(double proMembershipFee,StringBuilder finalOutput) {
		double discount = 0;
		String couponName = "NONE";
		if (this.student.getCoupon() != null) {
			couponName = this.student.getCoupon().getCouponName();
			discount = this.student.getCoupon().getDiscount(student.getCart(), proMembershipFee);
		}
		if(finalOutput!=null)
		finalOutput.append(printStatement("COUPON_DISCOUNT " + couponName, discount));
		return discount;
	}

	public String printStatement(String title, double value) {
		String decimalFormat = "%.2f";
		return title + " " + String.format(decimalFormat, value)+"\n";
	}
}
