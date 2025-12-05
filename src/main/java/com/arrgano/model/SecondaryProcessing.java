package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.Map;

@Document(collection = "secondary_processing")
public class SecondaryProcessing {
    @Id
    private String id;
    private String batchId;
    private String primaryProcessingId;
    private Date processingDate;
    private double almondQuantityUsed;
    private String machineId;
    private String machineOperator;
    private Date startTime;
    private Date endTime;
    private double crudeOilQuantity;
    private String filteringMachineId;
    private double filteredOilQuantity;
    private String filterOperatorId;
    private double targetYield;
    private double finalYield;
    private String comments;
    private Map<String, Object> processData;
    private Map<String, Object> dynamicFields;

    // Getters/Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getBatchId() { return batchId; }
    public void setBatchId(String batchId) { this.batchId = batchId; }
    public String getPrimaryProcessingId() { return primaryProcessingId; }
    public void setPrimaryProcessingId(String primaryProcessingId) { this.primaryProcessingId = primaryProcessingId; }
    public Date getProcessingDate() { return processingDate; }
    public void setProcessingDate(Date processingDate) { this.processingDate = processingDate; }
    public double getAlmondQuantityUsed() { return almondQuantityUsed; }
    public void setAlmondQuantityUsed(double almondQuantityUsed) { this.almondQuantityUsed = almondQuantityUsed; }
    public String getMachineId() { return machineId; }
    public void setMachineId(String machineId) { this.machineId = machineId; }
    public String getMachineOperator() { return machineOperator; }
    public void setMachineOperator(String machineOperator) { this.machineOperator = machineOperator; }
    public Map<String, Object> getDynamicFields() { return dynamicFields; }
    public void setDynamicFields(Map<String, Object> dynamicFields) { this.dynamicFields = dynamicFields; }
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }
    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }
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
    public double getFinalYield() { return finalYield; }
    public void setFinalYield(double finalYield) { this.finalYield = finalYield; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    public void calculateFinalYield() {
        if (crudeOilQuantity > 0) {
            this.finalYield = (filteredOilQuantity / crudeOilQuantity) * 100;
        }
    }
    public Map<String, Object> getProcessData() { return processData; }
    public void setProcessData(Map<String, Object> processData) { this.processData = processData; }
}
