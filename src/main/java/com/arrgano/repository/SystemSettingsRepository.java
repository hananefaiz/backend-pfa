package com.arrgano.repository;

import com.arrgano.model.SystemSettings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SystemSettingsRepository extends MongoRepository<SystemSettings, String> {
}
