package kz.homework.travellerstorage;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.RabbitMQContainer;

@TestConfiguration
public class RabbitMQTestConfiguration {

    private static final RabbitMQContainer rabbitMQContainer;

    static {
        rabbitMQContainer = new RabbitMQContainer("rabbitmq:3-management").withExposedPorts(5672, 15672);
        rabbitMQContainer.start();
    }
}
