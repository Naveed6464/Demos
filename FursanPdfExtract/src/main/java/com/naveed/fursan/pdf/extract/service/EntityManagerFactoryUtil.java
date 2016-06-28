/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.service;

import com.naveed.fursan.pdf.extract.config.AppProperties;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitTransactionType;
import org.eclipse.persistence.config.TargetServer;
import static org.eclipse.persistence.config.PersistenceUnitProperties.*;

/**
 *
 * @author nmrehman
 */
public class EntityManagerFactoryUtil {

    Map properties = new HashMap();
    EntityManagerFactory emf;
    AppProperties appProperties = AppProperties.getInstance();

    private EntityManagerFactoryUtil() {
        setEmf();
    }

    private static final EntityManagerFactoryUtil INSTANCE = new EntityManagerFactoryUtil();

    public static EntityManagerFactoryUtil getInstance() {
        return INSTANCE;
    }

    public static EntityManagerFactoryUtil getInstance(String propFileName) {
        return INSTANCE;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            setEmf();
        }
        return emf;
    }

    public final void setEmf() {
        setProperties();
        emf = Persistence.createEntityManagerFactory("dblocal", properties);;
    }

    public void setProperties() {
        //Ensure RESOURCE_LOCAL transactions is used.
        properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());
        // Configure the internal EclipseLink connection pool
        properties.put(JDBC_DRIVER, appProperties.getJdbcDriver());
        properties.put(JDBC_URL, appProperties.getJdbcUrl());
        properties.put(JDBC_USER, appProperties.getJdbcUser());
        properties.put(JDBC_PASSWORD, appProperties.getJdbcPassword());

        // Configure logging. FINE ensures all SQL is shown
        //properties.put(LOGGING_LEVEL, "FINE");
        //properties.put(LOGGING_TIMESTAMP, "false");
        //properties.put(LOGGING_THREAD, "false");
        //properties.put(LOGGING_SESSION, "false");
        //Ensure that no server-platform is configured
        properties.put(TARGET_SERVER, TargetServer.None);
    }

}
