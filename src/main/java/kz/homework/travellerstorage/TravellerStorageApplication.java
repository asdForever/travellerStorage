package kz.homework.travellerstorage;

import kz.homework.travellerstorage.configuration.MessageQueueConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MessageQueueConfiguration.class)
public class TravellerStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravellerStorageApplication.class, args);
    }
}
