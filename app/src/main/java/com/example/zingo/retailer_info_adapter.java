package com.example.zingo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class retailer_info_adapter extends ArrayAdapter<reatiler_info> {

    private static final String LOG_TAG = retailer_info_adapter.class.getSimpleName();

    public retailer_info_adapter(Activity context,ArrayList<reatiler_info> retailer){
        super(context,0,retailer);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


      reatiler_info currentinfo = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.rid);
        nameTextView.setText(currentinfo.getMretailer_id());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.rname);
        numberTextView.setText(currentinfo.getMretailer_name());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.rnumber);
        dateTextView.setText(currentinfo.getMretailer_number());

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.raddress);
        timeTextView.setText(currentinfo.getMretailer_address());



        return listItemView;
    }
}
