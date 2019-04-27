package com.example.a1606020003_nguyenhoangbao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.ViewHolder>{
    List<PhoneModel> models;
    int mResource;
    Context mContext;
    public MyViewAdapter(Context context,int resource, List<PhoneModel> objects){
        this.mContext = context;
        this.mResource = resource;
        this.models = objects;
    }
    @NonNull
    @Override
    public MyViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(mResource,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewAdapter.ViewHolder viewHolder, int i) {
        PhoneModel model = models.get(i);
        viewHolder.edtCode.setText(String.valueOf(model.getID()));
        viewHolder.edtName.setText(model.getProduct_Name());
        viewHolder.edtPrice.setText(String.valueOf(model.getPrice()));
        viewHolder.edtDesription.setText(model.getDesrciption());
        viewHolder.edtProducer.setText(model.getProducer());
    }
    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView edtCode;
        private TextView edtName;
        private  TextView edtPrice;
        private TextView edtDesription;
        private TextView edtProducer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.edtCode = itemView.findViewById(R.id.phone_edt_code);
            this.edtName = itemView.findViewById(R.id.phone_edt_name);
            this.edtPrice = itemView.findViewById(R.id.phone_edt_price);
            this.edtDesription = itemView.findViewById(R.id.phone_edt_desription);
            this.edtProducer = itemView.findViewById(R.id.phone_edt_producer);
        }
    }
}
