package com.example.matches.presentation.matches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.base.model.matches.Match
import com.example.matches.R

class MatchListAdapter : RecyclerView.Adapter<MatchListAdapter.MatchListViewHolder>() {

    private var items: MutableList<Match?> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_match_list, parent, false)
        return MatchListViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MatchListViewHolder, position: Int) {
        //TODO MOVE ON FROM HERE
        //TODO HAVE A LOOK AT DIFF UTIL AND DELEGATION
    }

    class MatchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


}