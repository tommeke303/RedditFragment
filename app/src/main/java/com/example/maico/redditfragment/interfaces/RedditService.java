package com.example.maico.redditfragment.interfaces;

import com.example.maico.redditfragment.domain.RedditPost;

import java.util.ArrayList;
import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Maico on 18/01/2015.
 */
public interface RedditService {

    @GET("/r/{category}.json")
    ArrayList<RedditPost> getReddits(@Path("category") String category);
}
