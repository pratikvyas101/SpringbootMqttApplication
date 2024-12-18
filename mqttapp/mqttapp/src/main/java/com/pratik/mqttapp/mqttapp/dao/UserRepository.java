package com.pratik.mqttapp.mqttapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratik.mqttapp.mqttapp.model.User;

public interface UserRepository extends JpaRepository<User,String> {

}
