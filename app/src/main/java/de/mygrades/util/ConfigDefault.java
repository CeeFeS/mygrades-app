package de.mygrades.util;

/**
 * Global default configuration file.
 *
 * Copy this file and rename it to Config.java
 */
public class ConfigDefault {
    // server info
    private static final String DOMAIN = "https://mygrades.de";
    private static final int PORT = 443;
    private static final int API_VERSION = 1;
    public static final String SERVER_URL = DOMAIN + ":" + PORT + "/api/v" + API_VERSION;

    // user agent used in jsoup
    public static final String BROWSER_USER_AGENT = "Mozilla/5.0 (Linux; U; Android 2.2; en-gb; Nexus One Build/FRF50) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
}