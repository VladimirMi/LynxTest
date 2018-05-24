package io.github.vladimirmi.lynxtest.data.net;

import io.github.vladimirmi.lynxtest.data.models.ArticleDetail;
import io.github.vladimirmi.lynxtest.data.models.Category;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public interface RestService {

    @GET("list.php")
    Call<Category> getCategory(@Query("category") String category);

    @GET("post.php")
    Call<ArticleDetail> getAricle(@Query("article") String article);
}
