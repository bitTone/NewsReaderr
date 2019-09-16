package com.tj.newsreader.models;

import com.squareup.moshi.Json;

public class NewsSource {

    //@Expose for Gson????
    //Expose is used to allow or disallow serialization and deserialization
    //optional if false field wont allow serialization
    @Json(name = "id") private String id;
    @Json(name = "name")  private String name;

    public String getId(){
        return id;


    }

    public void setId(String id){
        this.id = id;

    }

    public String getName(){
        return name;

    }

    public void setName(String name){
        this.name = name;

    }


}
