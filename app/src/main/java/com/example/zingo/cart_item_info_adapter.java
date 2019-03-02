package com.example.zingo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class cart_item_info_adapter extends ArrayAdapter<cart_item_info> {

    private static final String LOG_TAG = cart_item_info.class.getSimpleName();

    public cart_item_info_adapter(@androidx.annotation.NonNull @NonNull Context context, ArrayList<cart_item_info> resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        cart_item_info currentinfo = getItem(position);

        TextView returnTextView = (TextView) listItemView.findViewById(R.id.rid);
        returnTextView.setText(((cart_item_info) currentinfo).getMreturnid());

        TextView retailerTextView = (TextView) listItemView.findViewById(R.id.retailer_id);
        returnTextView.setText(((cart_item_info) currentinfo).getMretailerid());

        TextView productTextView = (TextView) listItemView.findViewById(R.id.product_name);
        returnTextView.setText(((cart_item_info) currentinfo).getMproductname());

        TextView batchTextView = (TextView) listItemView.findViewById(R.id.batch_no);
        returnTextView.setText(((cart_item_info) currentinfo).getMbatchno());

        TextView barcodeTextView = (TextView) listItemView.findViewById(R.id.barcode);
        returnTextView.setText(((cart_item_info) currentinfo).getMbarcode());

        TextView mrpTextView = (TextView) listItemView.findViewById(R.id.mrp_prod);
        returnTextView.setText(((cart_item_info) currentinfo).getMmrp());

        TextView mfgTextView = (TextView) listItemView.findViewById(R.id.mfg_date);
        returnTextView.setText(((cart_item_info) currentinfo).getMmfgdate());

        TextView expTextView = (TextView) listItemView.findViewById(R.id.date_exp);
        returnTextView.setText(((cart_item_info) currentinfo).getMexpdate());

        return listItemView;
    }
}


