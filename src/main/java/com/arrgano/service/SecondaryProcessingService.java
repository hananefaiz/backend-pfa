package com.arrgano.service;

import com.arrgano.dto.SecondaryProcessingForm;
import com.arrgano.model.*;
import com.arrgano.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SecondaryProcessingService {
    private final SecondaryProcessingRepository processingRepo;
    private final MachineRepository machineRepo;
    private final UserRepository userRepo;
    private final StockService stockService;

    public SecondaryProcessingService(SecondaryProcessingRepository processingRepo,
                                      MachineRepository machineRepo,
                                      UserRepository userRepo,
                                      StockService stockService) {
        this.processingRepo = processingRepo;
        this.machineRepo = machineRepo;
        this.userRepo = userRepo;
        this.stockService = stockService;
    }

    @Transactional
    public SecondaryProcessing startProcessing(String batchId, SecondaryProcessingForm form) {
        SecondaryProcessing processing = new SecondaryProcessing();
        processing.setBatchId(batchId);

        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            processing.setStartTime(timeFormat.parse(form.getStartTime()));
            processing.setEndTime(timeFormat.parse(form.getEndTime()));
        } catch (Exception e) {
            throw new RuntimeException("Format de temps invalide");
        }

        processing.setCrudeOilQuantity(form.getCrudeOilQuantity());
        processing.setFilteringMachineId(form.getFilteringMachineId());
        processing.setFilterOperatorId(form.getFilterOperatorId());
        processing.setTargetYield(form.getTargetYield());
        processing.setComments(form.getComments());
        processing.setProcessData(form.getProcessData());
        processing.calculateFinalYield();

        // Mise à jour des stocks
        stockService.updateCrudeOilStock(-form.getCrudeOilQuantity());
        stockService.updateFilteredOilStock(form.getFilteredOilQuantity());

        return processingRepo.save(processing);
    }

    public List<Machine> getAvailableFilteringMachines() {
        return machineRepo.findByTypeAndStatus("FILTRAGE", "EN_SERVICE");
    }

    public List<User> getAvailableOperators() {
        return userRepo.findByRole("OPERATOR");
    }

    public double getCurrentCrudeOilStock() {
        return stockService.getCrudeOilStock();
    }

    public double getCurrentFilteredOilStock() {
        return stockService.getFilteredOilStock();
    }
}
