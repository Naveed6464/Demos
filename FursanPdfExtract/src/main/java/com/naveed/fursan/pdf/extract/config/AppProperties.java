/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nmrehman
 */
public class AppProperties {

    final static Logger log = LoggerFactory.getLogger(AppProperties.class);
    private final Properties properties = new Properties();
    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;

    private final static String COFIG_FILE = "config.properties";

    private AppProperties() {
        loadProperties();
    }

    private static final AppProperties PROPERTIES = new AppProperties();

    public static AppProperties getInstance() {
        return PROPERTIES;
    }

    public static AppProperties getInstance(String propFileName) {
        return PROPERTIES;
    }

    public final void loadProperties() {

        InputStream input = null;
        try {
            input = new FileInputStream(COFIG_FILE);
            properties.load(input);
            updateProperties();
        } catch (IOException ex) {
            log.error("Property File not found " + ex);
            saveProperties("org.h2.Driver", "jdbc:h2:./fursanpdf", "sa", "");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void updateProperties() {
        jdbcDriver = properties.getProperty("JDBC_DRIVER", "org.h2.Driver");
        jdbcUrl = properties.getProperty("JDBC_URL", "jdbc:h2:./fursanpdf");
        jdbcUser = properties.getProperty("JDBC_USER", "sa");
        jdbcPassword = properties.getProperty("JDBC_PASSWORD", "");
    }

    public void save() {
        try {
            properties.store(new FileOutputStream(new File(COFIG_FILE)), null);
            properties.load(new FileInputStream(COFIG_FILE));
            updateProperties();
        } catch (Exception e) {
            log.error("Exception " + e);
        }
    }

    public void saveProperties(String jdbcDriver, String jdbcUrl, String jdbcUser, String jdbcPassword) {
        this.jdbcDriver = jdbcDriver;
        this.jdbcUrl = jdbcUrl;
        this.jdbcUser = jdbcUser;
        this.jdbcPassword = jdbcPassword;
        properties.setProperty("JDBC_DRIVER", jdbcDriver);
        properties.setProperty("JDBC_URL", jdbcUrl);
        properties.setProperty("JDBC_USER", jdbcUrl);
        properties.setProperty("JDBC_PASSWORD", jdbcPassword);
        save();
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

}
