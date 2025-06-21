package com.example.userInfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userInfo.dto.UserDTO;
import com.example.userInfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	// SLF4J Logger
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO)
	{
		UserDTO createdUser=userService.addUser(userDTO);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<UserDTO>fetchUserDetails(@PathVariable("userId") Integer id)
	{logger.info("User ID to be fetched is::"+id);
		ResponseEntity<UserDTO> getUserDetails=userService.fetchUserDetailsById(id);
		return getUserDetails;
		
	}
}
