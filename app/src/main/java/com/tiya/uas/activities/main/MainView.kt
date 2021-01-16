package com.tiya.uas.activities.main

import com.tiya.uas.model.MatchEvent

interface MainView {

    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<MatchEvent>)
    }

    interface Presenter{
        fun getFootballMatchData()

        fun getFootballUpcomingData()
    }

}