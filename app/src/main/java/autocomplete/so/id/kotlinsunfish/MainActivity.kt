package autocomplete.so.id.kotlinsunfish

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import autocomplete.so.id.kotlinsunfish.Extention.clear
import autocomplete.so.id.kotlinsunfish.Extention.save
import autocomplete.so.id.kotlinsunfish.model.LOGIN.ResponseLoginSaas
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {


    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var  preferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.injectLogin(this)
        onAttach()
    }

    override fun onLoadPreLoginSuccess(data: ResponseLoginSaas) {

        Log.d("Log", "Harusnya kepanggil")
        Log.d("Log", data.dATA.gOPATH)
        preferences.save("GOPath", data.dATA.gOPATH)

    }

    override fun onLoadPreLoginError(data: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAttach() {
        preferences.clear()
        presenter.onAttach(this)
    }

    override fun onDetach() {
    }

}
