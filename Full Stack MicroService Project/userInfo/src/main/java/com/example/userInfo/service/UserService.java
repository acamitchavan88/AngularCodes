package com.example.userInfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.userInfo.dto.UserDTO;
import com.example.userInfo.entity.User;
import com.example.userInfo.mapper.UserMapper;
import com.example.userInfo.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserDTO addUser(UserDTO userDTO) {
	User userObject=userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		// TODO Auto-generated method stub
		return UserMapper.INSTANCE.mapUserToUserDTO(userObject);
	}

	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User> getfetchedUserDetails=userRepo.findById(userId);
		if(getfetchedUserDetails.isPresent())
		{
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(getfetchedUserDetails.get()),HttpStatus.OK);
		}
	
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
}
