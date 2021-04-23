package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MController {
    @Autowired
    MService mserv;

    @GetMapping(value = "/manufacturers")
    public Iterable<Manufacturer> findAllManufacturer(){
        return mserv.findAllManufacturer();
    }

    @GetMapping(value = "/batches/{batchid}/manufacturers")
    List<Manufacturer> findByBatch_id(@PathVariable int batchid){
        return mserv.findAllManufacturerByBatchid(batchid);
    }

    @GetMapping(value = "/batches/{batchid}/manufacturers/{id}")
    Manufacturer findbyid(@PathVariable int batchid, @PathVariable int id){
        return mserv.findManufacturerById(id);
    }
}
