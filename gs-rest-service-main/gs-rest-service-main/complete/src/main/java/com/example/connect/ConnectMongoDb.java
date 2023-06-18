package com.example.connect;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectMongoDb implements Connect {

	private MongoDatabase  database;

	
	@Override
	public void connect() {

		//Creating a MongoDB client
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		//Connecting to the database
		database = mongo.getDatabase("myDatabase");
		      
		   }
		

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}


	public MongoDatabase getDatabase() {
		return database;
	}


	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}


	


}
