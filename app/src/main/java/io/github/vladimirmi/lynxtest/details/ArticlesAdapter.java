package io.github.vladimirmi.lynxtest.details;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vladimirmi.lynxtest.R;
import io.github.vladimirmi.lynxtest.data.models.ArticleDetail;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleVH> {

    private List<ArticleDetail.Article> articles = Collections.emptyList();

    public void setData(List<ArticleDetail.Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArticlesAdapter.ArticleVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticlesAdapter.ArticleVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesAdapter.ArticleVH holder, int position) {
        holder.bind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ArticleVH extends RecyclerView.ViewHolder {

        @BindView(R.id.headerTv) TextView headerTv;
        @BindView(R.id.textTv) TextView textTv;

        public ArticleVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(ArticleDetail.Article article) {
            headerTv.setText(article.getHeader());
            textTv.setText(article.getText());
        }
    }
}
