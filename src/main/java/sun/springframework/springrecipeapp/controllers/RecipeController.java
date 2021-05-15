package sun.springframework.springrecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.springframework.springrecipeapp.commands.RecipeCommand;
import sun.springframework.springrecipeapp.service.RecipeService;

@Slf4j
@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @GetMapping("/recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @PostMapping("/recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand recipeCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/"+recipeCommand.getId()+"/show";

    }
    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }
    @GetMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id){
        log.debug("Deleting Recipe Id:"+id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
