package io.github.vladimirmi.lynxtest.data.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class RestServiceProvider {

    private RestServiceProvider() {
    }

    public static RestService getService() {
        return createRetrofit().create(RestService.class);
    }

    private static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(createClient())
                .build();
    }

    private static OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(Api.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(Api.READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(Api.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

}
