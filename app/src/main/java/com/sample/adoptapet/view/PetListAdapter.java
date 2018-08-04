package com.sample.adoptapet.view;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sample.adoptapet.R;
import com.sample.adoptapet.core.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetListAdapter extends RecyclerView.Adapter<PetListAdapter.ViewHolder> {

    private Context context;
    private List<Pet> pets;
    private final OnItemClickListener listener;

    public PetListAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.pets = new ArrayList<>();
        this.listener = listener;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_pet, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pet pet = pets.get(position);
        bindListener(holder, pet);
        String petName = pet.getName();
        holder.textPetName.setText(petName);

        String photoUrl = pet.getProfilePicture();
        RequestOptions options = new RequestOptions()
                .placeholder(R.color.cardview_dark_background)
                .centerCrop();
        Glide.with(context)
                .load(photoUrl)
                .apply(options)
                .into(holder.petPhoto);

    }

    private void bindListener(ViewHolder viewHolder, final Pet pet) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(pet);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView petPhoto;
        TextView textPetName;

        public ViewHolder(View itemView) {
            super(itemView);
            textPetName = itemView.findViewById(R.id.item_pet_name);
            petPhoto = itemView.findViewById(R.id.item_pet_photo);
        }

    }
}
