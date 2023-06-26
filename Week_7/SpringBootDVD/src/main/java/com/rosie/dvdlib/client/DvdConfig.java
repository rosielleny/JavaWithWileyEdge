package com.rosie.dvdlib.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.rosie.dvdlib")
public class DvdConfig {

		@Bean
		public DriverManagerDataSource dataSource() {
			DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/DVDLibrary");
			driverManagerDataSource.setUsername("root");
			driverManagerDataSource.setPassword("Bluebell137");
			return driverManagerDataSource;
		}
		
		@Bean
		public JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate(dataSource());
		}
}
