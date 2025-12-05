package com.arrgano.service;

import com.arrgano.model.Machine;
import com.arrgano.model.User;
import com.arrgano.repository.*;
import com.arrgano.model.OperatorPerformance;
import com.arrgano.dto.OperatorPerformanceDTO;
import com.arrgano.model.ProductionStats;
import com.arrgano.dto.DashboardResponse;
import com.arrgano.repository.MachineRepository;
import com.arrgano.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class DashboardService {
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final ProductionStatsRepository statsRepository;
    private final OperatorPerformanceRepository performanceRepository;

    public DashboardService(MachineRepository machineRepository,
                            UserRepository userRepository ,
                            ProductionStatsRepository statsRepository,
                            OperatorPerformanceRepository performanceRepository) {
        this.machineRepository = machineRepository;
        this.userRepository = userRepository;
        this.statsRepository = statsRepository;
        this.performanceRepository = performanceRepository;
    }

    public Map<String, Object> getAdminDashboardData() {
        Map<String, Object> data = new HashMap<>();

        // Stats machines
        data.put("totalMachines", machineRepository.count());
        data.put("activeMachines", machineRepository.countByInService(true));

        // Liste des machines
        data.put("machines", machineRepository.findAll());

        // Liste des utilisateurs
        data.put("users", userRepository.findAll());

        return data;
    }
    public DashboardResponse getDashboardData(Date startDate, Date endDate, String lotId) {
        DashboardResponse response = new DashboardResponse();

        // Récupération des stats de production
        List<ProductionStats> stats = lotId != null ?
                statsRepository.findByLotId(lotId) :
                statsRepository.findByDateBetween(startDate, endDate);
        // Calcul des totaux
        response.setTotalFruitsProcessed(stats.stream().mapToDouble(ProductionStats::getFruitsProcessed).sum());
        response.setTotalAlmondsProduced(stats.stream().mapToDouble(ProductionStats::getAlmondsProduced).sum());
        response.setTotalCrudeOil(stats.stream().mapToDouble(ProductionStats::getCrudeOil).sum());
        response.setTotalFilteredOil(stats.stream().mapToDouble(ProductionStats::getFilteredOil).sum());
// Calcul des rendements
        if (response.getTotalFruitsProcessed() > 0) {
            response.setFruitsYield((response.getTotalAlmondsProduced() / response.getTotalFruitsProcessed()) * 100);
            response.setAlmondsYield((response.getTotalFilteredOil() / response.getTotalAlmondsProduced()) * 100);
        }

        // Récupération des performances des opérateurs
        List<OperatorPerformance> performances = lotId != null ?
                performanceRepository.findByLotId(lotId) :
                performanceRepository.findByEvaluationDateBetween(startDate, endDate);
        response.setOperatorPerformances(performances.stream()
                .map(p -> {
                    OperatorPerformanceDTO dto = new OperatorPerformanceDTO();
                    dto.setOperatorName(p.getOperatorName());
                    dto.setProductivity(p.getProductivity());
                    dto.setQuality(p.getQuality());
                    return dto;
                })
                .collect(Collectors.toList()));

        return response;
    }
    }