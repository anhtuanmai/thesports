package demo.anhtuan.thesports.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import demo.anhtuan.thesports.R
import demo.anhtuan.thesports.adapter.PlayerAdapter
import demo.anhtuan.thesports.api.ApiClient
import demo.anhtuan.thesports.model.Player
import demo.anhtuan.thesports.model.PlayerWrapper
import kotlinx.android.synthetic.main.activity_player.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class PlayerActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        initRecyclerView()

        val teamId = intent.extras.getLong("team_id", -1)
        if (!teamId.equals(-1)) {
            txtTeamName.text = intent.extras.getString("team_name")
            listAllPlayers(teamId)
        } else {
            Timber.e("team_id not found!!")
            this.finish()
        }
    }

    fun updateView(players: List<Player>) {
        recyclerView.adapter = PlayerAdapter(players)
    }

    fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun listAllPlayers(teamId: Long) {
        ApiClient.getApiService().listAllPlayers(teamId).enqueue(object : Callback<PlayerWrapper> {
            override fun onResponse(call: Call<PlayerWrapper>?, response: Response<PlayerWrapper>?) {
                response?.body()?.player?.let {
                    updateView(it)
                }
            }

            override fun onFailure(call: Call<PlayerWrapper>?, t: Throwable?) {
                Timber.e(t)
            }
        })
    }
}
