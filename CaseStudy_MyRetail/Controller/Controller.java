package org.kavya.restapi.casestudy.myretailcontroller;

import org.kavya.restapi.casestudy.myretailexternal.MyMongoDb;
import org.kavya.restapi.casestudy.myretailexternal.ProductDetail;
import org.kavya.restapi.casestudy.myretailmodel.Product;

/**
 * Controller class - returns the final response
 */
public class Controller {

	public static Product getProductDetails(Long id) throws Exception {
		String prodName = ProductDetail.getProductName(id);
		String prodPrice = MyMongoDb.getProductPrice(id);

		Product prod = new Product(id, prodName, prodPrice);
		prod.setId(prod.getId());
		prod.setName(prod.getName());
		prod.setPrice(prod.getPrice());

		return prod;
	}

}
