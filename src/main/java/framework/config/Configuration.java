package framework.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:configuration.properties")
public interface Configuration extends Config {

    String appUrl();

    @DefaultValue("CHROME")
    String browserName();
}