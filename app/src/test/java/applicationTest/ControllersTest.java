package applicationTest;

import ProductCatalogue.ModelAndRepository.Cart;
import ProductCatalogue.ModelAndRepository.Manufacturer;
import ProductCatalogue.ModelAndRepository.Product;
import ProductCatalogue.ProductApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ProductApplication.class)
@AutoConfigureMockMvc
public class ControllersTest extends AbstractMapping{
@Autowired
    MockMvc mvc;
    @Test
    public void findAllBatchesTest() throws Exception{
        String uri="/batches";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content=mvcResult.getResponse().getContentAsString();
        Product[] batches=super.mapFromJson(content, Product[].class);
        assertTrue(batches.length>0);
    }

    @Test
    public void findAllProductsTest() throws Exception{
        String uri="/batches/2/products";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content=mvcResult.getResponse().getContentAsString();
        Manufacturer[] products=super.mapFromJson(content, Manufacturer[].class);
        assertTrue(products.length>0);
    }

    @Test
    public void getProductsById() throws Exception{
        mvc.perform(MockMvcRequestBuilders
        .get("/batches/1/products/{id}", 11)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(11));
    }

    @Test
    public void addToCartTest() throws Exception{
        String uri="/batches/1/products/11/add";
        Cart cart=new Cart(1,11,"Apple", 1);
        String inputJson=super.mapToJson(cart);
        MvcResult mvcR=mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status=mvcR.getResponse().getStatus();
        assertEquals(201,status);
        String content=mvcR.getResponse().getContentAsString();
        assertEquals(content,"Added to Cart");
    }

    @Test
    public void findAllProductsOfCartTest() throws Exception{
        String uri="/cartItems";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content=mvcResult.getResponse().getContentAsString();
        Cart[] carts=super.mapFromJson(content, Cart[].class);
        assertTrue(carts.length==0);
    }

    @Test
    public void findAllProductsOfCartTest2() throws Exception{
        String uri="/cartItems";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content=mvcResult.getResponse().getContentAsString();
        Cart[] carts=super.mapFromJson(content, Cart[].class);
        assertTrue(carts.length>0);
    }

    @Test
    public void addToCartTest2() throws Exception{
        String uri="/batches/1/products/12/add";
        Cart cart=new Cart(1,11,"ABC", 1);
        String inputJson=super.mapToJson(cart);
        MvcResult mvcR=mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status=mvcR.getResponse().getStatus();
        assertEquals(404,status);
        String content=mvcR.getResponse().getContentAsString();
        assertEquals(content,"Product not found in the product catalog");
    }

    @Test
    public void deleteFromCart() throws Exception{
        String uri="/cartItems/1/11/remove";
        MvcResult mvcR=mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status=mvcR.getResponse().getStatus();
        assertEquals(404, status);
        String content=mvcR.getResponse().getContentAsString();
        assertEquals(content, "Product not found in cart");
    }

    @Test
    public void deleteFromCart2() throws Exception{
        String uri="/cartItems/1/11/remove";
        MvcResult mvcR=mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status=mvcR.getResponse().getStatus();
        assertEquals(200, status);
        String content=mvcR.getResponse().getContentAsString();
        assertEquals(content, "Removed from Cart");
    }

   @Test
    public void checkoutTest() throws Exception{
        String uri="/cartItems/checkout";
        MvcResult mvcR=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
        int status=mvcR.getResponse().getStatus();
        assertEquals(404, status);
        String content=mvcR.getResponse().getContentAsString();
        assertEquals(content, "Cart is Empty");
    }

    @Test
    public void updateTest2() throws Exception{
        String uri="/cartItems/1/11/update";
        Cart cart=new Cart(1,11,"Apple", 2);
        String inputJson=super.mapToJson(cart);
        MvcResult mvcR=mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status=mvcR.getResponse().getStatus();
        assertEquals(201,status);
        String content=mvcR.getResponse().getContentAsString();
        assertEquals(content,"Product is added");
    }

    @Test
    public void updateTest3() throws Exception{
        String uri="/cartItems/1/11/update";
        Cart cart=new Cart(1,11,"Apple", 2);
        String inputJson=super.mapToJson(cart);
        MvcResult mvcR=mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status=mvcR.getResponse().getStatus();
        assertEquals(200,status);
        String content=mvcR.getResponse().getContentAsString();
        assertEquals(content,"Nothing to update");
    }

}
