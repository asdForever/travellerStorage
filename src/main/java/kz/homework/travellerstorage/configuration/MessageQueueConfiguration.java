package kz.homework.travellerstorage.configuration;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfiguration {

    public final static String COUNTRY_QUEUE_NAME = "amqp.country.queue";
    public final static String COUNTRY_EXCHANGE_NAME = "amqp.country.exchange";

    public final static String CITY_QUEUE_NAME = "amqp.city.queue";
    public final static String CITY_EXCHANGE_NAME = "amqp.city.exchange";

    private static final boolean NON_DURABLE = false;
    private static final boolean DO_NOT_AUTO_DELETE = false;

    @Bean
    public Declarables countryBindings() {
        final Queue topicQueue = new Queue(COUNTRY_QUEUE_NAME, NON_DURABLE);
        final TopicExchange topicExchange = new TopicExchange(COUNTRY_EXCHANGE_NAME, NON_DURABLE, DO_NOT_AUTO_DELETE);

        return new Declarables(
                topicQueue,
                topicExchange,
                BindingBuilder
                        .bind(topicQueue)
                        .to(topicExchange)
                        .with(""));
    }

    @Bean
    public Declarables cityBindings() {
        final Queue topicQueue = new Queue(CITY_QUEUE_NAME, NON_DURABLE);
        final TopicExchange topicExchange = new TopicExchange(CITY_EXCHANGE_NAME, NON_DURABLE, DO_NOT_AUTO_DELETE);

        return new Declarables(
                topicQueue,
                topicExchange,
                BindingBuilder
                        .bind(topicQueue)
                        .to(topicExchange)
                        .with(""));
    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
