package io.github.vladimirmi.lynxtest.news;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import io.github.vladimirmi.lynxtest.data.models.Category;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class CategoryViewModel extends ViewModel {

    private String category;

    public void init(String category) {
        this.category = category;
    }

    public LiveData<List<Category.Event>> getEvents() {
        return null;
    }
}
