package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;

@Service
public class MService {
    @Autowired
    MRepo mrepo;

    public Iterable<Manufacturer> findAllManufacturer(){
        return mrepo.findAll();
    }

    public List<Manufacturer> findAllManufacturerByBatchid(int batchid){

        return mrepo.findByBatchid(batchid);}

    public Manufacturer findManufacturerById(int id){ return mrepo.findById(id).get();}
}
