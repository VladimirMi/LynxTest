package io.github.vladimirmi.lynxtest;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class App extends Application {

    @SuppressLint("StaticFieldLeak") private static Context context;

    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return App.context;
    }
}
