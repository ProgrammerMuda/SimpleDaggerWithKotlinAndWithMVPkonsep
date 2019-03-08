package autocomplete.so.id.kotlinsunfish.model.LOGIN

import com.google.gson.annotations.SerializedName

data class ResponseLoginSaas(
    @SerializedName("DATA")
    val dATA: DATA,
    @SerializedName("ERRMSG")
    val eRRMSG: String,
    @SerializedName("RESULT")
    val rESULT: Boolean
)

data class DATA(
@SerializedName("ACCOUNT")
val aCCOUNT: String,
@SerializedName("ACCOUNTNAME")
val aCCOUNTNAME: String,
@SerializedName("CUSTOM")
val cUSTOM: List<Any>,
@SerializedName("GOPATH")
val gOPATH: String,
@SerializedName("IST")
val iST: String,
@SerializedName("MODE")
val mODE: List<Any>,
@SerializedName("SFPATH")
val sFPATH: String
)