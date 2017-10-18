package org.kavya.restapi.casestudy.myretailexternal;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/*
 Connecting to NoSQL Db - MongoDB
 Extracting the current_price for the given product_id
 */

public class MyMongoDb {
	
	public static DBCollection getCollection() throws Exception {
		MongoClient client = new MongoClient("localhost", 27017);
		DB database = client.getDB("TestDB");
		DBCollection collection = database.getCollection("product");
		return collection;
	}

	public static String getProductPrice(Long id) throws Exception {

		String currentPrice = "";

		DBCollection collection = getCollection();

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("product_id", id);

		DBCursor cursor = collection.find(whereQuery);

		while (cursor.hasNext()) {
			currentPrice = (cursor.next().get("current_price").toString());

		}

		return currentPrice;
	}

}
