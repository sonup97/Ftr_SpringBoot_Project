package com.infy.ftr.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("WorkItemsMS")
public interface WorkItemsFeign {
	@GetMapping(value ="/ftr/workItems/managed-vehicleDetails/{vehicleNumber}")
	Boolean fetchWorkItemsByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) throws Exception;
}

