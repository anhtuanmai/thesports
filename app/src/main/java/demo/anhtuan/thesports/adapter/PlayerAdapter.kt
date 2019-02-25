package demo.anhtuan.thesports.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import demo.anhtuan.thesports.R
import demo.anhtuan.thesports.model.Player
import demo.anhtuan.thesports.viewholder.PlayerViewHolder


class PlayerAdapter(itemList: List<Player>) : RecyclerView.Adapter<PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_container, parent, false))
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.txtPlayerName.text = mDataList[position].strPlayer
        holder.txtPlayerBirth.text = mDataList[position].strPosition
        holder.txtPlayerPosition.text = mDataList[position].dateBorn
        holder.txtPlayerPrice.text = mDataList[position].strSigning
        mDataList[position].strCutout.let {
            Picasso.get().load(it).into(holder.imgPlayerImage)
        }
    }

    var mDataList: List<Player> = ArrayList<Player>()

    init {
        mDataList = itemList
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }
}