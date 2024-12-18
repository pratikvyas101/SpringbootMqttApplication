package com.pratik.mqttapp.mqttapp.service;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MqttSubscriberService {

    private static final String BROKER_URL = "tcp://pf-nanwj9sohdjeb5658ic8.cedalo.cloud:1883"; // Replace with Cedalo broker URL
    private static final String TOPIC = "Test3";
    private static final String CLIENT_ID = "sub-client";

    @Autowired
    private SimpMessagingTemplate messagingTemplate; // For WebSocket broadcasting

    public void start() {
        try {
            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName("cedalo-sub");
            options.setPassword("cedalo".toCharArray());
            options.setCleanSession(true);

            client.connect(options);
            System.out.println("Connected to MQTT broker");

            client.subscribe(TOPIC, (topic, message) -> {
                String payload = new String(message.getPayload());
                System.out.println("Received MQTT message: " + payload);

                // Convert MQTT payload to WebSocket-compatible format (JSON)
                messagingTemplate.convertAndSend("/topic/vehicle-state", payload); // Push to WebSocket clients
            });

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

