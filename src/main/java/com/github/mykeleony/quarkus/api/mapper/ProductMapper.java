package com.github.mykeleony.quarkus.api.mapper;

import com.github.mykeleony.quarkus.api.model.ProductInput;
import com.github.mykeleony.quarkus.domain.model.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class ProductMapper {

    private ModelMapper modelMapper;

    public Product toEntity(ProductInput productInput) {
        return modelMapper.map(productInput, Product.class);
    }

}
