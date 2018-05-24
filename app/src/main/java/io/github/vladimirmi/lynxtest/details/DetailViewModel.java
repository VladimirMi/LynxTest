package io.github.vladimirmi.lynxtest.details;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import io.github.vladimirmi.lynxtest.ServiceLocator;
import io.github.vladimirmi.lynxtest.data.Repository;
import io.github.vladimirmi.lynxtest.data.models.ArticleDetail;
import io.github.vladimirmi.lynxtest.data.models.Resource;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class DetailViewModel extends ViewModel {

    private String article;
    private Repository repository = ServiceLocator.REPOSITORY;

    public void init(String article) {
        this.article = article;
    }

    public LiveData<Resource<ArticleDetail>> getArticle() {
        return repository.getArticle(article);
    }
}
