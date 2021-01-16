package com.tiya.uas.model

import com.google.gson.annotations.SerializedName

data class MatchEventResponse (
        @SerializedName("events") var events: List<MatchEvent>)
