package com.tj.newsreader.models;

import com.squareup.moshi.Json;



public class Article {




    @Json(name = "Author") String name;
    @Json(name = "Title ") String title;
    @Json(name = "Description") String Description;
    @Json(name = "Image") String Image;

    public Article(String name, String title, String Description, String Image){

        this.name = name;
        this.title = title;
        this.Description = Description;
        this.Image = Image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Article(){





    }











}
