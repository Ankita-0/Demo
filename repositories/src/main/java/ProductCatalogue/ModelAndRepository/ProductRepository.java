package ProductCatalogue.ModelAndRepository;

import ProductCatalogue.ModelAndRepository.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
