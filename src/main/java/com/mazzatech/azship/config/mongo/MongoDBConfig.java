package com.mazzatech.azship.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {

    @Bean
    public MongoDatabaseFactory mongoConfigure(){
        String URL = "mongodb://127.0.0.1:27017/database";
        return new SimpleMongoClientDatabaseFactory(URL);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoConfigure());
    }
}
