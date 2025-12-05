package com.arrgano.service;

import com.arrgano.model.Batch;
import com.arrgano.model.User;
import com.arrgano.repository.BatchRepository;
import com.arrgano.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OperatorService {
    private final BatchRepository batchRepository;
    private final UserRepository userRepository;

    public OperatorService(BatchRepository batchRepository, UserRepository userRepository) {
        this.batchRepository = batchRepository;
        this.userRepository = userRepository;
    }

    public List<Batch> getCurrentBatches(String operatorId) {
        return batchRepository.findByOperatorIdAndStatus(operatorId, "IN_PROGRESS");
    }

    public List<Batch> getCompletedBatches(String operatorId) {
        return batchRepository.findByOperatorIdAndStatus(operatorId, "COMPLETED");
    }

    public Batch createNewBatch(String batchId, String operatorId) {
        Batch batch = new Batch();
        batch.setBatchId(batchId);
        batch.setStartDate(new Date());
        batch.setOperatorId(operatorId);
        batch.setStatus("IN_PROGRESS");
        return batchRepository.save(batch);
    }
    public User getCurrentOperator() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.orElseThrow(() ->
                new RuntimeException("Operator not found with email: " + email));
    }
}
