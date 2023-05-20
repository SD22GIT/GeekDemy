package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.command.AddProMembershipCommand;
import com.example.command.AddProgrammeCommand;
import com.example.command.ApplyCouponCommand;
import com.example.constants.AdditionalFees;
import com.example.entities.Student;
import com.example.entities.Coupon.CouponB4G1;
import com.example.entities.Coupon.CouponDEAL_G20;
import com.example.entities.Coupon.CouponDEAL_G5;
import com.example.entities.Programme.Certification;
import com.example.entities.Programme.Degree;
import com.example.entities.Programme.Diploma;
import com.example.entities.Programme.IProgramme;
import com.example.service.CouponService;
import com.example.service.StudentService;

import junit.framework.Assert;

public class MainTest {

	@Test
	public void testAddProgramme1() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();

		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		Assert.assertEquals(2, student.getCart().size());
	}
	
	@Test
	public void testAddProgramme2() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme diploma = new Diploma();

		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(diploma);
		Assert.assertEquals(3, student.getCart().size());
	}
	
	@Test
	public void testAddProgramme3() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme diploma = new Diploma();
		IProgramme degree = new Degree();

		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(diploma);
		studentService.addProgramme(degree);
		Assert.assertEquals(4, student.getCart().size());
	}

	@Test
	public void testBuyProMemberShip() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		studentService.buyProMemberShip();
		Assert.assertEquals(true, student.isProMembership());
	}

	@Test
	public void testDefaultProMemberShip() {
		Student student = new Student();
		Assert.assertEquals(false, student.isProMembership());
	}

	@Test
	public void testCalculateTotalProgramCost() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme diploma = new Diploma();
		IProgramme degree = new Degree();

		studentService.addProgramme(degree);
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(diploma);

		Assert.assertEquals(13500.0, studentService.calculateTotalProgramCost());
	}

	@Test
	public void calculateProMembershipDiscount() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme diploma = new Diploma();
		IProgramme degree = new Degree();

		studentService.addProgramme(degree);
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(diploma);
		studentService.buyProMemberShip();
		Assert.assertEquals(13205.0, studentService.calculateProMembershipDiscount());
	}

	@Test
	public void calculatePrintCouponDiscount() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme diploma = new Diploma();
		IProgramme degree = new Degree();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(diploma);
		studentService.addProgramme(degree);

		Assert.assertEquals(2500.0, studentService.calculatePrintCouponDiscount(AdditionalFees.PRO_MEMBERSHIP_FEE,null));
	}

	@Test
	public void testApplyCoupon() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme diploma = new Diploma();
		IProgramme diploma2 = new Diploma();

		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(diploma);
		studentService.addProgramme(diploma2);

		Assert.assertEquals(new CouponB4G1().getCouponName(), student.getCoupon().getCouponName());

		Assert.assertEquals(2500.0, student.getCoupon().getDiscount(student.getCart(), 0));

	}

	@Test
	public void testDefaultCouponCondition() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);

		Assert.assertEquals(0.0, studentService.calculatePrintCouponDiscount(AdditionalFees.PRO_MEMBERSHIP_FEE,null));
	}

	@Test
	public void testDefaultCoupon() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		IProgramme diploma = new Diploma();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);
		studentService.addProgramme(diploma);

		Assert.assertEquals(2500.0, studentService.calculatePrintCouponDiscount(AdditionalFees.PRO_MEMBERSHIP_FEE,null));
	}

	@Test
	public void testNoCoupon() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);

		Assert.assertEquals(0, 0, studentService.calculatePrintCouponDiscount(AdditionalFees.PRO_MEMBERSHIP_FEE,null));
	}

	@Test
	public void testG5CouponCondition() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme degree1 = new Degree();
		studentService.addProgramme(degree1);
		student.applyCoupon(new CouponDEAL_G5());

		Assert.assertEquals(0.0, studentService.calculatePrintCouponDiscount(AdditionalFees.PRO_MEMBERSHIP_FEE,null));
	}

	@Test
	public void testG5Coupon() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		CouponService couponService = new CouponService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);
		couponService.applyCoupon(new CouponDEAL_G5());

		Assert.assertEquals(460.0, studentService.calculatePrintCouponDiscount(AdditionalFees.PRO_MEMBERSHIP_FEE,null));
	}

	@Test
	public void testG5CouponWithoutProMembership() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);
		student.applyCoupon(new CouponDEAL_G5());

		Assert.assertEquals(450.0, studentService.calculatePrintCouponDiscount(0,null));
	}

	@Test
	public void testG20CouponCondition() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		CouponService couponService = new CouponService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);
		couponService.applyCoupon(new CouponDEAL_G20());

		Assert.assertEquals(0.0, studentService.calculatePrintCouponDiscount(AdditionalFees.PRO_MEMBERSHIP_FEE,null));
	}

	@Test
	public void testG20Coupon() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		IProgramme certification4 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);
		studentService.addProgramme(certification4);
		student.applyCoupon(new CouponDEAL_G20());

		Assert.assertEquals(2440.0, studentService.calculatePrintCouponDiscount(AdditionalFees.PRO_MEMBERSHIP_FEE,null));
	}

	@Test
	public void testG20CouponWithoutProMembership() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		IProgramme certification4 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);
		studentService.addProgramme(certification4);
		student.applyCoupon(new CouponDEAL_G20());

		Assert.assertEquals(2400.0, studentService.calculatePrintCouponDiscount(0,null));
	}

	@Test
	public void testDefaultCouponAndDealG20() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		CouponService couponService = new CouponService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		IProgramme certification4 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);
		studentService.addProgramme(certification4);
		couponService.applyCoupon(new CouponDEAL_G20());
		Assert.assertEquals(3000.0, studentService.calculatePrintCouponDiscount(0,null));
	}

	@Test
	public void testDefaultCouponAndDealG5() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		CouponService couponService = new CouponService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		IProgramme certification4 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(certification3);
		studentService.addProgramme(certification4);
		couponService.applyCoupon(new CouponDEAL_G5());
		Assert.assertEquals(3000.0, studentService.calculatePrintCouponDiscount(0,null));
	}

	@Test
	public void testCouponDealG20AndDealG5() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		CouponService couponService = new CouponService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		couponService.applyCoupon(new CouponDEAL_G5());
		couponService.applyCoupon(new CouponDEAL_G20());
		Assert.assertEquals(300.0, studentService.calculatePrintCouponDiscount(0,null));
	}

	@Test
	public void testAddProgrammeCommand() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		AddProgrammeCommand addProgram = new AddProgrammeCommand(studentService);
		String token[] = { "ADD_PROGRAMME", "CERTIFICATION", "1" };
		String token2[] = { "ADD_PROGRAMME", "DIPLOMA", "2" };
		addProgram.invoke(token);
		addProgram.invoke(token2);
		Assert.assertEquals(3, student.getCart().size());
	}

	@Test
	public void testAddProMembershipCommand() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		AddProMembershipCommand addProMemberShipCommand = new AddProMembershipCommand(studentService);
		String token[] = { "ADD_PRO_MEMBERSHIP" };
		addProMemberShipCommand.invoke(token);
		Assert.assertEquals(true, student.isProMembership());
	}

	@Test
	public void testApplyCouponCommand() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		CouponService couponService = new CouponService(student);
		AddProgrammeCommand addProgram = new AddProgrammeCommand(studentService);
		ApplyCouponCommand applyCouponCommand = new ApplyCouponCommand(couponService);
		String token[] = { "ADD_PROGRAMME", "CERTIFICATION", "1" };
		String token2[] = { "ADD_PROGRAMME", "DIPLOMA", "3" };
		addProgram.invoke(token);
		addProgram.invoke(token2);
		String token3[] = { "APPLY_COUPON", "DEAL_G20" };
		applyCouponCommand.invoke(token3);
		Assert.assertEquals("B4G1", student.getCoupon().getCouponName());
	}

	@Test
	public void testDiplomaName() {
		Diploma diploma = new Diploma();
		Assert.assertEquals("DIPLOMA", diploma.getProgrammeName());
	}

	@Test
	public void testDegreeName() {
		Degree degree = new Degree();
		Assert.assertEquals("DEGREE", degree.getProgrammeName());
	}

	@Test
	public void testCertificationName() {
		Certification certification = new Certification();
		Assert.assertEquals("CERTIFICATION", certification.getProgrammeName());
	}

	@Test
	public void testDiplomaCost() {
		Diploma diploma = new Diploma();
		Assert.assertEquals(2500.0, diploma.getProgrammeCost());
	}

	@Test
	public void testDegreeCost() {
		Degree degree = new Degree();
		Assert.assertEquals(5000.0, degree.getProgrammeCost());
	}

	@Test
	public void testCertificationCost() {
		Certification certification = new Certification();
		Assert.assertEquals(3000.0, certification.getProgrammeCost());
	}

	@Test
	public void testCouponB4G1Name() {
		CouponB4G1 coupon = new CouponB4G1();
		Assert.assertEquals("B4G1", coupon.getCouponName());
	}

	@Test
	public void testCouponDEAL_G20Name() {
		CouponDEAL_G20 coupon = new CouponDEAL_G20();
		Assert.assertEquals("DEAL_G20", coupon.getCouponName());
	}

	@Test
	public void testCouponDEAL_G5Name() {
		CouponDEAL_G5 coupon = new CouponDEAL_G5();
		Assert.assertEquals("DEAL_G5", coupon.getCouponName());
	}

	@Test
	public void testCouponB4G1Discount() {
		CouponB4G1 coupon = new CouponB4G1();
		List<IProgramme> programmes = new ArrayList<>();
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		IProgramme certification4 = new Certification();
		programmes.add(certification1);
		programmes.add(certification2);
		programmes.add(certification3);
		programmes.add(certification4);
		double discount = coupon.getDiscount(programmes, 0);

		Assert.assertEquals(3000.0, discount);
	}

	@Test
	public void testCouponDEAL_G20Discount() {
		CouponDEAL_G20 coupon = new CouponDEAL_G20();
		List<IProgramme> programmes = new ArrayList<>();
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		IProgramme certification4 = new Certification();
		programmes.add(certification1);
		programmes.add(certification2);
		programmes.add(certification3);
		programmes.add(certification4);
		double discount = coupon.getDiscount(programmes, 0);

		Assert.assertEquals(2400.0, discount);
	}

	@Test
	public void testCouponDEAL_G5Discount() {
		CouponDEAL_G5 coupon = new CouponDEAL_G5();
		List<IProgramme> programmes = new ArrayList<>();
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme certification3 = new Certification();
		IProgramme certification4 = new Certification();
		programmes.add(certification1);
		programmes.add(certification2);
		programmes.add(certification3);
		programmes.add(certification4);
		double discount = coupon.getDiscount(programmes, 0);

		Assert.assertEquals(600.0, discount);
	}
	
	@Test
	public void testPrintStatement() {
		StudentService studentService = new StudentService(null);
		String statement =  studentService.printStatement("SUB_TOTAL", 13000);
		System.out.println(statement);
		Assert.assertEquals("SUB_TOTAL 13000.00\n", statement);
	}
	
	@Test
	public void testPrintMethod() {
		Student student = new Student();
		StudentService studentService = new StudentService(student);
		IProgramme certification1 = new Certification();
		IProgramme certification2 = new Certification();
		IProgramme diploma = new Diploma();
		IProgramme degree = new Degree();
		studentService.addProgramme(certification1);
		studentService.addProgramme(certification2);
		studentService.addProgramme(diploma);
		studentService.addProgramme(degree);
		studentService.buyProMemberShip();
		String statement =  studentService.printBill();
		Assert.assertEquals("SUB_TOTAL 13405.00\nCOUPON_DISCOUNT B4G1 2475.00\nTOTAL_PRO_DISCOUNT 295.00\nPRO_MEMBERSHIP_FEE 200.00\nENROLLMENT_FEE 0.00\nTOTAL 10930.00\n", statement);
	}
	}