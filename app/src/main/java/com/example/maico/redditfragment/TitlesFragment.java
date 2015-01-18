package com.example.maico.redditfragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.maico.redditfragment.interfaces.OnItemSelectListener;

/**
 * Created by Maico on 17/01/2015.
 */
public class TitlesFragment extends ListFragment {

    private OnItemSelectListener onItemSelectListener;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setDivider(null);
        getListView().setDividerHeight(0);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            onItemSelectListener = (OnItemSelectListener) activity;
        } catch(ClassCastException ex) {
            throw new ClassCastException("Class must implement OnItemSelectListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        onItemSelectListener.OnItemSelect(position);
    }
}
