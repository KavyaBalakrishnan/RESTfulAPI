package org.kavya.restapi.casestudy.myretailresource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kavya.restapi.casestudy.myretailcontroller.Controller;
import org.kavya.restapi.casestudy.myretailmodel.Product;




@Path("/Products")
public class ProductResource {
	
	@Path("/{ProductID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("ProductID") Long id) {
		try {

			Product resp = Controller.getProductDetails(id);
			if (resp == null) {
				// return 404 not found if id doesn't exist
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			// return 200 if found
			return Response.ok().entity(resp).build();

		} catch (Exception e) {
			return Response.serverError().entity(e.toString()).build();
		}

	}

}
