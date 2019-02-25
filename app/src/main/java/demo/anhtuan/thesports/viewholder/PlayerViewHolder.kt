package demo.anhtuan.thesports.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import demo.anhtuan.thesports.R


class PlayerViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imgPlayerImage: ImageView = itemView.findViewById(R.id.imgPlayerImage)
    val txtPlayerName: TextView = itemView.findViewById(R.id.txtPlayerName)
    val txtPlayerBirth: TextView = itemView.findViewById(R.id.txtPlayerBirth)
    val txtPlayerPosition: TextView = itemView.findViewById(R.id.txtPlayerPosition)
    val txtPlayerPrice: TextView = itemView.findViewById(R.id.txtPlayerPrice)
}