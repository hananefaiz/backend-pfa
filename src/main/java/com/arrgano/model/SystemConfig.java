package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Document(collection = "system_config")
public class SystemConfig {
    @Id
    private String id;
    private Map<String, Object> settings; // Stocke tous les paramètres dynamiques

    // Getters/Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Map<String, Object> getSettings() { return settings; }
    public void setSettings(Map<String, Object> settings) { this.settings = settings; }
}
