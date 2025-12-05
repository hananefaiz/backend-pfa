package com.arrgano.dto;

public class TransformationData {
    private String lotId;
    private double crudeOil;
    private double filteredOil;

    // Getters et Setters
    public String getLotId() { return lotId; }
    public void setLotId(String lotId) { this.lotId = lotId; }
    public double getCrudeOil() { return crudeOil; }
    public void setCrudeOil(double crudeOil) { this.crudeOil = crudeOil; }
    public double getFilteredOil() { return filteredOil; }
    public void setFilteredOil(double filteredOil) { this.filteredOil = filteredOil; }

}
