package sun.springframework.springrecipeapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.springframework.springrecipeapp.domain.Recipe;
import sun.springframework.springrecipeapp.repositories.RecipeRepository;
import sun.springframework.springrecipeapp.service.ImageService;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    @Transactional
    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try{
            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[]  byteObject = new Byte[file.getBytes().length];
            int i=0;
            for(byte b: file.getBytes()){
                byteObject[i++] = b;
            }
            recipe.setImage(byteObject);
            recipeRepository.save(recipe);

        }catch (Exception e){
            //todo handle better
            log.error("error occurred", e);
            e.printStackTrace();
        }

    }
}

