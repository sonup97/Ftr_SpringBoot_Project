package com.infy.ftr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ftr.dto.Message;
import com.infy.ftr.dto.WorkItemDTO;
import com.infy.ftr.exception.FTRException;
import com.infy.ftr.service.WorkItemService;

@RestController
@RequestMapping("ftr/workItems")
@Validated
public class WorkItemController {

	@Autowired
	WorkItemService workItemService;
	
	@PostMapping
	public ResponseEntity<WorkItemDTO> createWorkItem(@Valid @RequestBody  WorkItemDTO workItemDTO ) throws FTRException
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(workItemService.createWorkItem(workItemDTO));
	}
	
	@GetMapping(value="{sourceCountry}")
	public ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable("sourceCountry") String sourceCountry)  
	{
		List<String> list = workItemService.fetchAvailableHarborLocations(sourceCountry);
		return new ResponseEntity<List<String>>(list,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value="{workItemId}")
	public ResponseEntity<Message> updateWorkItem(@PathVariable("workItemId") String workItemId,  @RequestBody WorkItemDTO workitemDTO) throws FTRException
	{
		return ResponseEntity.status(HttpStatus.OK).body(new Message(workItemService.updateWorkItem(workItemId, workitemDTO)));
	}
	
	
	@GetMapping
	public ResponseEntity<List<WorkItemDTO>> fetchWorkItemDetails(){
	 
		return ResponseEntity.ok(workItemService.fetchWorkItemDetails());
	
	}	
	
	@GetMapping("/managed-user/{userId}")
	public ResponseEntity<List<WorkItemDTO>> trackWorkItemByUser(@PathVariable("userId") String userId){
		 
		return ResponseEntity.ok(workItemService.trackWorkitemByUser(Long.valueOf(userId)));
	}
	
	
	@PostMapping("/managed-vehicle/{workItemId}")
	public ResponseEntity<Message> allocateVehicle(@PathVariable("workItemId") String workItemId) throws FTRException{
		
		return ResponseEntity.ok(new Message( workItemService.allocateVehicle(workItemId)));
	}
	
	
	
	
}
