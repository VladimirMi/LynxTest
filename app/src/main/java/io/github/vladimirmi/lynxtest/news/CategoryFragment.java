package io.github.vladimirmi.lynxtest.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.github.vladimirmi.lynxtest.R;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class CategoryFragment extends Fragment {

    private static final String ARG_CATEGORY = "category";

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

        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        textView.setText(getArguments().getString(ARG_CATEGORY));
        return rootView;
    }

}
