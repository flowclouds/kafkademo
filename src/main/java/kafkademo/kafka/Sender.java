package kafkademo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class Sender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Scheduled(cron = "*/5 * * * * ?")
    public void sendTest() {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        String message = "topic:[my-test] 发送消息hello,kafka  " + time;
        log.info(message);
        kafkaTemplate.send("my-test", time);
    }

}