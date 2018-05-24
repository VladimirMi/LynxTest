package io.github.vladimirmi.lynxtest;

import io.github.vladimirmi.lynxtest.data.Repository;
import io.github.vladimirmi.lynxtest.data.net.RestServiceProvider;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class ServiceLocator {

    public static final Repository REPOSITORY = new Repository(RestServiceProvider.getService());

    private ServiceLocator() {
    }
}
