package com.infy.ftr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.ftr.dto.UserProfileDTO;
import com.infy.ftr.dto.LoginDTO;
import com.infy.ftr.entity.UserProfileEntity;
import com.infy.ftr.exception.UserException;
import com.infy.ftr.repository.UserRepository;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;

	@Autowired
	Environment env;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserProfileDTO createUserProfile(UserProfileDTO dto) throws UserException {
		// TODO Auto-generated method stub
		logger.info("Inside createUserProfile end point");
		Optional<UserProfileEntity> userEntity = userRepo.findByPassportNumber(dto.getPassportNumber());

		if (userEntity.isPresent()) {
			logger.error(env.getProperty("user.alreadyexists"));
			throw new UserException(env.getProperty("user.alreadyexists"));

		}
		UserProfileEntity entity = UserProfileDTO.prepareEntity(dto);
		userRepo.save(entity);
		userEntity = userRepo.findByPassportNumber(entity.getPassportNumber());
		if (!userEntity.isPresent()) {
			logger.error(env.getProperty("general.exception"));
			throw new UserException(env.getProperty("general.exception"));
		}
		logger.info(env.getProperty("user.create.success"));
		return new UserProfileDTO(entity);
	}

	@Override
	public String updateUser(int userId, UserProfileDTO userDto) throws UserException {
		// TODO Auto-generated method stub
		logger.info("Inside updateUser end point");

		Optional<UserProfileEntity> userEntity = userRepo.findById(userId);

		if (userEntity.isEmpty()) {
			logger.error(env.getProperty("user.notFound"));
			throw new UserException(env.getProperty("user.notFound"));
		}

		if (userDto.getMobileNumber() == null || userDto.getPermanentAddress() == null
				|| userDto.getOfficeAddress() == null) {
			logger.error(env.getProperty("user.update.fail"));
			throw new UserException(env.getProperty("user.update.fail"));

		}
		UserProfileEntity ent = userEntity.get();

		ent.setMobileNumber(userDto.getMobileNumber());
		ent.setOfficeAddress(userDto.getOfficeAddress());
		ent.setPermanentAddress(userDto.getPermanentAddress());

		UserProfileEntity entAfter = userRepo.save(ent);

		if (!entAfter.getUserId().equals(ent.getUserId())) {
			logger.error(env.getProperty("general.exception"));
			throw new UserException(env.getProperty("general.exception"));
		}

		return (env.getProperty("user.update.success") + userId);
	}

	@Override
	public String deleteUser(int userId) throws UserException {
		// TODO Auto-generated method stub
		logger.info("Inside deleteUser end point");
		Optional<UserProfileEntity> userEntity = userRepo.findById(userId);

		if (userEntity.isEmpty()) {
			logger.error(env.getProperty("user.notFound"));
			throw new UserException(env.getProperty("user.notFound"));
		}
		userRepo.deleteById(userId);

		userEntity = userRepo.findById(userId);

		if (!userEntity.isEmpty()) {
			logger.error(env.getProperty("general.exception"));
			throw new UserException(env.getProperty("general.exception"));
		}
		return (env.getProperty("user.delete.success") + userId);
	}

	@Override
	public UserProfileDTO getUser(int userId) throws UserException {
		// TODO Auto-generated method stub
		logger.info("Inside getUser end point");

		Optional<UserProfileEntity> userEntity = userRepo.findById(userId);

		if (userEntity.isEmpty()) {
			logger.error(env.getProperty("user.notFound"));
			throw new UserException(env.getProperty("user.notFound"));
		}

		logger.info(env.getProperty("user.found") + userId);

		return new UserProfileDTO(userEntity.get());
	}

	@Override
	public String login(LoginDTO loginDto) throws UserException {
		// TODO Auto-generated method stub
		logger.info("Inside login end point");
		Optional<UserProfileEntity> userEntity = userRepo.findById(loginDto.getUserId());
	
		if (!userEntity.isPresent() || userEntity.get().getUserId() != loginDto.getUserId()
				|| !userEntity.get().getPassword().equals(loginDto.getPassword())) {
			logger.error(env.getProperty("user.login.failure"));

			throw new UserException(env.getProperty("user.login.failure"));
		}

		return env.getProperty("user.login.success");
	}

	@Override
	public List<UserProfileDTO> getAllUser() throws UserException {
		// TODO Auto-generated method stub
		logger.info("Inside get all users end point");
		List<UserProfileEntity> userEntity =userRepo.findAll();
		if(userEntity.isEmpty())
		{
			logger.error(env.getProperty("user.notFound"));
			throw new UserException(env.getProperty("user.notFound"));
		}
		List<UserProfileDTO> list=new ArrayList<UserProfileDTO>();
		
		for(UserProfileEntity ent:userEntity)
		{
			list.add(UserProfileEntity.prepareUserDto(ent));
		}
		return list;
	}

}

