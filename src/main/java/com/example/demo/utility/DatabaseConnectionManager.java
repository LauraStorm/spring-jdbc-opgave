package com.example.demo.utility;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    private DatabaseConnectionManager(){}

    public static Connection getConnection(){
        if(conn != null){
            return conn;
        }
//        Properties file
//        try(InputStream propertiesFile = new FileInputStream("src/main/resources/application.properties")){
//            Properties props = new Properties();
//            props.load(propertiesFile);
//            url = props.getProperty("db.url");
//            username = props.getProperty("db.username");
//            password = props.getProperty("db.password");
//            conn = DriverManager.getConnection(url, username, password);
//        }
        try{
            //Environment Variables
            url = System.getenv("db.url");
            username = System.getenv("db.username");
            password = System.getenv("db.password");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("We have a connection to DB");
        }

        catch(SQLException e){
            System.out.println("something went wrong with the DB connection");
            e.printStackTrace();
        }
        return conn;
    }
}
