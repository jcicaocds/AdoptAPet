package com.sample.adoptapet.presenter;


import android.support.annotation.NonNull;

import com.sample.adoptapet.api.Api;
import com.sample.adoptapet.core.Pet;
import com.sample.adoptapet.core.PetListPresenter;
import com.sample.adoptapet.core.PetListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetListPresenterImpl implements PetListPresenter {

    private PetListView view;
    private Api api;

    public PetListPresenterImpl(PetListView view) {
        this.view = view;
        this.api = new Api();
    }

    @Override
    public void getPets() {
        api.adoptService().getPets().enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(@NonNull Call<List<Pet>> call, @NonNull Response<List<Pet>> response) {
                if (response.isSuccessful()) {
                    List<Pet> pets = response.body();
                    view.loadPets(pets);
                } else {
                    view.showError();
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<Pet>> call, @NonNull Throwable t) {
                view.showError();
            }
        });
    }
}
