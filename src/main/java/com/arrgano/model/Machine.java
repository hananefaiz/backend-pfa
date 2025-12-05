package com.arrgano.model;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "machines")
public class Machine {
    @Id
    private String id;
    private String name;
    private String model;
    private String status;
    private String type;
    private double performance;
    private int anomalyCount;
    private boolean inService;
    private Map<String, Object> dynamicFields;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }

    public int getAnomalyCount() {
        return anomalyCount;
    }

    public void setAnomalyCount(int anomalyCount) {
        this.anomalyCount = anomalyCount;
    }

    public boolean isInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }
    public Map<String, Object> getDynamicFields() { return dynamicFields; }
    public void setDynamicFields(Map<String, Object> dynamicFields) { this.dynamicFields = dynamicFields; }
}