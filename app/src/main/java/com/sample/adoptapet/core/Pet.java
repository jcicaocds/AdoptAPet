package com.sample.adoptapet.core;


import com.squareup.moshi.Json;

import java.util.List;

public class Pet {
    @Json(name = "_id")
    private String id;

    @Json(name = "name")
    private String name;

    @Json(name = "age")
    private String age;

    @Json(name = "color")
    private String color;

    @Json(name = "size")
    private String size;

    @Json(name = "sex")
    private String sex;

    @Json(name = "description")
    private String description;

    @Json(name = "breed")
    private String breed;

    @Json(name = "profilePicture")
    private String profilePicture;

    @Json(name = "photos")
    private List<String> photos;

    @Json(name = "friendlyWith")
    private List<String> friendlyList;

    public Pet(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getSex() {
        return sex;
    }

    public String getDescription() {
        return description;
    }

    public String getBreed() {
        return breed;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public List<String> getFriendlyList() {
        return friendlyList;
    }
}
