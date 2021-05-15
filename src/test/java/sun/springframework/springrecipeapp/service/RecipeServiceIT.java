package sun.springframework.springrecipeapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import sun.springframework.springrecipeapp.commands.RecipeCommand;
import sun.springframework.springrecipeapp.converters.RecipeCommandToRecipe;
import sun.springframework.springrecipeapp.converters.RecipeToRecipeCommand;
import sun.springframework.springrecipeapp.domain.Recipe;
import sun.springframework.springrecipeapp.repositories.RecipeRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecipeServiceIT {

    public static final String DESCRIPTION = "new description";
    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Test
    @Transactional
    void testOfSaveDescription() {
        //given
        Iterable<Recipe> all = recipeRepository.findAll();
        Recipe next = all.iterator().next();
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(next);

        //when
        recipeCommand.setDescription(DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);

        //then
        assertNotNull(savedRecipeCommand);
        assertEquals(DESCRIPTION,savedRecipeCommand.getDescription());
        assertEquals(next.getId(),savedRecipeCommand.getId());
        assertEquals(next.getCategories().size(),savedRecipeCommand.getCategories().size());
        assertEquals(next.getIngredients().size(),savedRecipeCommand.getIngredients().size());

    }
}