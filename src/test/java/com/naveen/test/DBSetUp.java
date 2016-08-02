package com.naveen.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.NamingException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.BeforeClass;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.stereotype.Component;

@Component
public class DBSetUp  {

	private static String training_url ;
	private static String training_username ; 
	private static String training_password ;
	private static String training_jndiName  = "training";
	private static String driverClassName ;
    	
	@BeforeClass
	public static void createDataSource() throws Exception {
		loadProperties();
		createTrainingDataSource();	
	}
		
	private static void loadProperties() throws IOException {
		Properties prop = new Properties();
        
		String propFileName = "training-database.properties";
        
        InputStream inputStream = DBSetUp.class.getClassLoader().getResourceAsStream(propFileName);
        
        if (inputStream != null) {
               prop.load(inputStream);
        } else {
               throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        
        training_url = prop.getProperty("database1.url");
        training_username = prop.getProperty("database1.username");
        training_password = prop.getProperty("database1.password");
        driverClassName = prop.getProperty("database1.driverClassName");
            
        System.out.println("training URL : -->>" + training_url);
        System.out.println("training username : -->>"+ training_username);
        System.out.println("training password : -->>"+ training_password);
        System.out.println("training DriverClassName : -->"+ driverClassName);

       }

	public static void createTrainingDataSource() throws Exception {

		try {
			final SimpleNamingContextBuilder contextBuilder = new SimpleNamingContextBuilder();
			BasicDataSource ds = new BasicDataSource();
			ds.setUrl(training_url);
			ds.setUsername(training_username);
			ds.setPassword(training_password);
			ds.setDriverClassName(driverClassName);
			contextBuilder.bind("java:comp/env/jdbc/"
					+ training_jndiName, ds);
			contextBuilder.activate();
		} catch (NamingException ex) {
			System.out.println("Error while setting up the LPT Conveyancing data base "+ex.getMessage());
		}
	}
	public static void main(String[] args) throws IOException {
		System.out.println("Hello");
		loadProperties();
	}
}
