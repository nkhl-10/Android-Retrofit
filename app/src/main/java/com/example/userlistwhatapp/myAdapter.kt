package com.example.userlistwhatapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class myAdapter(val chats: ArrayList<DATAItem>, val context : Context?):
    RecyclerView.Adapter<myAdapter.Myclass>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
    val view=LayoutInflater.from(context).inflate(R.layout.chatlist,parent,false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        holder.name.text=chats.get(position).username
        holder.email.text=chats.get(position).email
        Picasso.get().load(chats.get(position).profile).into(holder.profile)


    }

    override fun getItemCount(): Int {
        return chats.size
    }

    class Myclass (v: View):RecyclerView.ViewHolder(v){
        var name=v.findViewById<TextView>(R.id.name)
        var email=v.findViewById<TextView>(R.id.email)
        var profile=v.findViewById<ImageView>(R.id.imageView)

    }

}