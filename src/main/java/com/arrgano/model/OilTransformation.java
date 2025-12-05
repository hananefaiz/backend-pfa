package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "oil_transformations")
public class OilTransformation {
    @Id
    private String id;
    private String lotId;
    private Date date;
    private double crudeOilQuantity; // L
    private double filteredOilQuantity; // L
    private double yieldPercentage;
    private String operatorId;
    private String field1;
    private String field2;

    // Constructeurs
    public OilTransformation() {}

    public OilTransformation(String lotId, double crudeOilQuantity,
                             double filteredOilQuantity, String operatorId) {
        this.lotId = lotId;
        this.date = new Date();
        this.crudeOilQuantity = crudeOilQuantity;
        this.filteredOilQuantity = filteredOilQuantity;
        this.yieldPercentage = (filteredOilQuantity / crudeOilQuantity) * 100;
        this.operatorId = operatorId;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getLotId() { return lotId; }
    public void setLotId(String lotId) { this.lotId = lotId; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public double getCrudeOilQuantity() { return crudeOilQuantity; }
    public void setCrudeOilQuantity(double crudeOilQuantity) {
        this.crudeOilQuantity = crudeOilQuantity;
        calculateYield();
    }
    public double getFilteredOilQuantity() { return filteredOilQuantity; }
    public void setFilteredOilQuantity(double filteredOilQuantity) {
        this.filteredOilQuantity = filteredOilQuantity;
        calculateYield();
    }
    public double getYieldPercentage() { return yieldPercentage; }
    public String getOperatorId() { return operatorId; }
    public void setOperatorId(String operatorId) { this.operatorId = operatorId; }

    private void calculateYield() {
        if (crudeOilQuantity > 0) {
            this.yieldPercentage = (filteredOilQuantity / crudeOilQuantity) * 100;
        }
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }
}
