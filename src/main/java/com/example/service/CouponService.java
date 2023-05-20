package com.example.service;

import com.example.entities.Student;
import com.example.entities.Coupon.CouponB4G1;
import com.example.entities.Coupon.ICoupon;

public class CouponService {
	
private Student student;
	
	public CouponService(Student student)
	{
		this.student = student;
	}
	
	public void applyCoupon(ICoupon coupon)
	{
		double currentDiscount=0;
		if(this.student.getCoupon()!=null)
		{
		currentDiscount = this.student.getCoupon().getDiscount(student.getCart(),0);
		if(currentDiscount>0)
		{
			if( this.student.getCoupon() instanceof CouponB4G1)
			{
				return;
			}
		}
		}
		
		
		double newDiscount = coupon.getDiscount(student.getCart(),0);
		
		if(newDiscount>currentDiscount)
		{
			this.student.applyCoupon(coupon);
		}
	}

}
