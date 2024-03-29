package sun.springframework.springrecipeapp.controllers;

import org.h2.util.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.springframework.springrecipeapp.commands.RecipeCommand;
import sun.springframework.springrecipeapp.domain.Recipe;
import sun.springframework.springrecipeapp.service.ImageService;
import sun.springframework.springrecipeapp.service.RecipeService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}/image")
    public String saveImageFile(@PathVariable String id, Model model){
        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/imageuploadform";
    }

    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile")MultipartFile file){
        imageService.saveImageFile(Long.valueOf(id),file);
        return "redirect:/recipe/"+id+"/show";
    }

    @GetMapping("recipe/{id}/recipeimage")
    public void getRecipeImage(@PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));
        byte[] byteArray = new byte[recipeCommand.getImage().length];
        int i=0;
        for(Byte b : recipeCommand.getImage()){
            byteArray[i++] = b;
        }
        httpServletResponse.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(byteArray);
        IOUtils.copy(is,httpServletResponse.getOutputStream());

    }
}
