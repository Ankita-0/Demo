package ProductCatalogue.ModelAndRepository;
import ProductCatalogue.ModelAndRepository.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends CrudRepository<Cart, Integer> {
    boolean existsByBatchidAndId(int batchid, int id);

    @Query("select c.quantity from Cart c where c.id=id")
    Integer getQuantityById(int id);

    @Query("select c.quantity from Cart c")
    Integer getQuantity();

    Cart findByBatchidAndId(int batchid, int id);
}
