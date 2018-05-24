package io.github.vladimirmi.lynxtest.details;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vladimirmi.lynxtest.R;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_ARTICLE = "article";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.teamsTv) TextView teamsTv;
    @BindView(R.id.timeTv) TextView timeTv;
    @BindView(R.id.tournamentTv) TextView tournamentTv;
    @BindView(R.id.placeTv) TextView placeTv;
    @BindView(R.id.articleList) RecyclerView articleList;
    @BindView(R.id.predictionLabelTv) TextView predictionLabelTv;
    @BindView(R.id.predictionTv) TextView predictionTv;

    private DetailViewModel viewModel;
    private ArticlesAdapter articlesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setupToolbar();
        setupArticles();
        setupView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupArticles() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        articleList.setLayoutManager(layoutManager);

        articlesAdapter = new ArticlesAdapter();
        articleList.setAdapter(articlesAdapter);
    }

    private void setupView() {
        viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        String article = getIntent().getStringExtra(EXTRA_ARTICLE);
        viewModel.init(article);

        viewModel.getArticle().observe(this, articleDetail -> {
            predictionLabelTv.setVisibility(View.VISIBLE);

            teamsTv.setText(String.format("%s - %s",
                    articleDetail.getTeam1().trim(),
                    articleDetail.getTeam2().trim()));
            timeTv.setText(articleDetail.getTime());
            tournamentTv.setText(articleDetail.getTournament());
            placeTv.setText(articleDetail.getPlace());
            predictionTv.setText(articleDetail.getPrediction());

            articlesAdapter.setData(articleDetail.getArticle());
        });
    }
}
