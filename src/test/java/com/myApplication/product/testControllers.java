package com.myApplication.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testControllers extends AbstractMapping{

    @Override
    @BeforeEach
    public void setUp(){
        super.setUp();
    }

    @Test
    public void testGetAll() throws Exception{
        String uri="/batches";
        MvcResult r=mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status=r.getResponse().getStatus();
        assertEquals(200, status);
        String c=r.getResponse().getContentAsString();
        Product[] products=super.mapFromJson(c, Product[].class);
        assertTrue(products.length>=0);
    }

    @Test
    public void testGetById() throws Exception{
        String uri="/batches/1/products/11";
        MvcResult r=mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status=r.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testAddToCart() throws Exception{
        String uri="/add";
        Cart c=new Cart(2, 31, "Samsung", 1);
        String iJson=super.mapToJson(c);
        MvcResult r=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(iJson)).andReturn();
        int status=r.getResponse().getStatus();
        assertEquals(200, status);
        String s=r.getResponse().getContentAsString();
        assertEquals(s, "Added to Cart");
    }

    @Test
    public void testRemoveFromCart() throws Exception{
        String uri="/remove/31";
        MvcResult r=mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status=r.getResponse().getStatus();
        assertEquals(400, status);
        String content=r.getResponse().getContentAsString();
        assertEquals(content,"Product 31 not found in cart");
    }

    @Test
    public void testRemoveFromCartF() throws Exception{
        String uri="/remove/31";
        MvcResult r=mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status=r.getResponse().getStatus();
        assertEquals(200, status);
        String s=r.getResponse().getContentAsString();
        assertTrue(s.contains("Removed from Cart"));
    }
}

