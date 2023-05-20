package com.example.entities.Coupon;

import java.util.List;

import com.example.constants.CouponConstants;
import com.example.entities.Programme.IProgramme;

public class CouponDEAL_G20 implements ICoupon {

	@Override
	public double getDiscount(List<IProgramme> programmes,double additionAmount) {
		
		double totalAmount=0;
		
		for(IProgramme programme:programmes)
		{
			totalAmount+=programme.getProgrammeCost();
		}
		
		if(totalAmount<CouponConstants.COUPON_DEAL_G20_AMOUNT_LIMIT)
		{
			return 0;
		}
		
		return (totalAmount+additionAmount) * CouponConstants.COUPON_DEAL_G20_DISCOUNT;
	}

	@Override
	public String getCouponName() {
		return CouponConstants.COUPON_DEAL_G20;
	}

}
