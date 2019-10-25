package pl.ukaszapps.curricullumvitae.view.model

sealed class ResultState<T>
class  Loading<T> : ResultState<T>()
data class Error<T>(val errorMessage: String): ResultState<T>()
data class Value<T>(val value: T): ResultState<T>()