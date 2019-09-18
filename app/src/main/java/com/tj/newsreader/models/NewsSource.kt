package com.tj.newsreader.models

import com.squareup.moshi.Json

class NewsSource {

    //@Expose for Gson????
    //Expose is used to allow or disallow serialization and deserialization
    //optional if false field wont allow serialization
    @Json(name = "id")
    var id: String? = null
    @Json(name = "name")
    var name: String? = null


}
