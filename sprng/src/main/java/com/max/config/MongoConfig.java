package com.max.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.max.mongo")
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    @Bean
    protected String getDatabaseName() {
        return "test";
    }
//    @Bean
//    MongoClient mongoClient() {
//        return new MongoClient();
//    }
//    @Bean
//    MongoClientFactoryBean mongoClientFactoryBean() {
//        return new MongoClientFactoryBean();
//    }
//    @Bean
//    MongoOperations mongoOperations(MongoClient mongoClient) {
//        return new MongoTemplate(mongoClient, "test");
//    }
}
