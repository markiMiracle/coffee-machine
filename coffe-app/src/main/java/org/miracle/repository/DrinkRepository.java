package org.miracle.repository;

import org.miracle.model.Drink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Optional<Drink> findByName(String name);

    List<Drink> findAllByCreatedAtBefore(LocalDate date);

    @Query("SELECT d FROM Drink d ORDER BY d.popularity DESC")
    Page<Drink> findAllByPopularity(Pageable pageable);

    @Query("SELECT d FROM Drink d ORDER BY d.createdAt")
    Page<Drink> findAllByCreatedAt(Pageable pageable);

    void deleteByName(String name);
}
