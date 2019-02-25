package demo.anhtuan.thesports.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import demo.anhtuan.thesports.R
import demo.anhtuan.thesports.model.Team
import demo.anhtuan.thesports.viewholder.TeamViewHolder
import demo.anhtuan.thesports.listener.OnItemClickListener


class TeamAdapter(itemList: List<Team>, var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<TeamViewHolder>() {

    var mDataList: List<Team> = ArrayList<Team>()

    init {
        mDataList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.team_container, parent, false))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(onItemClickListener)
        holder.txtTeamName.text = mDataList[position].strTeam
        mDataList[position].strTeamBadge.let {
            Picasso.get().load(it).into(holder.imgTeamBadge)
        }
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    fun getTeam(position: Int?): Team? {
        if (position != null) {
            return mDataList.get(position)
        } else {
            return null
        }
    }
}