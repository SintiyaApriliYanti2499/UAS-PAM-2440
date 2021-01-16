package com.tiya.uas.api

import com.tiya.uas.model.MatchEventResponse
import com.tiya.uas.model.TeamsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface TheSportDBRest {

    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<TeamsResponse>
}