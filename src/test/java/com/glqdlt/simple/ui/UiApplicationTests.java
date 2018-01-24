package com.glqdlt.simple.ui;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class UiApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	private static final Logger log = LoggerFactory.getLogger(UiApplicationTests.class);

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}



	@Test
	public void contextLoads() {

	}

	@Test
	public void rootConstruct() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		Assert.assertEquals(mockHttpServletResponse.getStatus(),200);
	}

	@Test
	public void epgListConstruct() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/book/list")).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		Assert.assertEquals(mockHttpServletResponse.getStatus(),200);
	}
	@Test
	public void epgDetailConstruct() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/book/detail/1")).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		Assert.assertEquals(mockHttpServletResponse.getStatus(),200);
	}

	@Test
	public void loginConstruct() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/auth/login")).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		Assert.assertEquals(mockHttpServletResponse.getStatus(),200);
	}
}
