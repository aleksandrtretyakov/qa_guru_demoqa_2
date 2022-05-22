package guru.qa.tests.properties;

import guru.qa.config.CredentialsConfigHW;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OwnerTestHW {

    CredentialsConfigHW config = ConfigFactory.create(CredentialsConfigHW.class);
    @Test
    @Tag("owner")
    void loginTest() {
        String user = config.user();
        String userPassword = config.userPassword();
        String baseUrl = config.baseUrl();
        String browserSize = config.browserSize();
        String selenoidUrl = config.selenoidUrl();

        System.out.println("Login: " + user);
        System.out.println("Password: " + userPassword);
        System.out.println("BaseUrl: " + baseUrl);
        System.out.println("BrowserSize: " + browserSize);
    }
}
