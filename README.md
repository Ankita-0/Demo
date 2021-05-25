# Product Catalogue 
Circuit breaker pattern: [Circuit Breaker Implementation](https://github.com/Ankita-0/CircuitBreaker.git)

## Catalogue:

### API Endpoints:

**View all batches(GET):** Get details of all the batches present.
   - *http://localhost:8080/batches*

**View all the products in a particular batch(GET):** Get the details of all the products in a particular batch.
   - *http://localhost:8080/batches/{batchid}/products*
   
**View details of a specific product(GET):** Get details of a product.
  - *http://localhost:8080/batches/{batchid}/products/{id}*
##

## Cart:
### API Endpoints:

**Add to Cart(POST):** Add products to cart.
  - *http://localhost:8080/batches/{batchid}/products/{id}/add*
  
**View Cart(GET):** View cart to see the added products in the cart.
  - *http://localhost:8080/cartItems*
  
**Remove Products from Cart(DELETE):** Remove product that is present in the cart.
  - *http://localhost:8080/cartItems/{batchid}/{id}/remove*
  
**Checkout(GET):** Checkout to place the order the cart will be empty after this.
  - *http://localhost:8080/cartItems/checkout* 
  
**Put Product(PUT):**
  - *http://localhost:8080/cartItems/{batchid}/{id}/update*
##
  
## Actuator:
### Endpoints:

**Created a health group named custom containing only the dp health indicator:**
  - *http://localhost:8080/actuator/health/custom*
  
**Git information:**
  - *http://localhost:8080/actuator/info*
