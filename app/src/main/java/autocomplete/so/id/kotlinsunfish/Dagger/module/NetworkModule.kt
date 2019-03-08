package autocomplete.so.id.kotlinsunfish.Dagger.module

import android.content.SharedPreferences
import autocomplete.so.id.kotlinsunfish.APIcLIENT.EndPoint
import autocomplete.so.id.kotlinsunfish.APIcLIENT.UrlIntreceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule (val baseUrl: String) {

    @Provides
    @Singleton
    fun httpClient(pref : SharedPreferences) : OkHttpClient{
        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(UrlIntreceptor(pref))
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.writeTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)
        return builder.build()
    }

    @Provides
    @Singleton
    fun retrofit(client: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun endPoint(retrofit: Retrofit): EndPoint {
        return retrofit.create(EndPoint::class.java)
    }
}