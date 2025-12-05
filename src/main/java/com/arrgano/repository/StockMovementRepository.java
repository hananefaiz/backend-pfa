package com.arrgano.repository;

import com.arrgano.model.StockMovement;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface StockMovementRepository extends MongoRepository<StockMovement, String> {
    List<StockMovement> findByProductNameOrderByDateDesc(String productName);
    List<StockMovement> findAllByOrderByDateDesc();
}
