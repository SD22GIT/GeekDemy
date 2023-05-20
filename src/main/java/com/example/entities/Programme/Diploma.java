package com.example.entities.Programme;

import com.example.constants.ProgrammeConstants;

public class Diploma implements IProgramme {

	private double cost = ProgrammeConstants.DIPLOMA_COST;

	@Override
	public String getProgrammeName() {
		return ProgrammeConstants.DIPLOMA;
	}

	@Override
	public double getProgrammeCost() {
		return this.cost;
	}

	@Override
	public void applyProMemberShipDiscount() {
		this.cost = this.cost - this.cost * ProgrammeConstants.DIPLOMA_DISCOUNT;
	}

}
