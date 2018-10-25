package com.dz.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.util.Arrays;

public class DBConnection {

    /**
     * To Start the connection
     */

    public MongoClient getConnection() {
        MongoClient mongoClient;
        MongoCredential credential;
        credential = MongoCredential.createCredential("system", "admin", "admin123".toCharArray());

        mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));


        try {
          /*  System.out.println("connected ");*/
            return mongoClient;
        } catch (MongoClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
