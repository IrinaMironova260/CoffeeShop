package com.example.coffeeshop.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OrderApiModel (
    @SerializedName("id") @Expose
    var id: Int? = null,

    @SerializedName("name") @Expose
    var name: String? = null,

    @SerializedName("phone") @Expose
    var phone: String? = null,

    @SerializedName("description") @Expose
    var description: String? = null,

    @SerializedName("priceOrder") @Expose
    var priceOrder: String? = null
)