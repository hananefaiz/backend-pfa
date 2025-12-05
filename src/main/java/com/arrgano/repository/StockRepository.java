package com.arrgano.repository;

import com.arrgano.model.StockItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface StockRepository extends MongoRepository<StockItem, String> {
    List<StockItem> findAllByOrderByNameAsc();
    Optional<StockItem> findByName(String name);
    Optional<StockItem> findByType(String type);
}
