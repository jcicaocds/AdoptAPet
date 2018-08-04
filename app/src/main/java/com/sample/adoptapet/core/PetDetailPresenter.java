package com.sample.adoptapet.core;

public interface PetDetailPresenter {

    void getPetInformation(Pet pet);
    void adopt(String email, String message);
    Pet getCurrentPet();

}
