package com.arrgano.repository;

import com.arrgano.model.OilTransformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface OilTransformationRepository extends MongoRepository<OilTransformation, String> {
    List<OilTransformation> findByLotId(String lotId);
    List<OilTransformation> findByOperatorId(String operatorId);
}
