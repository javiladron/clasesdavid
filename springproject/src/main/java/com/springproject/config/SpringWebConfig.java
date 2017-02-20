package com.springproject.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.springproject.controllers com.springproject.manager com.springproject.beans.validator com.springproject.dao" })

public class SpringWebConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/estaticos/**").addResourceLocations("/estaticos/");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
        	dataSource = (DataSource) jndi.lookup("jdbc/springproject");
        	return dataSource;
        } catch (NamingException e) {
        	System.out.println("datasource 1: "+e.getMessage());
        }
    	try{
    		dataSource = (DataSource) jndi.lookup("java:comp/env/jdbc/springproject");
    		return dataSource;
    	}catch(Exception ex){
    		System.out.println("datasource 2: "+ex.getMessage());	
    	}
    	return null;
	}
}
