package com.myApplication.product;

import com.myApplication.product.Exception.BatchNotFoundException;
import com.myApplication.product.Exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MService {
    @Autowired
    MRepo mrepo;

    @Autowired
    ProductRepository prepo;

    public Iterable<Manufacturer> findAllManufacturer(){
        return mrepo.findAll();
    }

    public List<Manufacturer> findAllManufacturerByBatchid(int batchid){
        if(mrepo.existsByBatchid(batchid)){
            return mrepo.findByBatchid(batchid);
        }
        else {
            throw new ItemNotFoundException("Items having batch_id:"+batchid+" not found");
        }
    }

    public Manufacturer findManufacturerById(int batchid, int id){
        if(mrepo.existsByBatchid(batchid) && mrepo.existsById(id)) {
            return mrepo.findById(id).get();
        }
        else{
            throw new ItemNotFoundException("Item having batch_id:"+batchid+" and id:"+id+" not found");
        }
    }
}
