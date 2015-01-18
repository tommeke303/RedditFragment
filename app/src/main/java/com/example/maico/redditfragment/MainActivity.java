package com.example.maico.redditfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.maico.redditfragment.GSON.DownloadReddits;
import com.example.maico.redditfragment.domain.RedditPost;
import com.example.maico.redditfragment.interfaces.AsyncResponse;
import com.example.maico.redditfragment.interfaces.OnItemSelectListener;

import java.util.ArrayList;


public class MainActivity extends Activity implements AsyncResponse, OnItemSelectListener {

    private DetailsFragment detailsFragment;
    private boolean isLandscape;
    private ArrayList<RedditPost> posts;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<>();
        adapter = new CustomAdapter(posts);

        FragmentManager fm = getFragmentManager();
        TitlesFragment titlesFragment = (TitlesFragment) fm.findFragmentById(R.id.titles);
        titlesFragment.setListAdapter(adapter);

        detailsFragment = (DetailsFragment) fm.findFragmentById(R.id.details);

        checkIsLandscape();

        if (detailsFragment == null && isLandscape) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.details, new DetailsFragment());
            ft.commit();
        }

        DownloadReddits task = new DownloadReddits();
        task.setDelegate(this);
        task.execute("funny");
    }

    @Override
    public void OnItemSelect(int pos) {
        RedditPost item = posts.get(pos);

        checkIsLandscape();

        if (isLandscape) {
            FragmentManager fm = getFragmentManager();
            detailsFragment = (DetailsFragment) fm.findFragmentById(R.id.details);
            detailsFragment.setItem(item);
        } else{
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("title", item.getTitle());
            intent.putExtra("author", item.getAuthor());
            intent.putExtra("thumbnail", item.getThumbnailUrl());
            intent.putExtra("score", item.getScore());
            intent.putExtra("comments", item.getComments());
            startActivity(intent);
        }
    }

    private void checkIsLandscape() {
        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public void processFinish(ArrayList<RedditPost> output) {
        posts.addAll(output);
        adapter.notifyDataSetChanged();
    }
}
