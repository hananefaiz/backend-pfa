package com.arrgano.repository;

import com.arrgano.model.Batch;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BatchRepository extends MongoRepository<Batch, String> {
    List<Batch> findByOperatorId(String operatorId);
    List<Batch> findByStatus(String status);
    List<Batch> findByOperatorIdAndStatus(String operatorId, String status);
}
