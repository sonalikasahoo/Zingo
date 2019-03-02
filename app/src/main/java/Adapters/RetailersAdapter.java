package Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zingo.R;
import com.example.zingo.reatiler_info;

import java.util.ArrayList;

import POJOs.RetailerElements;

public class RetailersAdapter extends RecyclerView.Adapter<RetailersAdapter.RetailerViewHolder>  {

    ArrayList<RetailerElements> retailersList;

    public RetailersAdapter(ArrayList<RetailerElements> retailersList) {
        this.retailersList = retailersList;
    }

    @NonNull
    @Override
    public RetailerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = (LayoutInflater)viewGroup.getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.retailers_card_layout, viewGroup, false);
        return new RetailersAdapter.RetailerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RetailerViewHolder retailerViewHolder, int i) {
        RetailerElements oneEle = retailersList.get(i);
        retailerViewHolder.tvRtName.setText(oneEle.getRtName());
        retailerViewHolder.tvRtContact.setText(oneEle.getRtContact());
        retailerViewHolder.tvAddress.setText(oneEle.getRtAddress());
    }

    @Override
    public int getItemCount() {
        return retailersList.size();
    }

    class RetailerViewHolder extends RecyclerView.ViewHolder {
        TextView tvRtId, tvRtName, tvRtContact, tvAddress;
        public RetailerViewHolder(View itemView) {
            super(itemView);
            tvRtName = itemView.findViewById(R.id.tvRtName);
            tvRtContact = itemView.findViewById(R.id.tvRtContact);
            tvAddress = itemView.findViewById(R.id.tvRtAddress);
        }
    }

    public static class retailer_info_adapter extends ArrayAdapter<reatiler_info> {

        private static final String LOG_TAG = retailer_info_adapter.class.getSimpleName();

        public retailer_info_adapter(Activity context, ArrayList<reatiler_info> retailer){
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
}
