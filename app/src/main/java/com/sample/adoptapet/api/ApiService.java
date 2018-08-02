package com.sample.adoptapet.api;


import com.sample.adoptapet.core.Pet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/api/pets")
    Call<List<Pet>> getPets();

    @GET("/api/pets/{pet_id}")
    Call<Pet> getPet(@Path("pet_id") String petId);
}
