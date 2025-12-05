package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Document(collection = "primary_processing")
public class PrimaryProcessing {
    @Id
    private String id;
    private String batchId;
    private Date startDate;
    private String mainOperator;
    private double fruitQuantity;
    private double almondQuantity;
    private double targetYield;
    private double actualYield;
    private List<String> operators;
    private String comments;
    private Map<String, Object> dynamicFields;

    // Getters/Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getBatchId() { return batchId; }
    public void setBatchId(String batchId) { this.batchId = batchId; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public String getMainOperator() { return mainOperator; }
    public void setMainOperator(String mainOperator) { this.mainOperator = mainOperator; }
    public double getFruitQuantity() { return fruitQuantity; }
    public void setFruitQuantity(double fruitQuantity) { this.fruitQuantity = fruitQuantity; }
    public double getAlmondQuantity() { return almondQuantity; }
    public void setAlmondQuantity(double almondQuantity) { this.almondQuantity = almondQuantity; }
    public double getTargetYield() { return targetYield; }
    public void setTargetYield(double targetYield) { this.targetYield = targetYield; }
    public double getActualYield() { return actualYield; }
    public void setActualYield(double actualYield) { this.actualYield = actualYield; }
    public List<String> getOperators() { return operators; }
    public void setOperators(List<String> operators) { this.operators = operators; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    public Map<String, Object> getDynamicFields() { return dynamicFields; }
    public void setDynamicFields(Map<String, Object> dynamicFields) { this.dynamicFields = dynamicFields; }

    public void calculateYield() {
        if (fruitQuantity > 0) {
            this.actualYield = (almondQuantity / fruitQuantity) * 100;
        }
    }
}
