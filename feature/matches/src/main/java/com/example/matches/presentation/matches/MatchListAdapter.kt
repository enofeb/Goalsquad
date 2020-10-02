package com.example.matches.presentation.matches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.base.model.matches.Match
import com.example.matches.R
import kotlinx.android.synthetic.main.item_match_list.view.*

class MatchListAdapter : RecyclerView.Adapter<MatchListAdapter.MatchListViewHolder>() {

    private var items: MutableList<Match?> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_match_list, parent, false)
        return MatchListViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MatchListViewHolder, position: Int) {
        val match = items[position]
        holder.itemView.textViewHomeTeamName.text = match?.homeTeam?.name
        holder.itemView.textViewAwayTeamName.text = match?.awayTeam?.name
        holder.itemView.textViewHomeScore.text =
            match?.score?.fullTimeResult?.homeTeamFullScore.toString()
        holder.itemView.textViewAwayScore.text =
            match?.score?.fullTimeResult?.awayTeamFullScore.toString()

    }

    fun updateItems(items: MutableList<Match?>?) {
        items?.let {
            val diffCallback = DiffUtilCallback(this.items, items)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            this.items.clear()
            this.items.addAll(items)
            diffResult.dispatchUpdatesTo(this)
        }
    }

    class MatchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    class DiffUtilCallback(
        private val oldList: MutableList<Match?>,
        private val newList: MutableList<Match?>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition]?.id == newList[newItemPosition]?.id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]
    }


}