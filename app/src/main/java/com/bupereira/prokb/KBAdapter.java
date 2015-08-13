package com.bupereira.prokb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

        // Get the current KBEntry
        final KBEntry mKBEntry = mItems.get(position);
        final ViewHolder holder;


        if (convertView == null) {
            // Inflate the View for this KBEntry
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.kb_item, null);

            // Fill in the specific KBEntry data
            holder = new ViewHolder();
            holder.KBTitle = (TextView) convertView.findViewById(R.id.KBTitle);
            holder.KBData = (TextView) convertView.findViewById(R.id.KBData);
            holder.KBDescription = (TextView) convertView.findViewById(R.id.KBDescription);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.KBTitle.setText(mKBEntry.getmTitle());
        holder.KBDescription.setText(mKBEntry.getmContent());
        holder.KBData.setText(mKBEntry.getmData());


        // TODO - Add a click Listener to open detail view next.

        // Return the View you just created
        return convertView;
    }

    static class ViewHolder {
        TextView KBTitle;
        TextView KBData;
        TextView KBDescription;
    }
}