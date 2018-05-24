package io.github.vladimirmi.lynxtest.data.models;

import java.util.List;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class ArticleDetail {

    private String team1;
    private String team2;
    private String time;
    private String tournament;
    private String place;
    private String prediction;
    private List<Article> article;

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    public static class Article {

        private String header;
        private String text;

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
