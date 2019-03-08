package autocomplete.so.id.kotlinsunfish.MVP

interface Presenter<T: View> {
    fun onAttach(view: T)
    fun onDetach()
}