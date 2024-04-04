package com.raven.core.exception

interface ErrorHandler {

    suspend fun getError(t : Throwable): ErrorSource
}