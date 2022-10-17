package com.infy.ftr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ftr_vehicle_workitem")
public class VechicleWorkItem {

	@Id
	@Column(name="work_item_id")
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
