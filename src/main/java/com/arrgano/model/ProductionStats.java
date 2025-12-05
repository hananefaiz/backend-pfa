package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "production_stats")
public class ProductionStats {
    @Id
    private String id;
    private Date date;
    private double fruitsProcessed; // kg
    private double almondsProduced; // kg
    private double crudeOil; // L
    private double filteredOil; // L
    private String lotId;

    // Constructeurs
    public ProductionStats() {}

    public ProductionStats(Date date, double fruitsProcessed, double almondsProduced,
                           double crudeOil, double filteredOil, String lotId) {
        this.date = date;
        this.fruitsProcessed = fruitsProcessed;
        this.almondsProduced = almondsProduced;
        this.crudeOil = crudeOil;
        this.filteredOil = filteredOil;
        this.lotId = lotId;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public double getFruitsProcessed() { return fruitsProcessed; }
    public void setFruitsProcessed(double fruitsProcessed) { this.fruitsProcessed = fruitsProcessed; }
    public double getAlmondsProduced() { return almondsProduced; }
    public void setAlmondsProduced(double almondsProduced) { this.almondsProduced = almondsProduced; }
    public double getCrudeOil() { return crudeOil; }
    public void setCrudeOil(double crudeOil) { this.crudeOil = crudeOil; }
    public double getFilteredOil() { return filteredOil; }
    public void setFilteredOil(double filteredOil) { this.filteredOil = filteredOil; }
    public String getLotId() { return lotId; }
    public void setLotId(String lotId) { this.lotId = lotId; }
}
