package com.myApplication.product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends CrudRepository<Cart, Integer> {
    boolean existsByBatchidAndId(int batchid, int id);
}
