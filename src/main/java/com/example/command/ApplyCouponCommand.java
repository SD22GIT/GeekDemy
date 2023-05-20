package com.example.command;

import com.example.entities.Coupon.CouponDEAL_G20;
import com.example.entities.Coupon.CouponDEAL_G5;
import com.example.service.CouponService;

public class ApplyCouponCommand implements ICommand {

	private CouponService couponService;

	public ApplyCouponCommand(CouponService couponService) {
		this.couponService = couponService;
	}

	@Override
	public void invoke(String tokens[]) {

		String coupon = tokens[1];

		if (coupon.equalsIgnoreCase("DEAL_G20")) {
			couponService.applyCoupon(new CouponDEAL_G20());
		}

		if (coupon.equalsIgnoreCase("DEAL_G5")) {
			couponService.applyCoupon(new CouponDEAL_G5());
		}

	}

}
