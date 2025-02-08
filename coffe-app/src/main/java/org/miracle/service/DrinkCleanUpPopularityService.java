package org.miracle.service;

import lombok.AllArgsConstructor;
import org.miracle.repository.DrinkRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class DrinkCleanUpPopularityService {

    private final DrinkRepository drinkRepository;

    @Transactional
    @Scheduled(cron = "0 0 0 1 * *")
    public void deleteOldRecords() {
        LocalDate fiveYearsAgo = LocalDate.now().minusYears(5);
        drinkRepository.findAllByCreatedAtBefore(fiveYearsAgo).forEach(drink -> drink.setPopularity(0));
    }

}
