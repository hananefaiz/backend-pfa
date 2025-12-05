package com.arrgano.dto;

import java.util.List;

public class TransformationDashboardResponse {
    private List<TransformationData> transformations;
    private List<OperatorPerformanceDTO> performances;
    private List<LotYieldDTO> lotYields;

    // Getters et Setters
    public List<TransformationData> getTransformations() {
        return transformations;
    }

    public void setTransformations(List<TransformationData> transformations) {
        this.transformations = transformations;
    }

    public List<OperatorPerformanceDTO> getPerformances() {
        return performances;
    }

    public void setPerformances(List<OperatorPerformanceDTO> performances) {
        this.performances = performances;
    }

    public List<LotYieldDTO> getLotYields() {
        return lotYields;
    }

    public void setLotYields(List<LotYieldDTO> lotYields) {
        this.lotYields = lotYields;
    }
}