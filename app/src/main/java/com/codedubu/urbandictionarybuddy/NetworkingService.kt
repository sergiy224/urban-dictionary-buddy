package com.codedubu.urbandictionarybuddy

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkingService {

    // Instace of our API Service
    val apiService: APIService = Retrofit.Builder()
        .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(APIService::class.java)


    fun defineTerm(term: String): LiveData<List<Term>> {
        return object: LiveData<List<Term>>() {

            override fun onActive() {
                super.onActive()

                // IO is the background thread.
                CoroutineScope(Dispatchers.IO).launch {
                    val response = apiService.defineTerm(term)

                    // DispatchQueue.main.async
                    withContext(Dispatchers.Main) {
                        value = response.terms
                    }
                }
            }
        }
    }
}