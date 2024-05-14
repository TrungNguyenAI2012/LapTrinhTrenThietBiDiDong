package com.nguyenthanhphong.aquariumshop.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyenthanhphong.aquariumshop.R;

import java.util.ArrayList;

public class MostAdapter extends RecyclerView.Adapter<MostAdapter.MostViewHolder> {
    ArrayList<MostHelperClass> mostLocations;

    public MostAdapter(ArrayList<MostHelperClass> mostLocations) {
        this.mostLocations = mostLocations;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_card_view_design, parent, false);
        MostViewHolder mostViewHolder = new MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {
        MostHelperClass mostHelperClass =mostLocations.get(position);
        holder.image.setImageResource(mostHelperClass.getImages());
        holder.title.setText(mostHelperClass.getTitles());
        holder.desc.setText(mostHelperClass.getDesceptions());
    }

    @Override
    public int getItemCount() {
        return mostLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc;
        public MostViewHolder(@NonNull View itemView) {

            super(itemView);

            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            desc = itemView.findViewById(R.id.mv_desc);
        }
    }
}
