package framework.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:testdata.properties")
public interface TestData extends Config {

    String validUserLogin();

    String validUserPassword();
}