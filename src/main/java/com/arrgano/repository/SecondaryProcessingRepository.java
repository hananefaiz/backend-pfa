package com.arrgano.repository;

import com.arrgano.model.SecondaryProcessing;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SecondaryProcessingRepository extends MongoRepository<SecondaryProcessing, String> {
    List<SecondaryProcessing> findByBatchId(String batchId);
    List<SecondaryProcessing> findByMachineOperator(String operatorId);
}
