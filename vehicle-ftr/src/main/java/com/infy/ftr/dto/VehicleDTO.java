package com.infy.ftr.dto;


import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infy.ftr.entity.Vehicle;
import com.infy.ftr.utility.DoubleIntegerValidation;
import com.infy.ftr.utility.EnumValidator;
import com.infy.ftr.utility.VehicleStatusEnum;




public class VehicleDTO {
	
	@NotNull(message = "{vehicle.vehicleNumber.must}")
	@Pattern(regexp = "(([A-Za-z]{2})[0-9]{4})", message = "{vehicle.vehicleNumber.invalid}")
	private String vehicleNumber;
	
	@NotEmpty(message = "{vehicle.vehicleName.must}")
	@Size(max = 30, message = "{vehicle.vehicleName.invalid}")
	@Pattern(regexp = "(?i)(Tower crane|FirePlace Crane|Double treadwheel Crane|Crawler Crane|Aerial Crane|Deck Crane)", message = "{vehicle.vehicleName.invalid}")
	private String vehicleName;
	
	@NotNull(message = "{vehicle.maxLiftingCapacity.must}")
	@DoubleIntegerValidation(message = "{vehicle.maxLiftingCapacity.invalid}")
	private Double maxLiftingCapacity;
	
	@NotNull(message = "{vehicle.retireDate.must}")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
	private Date retireDate;
	
	@NotNull(message = "{vehicle.vehicleStatus.must}")
	@EnumValidator(enumClass = VehicleStatusEnum.class, message = "{vehicle.vehicleStatus.invalid}")
	private String vehicleStatus;
	
	@NotNull(message = "{vehicle.harborLocation.must}")
	@Size(min = 5, max = 25, message = "{vehicle.harborLocation.invalid}")
	@Pattern(regexp = "^[A-Za-z][A-Za-z ]*$" , message = "{vehicle.harborLocation.invalid}")
	private String harborLocation;
	
	@NotNull(message = "{vehicle.country.must}")
	@Size(min = 5, max = 25, message = "{vehicle.country.invalid}")
	@Pattern(regexp = "^[A-Za-z][A-Za-z ]*$" , message = "{vehicle.country.invalid}")
	private String country;
	
	public VehicleDTO() {
		
	}

	public VehicleDTO(String vehicleNumber, String vehicleName, Double maxLiftingCapacity, Date retireDate,
			String vehicleStatus, String harborLocation, String country) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.maxLiftingCapacity = maxLiftingCapacity;
		this.retireDate = retireDate;
		this.vehicleStatus = vehicleStatus;
		this.harborLocation = harborLocation;
		this.country = country;
	}

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

	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public String getHarborLocation() {
		return harborLocation;
	}

	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "VehicleDTO [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", maxLiftingCapacity="
				+ maxLiftingCapacity + ", retireDate=" + retireDate + ", vehicleStatus=" + vehicleStatus
				+ ", harborLocation=" + harborLocation + ", country=" + country + "]";
	}
	
	
	
	public static Vehicle prepareVehicleEntity(VehicleDTO dto) {
		
		Vehicle vehicleEntity = new Vehicle();
		
		vehicleEntity.setVehicleNumber(dto.getVehicleNumber());
		vehicleEntity.setVehicleName(dto.getVehicleName());
		vehicleEntity.setMaxLiftingCapacity(dto.getMaxLiftingCapacity());
		vehicleEntity.setRetireDate(dto.getRetireDate());
		vehicleEntity.setVehicleStatus(dto.getVehicleStatus());
		vehicleEntity.setCountry(dto.getCountry());
		vehicleEntity.setHarborLocation(dto.getHarborLocation());
		
		return vehicleEntity;
	}
	
	public static VehicleDTO prepareVehicleDTO(Vehicle veh) {
		
		VehicleDTO vehicleDTO = new VehicleDTO();
		
		vehicleDTO.setVehicleNumber(veh.getVehicleNumber());
		vehicleDTO.setVehicleName(veh.getVehicleName());
		vehicleDTO.setMaxLiftingCapacity(veh.getMaxLiftingCapacity());
		vehicleDTO.setRetireDate(veh.getRetireDate());
		vehicleDTO.setVehicleStatus(veh.getVehicleStatus());
		vehicleDTO.setCountry(veh.getCountry());
//		System.out.println("Getting Harbour  "+ veh.getHarborLocation());
		vehicleDTO.setHarborLocation(veh.getHarborLocation());
		
		return vehicleDTO;
	}
	
	
	
	
	
	
	
	
	

}
