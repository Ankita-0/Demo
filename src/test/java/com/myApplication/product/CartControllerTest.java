package com.myApplication.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;
import java.util.stream.StreamSupport;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CartController.class)
class CartControllerTest {
    @MockBean
    CartService cserv;

    @Autowired
    MockMvc mvc;

    private List<Cart> cartList;

    @BeforeEach
    void setUp(){
        this.cartList=new ArrayList<>();
        this.cartList.add(new Cart(1, 23, "abc", 1));
        this.cartList.add(new Cart(1, 55, "afd", 1));
        this.cartList.add(new Cart(7, 78, "hgj", 1));
    }

    //@Test
    //void testAddToCart() throws Exception{
      //  CartController con=new CartController();
        //Cart c=new Cart(anyInt(), anyInt(), anyString(), anyInt());
        //doReturn("Added to Cart").when(cserv.addToCart(c));
        //String s=cserv.addToCart(c);
        //assertEquals("Added to Cart", s);
    //}

   /* @Test
    void testfindCartItems() throws Exception{
        given(cserv.findAll()).willReturn(cartList);
        mvc.perform(MockMvcRequestBuilders.get("/cartItems"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(jsonPath("$.size()", is(cartList.size())));
    }

   // @Test
    //void findCartItemsTest() throws Exception{
       // Cart c=new Cart(anyInt(), anyInt(), anyString(), anyInt());
        //doReturn(Optional.of(c)).when(cserv).findAll();
       // Iterable<Cart> i=cserv.findAll();
       // Assertions.assertTrue( Iterables.size(i), "Products should be present in the cart");
        //assertEquals(StreamSupport.stream(i.spliterator(),false).count(), );

    //}

    */
}

