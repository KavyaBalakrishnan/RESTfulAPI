package org.kavya.CaseStudy.myretail.client;
/*Getting the Product name from the external url */
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ProductDetails {

	public static String getProductName(Long id){


		String prodName = "";
		Client client = Client.create();
		String targetURL = "http://redsky.target.com/v2/pdp/tcin/" + id
				+ "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

		WebResource webResource = client.resource(targetURL);

		ClientResponse response = webResource.accept("application/JSON").get(ClientResponse.class);

		if (response.getStatus() != 200) {
			return ("Failed : http error code:" + response.getStatus());
		}
		String prodDetails = response.getEntity(String.class);

		// Extracting the title(Product name) from the response

		try {

			JsonParser parser = new JsonParser();
			JsonElement parsed = parser.parse(prodDetails);
			JsonObject asJsonObject = parsed.getAsJsonObject();
			JsonObject jsonArr = asJsonObject.getAsJsonObject("product");
			jsonArr = jsonArr.getAsJsonObject("item");
			jsonArr = jsonArr.getAsJsonObject("product_description");
			prodName = jsonArr.get("title").getAsString();


		} catch (Exception e) {

			e.printStackTrace();

		}
		return prodName;

	}

}
