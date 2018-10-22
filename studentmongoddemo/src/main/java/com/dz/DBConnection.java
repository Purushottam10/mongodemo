package com.dz;

import com.mongodb.MongoCredential;

import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.Connection;
import com.mongodb.MongoClient;
import org.bson.Document;

public class DBConnection {



    public Connection getConnection(){
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        MongoCredential credential;

        mongoClient = new MongoClient("localhost", 27017 );
        credential=MongoCredential.createCredential("admin ","admin","admin123".toCharArray());
        try {

            return credential;
        }
        catch (MongoC)
    }
}
