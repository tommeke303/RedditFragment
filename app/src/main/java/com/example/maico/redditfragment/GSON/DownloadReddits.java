package com.example.maico.redditfragment.GSON;

import android.os.AsyncTask;

import com.example.maico.redditfragment.domain.RedditPost;
import com.example.maico.redditfragment.interfaces.AsyncResponse;
import com.example.maico.redditfragment.interfaces.RedditService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Maico on 18/01/2015.
 */
public class DownloadReddits extends AsyncTask<String, Void , ArrayList<RedditPost>> {
    private AsyncResponse delegate = null;

    public void setDelegate(AsyncResponse asyncResponse) {
        this.delegate = asyncResponse;
    }

    @Override
    protected ArrayList<RedditPost> doInBackground(String... params) {

        String category = params[0];

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(ArrayList.class, new RedditDeserializer())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://www.reddit.com")
                .setConverter(new GsonConverter(gson))
                .build();

        RedditService redditService = restAdapter.create(RedditService.class);

        return redditService.getReddits(category);
    }

    @Override
    protected void onPostExecute(ArrayList<RedditPost> redditPosts) {
        super.onPostExecute(redditPosts);
        delegate.processFinish(redditPosts);
    }
}
