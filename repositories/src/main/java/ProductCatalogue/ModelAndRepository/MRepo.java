package ProductCatalogue.ModelAndRepository;

import ProductCatalogue.ModelAndRepository.Manufacturer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MRepo extends CrudRepository<Manufacturer, Integer>{
    List<Manufacturer> findByBatchid(int batchid);

    boolean existsByBatchid(Integer integer);

    boolean existsByIdAndName(int id, String name);

    boolean existsByBatchidAndId(int batchid, int id);

    Manufacturer findByBatchidAndId(int batchid, int id);

    //@Query("select p.price from Products p")
    //Double getPrice();
}
