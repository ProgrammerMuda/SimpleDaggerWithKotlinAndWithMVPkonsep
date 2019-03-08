package autocomplete.so.id.kotlinsunfish.APIcLIENT

import autocomplete.so.id.kotlinsunfish.model.LOGIN.ResponseLoginSaas
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoint {

 @GET("/sf6svc/SFCSunFish.cfm")
 fun preLogin(
  @Query("PROVIDER") PROVIDER: String,
  @Query("STRAUTHKEY") STRAUTHKEY: String,
  @Query("parameter") parameter: String
 ): Observable<ResponseLoginSaas>
}