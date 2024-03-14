package co.com.notification.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleMQMessageListener {

    @RabbitListener(queues = "${spring.rabbitmq.queue.prueba}")
    public void message(String s) {
        log.info("Mensaje {}", s);
    }

}
