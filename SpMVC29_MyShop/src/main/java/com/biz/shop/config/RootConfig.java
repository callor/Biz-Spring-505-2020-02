package com.biz.shop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = 
				{"com.biz.shop.auth",
				"com.biz.shop.service"})
public class RootConfig {

}
