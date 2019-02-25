package demo.anhtuan.thesports.model

import demo.anhtuan.thesports.api.ApiClient
import demo.anhtuan.thesports.presenter.TeamPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

interface TeamModel {
    fun getData(championshipName: String, teamPresenter: TeamPresenter)
}

class TeamModelImp : TeamModel {

    override fun getData(championshipName: String, teamPresenter: TeamPresenter) {
        ApiClient.getApiService().listAllTeams(championshipName).enqueue(object : Callback<TeamWrapper> {
            override fun onResponse(call: Call<TeamWrapper>?, response: Response<TeamWrapper>?) {
                response?.body()?.teams?.let {
                    teamPresenter.onNewData(it)
                }
            }

            override fun onFailure(call: Call<TeamWrapper>?, t: Throwable?) {
                Timber.e(t)
            }
        })
    }
}
