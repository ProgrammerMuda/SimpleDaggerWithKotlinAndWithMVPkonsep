package autocomplete.so.id.kotlinsunfish

import android.util.Log
import autocomplete.so.id.kotlinsunfish.APIcLIENT.EndPoint
import autocomplete.so.id.kotlinsunfish.Extention.errorConverter
import autocomplete.so.id.kotlinsunfish.MVP.Presenter
import autocomplete.so.id.kotlinsunfish.MVP.View
import autocomplete.so.id.kotlinsunfish.model.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import retrofit2.Retrofit
import javax.inject.Inject

class MainPresenter @Inject constructor(val retrofit: Retrofit, val api: EndPoint) : Presenter<MainView>{


    var prelogin = Disposables.empty()
    var view: MainView? = null

    override fun onAttach(view: MainView) {
        this.view = view
        loadPrelogin()
    }

    override fun onDetach() {
    }

    fun loadPrelogin(){
        prelogin.dispose()
        prelogin = api.preLogin(
            "GetAPIConfig",
            "9C1C5414B09EE2C0A7925C3FCC7CD25DBF54ECEDBB90BBFDA5C84F1F4CC660B95B6B3AFF2DFB05CC577B12A2ECD8072099BFF8D0CC7A0CAB3B985735",
            "{\"account\":\"885-dev\"}"
        )
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { res ->
                    Log.d("Log", res.toString())
                    view?.onLoadPreLoginSuccess(res)
                },
                { err ->
                    if (err is HttpException) {
                        val body = retrofit.errorConverter<Response>(err)
                        view?.onLoadPreLoginError("Error: ${body.message}")
                    } else {
                        view?.onLoadPreLoginError(err.localizedMessage)
                    }
                })
    }
}