package io.github.vladimirmi.lynxtest.news;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vladimirmi.lynxtest.R;
import io.github.vladimirmi.lynxtest.data.models.Category;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventVH> {

    private List<Category.Event> events= Collections.emptyList();
    private final OnDetailsClickListener listener;

    public EventsAdapter(OnDetailsClickListener listener) {
        this.listener = listener;
    }

    public void setData(List<Category.Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventVH holder, int position) {
        Category.Event event = events.get(position);
        holder.bind(event);
        holder.detailsBtn.setOnClickListener(view -> listener.onDetailsClick(event.getArticle()));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventVH extends RecyclerView.ViewHolder {
        @BindView(R.id.titleTv) TextView titleTv;
        @BindView(R.id.coefTv) TextView coefTv;
        @BindView(R.id.timeTv) TextView timeTv;
        @BindView(R.id.placeTv) TextView placeTv;
        @BindView(R.id.previewTv) TextView previewTv;
        @BindView(R.id.detailsBtn) Button detailsBtn;

        public EventVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Category.Event event) {
            titleTv.setText(event.getTitle());
            coefTv.setText(event.getCoefficient());
            timeTv.setText(event.getTime());
            placeTv.setText(event.getPlace());
            previewTv.setText(event.getPreview());
        }
    }

    public interface OnDetailsClickListener {
        void onDetailsClick(String article);
    }
}
