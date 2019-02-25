package demo.anhtuan.thesports.view

import demo.anhtuan.thesports.model.Team


interface TeamView {
    fun updateView(teams: List<Team>)
    fun setChampionship(name: String)
}