package com.arrgano.service;



import com.arrgano.dto.OilTransformationDTO;
import com.arrgano.dto.TransformationDashboardResponse;
import com.arrgano.model.OilTransformation;
import com.arrgano.dto.TransformationData;
import com.arrgano.dto.LotYieldDTO;
import com.arrgano.repository.OilTransformationRepository;
import com.arrgano.repository.OperatorPerformanceRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OilTransformationService {
    private final OilTransformationRepository transformationRepository;
    private final OperatorPerformanceRepository performanceRepository;

    public OilTransformationService(OilTransformationRepository transformationRepository,
                                    OperatorPerformanceRepository performanceRepository) {
        this.transformationRepository = transformationRepository;
        this.performanceRepository = performanceRepository;
    }

    public OilTransformation recordTransformation(OilTransformationDTO dto) {
        OilTransformation transformation = new OilTransformation(
                dto.getLotId(),
                dto.getCrudeOilQuantity(),
                dto.getFilteredOilQuantity(),
                dto.getOperatorId()
        );
        return transformationRepository.save(transformation);
    }

    public TransformationDashboardResponse getDashboardData() {
        TransformationDashboardResponse response = new TransformationDashboardResponse();

        // Données de transformation
        List<OilTransformation> allTransformations = transformationRepository.findAll();

        response.setTransformations(allTransformations.stream()
                .map(t -> {
                    TransformationData data = new TransformationData(); // Utilisez TransformationData au lieu de OilTransformation
                    data.setLotId(t.getLotId());
                    data.setCrudeOil(t.getCrudeOilQuantity()); // Assurez-vous que ces setters existent dans TransformationData
                    data.setFilteredOil(t.getFilteredOilQuantity());
                    return data;
                })
                .collect(Collectors.toList()));


        // Rendements par lot
        response.setLotYields(allTransformations.stream()
                .collect(Collectors.groupingBy(OilTransformation::getLotId))
                .entrySet().stream()
                .map(e -> {
                    LotYieldDTO dto = new LotYieldDTO();
                    dto.setLotId(e.getKey());
                    double totalCrude = e.getValue().stream().mapToDouble(OilTransformation::getCrudeOilQuantity).sum();
                    double totalFiltered = e.getValue().stream().mapToDouble(OilTransformation::getFilteredOilQuantity).sum();
                    dto.setYield(totalCrude > 0 ? (totalFiltered / totalCrude) * 100 : 0);
                    return dto;
                })
                .collect(Collectors.toList()));

        return response;
    }
}
