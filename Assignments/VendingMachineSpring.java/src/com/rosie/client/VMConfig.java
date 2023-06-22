package com.rosie.client;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rosie.dataaccess.*;
import com.rosie.service.*;
import com.rosie.ui.*;

@Configuration
public class VMConfig {
	
	
	@Bean("dao") //ItemDAO
	public ItemDAOImpl getItemDAOImpl() {
		return new ItemDAOImpl();
	}
	@Bean("audit") //auditDAO
	public AuditDAOImpl getAuditDAOImpl() {
		return new AuditDAOImpl();
	}
	@Bean("inventory")
	public InventoryImpl getInventoryImpl(ItemDAOImpl dao, AuditDAOImpl audit) throws IOException {
		return new InventoryImpl(dao, audit);
	}
	@Bean("change")
	public Change getChange() {
		return new Change();
	}
	@Bean("ui")	
	public UserInterfaceImpl getUserInterfaceImpl(InventoryImpl inventory, Change change) {
		return new UserInterfaceImpl();
	}
	
	
	
}
