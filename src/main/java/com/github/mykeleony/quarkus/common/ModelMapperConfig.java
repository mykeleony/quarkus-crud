package com.github.mykeleony.quarkus.common;

import jakarta.inject.Singleton;
import jakarta.ws.rs.Produces;
import org.modelmapper.ModelMapper;

@Singleton
public class ModelMapperConfig {

    @Produces
    @Singleton
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
