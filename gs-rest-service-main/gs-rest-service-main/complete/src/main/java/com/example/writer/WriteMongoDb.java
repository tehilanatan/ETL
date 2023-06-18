package com.example.writer;

import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.example.connect.ConnectMongoDb;

public class WriteMongoDb implements Writer {

	ConnectMongoDb connectMongoDb;
	Document document = new Document();

	@Override
	public void write(String nameOfCollection, List<Map<String, Object>> Table) {

		connectMongoDb = new ConnectMongoDb();
		connectMongoDb.connect();

		Table.forEach((item) -> {
			document = new Document();
			item.keySet().forEach((key)-> {
				
				document.append(key, item.get(key));	 

			});

			connectMongoDb.getDatabase().getCollection(nameOfCollection).insertOne(document);
		});

	}

}
