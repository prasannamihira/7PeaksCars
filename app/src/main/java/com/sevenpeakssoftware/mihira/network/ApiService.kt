package com.sevenpeakssoftware.mihira.network

import com.sevenpeakssoftware.mihira.model.CarsResponseData
import com.sevenpeakssoftware.mihira.utils.Config
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    /**
     * fetch cars list
     */
    @Headers(Config.CONTENT_TYPE_JSON)
    @GET("article/get_articles_list")
    fun fetchCarsList(): Observable<CarsResponseData>
}