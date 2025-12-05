package com.arrgano.security;


import com.arrgano.model.OperatorPerformance;
import com.arrgano.model.ProductionStats;
import com.arrgano.repository.OperatorPerformanceRepository;
import com.arrgano.repository.ProductionStatsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDashboardData(ProductionStatsRepository statsRepository,
                                        OperatorPerformanceRepository performanceRepository) {
        return args -> {
            // Stats de production
            statsRepository.save(new ProductionStats(new Date(), 220, 45, 33, 27, "LOT-001"));

            // Performances des opérateurs
            performanceRepository.save(new OperatorPerformance("OP1", "Opérateur A", 95, 92, "LOT-001"));
            performanceRepository.save(new OperatorPerformance("OP2", "Opérateur B", 89, 88, "LOT-001"));
        };
    }
}
