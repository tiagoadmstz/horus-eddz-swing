package com.cooperstandard.dal.config;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryService {

    private static final Logger LOG = Logger.getLogger("EntityManagerFactoryService");
    private static final Map<String, EntityManagerFactory> factories = new HashMap<String, EntityManagerFactory>();
    private static final Map<String, String> properties = new HashMap<String, String>();

    /**
     * This method returns an entity manager factory for a target persistence
     * unit
     *
     * @param persistenceUnitName
     * @return an entity manager factory for a target persistence unit
     */
    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName, Map<String, String> propMap) {
        if (factories.containsKey(persistenceUnitName)) {
            return factories.get(persistenceUnitName);
        }

        EntityManagerFactory emf = null;

        if (!propMap.isEmpty()) {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName, propMap);
        } else {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }

        factories.put(persistenceUnitName, emf);
        return emf;
    }

    public static void closeFactories() {
        LOG.info("Closing entity manager factories");
        factories.values().stream().forEach(fc -> {
            fc.close();
        });
        factories.clear();
    }

}
