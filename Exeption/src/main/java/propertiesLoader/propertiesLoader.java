package propertiesLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class propertiesLoader {

     private static Properties properties = new Properties();

     static public void  load(final String path, final String property){
         InputStream inputStream = propertiesLoader.class.getClassLoader().getResourceAsStream(path);

         InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
         try {
             properties.load(inputStreamReader);
         }
         catch (IOException e){
             e.printStackTrace();
         }

         System.out.println(properties.getProperty(property));
     }
}
