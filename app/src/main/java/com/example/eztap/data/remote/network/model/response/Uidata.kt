package com.example.eztap.data.remote.network.model.response

import com.google.gson.annotations.SerializedName

data class Uidata(
    @SerializedName("uitype") var uitype: String? = null,
    @SerializedName("value") var value: String? = null,
    @SerializedName("key") var key: String? = null

)
