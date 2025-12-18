package BaseTest;

import utilities.ReadConfigNew;

public interface frameWorkConstants {

	ReadConfigNew READ_CONFIG = new ReadConfigNew();

    // Environment
    String ENV = READ_CONFIG.getEnvironment();   // QA | UAT | PROD

    // URLs
    String BASE_URL = READ_CONFIG.getBaseURL();

    // Browser
    String BROWSER = READ_CONFIG.getBrowser();
    boolean HEADLESS_EXECUTION =
            Boolean.parseBoolean(READ_CONFIG.getHeadless());

    // Credentials
    String USER_EMAIL = READ_CONFIG.getUserEmail();
    String USER_NAME = READ_CONFIG.getUsername();
    String PASSWORD = READ_CONFIG.getPassword();

    // Timeouts
    int IMPLICIT_WAIT = 10;
    int EXPLICIT_WAIT = 20;
    int PAGE_LOAD_TIMEOUT = 25;
}
