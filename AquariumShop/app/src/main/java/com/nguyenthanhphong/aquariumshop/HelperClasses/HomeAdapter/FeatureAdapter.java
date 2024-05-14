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

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.FeaturedViewHolder> {
    ArrayList<FeaturedHelperClasss> featuredLocations;

    public FeatureAdapter (ArrayList<FeaturedHelperClasss> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_card_design,parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClasss featuredHelperClasss= featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperClasss.getImage());
        holder.title.setText(featuredHelperClasss.getTitle());
        holder.desc.setText(featuredHelperClasss.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.feature_image);
            title = itemView.findViewById(R.id.feature_title);
            desc = itemView.findViewById(R.id.feature_desc);
        }
    }
}
