package demo.anhtuan.thesports.api

import demo.anhtuan.thesports.model.PlayerWrapper
import demo.anhtuan.thesports.model.TeamWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("v1/json/1/search_all_teams.php")
    fun listAllTeams(@Query("l") championshipName: String): Call<TeamWrapper>

    @GET("v1/json/1/lookup_all_players.php")
    fun listAllPlayers(@Query("id") teamId: Long): Call<PlayerWrapper>
}