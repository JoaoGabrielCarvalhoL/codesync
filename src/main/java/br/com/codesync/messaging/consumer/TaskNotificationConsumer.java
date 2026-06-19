package br.com.codesync.messaging.consumer;

import br.com.codesync.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskNotificationConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.TASK_NOTIFICATION_QUEUE)
    public void consumeNotification(String message) {
        LOGGER.info("Received notification message: {}", message);
    }
}
