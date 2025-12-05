package com.arrgano.repository;

import com.arrgano.model.WomenGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface GroupRepository extends MongoRepository<WomenGroup, String> {
    List<WomenGroup> findByLocation(String location);
    List<WomenGroup> findByLeaderNameContainingIgnoreCase(String leaderName);
}
