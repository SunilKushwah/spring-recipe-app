package sun.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sun.springframework.springrecipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
