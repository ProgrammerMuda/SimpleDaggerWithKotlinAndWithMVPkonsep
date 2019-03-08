package autocomplete.so.id.kotlinsunfish.APIcLIENT

import android.content.SharedPreferences
import android.util.Log
import autocomplete.so.id.kotlinsunfish.Extention.get
import okhttp3.Interceptor
import okhttp3.Response

class UrlIntreceptor(val pref: SharedPreferences) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        Log.d("Log", "Masuk Intreceptor")
        Log.d("Log", pref.get("GOPath").toString())
        if (pref.get("GOPath") != null) {
            request = request.newBuilder()
                .url(pref.get("GOPath")!!)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build()
        }

        Log.d("Log", "Keluar Intereceptor")
        return  chain.proceed(request)


    }
}