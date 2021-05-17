package sun.springframework.springrecipeapp.service.impl;

import org.springframework.stereotype.Service;
import sun.springframework.springrecipeapp.commands.IngredientCommand;
import sun.springframework.springrecipeapp.commands.UnitOfMeasureCommand;
import sun.springframework.springrecipeapp.converters.IngredientToIngredientCommand;
import sun.springframework.springrecipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import sun.springframework.springrecipeapp.repositories.UnitOfMeasureRepository;
import sun.springframework.springrecipeapp.service.UnitOfMeasureService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
       return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
               .map(unitOfMeasureToUnitOfMeasureCommand::convert).collect(Collectors.toSet());

    }
}
