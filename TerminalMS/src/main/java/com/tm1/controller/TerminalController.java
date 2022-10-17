package com.tm1.controller;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm1.customExceptions.ServiceException;
import com.tm1.dto.TerminalDTO;
import com.tm1.error.CustomError;
import com.tm1.service.TerminalService;

import exception.TerminalMSException;

@RestController
@RequestMapping("/ftr/terminals")
@RefreshScope
@CrossOrigin
public class TerminalController {

	@Autowired
	TerminalService termService;
	@Autowired
	DiscoveryClient discoveryclient;
	
//	@Valid
	@PostMapping("")
	public String insertNewTerminal( @RequestBody TerminalDTO tDTO, Errors errors){
		String response = "";
		if (errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			CustomError error = new CustomError();
			error.setError_Code(HttpStatus.NOT_ACCEPTABLE.value());
			error.setError_Msg(response);
			return error.getError_Msg();
		} else {
			termService.insertNewTerminal(tDTO);
			return "Terminal added successfully";
		}
	}
	
	@GetMapping 
	public ResponseEntity<List<TerminalDTO>> fetchFTRTerminals(){
		return new ResponseEntity<>(
					termService.fetchFTRTerminals(),
					HttpStatus.OK);
	}
	
	@PutMapping("/{terminalId}/{newCapacity}")
	public ResponseEntity<String> updateTerminal(
									
									@PathVariable("terminalId") String terminalId,
									@PathVariable("newCapacity") Integer newCapacity)
									throws ServiceException{
		
		String resp = termService.updateTerminal(terminalId, newCapacity);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/fetchTerminalByTerminalId/{terminalId}")
	public ResponseEntity<TerminalDTO> fetchTerminalByTerminalId(@PathVariable("terminalId") String terminalId)
										throws TerminalMSException{
		return new ResponseEntity<TerminalDTO>(
					termService.fetchFTRTerminalByTerminalId(terminalId),
					HttpStatus.OK);
	}
	
	@GetMapping("/fetchTerminalByItemType/{itemType}")
	public ResponseEntity<List<TerminalDTO>> fetchTerminalsByItemType(@PathVariable("itemType") String itemType) throws TerminalMSException {
		return new ResponseEntity<List<TerminalDTO>>(termService.fetchTerminalsByItemType(itemType),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{terminalId}")
	public ResponseEntity<String> removeTerminal(@PathVariable("terminalId") String terminalId)
									throws TerminalMSException{
		
		String resp = termService.removeTerminal(terminalId);
//		return ResponseEntity.ok(resp);
		return new ResponseEntity<>(resp,HttpStatus.ACCEPTED);
	}
}
