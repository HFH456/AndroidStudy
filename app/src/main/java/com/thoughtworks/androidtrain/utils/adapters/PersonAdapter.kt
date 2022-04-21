package com.thoughtworks.androidtrain.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.androidtrain.R
import com.thoughtworks.androidtrain.data.Person
import com.thoughtworks.androidtrain.data.Tweet
import kotlinx.android.synthetic.main.persion_item_layout.view.*

class MainAdapter() : RecyclerView.Adapter<MainAdapter.PersonViewHolder>() {

    private var persons = ArrayList<Tweet>();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var from = LayoutInflater.from(parent.context)
        return PersonViewHolder(from.inflate(R.layout.persion_item_layout,parent,false))
//        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int = persons.size

    public fun setTweet(tweet : ArrayList<Tweet>) {
        this.persons.clear()
        this.persons.addAll(tweet)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.tvName.setText(persons.get(position).sender!!.nick)
        holder.tweet_content.setText(persons.get(position).content)
//        holder.itemView.text = items[position]
    }

    class PersonViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName = itemView.tv_name
        var tweet_content = itemView.tweet_content
    }
}