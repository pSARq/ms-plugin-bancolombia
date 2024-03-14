package co.com.notification.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue.prueba}")
    private String queueNotification;

    @Value("${spring.rabbitmq.exchange.prueba}")
    private String directExchangeNotification;

    @Value("${spring.rabbitmq.routing-key.prueba}")
    private String routingKeyNotification;


    //QUEUES
    @Bean
    Queue queueNotification() {
        return QueueBuilder.durable(queueNotification).build();
    }

    //EXCHANGES
    @Bean
    DirectExchange directExchangeNotification() {
        return new DirectExchange(directExchangeNotification);
    }

    //BINDINGS
    @Bean
    Binding bindingNotification() {
        return BindingBuilder.bind(queueNotification())
                .to(directExchangeNotification())
                .with(routingKeyNotification);
    }

}
