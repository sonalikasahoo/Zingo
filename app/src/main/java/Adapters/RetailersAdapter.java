package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zingo.R;

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
        retailerViewHolder.tvRtId.setText(oneEle.getRtId());
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
            tvRtId = itemView.findViewById(R.id.tvRtId);
            tvRtName = itemView.findViewById(R.id.tvRtName);
            tvRtContact = itemView.findViewById(R.id.tvRtContact);
            tvAddress = itemView.findViewById(R.id.tvRtAddress);
        }
    }
}
