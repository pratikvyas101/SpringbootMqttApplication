package com.pratik.mqttapp.mqttapp.controller;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pratik.mqttapp.mqttapp.dao.UserRepository;
import com.pratik.mqttapp.mqttapp.model.Odometer;
import com.pratik.mqttapp.mqttapp.model.User;
import com.pratik.mqttapp.mqttapp.model.VehicleData;
import com.pratik.mqttapp.mqttapp.service.MqttPublisherService;
import com.pratik.mqttapp.mqttapp.service.MqttSubscriberService;
import com.pratik.mqttapp.mqttapp.service.UserService;

@Controller
public class VehicleController {

    @Autowired
    private MqttSubscriberService mqttSubscriberService;
    
    @Autowired
    private MqttPublisherService publisherService;
    
    
    private UserService userService;
    private UserRepository userRepository;
    
    @Autowired
    public VehicleController(UserService userService,UserRepository userRepository) {
    	this.userService = userService;
    	this.userRepository = userRepository;
    }

    @GetMapping("/showMyLoginPage")
    public String loginHomePage() {
    	
    	return "users_login";
    }
    
    private String doorStatus = "off"; // Default value
    private String trunkStatus = "off"; // Default value
    private Integer acState = 24; // Default value
    
    
    
    @GetMapping("/vehicleState")
    public String getVehicleDashboard(Model model) {
        // Initialize with placeholder data
    	System.out.println("Acc State"+acState);
     	System.out.println("trunk State"+trunkStatus);
        model.addAttribute("vehicleData", new VehicleData());
        model.addAttribute("doorState", doorStatus);
        model.addAttribute("trunkState", trunkStatus);
        model.addAttribute("acState", acState);
        mqttSubscriberService.start(); // Start the MQTT subscriber
        return "vehicle-dashboard"; // Thymeleaf template name
    }
//    @GetMapping("/")
//    public String home(Model model) {
//    	 model.addAttribute("vehicleData", new VehicleData());
//         mqttSubscriberService.start(); // Start the MQTT subscriber
//    	return "vehicle-dashboard";
//    }
      
      @GetMapping("/controlVehicle")
      public String setSetting() {
    	  
    	  return "controller-page";
      }

      @GetMapping("/vehicleSettings")
      public String showUpdatePasswordPage(Model model) {
          // Add an empty object for binding the form
          model.addAttribute("User", new User());
          return "settings-page";
      }
      
      @PostMapping("/vehicleSettings")
      public String vehicleSetting(@ModelAttribute("User")User form,Model model) {
    	  try {
              // Validate input
              if (form.getUsername() == null || form.getUsername().isEmpty()) {
                  throw new IllegalArgumentException("Username cannot be empty");
              }
              if (form.getPassword() == null || form.getPassword().isEmpty()) {
                  throw new IllegalArgumentException("Password cannot be empty");
              }

              // Update password logic
              User user = userRepository.findById(form.getUsername())
                      .orElseThrow(() -> new RuntimeException("User not found for username: " + form.getUsername()));

              user.setPassword("{noop}" +form.getPassword()); // You can add encryption here if needed
              userRepository.save(user);

              // Add success message
              model.addAttribute("successMessage", "Password updated successfully for user: " + form.getUsername());
          } catch (Exception e) {
              // Handle errors
              model.addAttribute("errorMessage", e.getMessage());
          }
    	  return "settings-page";
      }
      
      @GetMapping("/diagnostices")
      public String diagnosticesSystem() {
    	  
    	  return "diagnostics";
      }
      

      @GetMapping("/odometer")
      public String odometerPage(Model model) {
    	  model.addAttribute("Odometer", new Odometer());
          return "odometer-dashboard"; // Maps to cluster.html
      }
      
      @PostMapping("/acState")
      public String acStatus(@RequestParam("acState") Integer value,Model model) throws Exception {
    	  System.out.println("acState is:"+value);
    	  String theValue = String.valueOf(value);
//    	  byte[] bty = theValue.getBytes(); 
//    	  int theValue = value;
//    	  byte bty = (byte)theValue;
    	  publisherService.publish("Test3",theValue);
    	  model.addAttribute("acState", value);
    	  return "controller-page";
      }
      
      @PostMapping("/doorState")
      public String doorStatus(@RequestParam("doorState") String value,Model model) throws Exception {
    	  System.out.println("doorStatus is:"+value);
    	  String theValue = value ;
//    	  byte[] bty = theValue.getBytes(); 
    	  publisherService.publish("Test3",theValue);
    	  model.addAttribute("doorState", value);
    	  return "controller-page";
      }
      
      @PostMapping("/trunkState")
      public String trunkStatus(@RequestParam("trunkState") String value,Model model) throws Exception {
    	  System.out.println("trunkStatus is:"+value);
    	  String theValue = value;
//    	  byte[] bty = theValue.getBytes(); 
    	  publisherService.publish("Test3",theValue);
    	  model.addAttribute("trunkState", value);
    	  return "controller-page";
      }
      
      @PostMapping("/accModeState")
      public String accStatus(@RequestParam("accModeState") String value,Model model) throws Exception {
    	  System.out.println("trunkStatus is:"+value);
    	  String theValue = value;
//    	  byte[] bty = theValue.getBytes(); 
    	  publisherService.publish("Test3",theValue);
    	  model.addAttribute("accModeState", value);
    	  return "controller-page";
      }
      
      @PostMapping("/tjpModeState")
      public String tjpStatus(@RequestParam("tjpModeState") String value,Model model) throws Exception {
    	  System.out.println("tjpStatus is:"+value);
    	  String theValue = value;
//    	  byte[] bty = theValue.getBytes(); 
    	  publisherService.publish("Test3",theValue);
    	  model.addAttribute("tjpModeState", value);
    	  return "controller-page";
      }
}

