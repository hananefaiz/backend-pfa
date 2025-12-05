package com.arrgano.repository;

import com.arrgano.model.PrimaryProcessing;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PrimaryProcessingRepository extends MongoRepository<PrimaryProcessing, String> {
    List<PrimaryProcessing> findByBatchId(String batchId);
    List<PrimaryProcessing> findByMainOperator(String operatorId);
}
