package com.bins.domain.usecases

import com.bins.domain.entity.DataEntity
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlin.coroutines.CoroutineContext


abstract class BaseUseCase<T>(private val coroutineContext: CoroutineContext){

    //Provide you the data channel from the data layer
    abstract suspend fun getUserData(data: Map<String, Any>? = null): ReceiveChannel<DataEntity<T>>

    /**
     * @param data from the Data layer
     *
     * communication between domain layer and the presentation layer and any data manipulation
     *  before sending to the presentation layer.
     */
    abstract suspend fun sendToPresentation(data: DataEntity<T>): DataEntity<T>

}