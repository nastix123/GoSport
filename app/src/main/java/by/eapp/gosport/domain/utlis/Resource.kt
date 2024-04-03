package by.eapp.gosport.domain.utlis

//typealias RootError = Error
//sealed interface Resource<out D, out E: RootError> {
//    data class Success<out D, out E: RootError>(val data: D) : Resource<D, E>
//    data class Error<out D, out E: RootError>(val error: E) : Resource<D, E>
//}

sealed class Resource<T>(
    val data: T? = null,
    val msg: String? = null
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(msg: String, data: T? = null) : Resource<T>(data, msg)

    class Loading<T>(data: T? = null) : Resource<T>(data)
}
