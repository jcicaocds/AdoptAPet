package com.sample.adoptapet.core;

public interface PetDetailView {

    void showPet(Pet pet);
    void showError();
    void adoptState(boolean success);
}
