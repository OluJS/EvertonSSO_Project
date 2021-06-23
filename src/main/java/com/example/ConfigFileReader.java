package com.example;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    public static Properties prop;

  public static void readPropertiesFile(){
      prop = new Properties();
      try {
          InputStream input = new FileInputStream("configs/configurations.properties");
          prop.load(input);

      } catch (Exception e) {
          e.printStackTrace();
      }
  }



}
