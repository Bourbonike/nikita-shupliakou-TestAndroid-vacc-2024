package com.example.nikita_shupliakou_testandroid_vacc_2024.network

import com.example.nikita_shupliakou_testandroid_vacc_2024.network.services.StoreService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {
    @Provides
    fun provideRetrofitService(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
//            .baseUrl(BuildConfig.MOVIE_DB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original: Request = chain.request()

                val requestBuilder: Request.Builder = original.newBuilder()
//                    .header(
//                        "Authorization",
//                        "Bearer " + BuildConfig.MOVIE_DB_API_KEY
//                    )

                val request: Request = requestBuilder.build()
                chain.proceed(request)

            }.build()
    }

    @Provides
    fun provideApiInterface(retrofit: Retrofit): StoreService {
        return retrofit.create(StoreService::class.java)
    }

}