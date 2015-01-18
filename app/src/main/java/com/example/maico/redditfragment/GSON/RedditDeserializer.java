package com.example.maico.redditfragment.GSON;

import com.example.maico.redditfragment.domain.RedditPost;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Maico on 18/01/2015.
 */
public class RedditDeserializer implements JsonDeserializer<ArrayList<RedditPost>> {
    @Override
    public ArrayList<RedditPost> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jobj = json.getAsJsonObject();
        JsonObject data = jobj.get("data").getAsJsonObject();
        JsonArray children = data.get("children").getAsJsonArray();

        ArrayList<RedditPost> posts = new ArrayList<>();

        for (int i = 1; i < children.size(); i++) {
            JsonObject postData = children.get(i).getAsJsonObject().get("data").getAsJsonObject();

            String title = postData.get("title").getAsString();
            String author = postData.get("author").getAsString();
            String thumbnail = postData.get("url").getAsString();
            int score = postData.get("score").getAsInt();
            int comments = postData.get("num_comments").getAsInt();

            RedditPost post = new RedditPost(title, author, thumbnail, score, comments);

            posts.add(post);
        }

        return posts;
    }
}
