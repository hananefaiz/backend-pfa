package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock_items")
public class StockItem {
    @Id
    private String id;
    private String name;
    private String type;
    private double currentQuantity;
    private double quantity;
    private double maxQuantity;
    private String unit;
    private String status;

    // Getters/Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCurrentQuantity() { return currentQuantity; }
    public void setCurrentQuantity(double currentQuantity) { this.currentQuantity = currentQuantity; }
    public double getMaxQuantity() { return maxQuantity; }
    public void setMaxQuantity(double maxQuantity) { this.maxQuantity = maxQuantity; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
