package sun.springframework.springrecipeapp.service;

import sun.springframework.springrecipeapp.commands.IngredientCommand;
import sun.springframework.springrecipeapp.domain.Ingredient;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);
}
