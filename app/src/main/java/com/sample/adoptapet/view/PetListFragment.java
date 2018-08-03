package com.sample.adoptapet.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.adoptapet.R;
import com.sample.adoptapet.core.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetListFragment extends Fragment {

    private RecyclerView recyclerView;
    private PetListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public PetListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pet_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.pet_list_recycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PetListAdapter(getContext());

        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Pet pet = new Pet("Pet #" + i);
            pets.add(pet);
        }
        adapter.setPets(pets);

        recyclerView.setAdapter(adapter);
    }
}
