package com.arrgano.dto;

public class OilTransformationDTO {
    private String lotId;
    private double crudeOilQuantity;
    private double filteredOilQuantity;
    private String operatorId;
    private String field1;
    private String field2;

    // Getters et Setters
    public String getLotId() { return lotId; }
    public void setLotId(String lotId) { this.lotId = lotId; }
    public double getCrudeOilQuantity() { return crudeOilQuantity; }
    public void setCrudeOilQuantity(double crudeOilQuantity) { this.crudeOilQuantity = crudeOilQuantity; }
    public double getFilteredOilQuantity() { return filteredOilQuantity; }
    public void setFilteredOilQuantity(double filteredOilQuantity) { this.filteredOilQuantity = filteredOilQuantity; }
    public String getOperatorId() { return operatorId; }
    public void setOperatorId(String operatorId) { this.operatorId = operatorId; }

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
