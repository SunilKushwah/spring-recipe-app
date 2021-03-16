package sun.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sun.springframework.springrecipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
