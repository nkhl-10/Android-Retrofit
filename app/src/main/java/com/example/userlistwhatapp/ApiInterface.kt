package com.example.userlistwhatapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/userlist.php")
   fun getdata(): Call<ArrayList<DATAItem>>
}