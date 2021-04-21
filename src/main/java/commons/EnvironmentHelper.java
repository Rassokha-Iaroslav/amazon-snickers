package commons;

import org.aeonbits.owner.ConfigFactory;

public class EnvironmentHelper {

    private static iTestsConfig env;

    static {
        String env = System.getProperty("env") == null ? "dev" : System.getProperty("env");
        ConfigFactory.setProperty("env", env);
        EnvironmentHelper.env = ConfigFactory.create(iTestsConfig.class);
    }

    public static iTestsConfig getEnv() {
        return env;
    }

}

