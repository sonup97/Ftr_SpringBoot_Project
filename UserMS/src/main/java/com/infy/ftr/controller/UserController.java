package com.infy.ftr.controller;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ftr.dto.LoginDTO;
import com.infy.ftr.dto.UserProfileDTO;
import com.infy.ftr.exception.UserException;
import com.infy.ftr.service.UserService;

@RestController
@RequestMapping("/ftr/userProfile")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<UserProfileDTO> createUserProfile(@Valid @RequestBody UserProfileDTO dto, Errors errors)
			throws UserException {

		if (errors.hasErrors()) {

			throw new UserException(returnError(errors));
		}

		return ResponseEntity.ok(userService.createUserProfile(dto));
	}

	@PutMapping(path = "/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable("userId") Integer userId,
			@RequestBody UserProfileDTO userDto) throws UserException {
		
		return ResponseEntity.ok(userService.updateUser(userId, userDto));
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId) throws UserException {
		
		return ResponseEntity.ok(userService.deleteUser(userId));
	}

	@GetMapping(path = "/{userId}")
	public ResponseEntity<UserProfileDTO> getUser(@PathVariable("userId") Integer userId) throws UserException {
		
		System.out.println("in get controller");
		return ResponseEntity.ok(userService.getUser(userId));
	}

	@GetMapping()
	public ResponseEntity<List<UserProfileDTO>> getAllUser() throws UserException {
		
		System.out.println("in get controller");
		return ResponseEntity.ok(userService.getAllUser());
	}

	

	@PostMapping(path="/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDto, Errors errors)
			throws UserException {

		if (errors.hasErrors()) {

			throw new UserException(returnError(errors));
		}
		System.out.println("in login controller");
		return ResponseEntity.ok(userService.login(loginDto));
	}

	public String returnError(Errors error) {
		String msg = error.getAllErrors().stream().map(obj -> obj.getDefaultMessage())
				.collect(Collectors.joining(", "));
		return msg;
	}
}
