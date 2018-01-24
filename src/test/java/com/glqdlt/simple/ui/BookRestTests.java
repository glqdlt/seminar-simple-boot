package com.glqdlt.simple.ui;

import com.glqdlt.simple.ui.controller.book.BookRestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRestTests {

    @Autowired
    @InjectMocks
    private BookRestController bookRestController;

    private MockMvc mockMvc;

    private static final Logger log = LoggerFactory.getLogger(BookRestTests.class);

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookRestController).build();
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void getEpgData() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("draw", "1");
        params.add("length", "10");
        params.add("start", "10");
        params.add("searchForm", "");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/book/list").params(params)).andReturn();
        MockHttpServletResponse mockHttpServletResponse =result.getResponse();

        Assert.assertEquals(mockHttpServletResponse.getStatus(),200);

    }

}
