package com.smt.smt_as;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class data_model {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName(){
        return name;
    }
//    @SerializedName("id")
//    @Expose
//    private String id;
//
//    @SerializedName("title")
//    @Expose
//    private String title;
//
//    @SerializedName("body")
//    @Expose
//    private String body;
//
//    public String getID(){
//        return id;
//    }
//
//    public String getTitle(){
//        return title;
//    }
//
//    public String getBody(){
//        return body;
//    }
}
