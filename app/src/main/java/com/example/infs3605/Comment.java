package com.example.infs3605;

import android.view.View;

import java.util.ArrayList;

/**
 * Simple POJO model for example
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Comment {

  private String title;
  private String content;
  private int imageView;
  private String sentimentScore;

    public Comment(String title, String content, int imageView, String sentimentScore) {
        this.title = title;
        this.content = content;
        this.imageView = imageView;
        this.sentimentScore = sentimentScore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getSentimentScore() {
        return sentimentScore;
    }

    public void setSentimentScore(String sentimentScore) {
        this.sentimentScore = sentimentScore;
    }
}
