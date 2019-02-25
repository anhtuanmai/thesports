package demo.anhtuan.thesports.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import demo.anhtuan.thesports.R
import demo.anhtuan.thesports.listener.OnItemClickListener


class TeamViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    val txtTeamName: TextView = itemView.findViewById(R.id.txtTeamName)
    val imgTeamBadge: ImageView = itemView.findViewById(R.id.imgIcon)

    fun bind(onItemClickListener: OnItemClickListener) {
        itemView.setOnClickListener( {v -> onItemClickListener.onItemClick(itemView)} )
    }
}