/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author parkjunhyun
 */

import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Test {
    @SuppressWarnings("deprecation")
   public static void main(String[] args) {
      String host = "iad2-c11-1.mongo.objectrocket.com:53725,iad2-c11-2.mongo.objectrocket.com:53725,iad2-c11-0.mongo.objectrocket.com:53725";
        String database = "MovieStore";
        String username = "G4";
        String password = "MovieStore";
        String options = "?replicaSet=87eb5f6054f945c5b9a3e0135b037fc1";

        String connectionString = String.format("mongodb://%s:%s@%s/%s%s", username, password, host, database, options);

        try {
            MongoClientURI client_uri = new MongoClientURI(connectionString);
            MongoClient client = new MongoClient(client_uri);
            DB db = client.getDB(database);
            Set<String> collection = db.getCollectionNames();

            DBCollection collection2 = db.getCollection("user");
            
            System.out.println("1. Find all matched documents");
            DBCursor cursor = collection2.find();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            client.close();
            System.out.println("Collection names:");
            System.out.println(collection);
            System.out.println("Connected!!!!");
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
   }
    
}
