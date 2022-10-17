package com.infy.ftr.dto;

public class VechicleWorkItemDTO {

	private String workItemId;
	private String vehicleNumber;
	private String assignedWorkItemStatus;

	public String getWorkItemId() {
		return workItemId;
	}

	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getAssignedWorkItemStatus() {
		return assignedWorkItemStatus;
	}

	public void setAssignedWorkItemStatus(String assignedWorkItemStatus) {
		this.assignedWorkItemStatus = assignedWorkItemStatus;
	}

}
