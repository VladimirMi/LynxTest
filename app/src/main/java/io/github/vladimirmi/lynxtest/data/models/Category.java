package io.github.vladimirmi.lynxtest.data.models;

import java.util.List;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class Category {

    private List<Events> events;

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public static class Events {

        private String title;
        private String coefficient;
        private String time;
        private String place;
        private String preview;
        private String article;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCoefficient() {
            return coefficient;
        }

        public void setCoefficient(String coefficient) {
            this.coefficient = coefficient;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public String getArticle() {
            return article;
        }

        public void setArticle(String article) {
            this.article = article;
        }
    }
}
