package com.arrgano.repository;

import com.arrgano.model.SystemConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SystemConfigRepository extends MongoRepository<SystemConfig, String> {

    /**
     * Trouve la première configuration système
     * @return Optional contenant la configuration système
     */
    Optional<SystemConfig> findFirstBy();

    /**
     * Trouve la configuration contenant un paramètre spécifique
     * @param key Clé du paramètre
     * @return Optional contenant la configuration
     */
    @Query("{ 'settings.?0': { $exists: true } }")
    Optional<SystemConfig> findBySettingKey(String key);

    /**
     * Met à jour un paramètre spécifique sans charger le document entier
     * @param id ID de la configuration
     * @param key Clé du paramètre
     * @param value Nouvelle valeur
     */
    @Query("{ '_id': ?0 }")
    @Update("{ $set: { 'settings.?1': ?2 } }")
    void updateSetting(String id, String key, Object value);

    /**
     * Vérifie l'existence d'un paramètre
     * @param key Clé du paramètre
     * @return true si le paramètre existe
     */
    @Query(value = "{ 'settings.?0': { $exists: true } }", exists = true)
    boolean settingExists(String key);

    /**
     * Supprime un paramètre spécifique
     * @param id ID de la configuration
     * @param key Clé du paramètre à supprimer
     */
    @Query("{ '_id': ?0 }")
    @Update("{ $unset: { 'settings.?1': 1 } }")
    void removeSetting(String id, String key);

    /**
     * Incrémente une valeur numérique
     * @param id ID de la configuration
     * @param key Clé du paramètre
     * @param increment Valeur d'incrément
     */
    @Query("{ '_id': ?0 }")
    @Update("{ $inc: { 'settings.?1': ?2 } }")
    void incrementSetting(String id, String key, Number increment);
}
