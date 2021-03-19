package sun.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sun.springframework.springrecipeapp.domain.Category;
import sun.springframework.springrecipeapp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
