package hoanghoi.datn.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.messaging.Message;

public interface MqttService {
    public void PushMQTTMessage(String topic, String message);
    public void HandleMQTTMessage(Message<?> message);
}
