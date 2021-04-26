package com.myApplication.product;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MRepo extends CrudRepository<Manufacturer, Integer>{
    List<Manufacturer> findByBatchid(int batchid);

    boolean existsByBatchid(Integer integer);

    boolean existsByName(String name);

    boolean existsByBatchidAndName(int batchid, String name);

    boolean existsByIdAndName(int id, String name);
}
