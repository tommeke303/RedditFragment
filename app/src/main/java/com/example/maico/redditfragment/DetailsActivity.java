package com.example.maico.redditfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.maico.redditfragment.domain.RedditPost;


public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        FragmentManager fm = getFragmentManager();
        DetailsFragment details = (DetailsFragment) fm.findFragmentById(R.id.details);

        Bundle data = getIntent().getExtras();
        String title = data.getString("title");
        String author = data.getString("author");
        String thumbnail = data.getString("thumbnail");
        int score = data.getInt("score");
        int comments = data.getInt("comments");

        RedditPost post = new RedditPost(title, author, thumbnail, score, comments);
        details.setItem(post);
    }


}
