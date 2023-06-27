package com.example.userlistwhatapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewAdapter (fragmentManager:FragmentManager,lifecycle:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 ->return Chat()
            1 ->return Status()
            2 ->return Calls()
            else->return Chat()
        }
    }
}