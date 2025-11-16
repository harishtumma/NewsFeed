package com.example.newsfeed.network.dao.headlindao

import com.google.gson.annotations.SerializedName

data class Source(@SerializedName("name")
                  val name: String = "",
                  @SerializedName("id")
                  val id: String = "")