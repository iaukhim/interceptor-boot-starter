package com.senla.iaukhim.interceptorbootstarter.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private IntereceptorProperties properties;

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(properties.getUri());
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(clientSettings);
    }

    @Override
    protected String getDatabaseName() {
        ConnectionString connectionString = new ConnectionString(properties.getUri());
        return connectionString.getDatabase();
    }
}
