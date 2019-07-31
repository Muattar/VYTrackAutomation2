package com.vytrack.utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;

    static{
        try {
            //path to our .properties file
            //Might be wrong path here, pay attention
            String path = "configuration.properties";
            //we create object of input stream to access file
            System.out.println(path);
            //provides access to file
            FileInputStream input = new FileInputStream(path);
            //
            configFile = new Properties();
            configFile.load(input);
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){

        return configFile.getProperty(key);
    }
}