package com.FlooringMastery.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.FlooringMastery.dao.*;


@Configuration
public class ServiceConfig {

	
	@Bean
    public OrderDaoImpl orderDaoImpl() {
        return new OrderDaoImpl();
    }
	
	@Bean
    public ProductDaoImpl prodctDaoImpl() {
        return new ProductDaoImpl();
    }
	
	@Bean
    public TaxDaoImpl taxDaoImpl() {
        return new TaxDaoImpl();
    }
}
