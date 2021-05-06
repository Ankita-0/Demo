package ProductCatalogue.services;

import ProductCatalogue.Exception.CartIsEmptyException;
import ProductCatalogue.Exception.ItemNotFoundException;
import ProductCatalogue.Exception.ItemNotFoundInCartException;

import ProductCatalogue.ModelAndRepository.Cart;
import ProductCatalogue.ModelAndRepository.CartRepo;
import ProductCatalogue.ModelAndRepository.MRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartService {
    @Autowired
    CartRepo crepo;
    @Autowired
    MRepo mrepo;

    public Cart getProduct(int id){
        return crepo.findById(id).orElseThrow(() -> new ItemNotFoundInCartException("Item "+id+" not found in cart"));
    }

    public String addToCart(int batchid, int id, Cart cart) {
        int quantity;
        if(mrepo.existsByBatchidAndId(batchid, id)
                && mrepo.existsByIdAndName(id, cart.getName())){
            if (crepo.existsById(cart.getId())) {
                quantity= crepo.getQuantity();
                crepo.deleteById(cart.getId());
                cart.setQuantity(cart.getQuantity()+quantity);
            }
            crepo.save(cart);
            return "Added to Cart";
        }
        else{
            throw new ItemNotFoundException("Product not found in the product catalog");
        }
    }

    public Iterable<Cart> findAll(){
        return crepo.findAll();
    }

    public String delete(int batchid, int id){
        if(crepo.existsByBatchidAndId(batchid, id)){
            crepo.deleteById(id);
            return "Removed from Cart";
    }
        else{
            throw new ItemNotFoundInCartException("Product not found in cart");
        }
    }

    public String orderPlaced(Iterable<Cart> cart){
        List<Cart> c=StreamSupport
                .stream(findAll().spliterator(), false)
                .collect(Collectors.toList());

        if(c.size()>0) {
            return "Order Placed";
        }
        else{
            throw new CartIsEmptyException("Cart is Empty");
        }
    }

    public String checkout(){
        String msg=orderPlaced(findAll());
        crepo.deleteAll();
        return msg;
    }

    public ResponseEntity<String> update(int batchid, int id, Cart cart){
            Optional<Cart> cOp=crepo.findById(id);
            if(cOp.isPresent())
                return new ResponseEntity<>("Nothing to update", HttpStatus.OK);

            //else{
            //crepo.deleteById(id);
            //crepo.save(cart);
            //return new ResponseEntity<>("Quantity is updated", HttpStatus.OK);
            //}
        else{
            crepo.save(cart);
            return new ResponseEntity<>("Product is added", HttpStatus.CREATED);

        }
    }
}
