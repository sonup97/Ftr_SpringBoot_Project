package com.infy.ftr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.infy.ftr.dto.VehicleDTO;
import com.infy.ftr.entity.Vehicle;
import com.infy.ftr.exception.VehichleStatusExistException;
import com.infy.ftr.exception.VehicleFtrException;
import com.infy.ftr.exception.VehicleNotFoundException;
import com.infy.ftr.repository.VehicleRepository;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${vehicle.create.success}")
	private String creationMessage;
	
	@Value("${vehicle.update.success}")
	private String updateMessage;
	
	@Value("${vehicle.delete.success}")
	private String deleteMessage;
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	
	
	public String insertNewVehicle(VehicleDTO vehicleDto) throws VehicleFtrException  {
		
		logger.info("Service -> insertNewVehicle");
		
		if(vehicleRepo.findByVehicleNumber(vehicleDto.getVehicleNumber()) != null){
			
			logger.info("Vehicle already exists");
			
			throw new VehicleFtrException("vehicle.alreadyexists");
		}
		else if(vehicleRepo.saveAndFlush(VehicleDTO.prepareVehicleEntity(vehicleDto)) != null){
			
			logger.info("Inserting a new vehicle detail successfully");
			
			return creationMessage + " " + vehicleDto.getVehicleNumber();
		}
		else {
			
			logger.info("Invalid data. Please check");
			
			return "Invalid data. Please check";
		}
		
		
	}
	
	
	public List<VehicleDTO> fetchAvailableVehicles()  throws VehicleNotFoundException {
		
		logger.info("Service -> fetchAvailableVehicles");
		
		List<Vehicle> vList = vehicleRepo.findAll();
		List<VehicleDTO> vListDTO = null;
		
		if(!(vList.isEmpty())) {
			
			vListDTO = new ArrayList<>();
			
			for(Vehicle vehicle : vList) {
				
				VehicleDTO vehicleDTO = VehicleDTO.prepareVehicleDTO(vehicle);
				vListDTO.add(vehicleDTO);
			}
			
			logger.info("Vehicle details retrieved. List of vehicles {}", vListDTO);
			
			return vListDTO;
		}
		else {
			
			logger.info("Vehicle details not found");
			
			throw new VehicleNotFoundException();
		}
		
	}
	
	

	public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleNotFoundException  {
		
		logger.info("Service -> fetchVehicleDetailsByVehicleName");
		
		List<Vehicle> vList = vehicleRepo.findByVehicleName(vehicleName);
		List<VehicleDTO> vListDTO = null;
		
		if(!(vList.isEmpty())) {
			
			vListDTO = new ArrayList<>();
			
			for(Vehicle vehicle : vList) {
				
				VehicleDTO vehicleDTO = VehicleDTO.prepareVehicleDTO(vehicle);
				vListDTO.add(vehicleDTO);
			}
			
			logger.info("Vehicle details retrieved. List of vehicles {}", vListDTO);
			
			return vListDTO;
		}
		else {
			
			logger.info("Vehicle details not found");
			
			throw new VehicleNotFoundException();
		}
		
		
	}
	
	
	public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber)  throws VehicleNotFoundException {
		
		logger.info("Service -> fetchVehicleDetailsByVehicleNumber");
		
		Vehicle vehicle = vehicleRepo.findByVehicleNumber(vehicleNumber);
		VehicleDTO vehicleDTO = null;
		
		if(vehicle != null) {
			
			vehicleDTO = VehicleDTO.prepareVehicleDTO(vehicle);
			
			logger.info("Vehicle details retrieved. Details of vehicles {}", vehicleDTO);
			
			return vehicleDTO;
		}
		else {
			
			logger.info("Vehicle details not found");
			
			throw new VehicleNotFoundException();
		}
		
		
	}
	
	
	public String updateVehicleStatus(String vehicleNumber, VehicleDTO dto) throws VehicleNotFoundException, VehichleStatusExistException, VehicleFtrException {
		
		logger.info("Service -> updateVehicleStatus");
		
		Vehicle vehicle = vehicleRepo.findByVehicleNumber(vehicleNumber);
		
		if(vehicle == null) {
			
			logger.info("Vehicle details not found");
			
			throw new VehicleNotFoundException();
		}
		else if(vehicle.getVehicleStatus().equals(dto.getVehicleStatus())) {
			
			logger.info("Vehicle Status is already : {}", dto.getVehicleStatus());
			
			throw new VehichleStatusExistException(dto.getVehicleStatus());
		}
		else if(dto.getVehicleStatus().equals("Active") || dto.getVehicleStatus().equals("Retired") || dto.getVehicleStatus().equals("InProgress")){
			
			logger.info("Vehicle Status successfully changed");
			
			vehicle.setVehicleStatus(dto.getVehicleStatus());
			vehicleRepo.save(vehicle);
			
			return updateMessage + " " + vehicle.getVehicleStatus();
		}
		else {
			
			logger.info("Invalid data, Vehicle status Should be Active or Inprogress or Retired");
			
			throw new VehicleFtrException("invalid.data");
		}
		
	}
	
	

	public String removeVehicle(String vehicleNumber) throws VehicleNotFoundException {
		
		logger.info("Service -> removeVehicle");
		
		Vehicle vehicle = vehicleRepo.findByVehicleNumber(vehicleNumber);
		
		if(vehicle != null) {
			
			logger.info("Removing vehicle details successfully");
			
			vehicleRepo.deleteById(vehicleNumber);
			
			return deleteMessage;
		}
		else {
			
			logger.info("Vehicle details not found");
			
			throw new VehicleNotFoundException();
		}
		
	}
	
	private final String VEHICLE_STATUS = "Active";
	
	

	public List<VehicleDTO> fetchVehicleByHarbor(String harborLocation)  throws VehicleNotFoundException {
		
		logger.info("ServiceImpl -> fetchVehicleByHarbor");
		List<VehicleDTO> response = new ArrayList<>();
		System.out.println("TEst");
		List<Vehicle> entities = vehicleRepo.findByHarborLocation(harborLocation);
		System.out.println(entities);
		if(entities.size() == 0) {
			throw new VehicleNotFoundException();
		}
		
		response = entities.stream().map(data -> VehicleDTO.prepareVehicleDTO(data)).collect(Collectors.toList());
		return response;
	}

}
