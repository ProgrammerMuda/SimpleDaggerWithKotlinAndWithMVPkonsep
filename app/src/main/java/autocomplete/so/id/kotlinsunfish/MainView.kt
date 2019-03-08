package autocomplete.so.id.kotlinsunfish

import autocomplete.so.id.kotlinsunfish.MVP.View
import autocomplete.so.id.kotlinsunfish.model.LOGIN.ResponseLoginSaas

interface MainView : View {

    fun onLoadPreLoginSuccess(data: ResponseLoginSaas)
    fun onLoadPreLoginError(data: String)
}