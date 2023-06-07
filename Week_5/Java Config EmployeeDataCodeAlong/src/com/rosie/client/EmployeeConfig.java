package com.rosie.client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rosie.persistence.*;
import com.rosie.presentation.*;
import com.rosie.service.*;

@Configuration
public class EmployeeConfig {
	
	@Bean("dataAccess")
	public EmployeeDataAccessImpl getEmployeeDataAccessImpl() {
		return new EmployeeDataAccessImpl();
	}
	
	@Bean("service")
	public EmployeeBussinessLogicImpl getEmployeeBussinessLogicImpl(EmployeeDataAccessImpl dataAccess) {
		return new EmployeeBussinessLogicImpl(dataAccess);
	}
	

	@Bean("ui")
	public EmployeeUserInterfaceImpl getEmployeeUserInterfaceImpl() {
		return new EmployeeUserInterfaceImpl();
	}
}
