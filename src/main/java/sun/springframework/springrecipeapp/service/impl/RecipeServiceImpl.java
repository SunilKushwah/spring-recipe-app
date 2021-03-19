package sun.springframework.springrecipeapp.service.impl;

import org.springframework.stereotype.Service;
import sun.springframework.springrecipeapp.domain.Recipe;
import sun.springframework.springrecipeapp.repositories.RecipeRepository;
import sun.springframework.springrecipeapp.service.RecipeService;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        Iterable<Recipe> all = recipeRepository.findAll();
        all.iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
