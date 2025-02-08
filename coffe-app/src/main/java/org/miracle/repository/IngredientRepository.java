package org.miracle.repository;

import org.miracle.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Ingredient> findByName(String name);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Ingredient> findByNameIn(List<String> names);

}
