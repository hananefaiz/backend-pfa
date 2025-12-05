package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "operator_performance")
public class OperatorPerformance {
    @Id
    private String id;
    private String operatorId;
    private String operatorName;
    private double productivity; // %
    private double quality; // %
    private Date evaluationDate;
    private String lotId;

    // Constructeurs
    public OperatorPerformance() {}

    public OperatorPerformance(String operatorId, String operatorName,
                               double productivity, double quality, String lotId) {
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.productivity = productivity;
        this.quality = quality;
        this.evaluationDate = new Date();
        this.lotId = lotId;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getOperatorId() { return operatorId; }
    public void setOperatorId(String operatorId) { this.operatorId = operatorId; }
    public String getOperatorName() { return operatorName; }
    public void setOperatorName(String operatorName) { this.operatorName = operatorName; }
    public double getProductivity() { return productivity; }
    public void setProductivity(double productivity) { this.productivity = productivity; }
    public double getQuality() { return quality; }
    public void setQuality(double quality) { this.quality = quality; }
    public Date getEvaluationDate() { return evaluationDate; }
    public void setEvaluationDate(Date evaluationDate) { this.evaluationDate = evaluationDate; }
    public String getLotId() { return lotId; }
    public void setLotId(String lotId) { this.lotId = lotId; }
}
