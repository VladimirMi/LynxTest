package io.github.vladimirmi.lynxtest.news;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.github.vladimirmi.lynxtest.R;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class CategoryFragment extends Fragment {

    private static final String ARG_CATEGORY = "category";
    @BindView(R.id.eventList) RecyclerView eventList;
    Unbinder unbinder;

    private CategoryViewModel viewModel;
    private EventsAdapter eventsAdapter;

    public CategoryFragment() {
    }

    public static CategoryFragment newInstance(String category) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        eventList.setLayoutManager(layoutManager);

        eventsAdapter = new EventsAdapter(this::showDetails);
        eventList.setAdapter(eventsAdapter);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String category = getArguments().getString(ARG_CATEGORY);
        viewModel = ViewModelProviders.of(this).get(category, CategoryViewModel.class);
        viewModel.init(category);

        viewModel.getEvents().observe(this, events -> {
            eventsAdapter.setData(events);
        });
    }

    private void showDetails(String article) {

    }
}
