package sun.springframework.springrecipeapp.service;

import sun.springframework.springrecipeapp.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);

}
