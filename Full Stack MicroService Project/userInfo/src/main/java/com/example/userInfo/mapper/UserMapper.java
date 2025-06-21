package com.example.userInfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.userInfo.dto.UserDTO;
import com.example.userInfo.entity.User;



@Mapper
public interface UserMapper {
	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
    User mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);
}
