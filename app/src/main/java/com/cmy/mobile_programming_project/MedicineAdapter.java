package com.cmy.mobile_programming_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    private List<MedicineData> medicineData;
    private Context context;

    public MedicineAdapter(Context context, List <MedicineData>medicineData) {
        this.medicineData = medicineData;
        this.context = context;
    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_item, null);
        return new MedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicineViewHolder holder, int position) {
        MedicineData medicine = medicineData.get(position);

        Glide.with(context).load(medicine.getImage()).into(holder.imageView);
        holder.tvName.setText(medicine.getName());
        holder.tvPrice.setText(String.valueOf(medicine.getPrice()));
    }


    @Override
    public int getItemCount() {
        return this.medicineData.size();
    }

    class MedicineViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvPrice;
        ImageView imageView;

        public MedicineViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
