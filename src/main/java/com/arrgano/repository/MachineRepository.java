package com.arrgano.repository;

import com.arrgano.model.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MachineRepository extends MongoRepository<Machine, String> {
    List<Machine> findByInService(boolean inService);
    long countByInService(boolean inService);
    List<Machine> findByStatus(String status);
    List<Machine> findByType(String type);
    List<Machine> findByTypeAndStatus(String type, String status);

}
