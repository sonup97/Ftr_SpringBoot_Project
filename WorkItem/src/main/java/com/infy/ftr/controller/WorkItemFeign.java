package com.infy.ftr.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infy.ftr.dto.VehicleDTO;
import com.infy.ftr.exception.FTRException;

@FeignClient("VehicleMS")
public interface WorkItemFeign {
	@GetMapping(value = "/ftr/vehicles/harbor/{harborLocation}")
	public List<VehicleDTO> fetchVehicleByHarbor(@PathVariable("harborLocation") String harborLocation) throws FTRException;
	}
///harbor/{harborLocation}
