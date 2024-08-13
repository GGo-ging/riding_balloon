package com.example.riding_balloon.data.source.local

import com.example.riding_balloon.data.model.TravelSpotInfo

object TravelSpotManager {

    private val travelSpotList: List<TravelSpotInfo> = getDummyData()

    private fun getDummyData(): List<TravelSpotInfo> {
        return listOf(
            TravelSpotInfo(
                id = 1,
                thumbnailUrl = "https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg",
                country = "일본",
                region = "오사카",
                description = "오사카 여행은 먹거리, 볼거리, 즐길 거리가 가득한 매력적인 도시\n" +
                        " 오사카성, 도톤보리, 우메다 등 역사와 현대가 공존하는 다양한 관광 명소가 있습니다.  오사카 사람들은 친절하고 활기차서 여행객들에게 편안한 분위기를 제공합니다.",
                images = listOf(
                    "https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg",
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTN2TThACkDTMoOIl8Zvb5IdfGOY8laJ5Y6jSZj9AkoYsAnt4aVbuS8wYh-8rfN",
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSMXRkSoKvn34V2gCtolpWuJRoi-0wZkQ_4AuOZFFM9bt8BzsZy42Idd_LhnFOF"
                ),
                ranking = 1
            ),
        )
    }

    fun getListByCountry(): List<TravelSpotInfo> {
        // country 이름 순으로 정렬
        return travelSpotList.sortedBy { it.country }
    }

    fun getListByRanking(): List<TravelSpotInfo> {
        // ranking 10위까지만 가져와서 정렬
        return travelSpotList.filter { it.ranking > 0 }.sortedBy { it.ranking }
    }
}