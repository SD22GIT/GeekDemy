package com.example.entities.Programme;

import com.example.constants.ProgrammeConstants;

public class Certification implements IProgramme {

	private double cost = ProgrammeConstants.CERTIFICATION_COST;

	@Override
	public String getProgrammeName() {
		return ProgrammeConstants.CERTIFICATION;
	}

	@Override
	public double getProgrammeCost() {
		return this.cost;
	}

	@Override
	public void applyProMemberShipDiscount() {
		this.cost = this.cost - this.cost * ProgrammeConstants.CERTIFICATION_DISCOUNT;
	}

}
