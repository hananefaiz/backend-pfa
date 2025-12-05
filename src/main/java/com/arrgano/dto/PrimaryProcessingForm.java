package com.arrgano.dto;

import java.util.List;

public class PrimaryProcessingForm {
    private double fruitQuantity;
    private double almondQuantity;
    private double targetYield;
    private List<String> operators;
    private String comments;

    // Getters and Setters
    public double getFruitQuantity() { return fruitQuantity; }
    public void setFruitQuantity(double fruitQuantity) { this.fruitQuantity = fruitQuantity; }
    public double getAlmondQuantity() { return almondQuantity; }
    public void setAlmondQuantity(double almondQuantity) { this.almondQuantity = almondQuantity; }
    public double getTargetYield() { return targetYield; }
    public void setTargetYield(double targetYield) { this.targetYield = targetYield; }
    public List<String> getOperators() { return operators; }
    public void setOperators(List<String> operators) { this.operators = operators; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}
