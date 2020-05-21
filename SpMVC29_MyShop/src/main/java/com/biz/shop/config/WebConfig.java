package com.biz.shop.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.biz.shop.config.security.JasyptConfig;
import com.biz.shop.config.security.SecurityConfig;
/**
 * web.xml을 대신할 클래스
 * @author Master
 *
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { 
				RootConfig.class,
				SecurityConfig.class,
				JasyptConfig.class,
				DBSetupConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { ServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	
	
	/*
	 * 한글 인코딩 필터링 처리
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter charFilter
		= new CharacterEncodingFilter();
		
		charFilter.setEncoding("UTF-8");
		
		// security에서 view 파일을 찾지 못했을때
		// 보여주는 오류메시지에서 한글 처리
		charFilter.setForceEncoding(true);
	
		return new Filter[] { charFilter };

	}


	
	
	
	
	

}








