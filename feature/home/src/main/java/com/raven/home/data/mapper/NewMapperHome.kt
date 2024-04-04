package com.raven.home.data.mapper

import com.raven.home.data.remote.entities.NewItemResponse
import com.raven.home.domain.entities.NewItem

interface NewMapperHome {
    fun responseToDomainNew(response: List<NewItemResponse>) : List<NewItem>
}