package com.hanchang97.starbucks.common


sealed class ApiState<out T> (val _data: T?, val message: String?) {

    data class Success<out R>(val data : R) : ApiState<R>(
        _data = data,
        message = null
    )
    data class Error(val exception: String?) : ApiState<Nothing>(
        _data = null,
        message = exception
    )
    object Loading: ApiState<Nothing>(
        _data = null,
        message = null
    )
    object Empty: ApiState<Nothing>(
        _data = null,
        message = null
    )
}
