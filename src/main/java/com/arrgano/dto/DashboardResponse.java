package com.arrgano.dto;

import java.util.List;

public class DashboardResponse {
    private double totalFruitsProcessed;
    private double totalAlmondsProduced;
    private double totalCrudeOil;
    private double totalFilteredOil;
    private double fruitsYield;
    private double almondsYield;
    private List<OperatorPerformanceDTO> operatorPerformances;

    // Getters et Setters
    public double getTotalFruitsProcessed() { return totalFruitsProcessed; }
    public void setTotalFruitsProcessed(double totalFruitsProcessed) { this.totalFruitsProcessed = totalFruitsProcessed; }
    public double getTotalAlmondsProduced() { return totalAlmondsProduced; }
    public void setTotalAlmondsProduced(double totalAlmondsProduced) { this.totalAlmondsProduced = totalAlmondsProduced; }
    public double getTotalCrudeOil() { return totalCrudeOil; }
    public void setTotalCrudeOil(double totalCrudeOil) { this.totalCrudeOil = totalCrudeOil; }
    public double getTotalFilteredOil() { return totalFilteredOil; }
    public void setTotalFilteredOil(double totalFilteredOil) { this.totalFilteredOil = totalFilteredOil; }
    public double getFruitsYield() { return fruitsYield; }
    public void setFruitsYield(double fruitsYield) { this.fruitsYield = fruitsYield; }
    public double getAlmondsYield() { return almondsYield; }
    public void setAlmondsYield(double almondsYield) { this.almondsYield = almondsYield; }
    public List<OperatorPerformanceDTO> getOperatorPerformances() { return operatorPerformances; }
    public void setOperatorPerformances(List<OperatorPerformanceDTO> operatorPerformances) { this.operatorPerformances = operatorPerformances; }
}
