package com.example.maico.redditfragment;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maico.redditfragment.domain.RedditPost;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Maico on 17/01/2015.
 */
public class DetailsFragment extends Fragment {

    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detailsfragment, container, false);
        img = (ImageView) view.findViewById(R.id.detailsImage);

        return view;
    }

    public void setItem(RedditPost post) {
        Picasso.with(getActivity().getBaseContext()).load(post.getThumbnailUrl()).into(img, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                img.setImageResource(R.drawable.no_image);
                Toast.makeText(getActivity(), "Image might be GIF, which cannot be loaded", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
