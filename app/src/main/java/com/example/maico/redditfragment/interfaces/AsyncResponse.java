package com.example.maico.redditfragment.interfaces;


import com.example.maico.redditfragment.domain.RedditPost;

import java.util.ArrayList;

/**
 * Created by Maico on 22/12/2014.
 */
public interface AsyncResponse {
    void processFinish(ArrayList<RedditPost> output);
}
