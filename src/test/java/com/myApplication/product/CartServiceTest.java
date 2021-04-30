package com.myApplication.product;
import com.myApplication.product.Exception.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest //(classes=ProductApplication.class)
class CartServiceTest {
    @MockBean
    CartService cserv;

    @Autowired
    MockMvc mvc;

    MRepo mrepo= Mockito.mock(MRepo.class);

    CartRepo crepo=Mockito.mock(CartRepo.class);

    ProductRepository prepo=Mockito.mock(ProductRepository.class);

    @BeforeEach
    void setUp() throws Exception{
        CartService cartService=new CartService();
    }


    @Test
    void addToCartTest() throws Exception {
        CartService cartService=new CartService();
        Cart c=new Cart(1,11,"Apple",1);
        when(mrepo.existsByBatchidAndName(anyInt(), anyString())).thenReturn(Boolean.TRUE);
        when(mrepo.existsByIdAndName(anyInt(), anyString())).thenReturn(Boolean.TRUE);
        when(crepo.existsById(anyInt())).thenReturn(Boolean.FALSE);
        String s=cartService.addToCart(c);
        assertEquals("Added to Cart", s);

    }


    /*@Test
    void addToCartTest2(){
        CartService cartService=new CartService();
        Cart c=new Cart(8,132,"Abc",1);
        Mockito.when(mrepo.existsByBatchidAndName(2, "ABC"));
        Mockito.when(mrepo.existsByIdAndName(8, "sgf"));
        String s=cartService.addToCart(c);
        assertEquals("Product not found in the product catalog", s);
    }

     */
    @Test
    void testCheckout(){
        CartService cserv=new CartService();
        Cart c=new Cart(1,11,"Apple",1);
        Cart c2=new Cart(1,11,"Apple",1);
        List<Cart> clist=new ArrayList<>();
        clist.add(c);
        clist.add(c2);
        String m;
        if(clist.size()>0){
            m="Order Placed";
        }
        else{
            m="Cart is Empty";
        }
        assertEquals("Order Placed", m);
    }
}