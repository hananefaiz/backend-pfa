package com.arrgano.service;

import com.arrgano.model.*;
import com.arrgano.repository.*;
import org.springframework.stereotype.Service;
import com.arrgano.dto.PrimaryProcessingForm;
import java.util.Date;
import java.util.List;

@Service
public class ProcessingService {
    private final PrimaryProcessingRepository primaryRepo;
    private final SecondaryProcessingRepository secondaryRepo;
    private final StockService stockService;
    private final UserRepository userRepository;
    private final MachineRepository machineRepository;

    public ProcessingService(PrimaryProcessingRepository primaryRepo,
                             SecondaryProcessingRepository secondaryRepo,
                             StockService stockService,
                             UserRepository userRepository,
                             MachineRepository machineRepository) {
        this.primaryRepo = primaryRepo;
        this.secondaryRepo = secondaryRepo;
        this.stockService = stockService;
        this.userRepository = userRepository;
        this.machineRepository = machineRepository;
    }

    public PrimaryProcessing startPrimaryProcessing(String batchId, String operatorId) {
        PrimaryProcessing processing = new PrimaryProcessing();
        processing.setBatchId(batchId);
        processing.setStartDate(new Date());
        processing.setMainOperator(operatorId);
        return primaryRepo.save(processing);
    }

    public PrimaryProcessing updatePrimaryProcessing(String id, PrimaryProcessingForm form) {
        PrimaryProcessing processing = primaryRepo.findById(id).orElseThrow();
        processing.setFruitQuantity(form.getFruitQuantity());
        processing.setAlmondQuantity(form.getAlmondQuantity());
        processing.setTargetYield(form.getTargetYield());
        processing.setComments(form.getComments());
        processing.setOperators(form.getOperators());
        processing.calculateYield();

        stockService.updateFruitStock(-form.getFruitQuantity());
        stockService.updateAlmondStock(form.getAlmondQuantity());

        return primaryRepo.save(processing);
    }

    public SecondaryProcessing startSecondaryProcessing(String batchId, String primaryProcessingId) {
        SecondaryProcessing processing = new SecondaryProcessing();
        processing.setBatchId(batchId);
        processing.setPrimaryProcessingId(primaryProcessingId);
        processing.setProcessingDate(new Date());
        return secondaryRepo.save(processing);
    }

    public double getCurrentFruitStock() {
        return stockService.getCurrentFruitStock();
    }

    public double getCurrentAlmondStock() {
        return stockService.getCurrentAlmondStock();
    }

    public PrimaryProcessing getPrimaryProcessing(String batchId) {
        return primaryRepo.findByBatchId(batchId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Lot non trouvé"));
    }
    public List<Machine> getAvailableMachines() {
        return machineRepository.findByStatus("EN_SERVICE");
    }

}
