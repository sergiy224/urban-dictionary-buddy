package com.codedubu.urbandictionarybuddy

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {

    // URL Endpoint: https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=wat
    // Headers: x-rapidapi-host": "mashape-community-urban-dictionary.p.rapidapi.com
    //	        x-rapidapi-key": "c84cb0b274mshac4d80fdb9d49bdp1b365fjsn41d0883d812f


    // This function will be suspended until needed.
    // @escaping                        -> DefineTermResponse
    @Headers(
        "x-rapidapi-host: mashape-community-urban-dictionary.p.rapidapi.com",
        "x-rapidapi-key: c84cb0b274mshac4d80fdb9d49bdp1b365fjsn41d0883d812f"
    )

    @GET("define")
    suspend fun defineTerm(
        @Query("term")
        term: String
    ): DefineTermResponse
}