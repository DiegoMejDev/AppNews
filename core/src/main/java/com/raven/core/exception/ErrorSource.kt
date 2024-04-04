package com.raven.core.exception

sealed class ErrorSource : Exception() {

    object Network : ErrorSource()

    object TimeOut : ErrorSource()

    data class ServiceError(
        val errorCode: Int,
        val messageError: String
    ) : ErrorSource()

    object Generic : ErrorSource()

}