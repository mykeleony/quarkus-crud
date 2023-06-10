package com.github.mykeleony.quarkus.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductInput {

    private String name;
    private BigDecimal unitPrice;

}
