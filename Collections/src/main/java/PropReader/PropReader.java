package PropReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropReader {

    private static Properties properties = new Properties();
    private static Map<String, String> propertiesMap = new HashMap<>();

    static public void  load(final String path, final String property){
        InputStream inputStream = PropReader.class.getClassLoader().getResourceAsStream(path);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try {
            properties.load(inputStreamReader);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        for(String key: properties.keySet().toArray(new String[0])){
            propertiesMap.put(key, properties.getProperty(key));
        }
    }
    public static Map<String, String> getMap(){
        return propertiesMap;
    }
}
