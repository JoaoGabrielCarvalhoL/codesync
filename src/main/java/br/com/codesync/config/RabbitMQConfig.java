package br.com.codesync.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //TODO: Once the necessary queues for the application are defined, obtain those values via @Value.
    public static final String TASK_NOTIFICATION_QUEUE = "codesync.task-notification.queue";
    public static final String TASK_NOTIFICATION_EXCHANGE = "codesync.task-notification.exchange";
    public static final String TASK_NOTIFICATION_ROUTING_KEY = "codesync.notification.routing-key";
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Bean
    public Queue taskNotificationQueue() {
        return QueueBuilder.durable(TASK_NOTIFICATION_QUEUE).build();
    }

    @Bean
    public DirectExchange taskNotificationExchange() {
        return new DirectExchange(TASK_NOTIFICATION_EXCHANGE);
    }

    @Bean
    public Binding taskNotificationBinding(Queue taskNotificationQueue, DirectExchange taskNotificationExchange) {
        LOGGER.info("Binding task notification exchange to queue {}", TASK_NOTIFICATION_QUEUE);
        return BindingBuilder.bind(taskNotificationQueue)
                .to(taskNotificationExchange)
                .with(TASK_NOTIFICATION_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }
}
