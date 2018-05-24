package io.github.vladimirmi.lynxtest.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.vladimirmi.lynxtest.data.models.Category;
import io.github.vladimirmi.lynxtest.data.net.RestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class Repository {
    private final RestService restService;
    private final Map<String, LiveData<List<Category.Event>>> eventsCache = new HashMap<>();

    public Repository(RestService restService) {
        this.restService = restService;
    }

    public LiveData<List<Category.Event>> getEvents(String category) {
        LiveData<List<Category.Event>> cached = eventsCache.get(category);
        if (cached != null) {
            return cached;
        }

        final MutableLiveData<List<Category.Event>> data = new MutableLiveData<>();
        eventsCache.put(category, data);

        restService.getCategory(category).enqueue(new Callback<Category>() {
            @Override
            public void onResponse(@NonNull Call<Category> call, @NonNull Response<Category> response) {
                data.setValue(response.body().getEvents());
            }

            @Override
            public void onFailure(@NonNull Call<Category> call, @NonNull Throwable t) {

            }
        });
        return data;
    }
}
