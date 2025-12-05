package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "system_settings")
public class SystemSettings {
    @Id
    private String id;
    private int alertThreshold;
    private String backupFrequency;
    private boolean notificationsEnabled;

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getAlertThreshold() { return alertThreshold; }
    public void setAlertThreshold(int alertThreshold) { this.alertThreshold = alertThreshold; }
    public String getBackupFrequency() { return backupFrequency; }
    public void setBackupFrequency(String backupFrequency) { this.backupFrequency = backupFrequency; }
    public boolean isNotificationsEnabled() { return notificationsEnabled; }
    public void setNotificationsEnabled(boolean notificationsEnabled) { this.notificationsEnabled = notificationsEnabled; }
}
