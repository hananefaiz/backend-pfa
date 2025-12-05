package com.arrgano.service;


import com.arrgano.model.SystemSettings;
import com.arrgano.repository.SystemSettingsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class SystemSettingsService {
    private final SystemSettingsRepository settingsRepository;

    @Value("${settings.default.alertThreshold:70}")
    private int defaultAlertThreshold;

    @Value("${settings.default.backupFrequency:Quotidienne}")
    private String defaultBackupFrequency;

    @Value("${settings.default.notificationsEnabled:true}")
    private boolean defaultNotificationsEnabled;

    private final Map<String, Object> defaultSettings = new HashMap<>();

    public SystemSettingsService(SystemSettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @PostConstruct
    public void initDefaultSettings() {
        defaultSettings.put("alertThreshold", defaultAlertThreshold);
        defaultSettings.put("backupFrequency", defaultBackupFrequency);
        defaultSettings.put("notificationsEnabled", defaultNotificationsEnabled);
    }

    public SystemSettings getSettings() {
        return settingsRepository.findAll().stream().findFirst().orElseGet(this::createDefaultSettings);
    }

    private SystemSettings createDefaultSettings() {
        SystemSettings settings = new SystemSettings();
        settings.setAlertThreshold((int) defaultSettings.get("alertThreshold"));
        settings.setBackupFrequency((String) defaultSettings.get("backupFrequency"));
        settings.setNotificationsEnabled((boolean) defaultSettings.get("notificationsEnabled"));
        return settingsRepository.save(settings);
    }

    public void saveSettings(SystemSettings settings) {
        if (settings.getId() == null) {
            settings = createDefaultSettings();
        }
        settingsRepository.save(settings);
    }

    public void updateSetting(String key, Object value) {
        SystemSettings settings = getSettings();
        switch (key) {
            case "alertThreshold":
                settings.setAlertThreshold((int) value);
                break;
            case "backupFrequency":
                settings.setBackupFrequency((String) value);
                break;
            case "notificationsEnabled":
                settings.setNotificationsEnabled((boolean) value);
                break;
            default:
                throw new IllegalArgumentException("Paramètre inconnu: " + key);
        }
        settingsRepository.save(settings);
    }
}