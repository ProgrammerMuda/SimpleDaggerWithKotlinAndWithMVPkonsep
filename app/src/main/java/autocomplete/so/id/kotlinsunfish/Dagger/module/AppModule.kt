package autocomplete.so.id.kotlinsunfish.Dagger.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import autocomplete.so.id.kotlinsunfish.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun application() : Application = app

    @Provides
    @Singleton
    fun context(): Context = app.applicationContext

    @Provides
    @Singleton
    fun sharedPreferences(app: Application) : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

}