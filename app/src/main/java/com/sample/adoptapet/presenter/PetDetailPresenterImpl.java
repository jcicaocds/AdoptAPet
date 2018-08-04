package com.sample.adoptapet.presenter;

import com.sample.adoptapet.api.Api;
import com.sample.adoptapet.core.Pet;
import com.sample.adoptapet.core.PetDetailPresenter;
import com.sample.adoptapet.core.PetDetailView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetDetailPresenterImpl implements PetDetailPresenter {

    private PetDetailView view;
    private Api api;
    private Pet currentPet;

    public PetDetailPresenterImpl(PetDetailView view) {
        this.view = view;
        this.api = new Api();
    }

    @Override
    public void getPetInformation(Pet pet) {
        api.adoptService().getPet(pet.getId()).enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {
                if (response.isSuccessful()) {
                    currentPet = response.body();
                    view.showPet(currentPet);
                } else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {
                view.showError();
            }
        });
    }

    @Override
    public void adopt(String email, String message) {
        // TODO: 4/8/18 Call adopt service
    }

    @Override
    public Pet getCurrentPet() {
        return currentPet;
    }
}
