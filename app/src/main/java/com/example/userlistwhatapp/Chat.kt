package com.example.userlistwhatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Chat : Fragment() {

lateinit var adapter: myAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_chat, container, false)

        var Data: ArrayList<DATAItem> = ArrayList()

        var recyclerView: RecyclerView = view.findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getdata().enqueue(object : Callback<ArrayList<DATAItem>> {
            override fun onResponse(call: Call<ArrayList<DATAItem>>?, response: Response<ArrayList<DATAItem>>?) {
                Data = response?.body()!!
                recyclerView.adapter = myAdapter(response?.body()!!, context)
            }

            override fun onFailure(call: Call<ArrayList<DATAItem>>?, t: Throwable?) {
            }
        })



        return  view
    }





    }
