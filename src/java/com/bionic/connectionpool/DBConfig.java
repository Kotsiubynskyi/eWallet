/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.connectionpool;

import java.util.ResourceBundle;

/**
 *
 * @author Eugene
 */
public class DBConfig {

    private static DBConfig instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "com.bionic.connectionpool.dbconfig";
    public static final String DRIVER = "DRIVER";
    public static final String URL = "URL";
    public static final String MAIN = "MAIN";
    public static final String ERROR = "ERROR";
    public static final String LOGIN = "LOGIN";
    public static final String DATASOURCE = "DATASOURCE";

    public static DBConfig getInstance() {
        if (instance == null) {
            instance = new DBConfig();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
