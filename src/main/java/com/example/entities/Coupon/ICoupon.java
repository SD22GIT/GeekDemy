package com.example.entities.Coupon;

import java.util.List;

import com.example.entities.Programme.IProgramme;

public interface ICoupon {
	
	public String getCouponName();
	public double getDiscount(List<IProgramme> programmes,double additionAmount);

}
