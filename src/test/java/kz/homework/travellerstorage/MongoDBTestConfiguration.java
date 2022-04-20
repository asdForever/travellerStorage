package kz.homework.travellerstorage;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.testcontainers.containers.MongoDBContainer;

@TestConfiguration
public class MongoDBTestConfiguration {

    private static final MongoDBContainer mongoDBContainer;

    static {
        mongoDBContainer = new MongoDBContainer("mongo:5.0.7");
        mongoDBContainer.start();
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        //ReplicaSetUrl will look similar to mongodb://localhost:33557/test
        ConnectionString connectionString = new ConnectionString(mongoDBContainer.getReplicaSetUrl());
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(mongoClientSettings);

        return new MongoTemplate(mongoClient, "test");
    }
}
