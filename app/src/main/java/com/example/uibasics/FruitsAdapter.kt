package com.example.uibasics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitsAdapter(
    private val fruitList: List<String>
) : RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>() {

    override fun getItemCount(): Int {
        return fruitList.size
    }

    // Only inflates cards
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        // Card 1 -> FruitsViewHolder instance 1
        // card 2 -> FruitsViewHolder instance 2
        // card 3 -> FruitsViewHolder instance 3
        val cardView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_card, parent, false)
        return FruitsViewHolder(cardView)
    }

    // Added text to those cards. Data binding happens here.
    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.fruitName.text = fruitList[position]
    }

    class FruitsViewHolder(cardView: View) : RecyclerView.ViewHolder(cardView) {
        val fruitName: TextView = cardView.findViewById(R.id.fruit_name)
    }
}