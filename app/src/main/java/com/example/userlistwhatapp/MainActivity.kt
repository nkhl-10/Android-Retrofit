package com.example.userlistwhatapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TableLayout
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    var tabtitle= arrayListOf("Chats","Status","Calls")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tablayout =findViewById<TabLayout>(R.id.tabLayout)
        var viewpager =findViewById<ViewPager2>(R.id.viewpager)
        viewpager.adapter=ViewAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tablayout,viewpager){
            tab,position ->
            tab.text =tabtitle[position]
        }.attach()





    }

}