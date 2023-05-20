package com.example.entities.Programme;

import com.example.constants.ProgrammeConstants;

public class Degree implements IProgramme{
	
	private double cost = ProgrammeConstants.DEGREE_COST;

	@Override
	public String getProgrammeName() {
		return ProgrammeConstants.DEGREE;
	}

	@Override
	public double getProgrammeCost() {
		return this.cost;
	}

	@Override
	public void applyProMemberShipDiscount() {
		this.cost = this.cost - this.cost * ProgrammeConstants.DEGREE_DISCOUNT;
	}

}
