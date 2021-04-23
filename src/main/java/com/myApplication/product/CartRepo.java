package com.myApplication.product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartRepo extends CrudRepository<Cart, Integer> {
}
