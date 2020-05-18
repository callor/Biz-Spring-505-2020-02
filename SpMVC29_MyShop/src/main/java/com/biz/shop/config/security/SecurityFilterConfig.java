package com.biz.shop.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*
 * java config 방식의 security에서는
 * AbstractSecurity... 클래스를 상속받은
 * 클래스를 만들고 내부 코드는 비워둔채로 두면
 * 자동으로 security filter로서 동작을 한다.
 */
public class SecurityFilterConfig 
	extends AbstractSecurityWebApplicationInitializer{

}
