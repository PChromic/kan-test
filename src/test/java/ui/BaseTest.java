package ui;

import com.codeborne.selenide.Configuration;
import com.sii.utils.PropertiesLoader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {
    private static final Properties PROPERTIES = PropertiesLoader.readPropertiesFromFile("testData.properties");
    static final String VALID_EMAIL = PROPERTIES.getProperty("user.email");
    static final String VALID_PASSWORD = PROPERTIES.getProperty("user.password");
    static final String LOCALE = PROPERTIES.getProperty("user.locale");
    static final String WORKSPACE_ID = PROPERTIES.getProperty("user.workspacePublicId");

    @BeforeClass
    public void initBrowserCapabilities() {
        var localeParam = "lang=" + LOCALE;
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(localeParam);
                Configuration.browserCapabilities = chromeOptions;
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(localeParam);
                Configuration.browserCapabilities = edgeOptions;
                break;
            default:
                throw new IllegalStateException("Unsupported browser: " + browser);
        }
    }
}
