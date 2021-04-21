package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:${env}.properties"
})

public interface iTestsConfig extends Config {

    @Key("mainPage")
    String host();

    @Key("browser")
    @DefaultValue("Chrome")
    String getBrowser();

    @Key("testRunType")
    @DefaultValue("regular")
    String getTestRunType();
}
