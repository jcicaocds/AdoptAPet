package com.sample.adoptapet.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.PluralsRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sample.adoptapet.R;
import com.sample.adoptapet.core.Pet;
import com.sample.adoptapet.core.PetDetailPresenter;
import com.sample.adoptapet.core.PetDetailView;
import com.sample.adoptapet.presenter.PetDetailPresenterImpl;

import me.gujun.android.taggroup.TagGroup;


public class PetDetailFragment extends Fragment implements PetDetailView {

    private PetDetailPresenter presenter;

    private TextView nameTextView;
    private TextView breedTextView;
    private TextView colorTextView;
    private TextView ageTextView;
    private TextView sizeTextView;
    private TextView sexTextView;
    private ImageView detailPhotoImageView;
    private TagGroup friendlyTagGroup;

    public PetDetailFragment() {
        presenter = new PetDetailPresenterImpl(this);
    }

    public PetDetailPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pet_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTextView = view.findViewById(R.id.pet_detail_name);
        breedTextView = view.findViewById(R.id.pet_detail_breed);
        colorTextView = view.findViewById(R.id.pet_detail_color_text_value);
        ageTextView = view.findViewById(R.id.pet_detail_age_text_value);
        sizeTextView = view.findViewById(R.id.pet_detail_size_text_value);
        sexTextView = view.findViewById(R.id.pet_detail_sex_text_value);
        detailPhotoImageView = view.findViewById(R.id.pet_detail_photo);
        friendlyTagGroup = view.findViewById(R.id.friendly_tag_group);

    }

    @Override
    public void showPet(Pet pet) {
        nameTextView.setText(pet.getName());
        breedTextView.setText(pet.getBreed());
        colorTextView.setText(pet.getColor());
        ageTextView.setText(pet.getAge());
        sizeTextView.setText(pet.getSize());
        sexTextView.setText(pet.getSex());

        friendlyTagGroup.setTags(pet.getFriendlyList().toArray(new String[0]));

        String photoUrl = pet.getProfilePicture();
        RequestOptions options = new RequestOptions()
                .placeholder(R.color.pet_detail_placeholder)
                .centerCrop();
        if (getContext() != null) {
            Glide.with(getContext())
                    .load(photoUrl)
                    .apply(options)
                    .into(detailPhotoImageView);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), getString(R.string.pet_detail_generic_error)
                , Toast.LENGTH_SHORT).show();
    }
}
