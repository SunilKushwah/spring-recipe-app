package sun.springframework.springrecipeapp.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sun.springframework.springrecipeapp.commands.UnitOfMeasureCommand;
import sun.springframework.springrecipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import sun.springframework.springrecipeapp.domain.UnitOfMeasure;
import sun.springframework.springrecipeapp.repositories.UnitOfMeasureRepository;
import sun.springframework.springrecipeapp.service.UnitOfMeasureService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitOfMeasureServiceImplTest {
    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    private UnitOfMeasureService unitOfMeasureService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository,unitOfMeasureToUnitOfMeasureCommand);
    }


    @Test
    void listAllUoms() {
        //given
        Set<UnitOfMeasure> uoms = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        uoms.add(uom1);
        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        uoms.add(uom2);
        when(unitOfMeasureRepository.findAll()).thenReturn(uoms);

        //when
        Set<UnitOfMeasureCommand> unitOfMeasureCommands = unitOfMeasureService.listAllUoms();

        //then
        assertEquals(2,unitOfMeasureCommands.size());
        verify(unitOfMeasureRepository,times(1)).findAll();

    }
}