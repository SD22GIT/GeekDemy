package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import com.example.entities.Coupon.CouponB4G1;
import com.example.entities.Coupon.ICoupon;
import com.example.entities.Programme.IProgramme;


public class Student {
	
	private List<IProgramme> cart;
	private boolean proMembership;
	private ICoupon coupon;
	
	public Student()
	{
		this.cart = new ArrayList<>();
		this.proMembership=false;
		this.coupon=null;
	}

	public List<IProgramme> getCart() {
		return cart;
	}

	public boolean isProMembership() {
		return proMembership;
	}

	public ICoupon getCoupon() {
		return coupon;
	}
	
	public void addProgramme(IProgramme programme)
	{
		this.cart.add(programme);
		if(this.cart.size()>=4)
		{
			this.coupon=new CouponB4G1();
		}
	}
	
	public void buyProMembership()
	{
		this.proMembership=true;
	}
	
	public void applyCoupon(ICoupon coupon)
	{
			this.coupon = coupon;
	}
	}
