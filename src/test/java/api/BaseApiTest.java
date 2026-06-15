package api;

import com.sii.utils.PropertiesLoader;
import org.testng.annotations.AfterSuite;

import java.util.Properties;

import static com.sii.db.HibernateUtil.EMF;

public class BaseApiTest {
    private static final Properties PROPERTIES = PropertiesLoader.readPropertiesFromFile("testData.properties");

    protected String getWorkspacePublicId() {
        return PROPERTIES.getProperty("user.workspacePublicId");
    }

    @AfterSuite
    public final void _afterSuite() {
        if (EMF != null) {
            EMF.close();
        }
    }
}
