package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {

    String user();
    String userPassword();
    String baseUrl();
    String browserSize();
    String selenoidUrl();
    String browser();
}
