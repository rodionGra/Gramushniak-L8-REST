package com.rest

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Example of use call.execute
 *
 * Using Retrofit to download JSON for the link:
 * https://cat-fact.herokuapp.com/facts
 * Convert it to Kotlin Objects by embedding the results in the console.
 * */

fun main() {
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com/") //Базовая часть адреса
            .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
            .build()

    val catApi2: CatApi? = retrofit.create(CatApi::class.java)  //Создаем объект, при помощи которого будем выполнять запросы

    val response = catApi2?.getInfoCat()?.execute()
    val catList : List<Cat>? = response?.body()


    catList?.forEach(::println)
}

interface CatApi{
    //Методы должны всегда возвращать объект типа Call<T> и иметь аннотацию типа запроса (GET, POST, PUT, DELETE).
    @GET("facts")           //вказана змінна в анотації get ставиться після основної ссилки
    fun getInfoCat() : Call<List<Cat>>
}
