package com.pratik.mqttapp.mqttapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratik.mqttapp.mqttapp.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    // Additional query methods if needed
}
