package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Document(collection = "batches")
public class Batch {
    @Id
    private String id;
    private String batchId;
    private Date startDate;
    private Date endDate;
    private String operatorId;
    private String status; // "IN_PROGRESS", "COMPLETED"
    private Map<String, Object> dynamicFields;

    // Getters/Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getBatchId() { return batchId; }
    public void setBatchId(String batchId) { this.batchId = batchId; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public String getOperatorId() { return operatorId; }
    public void setOperatorId(String operatorId) { this.operatorId = operatorId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Map<String, Object> getDynamicFields() { return dynamicFields; }
    public void setDynamicFields(Map<String, Object> dynamicFields) { this.dynamicFields = dynamicFields; }
}
