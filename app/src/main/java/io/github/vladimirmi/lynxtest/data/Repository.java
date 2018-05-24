package io.github.vladimirmi.lynxtest.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.vladimirmi.lynxtest.App;
import io.github.vladimirmi.lynxtest.R;
import io.github.vladimirmi.lynxtest.data.models.ArticleDetail;
import io.github.vladimirmi.lynxtest.data.models.Category;
import io.github.vladimirmi.lynxtest.data.models.Resource;
import io.github.vladimirmi.lynxtest.data.models.Status;
import io.github.vladimirmi.lynxtest.data.net.RestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
@SuppressWarnings("ConstantConditions")
public class Repository {

    private final RestService restService;
    private final Map<String, LiveData<Resource<List<Category.Event>>>> eventsCache = new HashMap<>();

    public Repository(RestService restService) {
        this.restService = restService;
    }

    public LiveData<Resource<List<Category.Event>>> getEvents(String category) {
        LiveData<Resource<List<Category.Event>>> cached = eventsCache.get(category);
        if (cached != null && cached.getValue().status == Status.SUCCESS) {
            return cached;
        }

        final MutableLiveData<Resource<List<Category.Event>>> data = new MutableLiveData<>();
        eventsCache.put(category, data);
        data.setValue(Resource.loading(null));

        restService.getCategory(category).enqueue(new Callback<Category>() {
            @Override
            public void onResponse(@NonNull Call<Category> call, @NonNull Response<Category> response) {
                Category body = response.body();
                if (response.isSuccessful() && body != null) {
                    data.setValue(Resource.success(body.getEvents()));
                } else {
                    data.setValue(Resource.error(errCodeToMsg(response.code()), null));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Category> call, @NonNull Throwable t) {
                data.setValue(Resource.error(throwableToMsg(t), null));
            }
        });
        return data;
    }

    public LiveData<Resource<ArticleDetail>> getArticle(String article) {
        final MutableLiveData<Resource<ArticleDetail>> data = new MutableLiveData<>();
        data.setValue(Resource.loading(null));

        restService.getAricle(article).enqueue(new Callback<ArticleDetail>() {
            @Override
            public void onResponse(@NonNull Call<ArticleDetail> call, @NonNull Response<ArticleDetail> response) {
                ArticleDetail body = response.body();
                if (response.isSuccessful() && body != null) {
                    data.setValue(Resource.success(body));
                } else {
                    data.setValue(Resource.error(errCodeToMsg(response.code()), null));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArticleDetail> call, @NonNull Throwable t) {
                data.setValue(Resource.error(throwableToMsg(t), null));
            }
        });
        return data;
    }

    private String errCodeToMsg(int code) {
        Context context = App.getAppContext();

        if (code >= 400 && code < 500) {
            return context.getString(R.string.client_error);
        } else {
            return context.getString(R.string.server_error);
        }
    }

    private String throwableToMsg(Throwable throwable) {
        if (throwable instanceof UnknownHostException) {
            return App.getAppContext().getString(R.string.net_error);
        } else {
            return throwable.getMessage();
        }
    }
}
