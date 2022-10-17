package com.infy.ftr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ftr_vehicles")
public class Vehicle {
	
	@Id
	private String vehicleNumber;
	private String vehicleName;
	private Double maxLiftingCapacity;
	private Date retireDate;
	private String vehicleStatus;
	private String country;
	private String harborLocation;
	
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Double getMaxLiftingCapacity() {
		return maxLiftingCapacity;
	}
	public void setMaxLiftingCapacity(Double maxLiftingCapacity) {
		this.maxLiftingCapacity = maxLiftingCapacity;
	}
	public Date getRetireDate() {
		return retireDate;
	}
	public void setRetireDate(Date date) {
		this.retireDate = date;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHarborLocation() {
		return harborLocation;
	}
	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}
	
	
	@Override
	public String toString() {
		return "Vehicle [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", maxLiftingCapacity="
				+ maxLiftingCapacity + ", retireDate=" + retireDate + ", vehicleStatus=" + vehicleStatus + ", country="
				+ country + ", harborLocation=" + harborLocation + "]";
	}
	
	
	
	
	

}
