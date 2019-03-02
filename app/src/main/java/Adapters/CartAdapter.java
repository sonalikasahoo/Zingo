package Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.zingo.R;

import java.util.ArrayList;

import POJOs.CartElements;
import POJOs.RetailerElements;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    ArrayList<CartElements> cartList;

    public CartAdapter(ArrayList<CartElements> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = (LayoutInflater)viewGroup.getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.cart_card_layout, viewGroup, false);
        return new CartAdapter.CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder cartViewHolder, int i) {
        final CartElements oneEle = cartList.get(i);
        cartViewHolder.tvPname.setText(oneEle.getPname());
        cartViewHolder.tvBarcode.setText(oneEle.getBarcode());
        cartViewHolder.tvMfg.setText(oneEle.getMfg());
        cartViewHolder.tvExp.setText(oneEle.getExp());
        cartViewHolder.tvMrp.setText(oneEle.getMrp());
        cartViewHolder.tvReturnId.setText(oneEle.getReturnId());
        cartViewHolder.tvBatchno.setText(oneEle.getBatchno());

        cartViewHolder.cbSelect.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected


        /*cartViewHolder.cbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //set your object's last status
                oneEle.setOn(isChecked);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvPname, tvBarcode, tvMfg, tvExp, tvMrp, tvReturnId, tvBatchno;
        public CheckBox cbSelect;
        public CartViewHolder(View itemView) {
            super(itemView);
            tvPname = itemView.findViewById(R.id.tvPname);
            tvBarcode = itemView.findViewById(R.id.tvBarcode);
            tvMfg = itemView.findViewById(R.id.tvMfg);
            tvMrp = itemView.findViewById(R.id.tvMrp);
            tvExp = itemView.findViewById(R.id.tvExp);
            tvReturnId = itemView.findViewById(R.id.tvReturnId);
            tvBatchno = itemView.findViewById(R.id.tvBatchno);
            cbSelect = itemView.findViewById(R.id.cbSelect);
        }
    }

    public static class cart_info_adapter extends ArrayAdapter<CartElements> {

        private static final String LOG_TAG = cart_info_adapter.class.getSimpleName();

        public cart_info_adapter(Activity context, ArrayList<CartElements> cart){
            super(context,0,cart);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }


            CartElements currentinfo = getItem(position);

            TextView pName = (TextView) listItemView.findViewById(R.id.tvPname);
            pName.setText(currentinfo.getBarcode());

            TextView barCode = (TextView) listItemView.findViewById(R.id.tvBarcode);
            barCode.setText(currentinfo.getBarcode());

            TextView mfg = (TextView) listItemView.findViewById(R.id.tvMfg);
            mfg.setText(currentinfo.getBarcode());

            TextView exp = (TextView) listItemView.findViewById(R.id.tvExp);
            exp.setText(currentinfo.getBarcode());

            TextView mrp = (TextView) listItemView.findViewById(R.id.tvMrp);
            mrp.setText(currentinfo.getBarcode());

            TextView returnId = (TextView) listItemView.findViewById(R.id.tvReturnId);
            returnId.setText(currentinfo.getBarcode());

            TextView batchNo = (TextView) listItemView.findViewById(R.id.tvBatchno);
            batchNo.setText(currentinfo.getBarcode());



            return listItemView;
        }
    }
}
