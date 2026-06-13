package api;

import com.sii.utils.PropertiesLoader;

import java.util.Properties;

public class BaseApiTest {
    private static final Properties PROPERTIES = PropertiesLoader.readPropertiesFromFile("testData.properties");

    protected String getWorkspacePublicId() {
        return PROPERTIES.getProperty("user.workspacePublicId");
    }
}
