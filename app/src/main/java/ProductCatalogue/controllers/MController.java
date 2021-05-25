package ProductCatalogue.controllers;

import ProductCatalogue.ModelAndRepository.Manufacturer;
import ProductCatalogue.ModelAndRepository.Product;
import ProductCatalogue.services.MService;
import ProductCatalogue.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Api(value = "Endpoints for details of batches and products")
@RestController
public class MController {
    @Autowired
    MService mserv;

    @Autowired
    ProductService service;

    Logger logger= LoggerFactory.getLogger(MController.class);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gives the details of all the Batches", notes="List of Batches", response=Product.class,responseContainer = "List")
    @ApiResponses(value={
            @ApiResponse(code= 500, message= "Server error"),
            @ApiResponse(code= 200, message= "Successful retrieval")})
    @GetMapping(value= "/batches")
    public List<Product> findAll() {
        return StreamSupport
                .stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Gives details of all products present by batch id.", notes ="List of Products", response= Manufacturer.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code=500, message = "Server Error"),
            @ApiResponse(code=200, message="Successful Retrieval")})
    @GetMapping(value = "/batches/{batchid}/products")
    List<Manufacturer> findByBatchid(@PathVariable int batchid){
        logger.info("Getting all the products having batch_id "+batchid);
        return mserv.findAllManufacturerByBatchid(batchid);
    }

    @ApiOperation(value = "Gives details of the product by batch id and product id", notes= "Product details", response = Manufacturer.class)
    @ApiResponses(value = {
            @ApiResponse(code= 500, message = "Server Error"),
            @ApiResponse(code= 200, message= "Successful Retrieval")})
    @GetMapping(value = "/batches/{batchid}/products/{id}")
    Manufacturer findbyid(@PathVariable int batchid, @PathVariable int id){
        return mserv.findManufacturerById(batchid, id);
    }
}
