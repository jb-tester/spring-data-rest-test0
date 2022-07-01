package com.mytests.spring.springDataRestTest0;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataRestTest0ApplicationTests {
    @Autowired
    WebApplicationContext context;


    MockMvc mvc;

    @Before()
    public void setUp() {

        this.mvc = webAppContextSetup(context).build();


    }

    @Test
    public void testFamily() throws Exception {
        mvc.perform(get("/data-rest-test0/family").accept(MediaTypes.HAL_JSON))
                .andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON))
                .andExpect(status().isOk());

    }
    @Test
    public void testSearchByName() throws Exception {
        mvc.perform(get("/data-rest-test0/family/search/findByFirstName")
                        .accept(MediaTypes.HAL_JSON)
                        .param("firstName","vera"))
                .andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..relatives[0].lastName").value("ivanova"));

    }
    @Test
    public void testSearchByFamilyName() throws Exception {
        mvc.perform(get("/data-rest-test0/family/search/surnames")
                        .accept(MediaTypes.HAL_JSON)
                        .param("surname","petrovskaya"))
                .andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..relatives[?(@.firstName == 'irina')]").exists());

    }
}
