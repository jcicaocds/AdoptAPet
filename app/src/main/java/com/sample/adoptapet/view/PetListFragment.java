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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sample.adoptapet.R;
import com.sample.adoptapet.core.Pet;
import com.sample.adoptapet.core.PetListPresenter;
import com.sample.adoptapet.core.PetListView;
import com.sample.adoptapet.presenter.PetListPresenterImpl;

import java.util.List;

public class PetListFragment extends Fragment implements PetListView, OnItemClickListener {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private PetListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private PetListPresenter presenter;

    public PetListFragment() {
        presenter = new PetListPresenterImpl(this);
    }

    public PetListPresenter getPresenter() {
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
        return inflater.inflate(R.layout.fragment_pet_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.pet_list_progress_bar);
        recyclerView = view.findViewById(R.id.pet_list_recycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PetListAdapter(getContext(), this);
        recyclerView.setAdapter(adapter);

        presenter.getPets();

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadPets(List<Pet> pets) {
        adapter.setPets(pets);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(Pet pet) {
        ((MainActivity) getActivity()).showPetDetailFragment(pet);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), getString(R.string.pet_list_generic_error)
                , Toast.LENGTH_SHORT).show();
    }

}
