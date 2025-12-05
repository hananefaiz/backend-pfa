package com.arrgano.dto;

import java.util.Map;

public class SecondaryProcessingForm {
    private String startTime;
    private String endTime;
    private double crudeOilQuantity;
    private String filteringMachineId;
    private double filteredOilQuantity;
    private String filterOperatorId;
    private double targetYield;
    private String comments;
    private Map<String, Object> processData;

    // Getters/Setters
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public double getCrudeOilQuantity() { return crudeOilQuantity; }
    public void setCrudeOilQuantity(double crudeOilQuantity) { this.crudeOilQuantity = crudeOilQuantity; }
    public String getFilteringMachineId() { return filteringMachineId; }
    public void setFilteringMachineId(String filteringMachineId) { this.filteringMachineId = filteringMachineId; }
    public double getFilteredOilQuantity() { return filteredOilQuantity; }
    public void setFilteredOilQuantity(double filteredOilQuantity) { this.filteredOilQuantity = filteredOilQuantity; }
    public String getFilterOperatorId() { return filterOperatorId; }
    public void setFilterOperatorId(String filterOperatorId) { this.filterOperatorId = filterOperatorId; }
    public double getTargetYield() { return targetYield; }
    public void setTargetYield(double targetYield) { this.targetYield = targetYield; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    public Map<String, Object> getProcessData() { return processData; }
    public void setProcessData(Map<String, Object> processData) { this.processData = processData; }
}
