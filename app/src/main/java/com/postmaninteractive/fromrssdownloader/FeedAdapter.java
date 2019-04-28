package com.postmaninteractive.fromrssdownloader;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            Log.d(TAG, "getView: called with null convertview");
            convertView = layoutInflater.inflate(layoutResource,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else{
            Log.d(TAG, "getView: provided with convertview");
            viewHolder = (ViewHolder) convertView.getTag();
        }
//         TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
//        TextView tvArtist = (TextView) convertView.findViewById(R.id.tvArtist);
//        TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);
//
        FeedEntry currentEntry = applications.get(position);
        viewHolder.tvName.setText(currentEntry.getName());
        viewHolder.tvArtist.setText(currentEntry.getArtist());
        viewHolder.tvSummary.setText(currentEntry.getSummary());
        return convertView;
    }

    private class ViewHolder{
        private final TextView tvName, tvArtist, tvSummary;

        ViewHolder(View v){
             tvName = v.findViewById(R.id.tvName);
             tvArtist =v.findViewById(R.id.tvArtist);
             tvSummary = v.findViewById(R.id.tvSummary);
        }
    }
}
