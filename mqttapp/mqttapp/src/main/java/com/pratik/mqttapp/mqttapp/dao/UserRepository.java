package com.pratik.mqttapp.mqttapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.pratik.mqttapp.mqttapp.model.User;

public interface UserRepository extends JpaRepository<User,String> {
//	  public  User findByUsername(String username);
//     Optional<User> findByIdWithAuthorities(@Param("id") Long id);
//     Optional<User> findByUsernameWithAuthorities(@Param("username") String username);
}
