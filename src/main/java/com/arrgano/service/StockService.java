package com.arrgano.service;

import com.arrgano.model.StockMovement;
import com.arrgano.model.StockItem;
import com.arrgano.repository.StockMovementRepository;
import com.arrgano.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final StockMovementRepository movementRepository;
    private final DynamicConfigService configService;

    public StockService(StockRepository stockRepository,
                        StockMovementRepository movementRepository,
                        DynamicConfigService configService) {
        this.stockRepository = stockRepository;
        this.movementRepository = movementRepository;
        this.configService = configService;
    }

    // Gestion des items de stock
    public List<StockItem> getAllStockItems() {
        updateStockStatuses();
        return stockRepository.findAllByOrderByNameAsc();
    }

    public void updateStockStatuses() {
        double criticalThreshold = configService.getConfigValue("stockCriticalThreshold", Double.class);
        double warningThreshold = configService.getConfigValue("stockWarningThreshold", Double.class);

        stockRepository.findAll().forEach(item -> {
            double percentage = (item.getCurrentQuantity() / item.getMaxQuantity()) * 100;
            if (percentage < criticalThreshold) {
                item.setStatus("Stock critique/Commander rapidement");
            } else if (percentage < warningThreshold) {
                item.setStatus("Stock bas");
            } else {
                item.setStatus("Stock normal");
            }
            stockRepository.save(item);
        });
    }

    // Gestion des mouvements de stock
    public List<StockMovement> getAllMovements() {
        return movementRepository.findAllByOrderByDateDesc();
    }

    public List<StockMovement> getProductMovements(String productName) {
        return movementRepository.findByProductNameOrderByDateDesc(productName);
    }

    public StockMovement recordMovement(String productName, double quantity, String movementType, String notes) {
        StockMovement movement = new StockMovement();
        movement.setProductName(productName);
        movement.setQuantity(quantity);
        movement.setMovementType(movementType);
        movement.setDate(new Date());
        movement.setNotes(notes);

        // Mettre à jour le stock correspondant
        updateStockQuantity(productName, quantity, movementType);

        return movementRepository.save(movement);
    }

    private void updateStockQuantity(String productName, double quantity, String movementType) {
        StockItem item = stockRepository.findByName(productName)
                .orElseGet(() -> {
                    StockItem newItem = new StockItem();
                    newItem.setName(productName);
                    newItem.setMaxQuantity(100); // Valeur par défaut
                    return newItem;
                });

        if ("ENTREE".equalsIgnoreCase(movementType)) {
            item.setCurrentQuantity(item.getCurrentQuantity() + quantity);
        } else if ("SORTIE".equalsIgnoreCase(movementType)) {
            item.setCurrentQuantity(item.getCurrentQuantity() - quantity);
        }

        stockRepository.save(item);
    }
    @Transactional
    public void updateFruitStock(double quantity) {
        StockItem fruits = stockRepository.findByName("Fruits d'argan")
                .orElseGet(() -> {
                    StockItem newItem = new StockItem();
                    newItem.setName("Fruits d'argan");
                    newItem.setCurrentQuantity(0);
                    newItem.setMaxQuantity(10000); // Valeur par défaut
                    newItem.setUnit("kg");
                    return stockRepository.save(newItem);
                });

        fruits.setCurrentQuantity(fruits.getCurrentQuantity() + quantity);
        stockRepository.save(fruits);
    }
    @Transactional
    public void updateAlmondStock(double quantity) {
        StockItem almonds = stockRepository.findByName("Amandes")
                .orElseGet(() -> {
                    StockItem newItem = new StockItem();
                    newItem.setName("Amandes");
                    newItem.setCurrentQuantity(0);
                    newItem.setMaxQuantity(5000); // Valeur par défaut
                    newItem.setUnit("kg");
                    return stockRepository.save(newItem);
                });

        almonds.setCurrentQuantity(almonds.getCurrentQuantity() + quantity);
        stockRepository.save(almonds);
    }
    public double getCurrentFruitStock() {
        return stockRepository.findByName("Fruits d'argan")
                .map(StockItem::getCurrentQuantity)
                .orElse(0.0);
    }

    public double getCurrentAlmondStock() {
        return stockRepository.findByName("Amandes")
                .map(StockItem::getCurrentQuantity)
                .orElse(0.0);
    }
    public void updateCrudeOilStock(double quantity) {
        StockItem crudeOil = stockRepository.findByType("CRUDE_OIL")
                .orElseThrow(() -> new RuntimeException("Stock CRUDE_OIL non trouvé"));
        crudeOil.setQuantity(crudeOil.getQuantity() + quantity);
        stockRepository.save(crudeOil);
    }
    public void updateFilteredOilStock(double quantity) {
        StockItem filteredOil = stockRepository.findByType("FILTERED_OIL")
                .orElseThrow(() -> new RuntimeException("Stock FILTERED_OIL non trouvé"));
        filteredOil.setQuantity(filteredOil.getQuantity() + quantity);
        stockRepository.save(filteredOil);
    }
    public double getCrudeOilStock() {
        return stockRepository.findByType("CRUDE_OIL")
                .orElseThrow(() -> new RuntimeException("Stock CRUDE_OIL non trouvé"))
                .getQuantity();
    }

    public double getFilteredOilStock() {
        return stockRepository.findByType("FILTERED_OIL")
                .orElseThrow(() -> new RuntimeException("Stock FILTERED_OIL non trouvé"))
                .getQuantity();
    }


}