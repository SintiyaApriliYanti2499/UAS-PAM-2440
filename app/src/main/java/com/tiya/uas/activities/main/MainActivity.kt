package com.tiya.uas.activities.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tiya.uas.api.TheSportDBApi
import com.tiya.uas.api.TheSportDBRest
import com.tiya.uas.adapter.TeamsAdapter
import com.tiya.uas.model.MatchEvent
import com.tiya.uas.model.MatchEventPresenter
import com.tiya.uas.R
import com.tiya.uas.R.id.lastMatch
import com.tiya.uas.R.id.nextMatch
import com.tiya.uas.utils.invisible
import com.tiya.uas.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger

class MainActivity : AppCompatActivity(), AnkoLogger, MainView.View {

    lateinit var mPresenter : MainPresenter

    private var matchLists : MutableList<MatchEvent> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = TheSportDBApi.getClient().create(TheSportDBRest::class.java)
        val request = MatchEventPresenter(service)
        mPresenter = MainPresenter(this, request)
        mPresenter.getFootballMatchData()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
              lastMatch -> {
                  mPresenter.getFootballMatchData()
                }
               nextMatch -> {

                   mPresenter.getFootballUpcomingData()
                }

            }
            true
        }
        bottom_navigation.selectedItemId = lastMatch

    }

    override fun hideLoading() {
        mainProgressBar.invisible()
    }

    override fun showLoading() {
        mainProgressBar.visible()
    }

    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = TeamsAdapter(matchList, applicationContext)
    }


}
