package com.example.entities.Coupon;

import java.util.List;

import com.example.constants.CouponConstants;
import com.example.entities.Programme.IProgramme;

public class CouponB4G1 implements ICoupon {

	@Override
	public double getDiscount(List<IProgramme> programmes,double additionAmount) {
		
		if(programmes.size()<CouponConstants.COUPON_B4G1_PROGRAMME_LIMIT)
		{
		return 0;	
		}
		
		double minimunProgrammePrice = programmes.get(0).getProgrammeCost();
		
		for(int i=1;i<programmes.size();++i)
		{
			if(programmes.get(i).getProgrammeCost()<minimunProgrammePrice)
			{
				minimunProgrammePrice = programmes.get(i).getProgrammeCost();
			}
		}
		
		return minimunProgrammePrice;
	}

	@Override
	public String getCouponName() {
		return CouponConstants.COUPON_B4G1;
	}

}
