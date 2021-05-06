package ProductCatalogue.controllers;

import ProductCatalogue.ModelAndRepository.Cart;
import ProductCatalogue.services.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="Endpoints for cart")
@RestController
public class CartController {
    @Autowired
    CartService cserv;

    @ApiOperation(value= "Adds products to the cart",
            notes= "Add any product which is available in the Product Catalogue", responseContainer = "String")
    @ApiResponses(value = {
            @ApiResponse(code= 404, message = "Not Found"),
            @ApiResponse(code= 201, message= "Created")})
    @PostMapping("/batches/{batchid}/products/{id}/add")
    public ResponseEntity<String> addToCart(@PathVariable int batchid, @PathVariable int id, @RequestBody Cart cart){
        return new ResponseEntity<>(cserv.addToCart(batchid, id, cart), HttpStatus.CREATED);
    }

    @ApiOperation(value= "Removes products from cart",
            notes= "Remove any product that is present in the cart", responseContainer = "String")
    @DeleteMapping("/cartItems/{batchid}/{id}/remove")
    String delete(@PathVariable int batchid, @PathVariable int id){
        return cserv.delete(batchid, id);
    }

    @ApiOperation(value = "View Cart",
            notes= "View what is present in the cart", response = Cart.class, responseContainer = "List")
    @GetMapping(value = "/cartItems")
    public Iterable<Cart> findCartItems(){
        return cserv.findAll();
    }

    @ApiOperation(value= "Checkout to place the order",
            notes= "All the items from the cart would be removed and the cart will be empty after this.", responseContainer = "String")
    @GetMapping(value = "/cartItems/checkout")
    public String checkout(){
        return cserv.checkout();
    }

    @ApiOperation(value= "Products", responseContainer = "String")
    @ApiResponses(value = {
            @ApiResponse(code= 201, message= "Created"),
            @ApiResponse(code=200, message= "Nothing to update")})
    @PutMapping(value = "/cartItems/{batchid}/{id}/update")
    public ResponseEntity<String> update(@PathVariable int batchid, @PathVariable int id, @RequestBody Cart cart){
        return (cserv.update(batchid, id, cart));
    }

}
