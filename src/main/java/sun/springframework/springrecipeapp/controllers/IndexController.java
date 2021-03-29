package sun.springframework.springrecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.springframework.springrecipeapp.domain.Category;
import sun.springframework.springrecipeapp.domain.UnitOfMeasure;
import sun.springframework.springrecipeapp.repositories.CategoryRepository;
import sun.springframework.springrecipeapp.repositories.UnitOfMeasureRepository;
import sun.springframework.springrecipeapp.service.RecipeService;

import java.util.Optional;
@Slf4j
@Controller
public class IndexController {

private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        log.debug("Getting index page.");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

}
