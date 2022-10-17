package com.infy.ftr.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.hibernate.annotations.common.util.impl.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ftr.dto.Message;
import com.infy.ftr.dto.VehicleDTO;
import com.infy.ftr.exception.VehichleStatusExistException;
import com.infy.ftr.exception.VehicleFtrException;
import com.infy.ftr.exception.VehicleNotFoundException;
import com.infy.ftr.service.VehicleService;

@RestController
@RequestMapping("ftr/vehicles")
@Validated
@CrossOrigin
@RefreshScope
public class VehicleController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	VehicleService vehicleService;
	
	


	@PostMapping
	public ResponseEntity<Message> insertNewVehicle(@Valid @RequestBody VehicleDTO dto) throws VehicleFtrException {
		
		logger.info("Controller -> insertNewVehicle");
		
		return ResponseEntity.ok(new Message(vehicleService.insertNewVehicle(dto)));
	}
	
	

	@GetMapping
	public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles()  throws VehicleNotFoundException{
		
		logger.info("Controller -> fetchAvailableVehicles");
		
		return new ResponseEntity<List<VehicleDTO>>(vehicleService.fetchAvailableVehicles(), HttpStatus.OK);
	}
	
	

	@GetMapping(value = "managed-name/{vehicleName}")
	public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable String vehicleName) throws VehicleNotFoundException {
		
		logger.info("Controller -> fetchVehicleDetailsByVehicleName");
		
		return new ResponseEntity<List<VehicleDTO>>(vehicleService.fetchVehicleDetailsByVehicleName(vehicleName), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "managed-number/{vehicleNumber}")
	public ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable String vehicleNumber) throws VehicleNotFoundException {
		
		logger.info("Controller -> fetchVehicleDetailsByVehicleNumber");
		
		return new ResponseEntity<VehicleDTO>(vehicleService.fetchVehicleDetailsByVehicleNumber(vehicleNumber), HttpStatus.OK);
	}
	

	@PutMapping(value = "{vehicleNumber}")
	public ResponseEntity<Message> updateVehicleStatus(@PathVariable String vehicleNumber, @RequestBody VehicleDTO dto) throws VehicleNotFoundException, VehichleStatusExistException, VehicleFtrException {
		
		logger.info("Controller -> updateVehicleStatus");
		System.out.println("data came from postman put method");
		return ResponseEntity.ok(new Message(vehicleService.updateVehicleStatus(vehicleNumber, dto)));
	}
	
	@DeleteMapping(value = "{vehicleNumber}")
	public ResponseEntity<Message> removeVehicle(@PathVariable String vehicleNumber) 	throws VehicleNotFoundException {
		
		logger.info("Controller -> removeVehicle");
		
		return ResponseEntity.ok(new Message(vehicleService.removeVehicle(vehicleNumber)));
	}
	
	

	@GetMapping(value = "/harbor/{harborLocation}")
	public ResponseEntity<List<VehicleDTO>> fetchVehicleByHarbor(@PathVariable("harborLocation") String harborLocation) throws VehicleNotFoundException {
		logger.info("Controller -> fetchVehicleByHarbor");
		return ResponseEntity.ok(vehicleService.fetchVehicleByHarbor(harborLocation));
	}

}
