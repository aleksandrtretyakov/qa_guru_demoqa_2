package guru.qa.homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.CredentialsConfig;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        Configuration.browser = config.browser();
        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
        Configuration.remote = "https://" + config.user() + ":" + config.userPassword() + "@" + config.selenoidUrl();

//        String login = config.login();
//        String password = config.password();
//
//        String propertyBrowser = System.getProperty("propertyBrowser", "chrome");
//        String propertyVersion = System.getProperty("propertyVersion", "100");
//
//        String propertyMainPageUrl = System.getProperty("propertyMainPageUrl", "https://demoqa.com");
//        String propertyBrowserSize = System.getProperty("propertyBrowserSize", "1980x1080");
//        String propertyRemoteUrl = System.getProperty("propertySelenoidUrl", "selenoid.autotests.cloud/wd/hub");
//
//        Configuration.browser = propertyBrowser;
//        Configuration.browserVersion = propertyVersion;
//        Configuration.baseUrl = propertyMainPageUrl;
//        Configuration.browserSize = propertyBrowserSize;
//        Configuration.remote = "https://" + login + ":" + password + "@" + propertyRemoteUrl;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("My screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
