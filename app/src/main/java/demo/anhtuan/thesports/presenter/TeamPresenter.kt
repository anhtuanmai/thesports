package demo.anhtuan.thesports.presenter

import demo.anhtuan.thesports.model.Team
import demo.anhtuan.thesports.model.TeamModel
import demo.anhtuan.thesports.view.TeamView

interface TeamPresenter {
    fun retrieveData(championshipName: String)
    fun onNewData(teams: List<Team>)
}

class TeamPresenterImp(val teamView: TeamView, val teamModel: TeamModel) : TeamPresenter {

    override fun retrieveData(championshipName: String) {
        teamModel.getData(championshipName, this)
    }

    override fun onNewData(teams: List<Team>) {
        teamView.updateView(teams)
    }
}