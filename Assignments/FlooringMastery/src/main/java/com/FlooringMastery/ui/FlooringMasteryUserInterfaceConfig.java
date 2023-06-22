package com.FlooringMastery.ui;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.FlooringMastery.dao.OrderDaoImpl;
import com.FlooringMastery.dao.ProductDaoImpl;
import com.FlooringMastery.dao.TaxDaoImpl;
import com.FlooringMastery.service.*;

@Configuration
public class FlooringMasteryUserInterfaceConfig {
	
	@Bean
    public UserIOConsoleImpl userIOConsoleImpl() {
        return new UserIOConsoleImpl();
    }
	
    @Bean
    public ProductDaoImpl productDaoImpl() {
        return new ProductDaoImpl();
    }
    
    @Bean
    public TaxDaoImpl taxDaoImpl() {
        return new TaxDaoImpl();
    }
    
    @Bean
    public OrderDaoImpl orderDaoImpl() {
        return new OrderDaoImpl();
    }
	
	@Bean
    public OrderServiceImpl orderServiceImpl(OrderDaoImpl orderDaoImpl, TaxServiceImpl taxServiceImpl) {
        return new OrderServiceImpl(orderDaoImpl, taxServiceImpl);
    }
	
	@Bean
    public ProductServiceImpl productServiceImpl(ProductDaoImpl productDaoImpl) {
        return new ProductServiceImpl(productDaoImpl);
    }
	
	@Bean
    public TaxServiceImpl taxServiceImpl(TaxDaoImpl taxDaoImpl) {
        return new TaxServiceImpl(taxDaoImpl);
    }
}
