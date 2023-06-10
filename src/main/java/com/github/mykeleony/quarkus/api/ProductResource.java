package com.github.mykeleony.quarkus.api;

import com.github.mykeleony.quarkus.api.mapper.ProductMapper;
import com.github.mykeleony.quarkus.api.model.ProductInput;
import com.github.mykeleony.quarkus.domain.model.Product;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class ProductResource {

    private ProductMapper productMapper;

    @GET
    public List<Product> findAllProducts() {
        return Product.listAll();
    }

    @POST
    @Transactional
    public void createProduct(ProductInput productInput) {
        Product product = productMapper.toEntity(productInput);

        product.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void updateProduct(@PathParam("id") Long id, ProductInput productInput) {
        Optional<Product> optionalProduct = Product.findByIdOptional(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productInput.getName());
            product.setUnitPrice(productInput.getUnitPrice());

            product.persist();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deleteProduct(@PathParam("id") Long id) {
        Optional<Product> optionalProduct = Product.findByIdOptional(id);

        optionalProduct.ifPresentOrElse(Product::delete, () -> {
            throw new NotFoundException();
        });
    }

}
