package sun.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sun.springframework.springrecipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
