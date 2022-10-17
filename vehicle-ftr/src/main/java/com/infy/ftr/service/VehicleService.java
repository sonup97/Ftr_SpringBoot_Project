package com.infy.ftr.service;


import java.util.List;

import com.infy.ftr.dto.VehicleDTO;
import com.infy.ftr.exception.VehichleStatusExistException;
import com.infy.ftr.exception.VehicleFtrException;
import com.infy.ftr.exception.VehicleNotFoundException;


public interface VehicleService {
	
	public String insertNewVehicle(VehicleDTO vehicleDto) throws VehicleFtrException;
	
	public List<VehicleDTO> fetchAvailableVehicles() throws VehicleNotFoundException;
	
	public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName)throws VehicleNotFoundException;
	
	public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws VehicleNotFoundException;
	
	public String updateVehicleStatus(String vehicleNumber, VehicleDTO dto) throws VehicleNotFoundException, VehichleStatusExistException, VehicleFtrException;
	
	public String removeVehicle(String vehicleNumber) throws VehicleNotFoundException;
	
	public List<VehicleDTO> fetchVehicleByHarbor(String harborLocation) throws VehicleNotFoundException;
}
