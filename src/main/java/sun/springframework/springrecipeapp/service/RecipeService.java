package sun.springframework.springrecipeapp.service;

import sun.springframework.springrecipeapp.commands.RecipeCommand;
import sun.springframework.springrecipeapp.domain.Ingredient;
import sun.springframework.springrecipeapp.domain.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    RecipeCommand findCommandById(Long id);
    void deleteById(Long id);

}
