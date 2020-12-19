package com.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Cat {

    @SerializedName("status")
    @Expose
    var status : Status? = null

    @SerializedName("type")
    @Expose
    var type :  String  = ""

    @SerializedName("text")
    @Expose
    var text : String = ""

    @SerializedName("source")
    @Expose
    var source : String = ""

    @SerializedName("used")
    @Expose
    var used : Boolean = false

    override fun toString(): String {
        return "Cat(status=$status, type='$type', text='$text', source='$source', used=$used)"
    }

}

class Status {

    @SerializedName("verified")
    @Expose
    var verified : Boolean = false

    @SerializedName("sentCount")
    @Expose
    var sentCount : Int = -1

    @SerializedName("feedback")
    @Expose
    var feedback : String = ""


    override fun toString(): String {
        return "verified=$verified, sentCount=$sentCount, feedback='$feedback' "
    }

}