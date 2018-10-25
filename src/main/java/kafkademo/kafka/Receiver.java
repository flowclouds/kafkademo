package kafkademo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "my-test")
    public void receive(@Payload String message,
                        @Headers MessageHeaders headers) {
        LOG.info("接收到消息received message='{}'", message);
    }
}