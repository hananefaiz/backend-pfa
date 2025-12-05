package com.arrgano.repository;

import com.arrgano.model.ProductionStats;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

public interface ProductionStatsRepository extends MongoRepository<ProductionStats, String> {
    List<ProductionStats> findByDateBetween(Date startDate, Date endDate);
    List<ProductionStats> findByLotId(String lotId);
}
