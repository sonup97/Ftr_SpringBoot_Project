package com.infy.ftr.service;

import java.util.List;

import com.infy.ftr.dto.LoginDTO;
import com.infy.ftr.dto.UserProfileDTO;
import com.infy.ftr.exception.UserException;

public interface UserService {

	public UserProfileDTO createUserProfile(UserProfileDTO dto) throws UserException;
	public String updateUser(int userId,UserProfileDTO userDto) throws UserException;
	public String deleteUser(int userId) throws UserException;
	public UserProfileDTO getUser(int userId)throws UserException;
	public String login(LoginDTO logindto)throws UserException;
	public List<UserProfileDTO> getAllUser() throws UserException;
}