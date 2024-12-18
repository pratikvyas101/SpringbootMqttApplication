package com.pratik.mqttapp.mqttapp.service;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class MqttSubscriber {

    private final MqttClient mqttClient;
    private final List<SseEmitter> emitters = Collections.synchronizedList(new ArrayList<>());
    private String mqttMessages = " ";
    
    public MqttSubscriber(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
//        init();
    }

    private void init() {
        try {
            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.err.println("Connection lost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) {
                    String payload = new String(message.getPayload());
                    System.out.println("Received message: " + payload);
                    handleMessage(new String(message.getPayload())); 
                    subscribeMessage(new String(message.getPayload()));
                    // Send the message to all connected clients
//                    for (SseEmitter emitter : emitters) {
//                        try {
//                            emitter.send(payload);
//                        } catch (IOException e) {
//                            emitters.remove(emitter);
//                        }
//                    }
                }

                @Override
                public void deliveryComplete(org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token) {
                    // No-op for subscriber
                }
            });
            mqttClient.subscribe("Test3"); // Replace with your topic
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void handleMessage(String message) {
        synchronized (mqttMessages) {
//            mqttMessages.add(message);
        	mqttMessages = message;
//            if (mqttMessages.size() > 50) { // Limit to the last 50 messages
//                mqttMessages.remove(0);
//            }
        }
    }

    public String getLatestMessages() {
        synchronized (mqttMessages) {
            return new String(mqttMessages);
        }
    }
    
    public void subscribeMessage(String message) {
        // Send the message to all active emitters
    	System.out.println("subscribeMessage");
        synchronized (emitters) {
            Iterator<SseEmitter> iterator = emitters.iterator();
            while (iterator.hasNext()) {
                SseEmitter emitter = iterator.next();
                try {
                    emitter.send(SseEmitter.event().data(message));
                } catch (IOException e) {
                    // Remove emitter on send failure
                    iterator.remove();
                }
            }
        }
    }

    // Method to add a new emitter (client)
    public SseEmitter addEmitter() {
    	 SseEmitter emitter = new SseEmitter(0L); // Timeout after 120 seconds
//    	 SseEmitter emitter = new SseEmitter();
    	 emitters.add(emitter);
    	 
    	 Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
    	        try {
    	            emitter.send(SseEmitter.event().comment("heartbeat"));
    	        } catch (IOException e) {
    	            emitters.remove(emitter);
    	        }
    	    }, 2, 2, TimeUnit.SECONDS);

         // Remove emitter on timeout or completion
         emitter.onCompletion(() -> emitters.remove(emitter));
         emitter.onTimeout(() -> emitters.remove(emitter));
         emitter.onError(e -> emitters.remove(emitter));
    
        return emitter;
    }
}

