package demo.anhtuan.thesports.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    companion object {
        private val BASE_URL = "https://www.thesportsdb.com/api/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }

        fun getApiService(): ApiService {
            return getRetrofit().create(ApiService::class.java)
        }
    }
}