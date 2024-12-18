package com.pratik.mqttapp.mqttapp.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    private static final String BROKER_URL = "tcp://pf-nanwj9sohdjeb5658ic8.cedalo.cloud:1883";
    private static final String CLIENT_ID = "pub-client";

    @Bean                                           
    public MqttClient mqttClient() throws Exception {
        MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName("cedalo-pub"); // Replace with your username
        options.setPassword("cedalo".toCharArray());
        options.setCleanSession(true);
        client.connect(options);
        return client;
    }
}	

