package com.pratik.mqttapp.mqttapp.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Service
public class MqttPublisherService {
	  
	 private final MqttClient mqttClient;

	    public MqttPublisherService(MqttClient mqttClient) {
	        this.mqttClient = mqttClient;
	    } 
	    public void publish(String topic, String message) throws Exception {
	        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
	        mqttMessage.setQos(1); // QoS level
	        mqttClient.publish("Vehicle-pulisher", mqttMessage);
	    }

}
