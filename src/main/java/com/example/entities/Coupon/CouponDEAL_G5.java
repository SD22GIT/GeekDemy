package com.example.entities.Coupon;

import java.util.List;

import com.example.constants.CouponConstants;
import com.example.entities.Programme.IProgramme;

public class CouponDEAL_G5 implements ICoupon {

	@Override
	public double getDiscount(List<IProgramme> programmes,double additionAmount) {

		if (programmes.size() < CouponConstants.COUPON_G5_PROGRAMME_LIMIT) {
			return 0;
		}
		
		double totalCost=0;
		
		for(IProgramme programme:programmes)
		{
			totalCost+=programme.getProgrammeCost();
		}

		return (totalCost+additionAmount) * CouponConstants.COUPON_DEAL_G5_DISCOUNT;
	}

	@Override
	public String getCouponName() {
		return CouponConstants.COUPON_DEAL_G5;
	}
}
