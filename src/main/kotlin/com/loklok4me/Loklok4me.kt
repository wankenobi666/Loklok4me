package com.loklok4me

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class Loklok4me : MainAPI() {
    override var mainUrl = "https://www.loklok.com"
    override var name = "Loklok4me"
    override val hasMainPage = true
    override val hasQuickSearch = true
    override val hasDownloadSupport = true

    override val supportedTypes = setOf(
        TvType.Movie,
        TvType.TvSeries,
        TvType.Anime
    )

    override suspend fun getMainPage(): HomePageResponse {
        val home = listOf(
            MovieSearchResponse(
                "Example Movie",
                "https://www.loklok.com/movie/example",
                this.name,
                TvType.Movie,
                "https://via.placeholder.com/150"
            )
        )
        return HomePageResponse(listOf(HomePageList("Popular", home)))
    }

    override suspend fun search(query: String): List<SearchResponse> {
        return listOf(
            MovieSearchResponse(
                "Search Result for $query",
                "$mainUrl/search?q=$query",
                this.name,
                TvType.Movie,
                "https://via.placeholder.com/150"
            )
        )
    }

    override suspend fun load(url: String): LoadResponse {
        return MovieLoadResponse(
            "Sample Movie",
            url,
            this.name,
            TvType.Movie,
            url,
            "Overview text here",
            null,
            null
        )
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        callback.invoke(
            ExtractorLink(
                name,
                "Loklok4me",
                "https://example.com/video.mp4",
                referer = mainUrl,
                quality = Qualities.P1080.value
            )
        )
    }
}