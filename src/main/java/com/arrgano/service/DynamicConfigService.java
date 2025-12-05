package com.arrgano.service;

import com.arrgano.model.SystemConfig;
import com.arrgano.repository.SystemConfigRepository;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class DynamicConfigService {
    private final SystemConfigRepository configRepository;
    private Map<String, Object> defaultConfig;

    public DynamicConfigService(SystemConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    @PostConstruct
    public void initDefaults() {
        defaultConfig = new HashMap<>();
        defaultConfig.put("alertThreshold", 70);
        defaultConfig.put("backupFrequency", "Quotidienne");
        defaultConfig.put("notifications", true);
        defaultConfig.put("stockCriticalThreshold", 30.0);
        defaultConfig.put("stockWarningThreshold", 50.0);
    }

    public SystemConfig getConfig() {
        return configRepository.findAll().stream().findFirst()
                .orElseGet(() -> {
                    SystemConfig newConfig = new SystemConfig();
                    newConfig.setSettings(defaultConfig);
                    return configRepository.save(newConfig);
                });
    }

    public void updateConfig(String key, Object value) {
        SystemConfig config = getConfig();
        config.getSettings().put(key, value);
        configRepository.save(config);
    }

    public <T> T getConfigValue(String key, Class<T> type) {
        Object value = getConfig().getSettings().getOrDefault(key, defaultConfig.get(key));
        return type.cast(value);
    }
}