package com.github.mykeleony.quarkus.api;

import com.github.mykeleony.quarkus.domain.model.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> findAllProducts() {
        return Product.listAll();
    }

}
