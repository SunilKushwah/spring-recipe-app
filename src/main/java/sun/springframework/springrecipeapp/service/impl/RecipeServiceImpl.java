package sun.springframework.springrecipeapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.springframework.springrecipeapp.domain.Recipe;
import sun.springframework.springrecipeapp.repositories.RecipeRepository;
import sun.springframework.springrecipeapp.service.RecipeService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in  the service");
        Set<Recipe> recipeSet = new HashSet<>();
        Iterable<Recipe> all = recipeRepository.findAll();
        all.iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(!recipeOptional.isPresent())
            throw new RuntimeException("recipe not found");

        return recipeOptional.get();
    }

}
