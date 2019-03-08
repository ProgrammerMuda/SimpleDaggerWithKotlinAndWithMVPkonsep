package autocomplete.so.id.kotlinsunfish.Dagger.Component

import autocomplete.so.id.kotlinsunfish.Dagger.module.AppModule
import autocomplete.so.id.kotlinsunfish.Dagger.module.NetworkModule
import autocomplete.so.id.kotlinsunfish.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun injectLogin(activity: MainActivity)

}