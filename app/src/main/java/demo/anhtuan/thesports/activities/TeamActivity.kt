package demo.anhtuan.thesports.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.KeyEvent
import android.view.View
import demo.anhtuan.thesports.R
import demo.anhtuan.thesports.adapter.TeamAdapter
import demo.anhtuan.thesports.listener.OnItemClickListener
import demo.anhtuan.thesports.model.Team
import demo.anhtuan.thesports.model.TeamModelImp
import demo.anhtuan.thesports.presenter.TeamPresenter
import demo.anhtuan.thesports.presenter.TeamPresenterImp
import demo.anhtuan.thesports.view.TeamView
import kotlinx.android.synthetic.main.activity_team.*


class TeamActivity : AppCompatActivity(), TeamView {

    lateinit var teamPresenter: TeamPresenter
    lateinit var recyclerView: RecyclerView
    var teamAdapter: TeamAdapter? = null
    var onItemClickListener = object : OnItemClickListener {
        override fun onItemClick(view: View) {
            launchPlayerActivity(teamAdapter?.getTeam(recyclerView.getChildAdapterPosition(view)))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        initRecyclerView()
        initListeners()

        teamPresenter = TeamPresenterImp(this, TeamModelImp())

        edtChampionshipName.setText("French Ligue 1") //TODO: please remove this on release version
    }

    //TeamView region starts
    override fun setChampionship(name: String) {
        teamPresenter.retrieveData(name)
    }

    override fun updateView(teams: List<Team>) {
        teamAdapter = TeamAdapter(teams, onItemClickListener)
        recyclerView.adapter = teamAdapter
    }
    //TeamView region ends

    fun initRecyclerView() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = TeamAdapter(arrayListOf(), onItemClickListener)
    }

    fun initListeners() {
        edtChampionshipName.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                setChampionship(edtChampionshipName.text.toString())
            }
            false
        })
        btnCancel.setOnClickListener(
                { v ->
                    clearResult()
                }
        )

    }

    fun clearResult() {
        recyclerView.adapter = TeamAdapter(arrayListOf(), onItemClickListener)
    }

    fun launchPlayerActivity(team: Team?) {
        team?.let {
            var intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("team_id", it.idTeam)
            intent.putExtra("team_name", it.strTeam)
            startActivity(intent)
        }
    }
}