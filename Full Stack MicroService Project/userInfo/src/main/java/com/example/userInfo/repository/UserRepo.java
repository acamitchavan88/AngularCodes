package com.example.userInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userInfo.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
