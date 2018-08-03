package com.sample.adoptapet.core;


import java.util.List;

public interface PetListView {
    void loadPets(List<Pet> pets);

    void showError();
}
