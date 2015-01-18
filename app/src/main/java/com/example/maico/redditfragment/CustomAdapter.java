package com.example.maico.redditfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.maico.redditfragment.domain.RedditPost;

import java.util.ArrayList;

/**
 * Created by Maico on 17/01/2015.
 */
public class CustomAdapter extends BaseAdapter {

    private ArrayList<RedditPost> posts;

    public CustomAdapter(ArrayList<RedditPost> posts) {
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.listitem, parent, false);
        }

        TextView titleView = (TextView) convertView.findViewById(R.id.title);
        TextView authorView = (TextView) convertView.findViewById(R.id.author);
        TextView scoreView = (TextView) convertView.findViewById(R.id.score);
        TextView commentsView = (TextView) convertView.findViewById(R.id.comments);

        RedditPost post = (RedditPost) getItem(position);

        String title = post.getTitle();
        String author = String.format("By %s", post.getAuthor());
        String score = String.format("%d ", post.getScore());
        String comments = String.format("points and %d comments", post.getComments());

        titleView.setText(title);
        authorView.setText(author);
        scoreView.setText(score);
        commentsView.setText(comments);

        return convertView;
    }
}
