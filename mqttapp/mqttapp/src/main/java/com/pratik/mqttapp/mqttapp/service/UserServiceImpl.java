package com.pratik.mqttapp.mqttapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.mqttapp.mqttapp.dao.UserRepository;
import com.pratik.mqttapp.mqttapp.model.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
 
    private UserRepository userRepository;
    
    
    public UserServiceImpl() {
    	
    }
    @Autowired
	public UserServiceImpl(UserRepository userRepository) {
	
		this.userRepository = userRepository;
	    	
	}
	
	@Override
	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}
	
// 	@Transactional
//    public User getUserById(Long id) {
//        return userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
	
	public void updatePassword(String username, String newPassword) {
	        User user = userRepository.findById(username)
	                                   .orElseThrow(() -> new RuntimeException("User not found"));
	        user.setPassword(newPassword);
	        userRepository.save(user);
	}

}
