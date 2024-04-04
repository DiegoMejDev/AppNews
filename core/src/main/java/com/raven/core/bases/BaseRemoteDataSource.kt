package com.raven.core.bases
import com.raven.core.exception.ErrorHandler
import com.raven.core.exception.ErrorSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

abstract class BaseRemoteDataSource : ErrorHandler{

    protected suspend fun <Out> getResult(
        call: suspend () -> Out
    ) : Flow<Out> = flow {
        try{
            emit(call())

        } catch (e : Exception) {
            val error = getError(e)
            throw error

        }
    }

    override suspend fun getError(t: Throwable): ErrorSource = when(t){
        is HttpException -> {
            val errorBodyResponse = t.response()?.errorBody()?.string() ?: ""
            //This is a Mock of a possible error
            ErrorSource.ServiceError(400,"Something is wrong")

        }
        is IOException -> {
            when(t){
                is SocketTimeoutException -> ErrorSource.TimeOut
                else -> ErrorSource.Generic
            }
        }
        else -> ErrorSource.Generic
    }
}