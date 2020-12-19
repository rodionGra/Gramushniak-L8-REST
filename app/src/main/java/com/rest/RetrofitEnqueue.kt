package com.rest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.ArrayList

/**
 * Example of use call.enqueue
 *
 * Using Retrofit to download JSON for the link:
 * https://cat-fact.herokuapp.com/facts
 * Convert it to Kotlin Objects by embedding the results in the console.*/

fun main() {
    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://cat-fact.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val jsonPlaceHolderApi : JsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

    val call : Call<List<Cat>> = jsonPlaceHolderApi.getCatList()

    var catList: List<Cat>? = null

    call.enqueue(object : Callback<List<Cat>> {
        override fun onResponse(call: Call<List<Cat>>, response : Response<List<Cat>>) {
            if (response.isSuccessful) {
                catList = response.body()
            }else {
                // error response, no access to resource?
            }
        }
        override fun onFailure(call: Call<List<Cat>>, t: Throwable) {

        }
    })
    println("Please wait! Downloading files")

    var counter = 0
    while (counter <= 10){
        Thread.sleep(1_000)
        if (catList !== null){
            catList?.forEach (::println)
            break
        }
        counter++
    }
    if (catList == null) println("No data")
}

interface JsonPlaceHolderApi{
    //Методы должны всегда возвращать объект типа Call<T> и иметь аннотацию типа запроса (GET, POST, PUT, DELETE).
    //(@Query("name") String resourceName, @Query("num") int count)
    @GET("facts")           //вказана змінна в анотації get ставиться після основної ссилки
    fun getCatList() : Call<List<Cat>>
}




