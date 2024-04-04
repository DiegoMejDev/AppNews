package com.raven.home.data.mapper

import com.raven.home.data.remote.entities.MediaResponse
import com.raven.home.data.remote.entities.NewItemResponse
import com.raven.home.domain.entities.Media
import com.raven.home.domain.entities.NewItem
import javax.inject.Inject

class NewMapperHomeImpl @Inject constructor() : NewMapperHome {
    override fun responseToDomainNew(response: List<NewItemResponse>) : List<NewItem> {
        val newsList = mutableListOf<NewItem>()

        response.forEach {
            newsList.add(
                NewItem(
                    it.abstract,
                    it.adx_keywords,
                    it.asset_id,
                    it.byline,
                    it.column,
                    it.des_facet,
                    it.eta_id,
                    it.geo_facet,
                    it.id,
                    mediaToDomain(it.media),
                    it.nytdsection,
                    it.org_facet,
                    it.per_facet,
                    it.published_date,
                    it.section,
                    it.source,
                    it.subsection,
                    it.title,
                    it.type,
                    it.updated,
                    it.uri,
                    it.url
                )
            )
        }

        return newsList
    }
    private fun mediaToDomain(response: List<MediaResponse>): List<Media> {
        val mediaList = mutableListOf<Media>()

        response.forEach {
            mediaList.add(
                Media(
                    it.approved_for_syndication,
                    it.caption,
                    it.copyright,
                    it.subtype,
                    it.type
                )
            )
        }

        return mediaList
    }
    }



