package io.github.vladimirmi.lynxtest.news;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import io.github.vladimirmi.lynxtest.ServiceLocator;
import io.github.vladimirmi.lynxtest.data.Repository;
import io.github.vladimirmi.lynxtest.data.models.Category;
import io.github.vladimirmi.lynxtest.data.models.Resource;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class CategoryViewModel extends ViewModel {

    private String category;
    private Repository repository = ServiceLocator.REPOSITORY;

    public void init(String category) {
        this.category = category;
    }

    public LiveData<Resource<List<Category.Event>>> getEvents() {
        return repository.getEvents(category);
    }
}
