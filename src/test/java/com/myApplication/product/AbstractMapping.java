package com.myApplication.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

@SpringBootTest(classes = ProductApplication.class)
@WebAppConfiguration
public abstract class AbstractMapping {
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext w;

    protected void setUp(){
        mvc= MockMvcBuilders.webAppContextSetup(w).build();
    }
    protected String mapToJson(Object obj) throws JsonProcessingException{
        ObjectMapper objMap=new ObjectMapper();
        return objMap.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> c) throws JsonMappingException, IOException, JsonProcessingException {
        ObjectMapper objMap=new ObjectMapper();
        return objMap.readValue(json, c);
    }
}
