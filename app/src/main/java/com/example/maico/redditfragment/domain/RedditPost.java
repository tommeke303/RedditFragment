package com.example.maico.redditfragment.domain;

/**
 * Created by Maico on 17/01/2015.
 */
public class RedditPost {
    private String title, author, thumbnailUrl;
    private int score, comments;

    public RedditPost(String title, String author, String thumbnailUrl, int score, int comments) {
        this.title = title;
        this.author = author;
        this.thumbnailUrl = thumbnailUrl;
        this.score = score;
        this.comments = comments;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
