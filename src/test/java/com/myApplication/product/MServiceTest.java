package com.myApplication.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MServiceTest<plst> {
    @Autowired
    MockMvc mvc;

    @Mock
    MRepo mrepo;
    //@Autowired
    //MRepo mrepo;

    @Mock
    MService mserv;

    @Mock
    ProductService pserv;

    @MockBean
    MController mcon;

    List<Product> plst;

    public void setUp() throws Exception {
        Product p = new Product(1, "ABC", "ghfhgk", 50.00, 1);
        plst = new ArrayList<>();
        plst.add(p);
    }

    @Test
    void testfindAllManufacturer() throws Exception {
        //given(mcon.findAll()).willReturn(plst);
        //mvc.perform(get("/batches")).andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(1)));
        Manufacturer m= new Manufacturer(1, 11, "ABC", 50000.00);
        //mrepo.save(m);
        //assertNotNull(mrepo.findAll());
        MService mserv=new MService();
        List<Manufacturer> lst=new ArrayList<>();
        lst.add(m);
        when(mrepo.findAll()).thenReturn(anyIterable());
        Iterable<Manufacturer> mr=mserv.findAllManufacturer();
        assertSame(lst, mr);

        //assertTrue();
        //doReturn(Optional.of(prod)).when(mrepo.findById(anyInt()));
       // doReturn(Optional.of(prod)).when(mserv.findManufacturerById(anyInt(), anyInt()));
       // Manufacturer returnProduct=mserv.findManufacturerById(1, 11);
       // Assertions.assertSame(returnProduct, prod);

    }

   // @Test
    //public void test
}