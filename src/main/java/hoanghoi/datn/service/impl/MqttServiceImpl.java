package hoanghoi.datn.service.impl;

import hoanghoi.datn.service.MqttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MqttServiceImpl implements MqttService {
    @Autowired
    @Qualifier("mqttOutboundChannel")
    private MessageChannel mqttOutBoundChannel;

    @Override
    public void PushMQTTMessage(String topic, String message) {
        try{
            mqttOutBoundChannel.send(
                    MessageBuilder.withPayload(message)
                            .setHeader("mqtt_topic",topic)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void HandleMQTTMessage(Message<?> message) {
        //get topic, payload
//        String topic = message.getHeaders().get("")
    }
}
