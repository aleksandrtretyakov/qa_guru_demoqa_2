package guru.qa.tests.properties;

import guru.qa.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OwnerTest {

    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    @Test
    @Tag("owner")
    void loginTest() {

        String user = config.user();
        String userPassword = config.userPassword();
        String baseUrl = config.baseUrl();
        String browserSize = config.browserSize();
        String selenoidUrl = config.selenoidUrl();
        String browser = config.browser();


        System.out.println("Login: " + user);
        System.out.println("Password: " + userPassword);
        System.out.println("BaseUrl: " + baseUrl);
        System.out.println("BrowserSize: " + browserSize);
        System.out.println("SelenoidUrl: " + selenoidUrl);
        System.out.println("Browser: " + browser);

        String message = "I logged in as " + user + " with password " + userPassword;
        System.out.println(message);
    }
}
