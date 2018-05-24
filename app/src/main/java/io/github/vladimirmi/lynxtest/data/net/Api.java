package io.github.vladimirmi.lynxtest.data.net;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class Api {

    final static String BASE_URL = "http://mikonatoruri.win/";

    final static int CONNECT_TIMEOUT = 5000;
    final static int READ_TIMEOUT = 5000;
    final static int WRITE_TIMEOUT = 5000;

    public final static String[] CATEGORIES = {
            "football",
            "hockey",
            "tennis",
            "basketball",
            "volleyball",
            "cybersport"
    };


    private Api() {
    }
}
