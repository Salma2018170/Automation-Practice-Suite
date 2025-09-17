package engine;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    private static String repoUrl="src/main/resources/config.properties";

    public static void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(repoUrl)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *This method is used to get the browser name from the config.properties file
     *
     * @param key the key to search for in the properties file
     * @param defaultValue the value to return if the key is not found
     * @return the value associated with the key, or the default value if the key is not found
     */
    public static String getProperty(String key , String defaultValue){
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key,defaultValue);
    }
}
