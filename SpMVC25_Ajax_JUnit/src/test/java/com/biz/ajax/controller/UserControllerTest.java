package com.biz.ajax.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
		)
public class UserControllerTest {

	
	private MockMvc mockMvc;
	
	
		
	@InjectMocks
	private UserController userController;
		
	@Before
	public void setUp() throws Exception {
		
		mockMvc = MockMvcBuilders
					.standaloneSetup(userController)
					.build();
	}

	@Test
	public void testSaveUser() throws Exception {
	
		mockMvc
		.perform(post("/saveUser"))
		.andExpect(status().isOk());
	
	}

}








