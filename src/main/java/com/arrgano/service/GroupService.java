package com.arrgano.service;

import com.arrgano.dto.GroupRequest;
import com.arrgano.model.WomenGroup;
import com.arrgano.repository.GroupRepository;
import com.arrgano.service.StockService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final StockService stockService;

    public GroupService(GroupRepository groupRepository, StockService stockService) {
        this.groupRepository = groupRepository;
        this.stockService = stockService;
    }

    public WomenGroup createGroup(GroupRequest request) {
        // Vérifier les stocks disponibles
        if (request.getInitialFruitQuantity() > stockService.getCurrentFruitStock()) {
            throw new RuntimeException("Stock de fruits insuffisant");
        }

        if (request.getInitialAlmondQuantity() > stockService.getCurrentAlmondStock()) {
            throw new RuntimeException("Stock d'amandes insuffisant");
        }

        WomenGroup group = new WomenGroup(
                request.getGroupName(),
                request.getLeaderName(),
                request.getMembers(),
                request.getLocation(),
                request.getInitialFruitQuantity(),
                request.getInitialAlmondQuantity()
        );

        // Mettre à jour les stocks
        stockService.updateFruitStock(-request.getInitialFruitQuantity());
        stockService.updateAlmondStock(-request.getInitialAlmondQuantity());

        return groupRepository.save(group);
    }

    public List<WomenGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    public List<WomenGroup> getGroupsByLocation(String location) {
        return groupRepository.findByLocation(location);
    }
}
