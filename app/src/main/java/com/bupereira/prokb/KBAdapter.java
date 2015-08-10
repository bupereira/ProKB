package com.bupereira.prokb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bupereira on 09/08/2015.
 */
public class KBAdapter extends BaseAdapter {

    private final List<KBEntry> mItems = new ArrayList<KBEntry>();
    private final Context mContext;


    public KBAdapter(Context context) {

        mContext = context;

    }

    // Add a KBEntry to the adapter
    // Notify observers that the data set has changed
    public void add(KBEntry item) {

        mItems.add(item);
        notifyDataSetChanged();

    }

    // Clears the list adapter of all items.

    public void clear() {

        mItems.clear();
        notifyDataSetChanged();

    }

    // Returns the number of ToDoItems

    @Override
    public int getCount() {

        return mItems.size();

    }

    // Retrieve the number of ToDoItems

    @Override
    public Object getItem(int pos) {

        return mItems.get(pos);

    }

    // Get the ID for the ToDoItem
    // In this case it's just the position

    @Override
    public long getItemId(int pos) {

        return pos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //mContext.setConte
        if (convertView == null)
            convertView = /*mContext*/ convertView.inflate(mContext, (int) getItemId(position), parent);;

        // TODO - Inflate the View for this ToDoItem
        // from todo_item.xml.



        // Return the View you just created
        return null;
    }
