package com.infy.ftr.utility;

public enum VehicleStatusEnum {
	
	ACTIVE("Active"),
	RETIRED("Retired"),
	INPROGRESS("InProgress");
	
	private final String value;

	VehicleStatusEnum(String string) {
		
		this.value = string;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
