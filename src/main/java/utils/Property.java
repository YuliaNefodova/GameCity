package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static utils.Constants.*;

public class Property {

    private InputStream fis;
    private Properties property;

    public Property() {
        property = new Properties();
        fis = Property.class.getClassLoader().getResourceAsStream(NAME_PROPERTY_FILE);
        try {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getBeginMapping() {
        return property.getProperty(SERVER_MAPPING_BEGIN);
    }
    public String getNextWordMapping() {
        return property.getProperty(SERVER_MAPPING_NEXT);
    }
    public String getEndMapping() {
        return property.getProperty(SERVER_MAPPING_END);
    }
    public String getPort() {
        return property.getProperty(SERVER_PORT);
    }

}
