package com.tiya.uas.model

import io.reactivex.Flowable

interface MatchEventView {

    fun getFootballMatch(id : String) : Flowable<MatchEventResponse>

    fun getTeams(id : String = "0") : Flowable<TeamsResponse>

    fun getUpcomingMatch(id : String) : Flowable<MatchEventResponse>

}