package sun.springframework.springrecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.springframework.springrecipeapp.commands.RecipeCommand;
import sun.springframework.springrecipeapp.exceptions.NotFoundException;
import sun.springframework.springrecipeapp.service.RecipeService;

import javax.validation.Valid;

@Slf4j
@Controller
public class RecipeController {

    private RecipeService recipeService;

    private String RECIPE_RECIPEFORM_URL = "recipe/recipeform";

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

        return RECIPE_RECIPEFORM_URL;
    }

    @PostMapping("/recipe")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult){//binding result is result of validation
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });
            return  RECIPE_RECIPEFORM_URL;
        }
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){
        log.error("Handling not found exception");
        log.error(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }


}
