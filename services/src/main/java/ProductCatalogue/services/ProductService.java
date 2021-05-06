package ProductCatalogue.services;

import ProductCatalogue.Exception.ItemNotFoundException;
import ProductCatalogue.ModelAndRepository.MRepo;
import ProductCatalogue.ModelAndRepository.Manufacturer;
import ProductCatalogue.ModelAndRepository.Product;
import ProductCatalogue.ModelAndRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    MService mserv;
    @Autowired
    ProductRepository prepo;
    @Autowired
    MRepo mrepo;

    public Iterable<Product> findAll() {
        return prepo.findAll();
    }

}

