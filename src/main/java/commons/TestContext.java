package commons;

import enums.Context;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private Map<String, Object> scenarioContext;

    public TestContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    public Object getContext(Context key, Object defaultValue) {
        if (scenarioContext != null) {
            Object answer = scenarioContext.get(key.toString());
            if (answer != null) {
                return answer;
            } else {
                scenarioContext.put(key.toString(), defaultValue);
            }
        }
        return defaultValue;
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }

    public WebDriver getDriver() {
        return TestsInitializer.getDriver();
    }

}
