package ui;

import com.sii.utils.KanFaker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeClass
    public void setUp(){
    }

    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }
}
