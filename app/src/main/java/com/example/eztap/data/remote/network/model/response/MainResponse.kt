package com.example.eztap.data.remote.network.model.response

import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("logo-url") var logourl: String? = null,
    @SerializedName("heading-text") var headingtext: String? = null,
    @SerializedName("uidata") var uidata: ArrayList<Uidata> = arrayListOf()
)