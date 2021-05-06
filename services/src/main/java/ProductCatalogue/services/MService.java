package ProductCatalogue.services;

import ProductCatalogue.Exception.ItemNotFoundException;
import ProductCatalogue.ModelAndRepository.MRepo;
import ProductCatalogue.ModelAndRepository.Manufacturer;
import ProductCatalogue.ModelAndRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
