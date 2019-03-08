package autocomplete.so.id.kotlinsunfish

import android.annotation.SuppressLint
import android.app.Application
import autocomplete.so.id.kotlinsunfish.Dagger.Component.AppComponent
import autocomplete.so.id.kotlinsunfish.Dagger.Component.DaggerAppComponent
import autocomplete.so.id.kotlinsunfish.Dagger.module.AppModule
import autocomplete.so.id.kotlinsunfish.Dagger.module.NetworkModule
import dagger.Component

class App: Application() {

    companion object {
          lateinit var appComponent:  AppComponent
    }

    override fun onCreate() {
        super.onCreate()


        InitDi()
    }

    private fun InitDi(){
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule("https://saas.dataon.com"))
            .build()
    }
}