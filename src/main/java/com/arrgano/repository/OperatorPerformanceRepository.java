package com.arrgano.repository;

import com.arrgano.model.OperatorPerformance;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

public interface OperatorPerformanceRepository extends MongoRepository<OperatorPerformance, String> {
    List<OperatorPerformance> findByEvaluationDateBetween(Date startDate, Date endDate);
    List<OperatorPerformance> findByLotId(String lotId);
}
