package com.example.riding_balloon.data.source.local

import com.example.riding_balloon.data.model.TravelSpotInfo

object TravelSpotManager {

    private val travelSpotList: List<TravelSpotInfo> = getDummyData()

    fun getTravelSpots(): List<TravelSpotInfo> {
        return travelSpotList
    }

    private fun getDummyData(): List<TravelSpotInfo> {
        return listOf(
            TravelSpotInfo(
                id = 1,
                thumbnailUrl = "https://d28dpoj42hxr8c.cloudfront.net/files/topics/9586_ext_14_ko_0.jpg?v=1449751963",
                country = "일본",
                region = "오사카",
                description = "오사카 여행은 먹거리, 볼거리, 즐길 거리가 가득한 매력적인 도시.\n" + "오사카성, 도톤보리, 우메다 등 역사와 현대가 공존하는 다양한 관광 명소가 있습니다. 오사카 사람들은 친절하고 활기차서 여행객들에게 편안한 분위기를 제공합니다.",
                images = listOf(
                    "https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg",
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTN2TThACkDTMoOIl8Zvb5IdfGOY8laJ5Y6jSZj9AkoYsAnt4aVbuS8wYh-8rfN",
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSMXRkSoKvn34V2gCtolpWuJRoi-0wZkQ_4AuOZFFM9bt8BzsZy42Idd_LhnFOF"
                ),
                ranking = 1
            ),
            TravelSpotInfo(
                id = 2,
                thumbnailUrl = "https://www.koreatimes.net/images/attach/PSHW4OZG564MAVI-2017042813045131/20170428-13042069.jpg",
                country = "일본",
                region = "도쿄",
                description = "**일본의 수도이자 세계적인 도시, 도쿄!**\n" + " 현대적인 고층빌딩과 전통적인 사원이 조화롭게 어우러진 매력적인 도시입니다. 전통문화와 현대문화가 공존하는 도시에서 다양한 문화와 일본 전통 음식부터 세계 각국의 음식까지 다양하게 즐길 수 있습니다.",
                images = listOf(
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQHh4mJMReRMqAVk_nNuEaMILlSMDu3guJSsTgRga-2tC2YE41J8X85HRn_7tBQ",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMbxVOk__Qh1gSAgtp1XB9rPOg3J7s82lZhOKtY4BF9VK4mFYrMnIrdYiR6t-T",
                    "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSSiRr64gDONbJO42EbAHBDWHGl7s5hLufVFD2csxMVa1x4v2ZnUrqSReGn2-hy"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 3,
                thumbnailUrl = "https://www.koreatimes.net/images/attach/PSHW4OZG564MAVI-2017042813045131/20170428-13042069.jpg",
                country = "일본",
                region = "삿포로",
                description = "**눈과 얼음의 도시, 겨울왕국의 매력을 느껴보세요!** \n" + "일본 홋카이도의 중심 도시 삿포로는 겨울 스포츠의 천국으로 알려져 있지만, 사계절 내내 다양한 매력을 품고 있는 도시입니다.",
                images = listOf(
                    "https://www.koreatimes.net/images/attach/PSHW4OZG564MAVI-2017042813045131/20170428-13042069.jpg",
                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ3Ape1JqyPij9iJzmFu1sjZ_LyYtDVCafTutxYybNSgznb50KeXenxmJq1giwy",
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTIdG-1AyktsnSnz1LxRRImuCSE0NMCRS1mMq4NpjgMLjUjQE_N-X7EYhFX116P"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 4,
                thumbnailUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTD0rBC0PqRR0_uXFDDtQCID_jBT5rajSIT7nlKe0zj4mKTyHv56M5x8kKhzIwV",
                country = "중국",
                region = "베이징",
                description = "역사와 현대가 공존하는 매력적인 도시, 베이징! \n" + "자금성, 만리장성 등 유네스코 세계문화유산을 비롯해 다양한 역사 유적지를 방문하여 중국의 역사와 문화를 체험할 수 있습니다.",
                images = listOf(
                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTD0rBC0PqRR0_uXFDDtQCID_jBT5rajSIT7nlKe0zj4mKTyHv56M5x8kKhzIwV",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsaV6uxtUTbGXDe_W10uXf4WJ6gP6M7LH4h7FmAqYK3nzjto42Umma4SYbBhI5",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThB1iyJ9QBBbM4kGAkHxoAaIW7tkr49g2L8loi0Qy0UUDWRyxoYmGCfLhp_vez"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 5,
                thumbnailUrl = "https://i.namu.wiki/i/6ncBHFTm35s4CVBf3Nvy7FlfzuJddHejvX-cCxkM7wI8ohjmQFUuTpYAZh05EZQ5adQ4raoVwF12NqhG3DQttgaAS7h8ENsUDhfif5ixmW55FvJRtuID5By3i978WEY86cqaDS__DU1pBfSHQ46Nuw.webp",
                country = "중국",
                region = "상하이",
                description = "**상하이, 동양의 파리를 만나다!** \n" + "동양의 파리라 불리는 상하이는 과거와 현재가 공존하는 매력적인 도시입니다. 화려한 야경과 현대적인 건축물, 그리고 전통적인 중국 문화까지 다채로운 모습을 갖추고 있어 많은 여행객들을 매료시키고 있습니다.",
                images = listOf(
                    "https://i.namu.wiki/i/6ncBHFTm35s4CVBf3Nvy7FlfzuJddHejvX-cCxkM7wI8ohjmQFUuTpYAZh05EZQ5adQ4raoVwF12NqhG3DQttgaAS7h8ENsUDhfif5ixmW55FvJRtuID5By3i978WEY86cqaDS__DU1pBfSHQ46Nuw.webp",
                    "https://i.namu.wiki/i/EYqLAuw-3lteWu8bZ4Vc_6KeyLWu3rhQHKsRDaBcz2fPWUpSgkil3Ve0Lvxh8KY-NZO7dx63annZubNPVNDI-UsVzRSVxqgvNQyNOG3mx8HxQOlnDgz4Im6UMFcosWYxd4CS9B0DOgzm1zN0z6Fc2g.webp",
                    "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcS4eLWJlinESq3lrarEgv5IMcmMA4egTSNW6KBEwZH2OGQ4fqq313FC_xO5nwZv"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 6,
                thumbnailUrl = "https://d1rcr366f28p93.cloudfront.net/wp-content/uploads/2018/04/%EA%B8%80%EB%A1%9C%EB%B2%8C%EC%9D%B8%EC%82%AC%EC%9D%B4%ED%8A%B8%EC%8D%B8%EB%84%A4%EC%9D%BC.jpg",
                country = "베트남",
                region = "하노이",
                description = "베트남의 심장, 하노이를 소개합니다!\n"+"베트남의 수도, 하노이는 천년의 역사를 가진 도시로서 오랜 시간 동안 베트남의 정치, 경제, 문화의 중심지 역할을 해왔습니다. 프랑스 식민지 시대의 건축물과 전통적인 베트남 건축물이 조화롭게 어우러져 독특한 매력을 자랑합니다.",
                images = listOf(
                    "https://i.namu.wiki/i/7f-OowTH4eRHCA_BwSLFSnoe28XHpbp5M2Nxg45WLeuDa8UX_B9Smm9vjjKSSG4rujcDCBVvInb2NprTDAkcacDepk_DS40sYIPpGrp7kPuQosVcmX7hNILv_9RbhODBiCguUTqzeus9vtnTde39-A.webp",
                    "https://i.namu.wiki/i/EPpd6a_Ww0TnDmzUGnfwQj2kNBvcb2n4jNpdR-oeE670fgHPwWvKtuPBPCtw1i5mm9YKETfHDiCYpDfUjzxGAS6TnS4-oJtHWjn6hATbpYUMegiE1z1yPVgVOnmoQ5YqfRRa_fplqsQnSz6Ks7HmJQ.webp",
                    "https://i.namu.wiki/i/JK953CLxojz_xXCrhMbYXWsCZBTmyG2SGmI0BIGnIYt95YGhNVaA1fsGPi2rosMp0bDh7_0TOdqdyZ216NoCn0k90M8UzktcRvFPaanPhKfFgOYfCMm_hH7Y_TT_ylNC_2Roe0e5sOBiqYMPckd-xA.webp"
                ),
                ranking = 2
            ),
            TravelSpotInfo(
                id = 7,
                thumbnailUrl = "https://search.pstatic.net/common?src=https://dbscthumb-phinf.pstatic.net/5885_000_3/20200818104640792_XCDX844N8.jpg/fb112_3_i1.jpg?type=w540_fst&type=m1500_travelsearch",
                country = "베트남",
                region = "호치민",
                description = "동남아시아의 떠오르는 별, 호치민!\n"+"과거 사이공이라고 불렸던 호치민은 베트남의 경제 중심지이자 역동적인 도시입니다. 프랑스 식민지 시대의 건축물과 현대적인 고층 빌딩이 조화롭게 어우러져 독특한 매력을 자랑하며, 저렴한 물가와 친절한 사람들로 여행객들에게 인기가 높습니다.",
                images = listOf(
                    "https://search.pstatic.net/common?src=https://dbscthumb-phinf.pstatic.net/5885_000_3/20200818104640792_XCDX844N8.jpg/fb112_3_i1.jpg?type=w540_fst&type=m1500_travelsearch",
                    "https://search.pstatic.net/common?src=https%3A%2F%2Fdbscthumb-phinf.pstatic.net%2F5885_000_3%2F20200818104649989_VEGDN6FTL.jpg%2Ffb112_3_i2.jpg%3Ftype%3Dw540_fst&type=m1500_travelsearch",
                    "https://search.pstatic.net/common?src=https://dbscthumb-phinf.pstatic.net/5885_000_3/20200818105943270_I9WYBCB76.jpg/fb112_45_i2.jpg?type=w540_fst&type=w800_travelsearch"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 8,
                thumbnailUrl = "https://image.kkday.com/v2/image/get/w_960,c_fit,q_55,t_webp/s1.kkday.com/product_116129/20210226052301_E4loz/jpg",
                country = "말레이시아",
                region = "다양한 지역",
                description = "말레이시아는 다양한 문화와 아름다운 자연이 조화롭게 어우러진 매력적인 여행지입니다. 이슬람 문화와 중국, 인도 문화가 융합되어 독특한 음식과 풍습을 경험할 수 있으며, 피나투보 화산, 코타키나발루 해변 등 다채로운 자연 경관을 만끽할 수 있습니다.",
                images = listOf(
                    "https://image.kkday.com/v2/image/get/w_960,c_fit,q_55,t_webp/s1.kkday.com/product_116129/20210226052301_E4loz/jpg",
                    "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/532000/532651-kota-kinabalu.jpg",
                    "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/44000/44008-Melaka-Historical-City.jpg"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 9,
                thumbnailUrl = "https://res.klook.com/image/upload/Mobile/City/olvu6sgb3dcdjwlcpts3.jpg",
                country = "인도네시아",
                region = "다양한 지역",
                description = "인도네시아는 수많은 섬으로 이루어진 열대의 천국입니다. 세계에서 가장 큰 군도 국가로, 다양한 문화와 아름다운 자연을 동시에 경험할 수 있는 매력적인 여행지입니다.",
                images = listOf(
                    "https://res.klook.com/image/upload/Mobile/City/olvu6sgb3dcdjwlcpts3.jpg",
                    "https://ak-d.tripcdn.com/images/0350m12000bxp23v82270_C_1136_640_Q10.jpg",
                    "https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/13f9/image/xGgWcacouds-uEcAtggX0XyLuXs.jpg"
                ),
                ranking = 8
            ),
            TravelSpotInfo(
                id = 10,
                thumbnailUrl = "https://www.befreetour.com/img/produk/yehliu-geological-park-admission-ticket/yehliu-geological-park-admission-ticket_3e9bdd8ffe2f7a8587e1e6df7c6e1d3f7e774b98.jpg",
                country = "대만",
                region = "타이베이",
                description = "대만은 아름다운 자연과 독특한 문화가 어우러진 매력적인 섬나라입니다. 예류 지질공원과 타이루거 협곡 같은 아름다운 자연을 비롯해 밤시장과 온천 등 다양한 즐길 거리가 있어 잊지 못할 여행을 선사합니다.",
                images = listOf(
                    "https://www.befreetour.com/img/produk/yehliu-geological-park-admission-ticket/yehliu-geological-park-admission-ticket_3e9bdd8ffe2f7a8587e1e6df7c6e1d3f7e774b98.jpg",
                    "https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/06def5bd-1d92-40f2-a9c2-1965f02797ed.jpeg",
                    "https://mblogthumb-phinf.pstatic.net/20161021_45/suni2park_1476994150025NCJxK_JPEG/%B4%EB%B8%B81.01.jpg?type=w800"
                ),
                ranking = 6
            ),
            TravelSpotInfo(
                id = 11,
                thumbnailUrl = "https://cdn.autotribune.co.kr/news/photo/202402/13815_65357_2510.png",
                country = "홍콩",
                region = "다양한 지역",
                description = "동서양이 조화롭게 어우러진 매력적인 도시, 홍콩 여행을 떠나보세요! 동양과 서양의 문화가 융합된 독특한 매력을 가진 홍콩은 쇼핑, 미식, 야경 등 다양한 즐길 거리를 제공합니다.",
                images = listOf(
                    "https://cdn.autotribune.co.kr/news/photo/202402/13815_65357_2510.png",
                    "https://tourimage.interpark.com/BBS/Tour/FckUpload/201702/6362174230293976690.jpg",
                    "https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/6b9c2427-b62f-457c-9155-5ca9c117ca03.jpeg"
                ),
                ranking = 10
            ),
            TravelSpotInfo(
                id = 12,
                thumbnailUrl = "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/oeE/image/iJ0QcJNYu9ndZ86tDH1tPRhbOQY",
                country = "태국",
                region = "다양한 지역",
                description = "태국 여행, 꿈결 같은 아름다움을 경험하세요! 신비로운 사원, 아름다운 해변, 맛있는 음식까지, 태국은 다양한 매력을 품고 있는 매력적인 여행지입니다.",
                images = listOf(
                    "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/oeE/image/iJ0QcJNYu9ndZ86tDH1tPRhbOQY",
                    "https://i2.wp.com/www.agoda.com/wp-content/uploads/2019/10/Asiatique-the-Riverfront-Bangkok-tourist-spots.jpg?ssl=1",
                    "https://www.dailypop.kr/news/photo/201908/40732_76131_1053.jpg"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 13,
                thumbnailUrl = "https://i.namu.wiki/i/I6UbW_JgtFLUAGL80DJZ_SiWHL6_xQLxKu562lVFeG11gk4mPm5PcR-1zVKxrdRIkdIMwMwqV6DJH60cxGqLPrg7xmANmNEpsW02NhxPxjOWM3iRfU8wW29NA8F6m5YD3DFLAQ-c-B2vNXD_Jfx1iA.webp",
                country = "튀르키예",
                region = "이스탄불, 카파도키아, 안탈리아",
                description = "이스탄불의 블루 모스크와 그랜드 바자르에서 동서양의 문화를 느끼고, 카파도키아의 기암 지대와 열기구 투어로 독특한 자연 경관을 즐길 수 있습니다. 해안가의 아름다운 리조트 지역인 안탈리아와 전통적인 터키 요리도 빼놓을 수 없습니다.",
                images = listOf(
                    "https://i.namu.wiki/i/I6UbW_JgtFLUAGL80DJZ_SiWHL6_xQLxKu562lVFeG11gk4mPm5PcR-1zVKxrdRIkdIMwMwqV6DJH60cxGqLPrg7xmANmNEpsW02NhxPxjOWM3iRfU8wW29NA8F6m5YD3DFLAQ-c-B2vNXD_Jfx1iA.webp",
                    "https://i.namu.wiki/i/BFRx2IpfxZLMWh1Cw51vTSNUthJ3uM-QosQ-oFNBsZpZQHjIsy6MyOplsEpjpWJlVicgkPeL9Ou1JOhsPGcQeA.webp",
                    "https://i.namu.wiki/i/4-WC3SEQ6E1msNvD81GVw_o35d3mz1SgQndYpPSmLsis8xdYvl_Tx2MGmWUixy6bsIzDm1rPOcIscIdme_20yg.webp"
                ),
                ranking = 9
            ),
            TravelSpotInfo(
                id = 14,
                thumbnailUrl = "https://www.kkday.com/ko/blog/wp-content/uploads/1.-에펠탑wp.jpg",
                country = "프랑스",
                region = "파리, 프로방스, 니스",
                description = "프랑스는 낭만적인 파리의 에펠탑과 루브르 박물관, 고풍스러운 남부의 프로방스와 니스 해변으로 유명합니다. 맛있는 크루아상과 와인, 다채로운 미술과 역사 유적이 가득해 매력적입니다. 모든 계절에 방문하기 좋은 프랑스에서 잊지 못할 추억을 만들어보세요!",
                images = listOf(
                    "https://www.kkday.com/ko/blog/wp-content/uploads/1.-에펠탑wp.jpg",
                    "https://www.kkday.com/ko/blog/wp-content/uploads/2.-루브르-박물관wp.jpg",
                    "https://www.kkday.com/ko/blog/wp-content/uploads/3.-베라사유-궁전wp.jpg"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 15,
                thumbnailUrl = "https://i.namu.wiki/i/VN2oJShm702l1NDHNCjf5ny2Pb6-8nSQc78WEHTS0Z5W97lGLJVYFrThLobCyhCzI4EZitV92qcpnMaO0YL2G4024pbiYjiv-ZYkxRO0PwS1h--W4SIfJmZqghhlVqMGR-4AUm7C2djcq8j0XPhbzQ.webp",
                country = "오스트리아",
                region = "빈, 잘츠부르크, 알프스",
                description = "빈에서 클래식 음악의 황홀함을 느끼고, 잘츠부르크에서 모차르트의 발자취를 따라가며, 알프스 산맥의 스키 리조트와 아름다운 자연 경관을 만끽할 수 있습니다. 또, 비엔나의 궁전들과 카페 문화도 오스트리아만의 매력입니다.",
                images = listOf(
                    "https://i.namu.wiki/i/VN2oJShm702l1NDHNCjf5ny2Pb6-8nSQc78WEHTS0Z5W97lGLJVYFrThLobCyhCzI4EZitV92qcpnMaO0YL2G4024pbiYjiv-ZYkxRO0PwS1h--W4SIfJmZqghhlVqMGR-4AUm7C2djcq8j0XPhbzQ.webp",
                    "https://i.namu.wiki/i/9aFQFr4VetOvmef0FGGysqmSFBt2Xua3uORvPagZdkhjMsKljkd0C1OWZnRK49C8YCMQz7pCW47Avg6nOPb_x732IKuZrCtnz3fqr-wR1gbsYVMCuzWXhiXCxDxTDX0eSb-m3qWDD2SK1YtKmPOMnw.webp",
                    "https://i.namu.wiki/i/r1P7ba3qNxUPDqQg8TLuTBOfvtEJuLYaasCZ-Avku8kzNuQ9rJw2H4yBka0YsoqVxIvFuoT4_gSaaOOk3oNk95T27PMcoUKaQymDtPBqbfrf8rYj2_SiPuQULl1hVVhgx9foA8KBfUlP3pRR5Wr3TA.webp"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 16,
                thumbnailUrl = "https://i.namu.wiki/i/eg8a3zFdxzEN3Xl5x7LLvav5OZR3uyVyqIjpx2KyjWtIZ-VDKBM_WtZQlT9w2ZOJgGUEGpCqxfmW3z7FQvR-beZlndErGgxQGq2otF0N7CQ0cpCcugDx6z7PmZ4vgeE72E1v44OI2EdUzT2zll22iQ.webp",
                country = "영국",
                region = "런던, 옥스퍼드, 케임브리지, 스코틀랜드 고원",
                description = "런던의 버킹엄 궁전과 타워 브리지, 빅벤 등 세계적으로 유명한 랜드마크를 탐방하고, 고풍스러운 도시인 옥스퍼드와 케임브리지에서 영국의 학문적 전통을 느껴보세요. 스코틀랜드의 고원지대와 잉글랜드의 전원 풍경도 영국 여행의 백미입니다.",
                images = listOf(
                    "https://i.namu.wiki/i/eg8a3zFdxzEN3Xl5x7LLvav5OZR3uyVyqIjpx2KyjWtIZ-VDKBM_WtZQlT9w2ZOJgGUEGpCqxfmW3z7FQvR-beZlndErGgxQGq2otF0N7CQ0cpCcugDx6z7PmZ4vgeE72E1v44OI2EdUzT2zll22iQ.webp",
                    "https://i.namu.wiki/i/IIqVmg9mm8tObGZ5SQwjktJukCmfI1prM-A5X58UkdJm8YR-8fBdaA37Abd6J4u_SvS7F2Qn3EAQz037cd3SsQ.webp",
                    "https://d2ur7st6jjikze.cloudfront.net/offer_photos/59912/368961_large_1559725487.jpg?1559725487"
                ),
                ranking = 0
            ),

            TravelSpotInfo(
                id = 17,
                thumbnailUrl = "https://d3b39vpyptsv01.cloudfront.net/photo/1/2/17f552dbb8d76670480cd3ec5e9ac0c2.jpg",
                country = "이탈리아",
                region = "로마, 피렌체, 베네치아, 나폴리",
                description = "로마의 콜로세움과 바티칸 시국의 성 베드로 대성당을 방문하며 역사의 깊이를 체감하고, 피렌체의 르네상스 예술 작품들과 베네치아의 운하에서 이탈리아의 문화적 유산을 만끽하세요. 또한, 나폴리에서 정통 이탈리아 피자를 맛보며 미식의 즐거움도 놓치지 마세요.",
                images = listOf(
                    "https://d3b39vpyptsv01.cloudfront.net/photo/1/2/17f552dbb8d76670480cd3ec5e9ac0c2.jpg",
                    "https://i.namu.wiki/i/lI83jn5gj17g3OSAw5Rd40APO5pRIEBdOPUWjGWKGz-smrWqBMo74_VK33RkJUj6qsdxqJUE77Jb_8SSfFSzfQ.webp",
                    "https://i.namu.wiki/i/hlqCWoDArbKp1cGRMKttlQv56q3iUC-SsKdgTNN3BATSKqHsDdq1AsCYuPP1_atbPvsnzqUc3qGMATAWENIQsg.webp"
                ),
                ranking = 0
            ),

            TravelSpotInfo(
                id = 18,
                thumbnailUrl = "https://image.yes24.com/images/chyes24/d/2/5/e/d25e4abe1330dc481dc0343ba0477c58.jpg",
                country = "독일",
                region = "베를린, 바이에른",
                description = "베를린의 이스트사이드 갤러리와 홀로코스트 추모비에서 현대사의 중요한 순간들을 돌아보고, 바이에른 주의 노이슈반슈타인 성에서 동화 같은 풍경을 경험하세요. 맥주 축제인 옥토버페스트와 함께 독일의 풍부한 전통과 문화를 체험하는 것도 필수입니다.",
                images = listOf(
                    "https://image.yes24.com/images/chyes24/d/2/5/e/d25e4abe1330dc481dc0343ba0477c58.jpg",
                    "https://t1.daumcdn.net/cfile/tistory/251001495444A83B0C",
                    "https://i.namu.wiki/i/iwIPohOW5CIQsJj2zlHUgnPMezczRe4aLQkdeRNjbDZlxUR1k6weSUvLGtGhZI0ytf-52mbxUQJvK6WLuuuihyfE3qqY1okoiThi5OLd97E9kAxbfIraG3tdSp1ii6-t0nL1bnVcccHYU4bf8BzGhQ.webp"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 19,
                thumbnailUrl = "https://i.namu.wiki/i/eRAYSGmIiQ9BH4iMcf0U07tcO6Reb4fcFj-GUkDEfDRFWUFhPRTkcFJzhx93CT5AIIU47HcZEMtGuI0IkAcytg.webp",
                country = "그리스",
                region = "아테네, 산토리니, 크레타",
                description = "아테네의 파르테논 신전에서 고대 그리스의 역사를 느끼고, 산토리니의 푸른 돔과 하얀 집들이 어우러진 해변에서 낭만적인 휴가를 즐겨보세요. 크레타 섬의 미노스 문명 유적지와 지중해 요리도 그리스 여행의 큰 매력입니다.",
                images = listOf(
                    "https://i.namu.wiki/i/eRAYSGmIiQ9BH4iMcf0U07tcO6Reb4fcFj-GUkDEfDRFWUFhPRTkcFJzhx93CT5AIIU47HcZEMtGuI0IkAcytg.webp",
                    "https://i.namu.wiki/i/FHBf0h6valEandlnrm-wEvji1OB055VE-yDq7fe0a5-bOdcwDTkIZ-nSOJSs7SWC06IxeVLnwZmnPcxp_esYlA.webp",
                    "https://i.namu.wiki/i/2h2uj1bN8Cf9WBoddlZtPu-uht2VsYSWa_UgxFhZ-OKOecieo48Ah-_v4av5uab4MWw3BepDuBXNEe5jaboTRuAFWd3ctpSLj34aoEwkURDIYtsotgmQUCeydCd65MIZrciwfVSmx9Tt3vHuReGefA.webp"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 20,
                thumbnailUrl = "https://blog.kakaocdn.net/dn/b1UlYj/btsjkhb1arM/lBPr8jKBtmtG1iNyT8DEeK/img.jpg",
                country = "스위스",
                region = "알프스",
                description = "웅장한 알프스 산맥, 푸른 초원, 맑은 호수까지! 자연 속에서 다양한 액티비티를 즐길 수 있는 천국이에요. 다양한 언어를 사용하는 다문화 국가라서 각 지역마다 다른 매력을 느낄 수 있고, 고급스러운 호텔과 레스토랑이 많아 특별한 여행을 원하는 분들에게 안성맞춤이에요.",
                images = listOf(
                    "https://blog.kakaocdn.net/dn/b1UlYj/btsjkhb1arM/lBPr8jKBtmtG1iNyT8DEeK/img.jpg",
                    "https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/8ddd5e56-2782-4502-8590-0cc401e7a97c.jpeg",
                    "https://lucki.kr/wp-content/uploads/2022/01/524A9425-copy.jpg"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 21,
                thumbnailUrl = "https://cdn.imweb.me/upload/S2017101359e025984d346/a1ed31127b642.jpg",
                country = "덴마크",
                region = "코펜하겐",
                description = "안데르센 동화의 배경이 된 도시 코펜하겐의 인어공주 동상부터 알록달록한 집들까지, 동화 속 세상을 걷는 듯한 낭만을 느낄 수 있어요. 세계에서 가장 행복한 나라 중 하나로 꼽히는 덴마크에서 현지인들처럼 여유롭고 행복한 시간을 보내세요.",
                images = listOf(
                    "https://cdn.imweb.me/upload/S2017101359e025984d346/a1ed31127b642.jpg",
                    "https://cdn.imweb.me/upload/S2017101359e025984d346/d90b43640b6b1.jpg",
                    "https://cdn.imweb.me/upload/S2017101359e025984d346/5bf3bea5c9632.jpg"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 22,
                thumbnailUrl = "https://images.ctfassets.net/mivicpf5zews/50Yy0lFHqMqQyGIQOUg0K4/00837d30fa948e22063033e5f3ea5e65/Begium_H1_Ghent_1200x600px.jpg?q=75",
                country = "벨기에",
                region = "벨기에",
                description = "**작지만 강한 매력을 가진 벨기에!** 다양한 문화가 조화롭게 어우러진 유럽의 보석 같은 나라입니다. 다양한 종류의 맥주를 맛보며 벨기에의 맥주 문화를 경험해 보고, 유네스코 세계문화유산과 아름다운 건축물과 함께 다양한 문화 행사를 체험해 보세요.",
                images = listOf(
                    "https://images.ctfassets.net/mivicpf5zews/50Yy0lFHqMqQyGIQOUg0K4/00837d30fa948e22063033e5f3ea5e65/Begium_H1_Ghent_1200x600px.jpg?q=75",
                    "https://image.theminda.com/data/travel/image/middle/201609/1473796269_0.jpg",
                    "https://www.eurail.com/content/dam/images/eurail/shutterstock_292717961.adaptive.767.0.jpg"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 23,
                thumbnailUrl = "https://www.eurail.com/ko/plan-your-trip/trip-ideas/suggested-itineraries/1-week-spain/_jcr_content/root/responsivegrid/masthead-image.coreimg.jpeg/1715095470381/seville-spain.jpeg",
                country = "스페인",
                region = "스페인",
                description = "**열정과 예술의 나라, 스페인!** 뜨거운 태양 아래 펼쳐진 아름다운 해변, 역사와 문화가 살아 숨 쉬는 도시, 그리고 맛깔스러운 음식까지! 스페인은 다양한 매력을 가진 매혹적인 나라입니다. 고풍스러운 건축물과 좁은 골목길을 거닐며 스페인의 역사를 느껴보세요.",
                images = listOf(
                    "https://www.eurail.com/ko/plan-your-trip/trip-ideas/suggested-itineraries/1-week-spain/_jcr_content/root/responsivegrid/masthead-image.coreimg.jpeg/1715095470381/seville-spain.jpeg",
                    "https://d3b39vpyptsv01.cloudfront.net/photo/1/2/bb2819289d9d9dce22ec5470815c611f.jpg",
                    "https://img4.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202308/21/flybemagazine/20230821160720215qwcj.jpg"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 24,
                thumbnailUrl = "https://pimg.mk.co.kr/meet/neds/2018/09/image_readtop_2018_597957_15375096653469045.jpeg",
                country = "포르투갈",
                region = "포르투갈",
                description = "포르투갈 여행, 매력적인 이베리아 반도의 보석을 만나보세요! 아름다운 해변, 유서 깊은 도시, 맛있는 음식, 그리고 친절한 사람들까지 모두 갖춘 매력적인 여행지입니다. 역사와 문화, 자연이 조화롭게 어우러진 포르투갈에서 잊지 못할 추억을 만들어보세요.",
                images = listOf(
                    "https://pimg.mk.co.kr/meet/neds/2018/09/image_readtop_2018_597957_15375096653469045.jpeg",
                    "https://cdn.imweb.me/upload/S2017101359e025984d346/52858a30001c8.jpg",
                    "https://etias-visa.kr/assets/uploads/imagery/blog/portugal-algarve.jpg"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 25,
                thumbnailUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ6iYvl4_34kjFhYRM2MF0GzI12L3cA9rjG7HryAyll4_0YCGBZ8_PqNVxyIZa3",
                country = "미국",
                region = "뉴욕",
                description = "뉴욕은 단순한 도시를 넘어, 세계 문화, 금융, 예술의 중심지입니다. 밤낮으로 활기가 넘치는 거리, 하늘을 찌를 듯한 마천루, 그리고 다양한 문화가 어우러져 독특한 매력을 발산하는 도시죠.",
                images = listOf(
                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ6iYvl4_34kjFhYRM2MF0GzI12L3cA9rjG7HryAyll4_0YCGBZ8_PqNVxyIZa3",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyDQ96V9Ak0dXzTojOHPsBxqZSEhj8SzX6082YaHytXbclDvQ2p03eqPEAibf-",
                    "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQPO382MuVZcJUF3F18ILAegSp5b3_Iha4Ta5tVVSA5QtBaUdC1hb6XAGP5zlBk"
                ),
                ranking = 3
            ),
            TravelSpotInfo(
                id = 26,
                thumbnailUrl = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQRl0spjhVRq6xnxoVpsBtTzJWaG1_wG63ogXhR1K2pO8e_0P_LC-BjcMoDvlPW",
                country = "미국",
                region = "시카고",
                description = "미국 중서부의 심장, 시카고는 웅장한 건축물과 활기 넘치는 문화, 그리고 깊은 역사를 간직한 매력적인 도시입니다.",
                images = listOf(
                    "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQRl0spjhVRq6xnxoVpsBtTzJWaG1_wG63ogXhR1K2pO8e_0P_LC-BjcMoDvlPW",
                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRJDc5Wl5bIdC6lJHudXe-aRDCLPY6UELQutD9WFw5tk2lK7TYPotJOYg-YnaJf",
                    "https://i.namu.wiki/i/aU7Hsfj6__ZAG6MmipNCzmNEbkO1jG5pUAo0HiS16IlOMTQ-SfRy1mSsB9n6sT1tmGqKTvbL7c0mFYOl1aoTYw3HkUY9ewBHdtZ1VcLx1R1zbE79fBv4EsO6l_ID-6H19ueI5-8sdX6z5JdGKF7R-w.webp"
                ),
                ranking = 0
            ),
            TravelSpotInfo(
                id = 27,
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScI8St1-KodrakDxkbIkYc7CuQ1sMUBXI_Bpzf6B1vx7W4-MZwlih246ylD9ov",
                country = "하와이",
                region = "하와이",
                description = "하와이는 푸른 바다, 울창한 열대 우림, 활화산 등 다양한 자연경관을 자랑하는 아름다운 섬입니다. 아름다운 해변에서 휴식을 취하거나, 다양한 해양 스포츠를 즐기고, 화산 국립공원을 방문하여 자연의 위대함을 느낄 수 있습니다.",
                images = listOf(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScI8St1-KodrakDxkbIkYc7CuQ1sMUBXI_Bpzf6B1vx7W4-MZwlih246ylD9ov",
                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRVmEABfz47J_S5VTrFUgvQOBCSYCiNhY5Jl5B-FWzA6BwahUcCI9imztdWfASv",
                    "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQgzy5VUUv9rgkld3W-XZ3FeqMt_Gk8Z2m7zF-MLp5E07Hdjzg05NbcvdNc2Aw-"
                ),
                ranking = 0
            ),

            TravelSpotInfo(
                id = 28,
                thumbnailUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQCtOS_s7WKOAS7BGdgBe-3p7_INtjgLMg0gX6ZynvXlnIb9KuRqSLZzkQFaP5E",
                country = "캐나다",
                region = "몬트리올, 벤쿠버, 퀘백",
                description = "넓은 영토만큼이나 다양한 매력을 가진 캐나다는 아름다운 자연, 다채로운 문화, 친절한 사람들로 가득한 매력적인 여행지입니다.",
                images = listOf(
                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQCtOS_s7WKOAS7BGdgBe-3p7_INtjgLMg0gX6ZynvXlnIb9KuRqSLZzkQFaP5E",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSv-NS8ii1H0_VXYS3VmfzLvGaD2vCNTTy_NqTVUBUXgd93d9mjMtuBARAq59uI",
                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSnd69HRQakx_j9QTmhm1XI0WkLFsnMLqtm7YwIkcwBpLCWX5hVb2f2gHL5QwkC"
                ),
                ranking = 0
            ),

            TravelSpotInfo(
                id = 29,
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhOyewEWvc7U4Zm7JvolgUhOUrz1MO4JVdq_6_x6LfNneiEoWjfTRhB1dn1APl",
                country = "브라질",
                region = "브라질",
                description = "남아메리카 대륙에서 가장 큰 나라인 브라질은 다채로운 문화와 아름다운 자연, 그리고 열정적인 축제로 유명합니다.",
                images = listOf(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhOyewEWvc7U4Zm7JvolgUhOUrz1MO4JVdq_6_x6LfNneiEoWjfTRhB1dn1APl",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRql5-8Nuh890_DeLdaemb9jehRQJ7wjMh1o-6wRbsFuAn-mydxZF-LUpMb5Ude",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR22mC_i3EcA6YGtBXybTAwrwSlXSvd_rfYB2YkxH67RZUpl_TR3k_Yv6eyKDvW"
                ),
                ranking = 0
            ),

            TravelSpotInfo(
                id = 30,
                thumbnailUrl = "https://cdn.traveltimes.co.kr/news/photo/202310/406489_29617_912.jpg",
                country = "아르헨티나",
                region = "아르헨티나",
                description = "남아메리카 대륙의 남쪽 끝에 위치한 아르헨티나는 웅장한 안데스 산맥부터 광활한 팜파스 초원, 아름다운 파타고니아까지 다양한 자연 환경을 품고 있는 매력적인 나라입니다.",
                images = listOf(
                    "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSYPHFSukQys8-_Uxl2PE0UgLk2Ea_GCain9ahEm9Zb7TvpxSZ1RAqisQxDoalg",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb1Lue18DVnIl97cxgHi80q-k-sqmdNdeRg4O2EiU9floCCVtHMfwi6GJ_f_EZ",
                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSd5l-MgLJ90rRpWil0kjN7SY9EuQ7Sy0WQWEeMr-6aPRWTCjTWhCjP07zreRs9"
                ),
                ranking = 0
            ),

            TravelSpotInfo(
                id = 31,
                thumbnailUrl = "https://cdn.traveltimes.co.kr/news/photo/202310/406489_29617_912.jpg",
                country = "이집트",
                region = "이집트",
                description = "신비로운 고대 문명의 땅, 이집트 여행을 떠나보세요! 역사와 미스터리가 살아 숨 쉬는 곳, 이집트는 피라미드, 스핑크스와 같은 거대한 유적부터 나일강의 아름다운 풍경까지 다양한 볼거리를 제공합니다.",
                images = listOf(
                    "https://cdn.traveltimes.co.kr/news/photo/202310/406489_29617_912.jpg",
                    "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/2AuX/image/yZFZIIykrdpjqylphbBG5pPjOBE.jpg",
                    "https://digitalchosun.dizzo.com/site/data/img_dir/2019/11/29/2019112980117_0.jpg"
                ),
                ranking = 0
            ),

            TravelSpotInfo(
                id = 32,
                thumbnailUrl = "https://www.hanbit.co.kr/data/editor/20191017121027_wgbsqeit.png",
                country = "호주",
                region = "호주",
                description = "호주 여행, 넓고 웅장한 자연과 다채로운 도시를 만나다! 캥거루와 코알라 같은 독특한 동물들부터 아름다운 해변, 울창한 열대우림까지 다양한 매력을 품고 있는 나라입니다.",
                images = listOf(
                    "https://www.hanbit.co.kr/data/editor/20191017121027_wgbsqeit.png",
                    "https://tourimage.interpark.com//Spot/111/10715/202209/6379995266288289440.jpg",
                    "https://digitalchosun.dizzo.com/site/data/img_dir/2017/06/27/2017062712165_4.jpg"
                ),
                ranking = 0
            ),

            TravelSpotInfo(
                id = 33,
                thumbnailUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2020/08/19/102532636.5.jpg",
                country = "괌",
                region = "괌",
                description = "괌 여행, 정말 좋은 선택이시네요! 에메랄드빛 투명한 바다, 하얀 모래사장, 울창한 열대 우림까지! 그 곳에서 다양한 액티비티까지 즐길 수 있는 매력적인 곳이죠.",
                images = listOf(
                    "https://www.kayak.co.kr/c/wp-content/uploads/sites/308/2022/04/danny-mc-z5j2dwpb3p0-unsplash.jpg",
                    "https://tourimage.interpark.com/BBS/Tour/FckUpload/201606/6360097958533349240.jpg",
                    "https://www.cts.tv/plugin/editor/summernote/upload/dc1c2ed9a15f7c359a35bb6e833c4319_thumb.jpeg"
                ),
                ranking = 7
            ),

            TravelSpotInfo(
                id = 34,
                thumbnailUrl = "https://www.agoda.com/wp-content/uploads/2024/02/Downtown-Manila-hotels-things-to-do-in-Manila-Rizal-Park-Philippines-1.jpg",
                country = "필리핀",
                region = "마닐라",
                description = "7,000개가 넘는 섬으로 이루어진 천혜의 자연, 저렴한 물가와 친절한 사람들, 다채로운 문화와 맛있는 음식! 이 모든 것들이 선사하는 잊지 못할 추억을 경험 해보세요.",
                images = listOf(
                    "https://i.namu.wiki/i/bTqsNAZYwzLO_4zCqRATtJ8dg55YgZ8zYMDp0QKiJxPEURR3hKKfyOWdQhIs6ABf31bDtX9n5BE7fBZWie8mlw.webp",
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/e6/90/9e/caption.jpg?w=1200&h=-1&s=1&cx=1920&cy=1080&chk=v1_98d290c726259c64b704",
                    "https://media.istockphoto.com/id/1092423872/ko/%EC%82%AC%EC%A7%84/%EB%A7%88%EB%8B%90%EB%9D%BC-%EB%B2%A0%EC%9D%B4-%ED%95%84%EB%A6%AC%ED%95%80-%EB%A7%88%EB%8B%90%EB%9D%BC-%EC%8B%9C%EC%9D%98-%EC%8A%A4%EC%B9%B4%EC%9D%B4-%EB%9D%BC%EC%9D%B8.jpg?s=612x612&w=0&k=20&c=joiJzyt8h_DI57YQEZceAaS4rhJBxlgGaJU5QlztLmg="
                ),
                ranking = 4
            ),

            TravelSpotInfo(
                id = 35,
                thumbnailUrl = "https://story.s-oil.com/wp-content/uploads/2021/06/%EB%B6%80%EB%A3%A8%EB%A7%88%EB%B8%94_01.jpg",
                country = "싱가포르",
                region = "싱가포르",
                description = "첨단 건축물과 아름다운 정원이 조화를 이루는 싱가포르! 쇼핑몰, 시장, 테마파크 등 다양한 곳에서 즐거운 시간을 보낼 수 있어요.",
                images = listOf(
                    "https://img.khan.co.kr/news/2022/06/09/news-p.v1.20220609.4b67056841a94763a34f8845694316d6_P1.jpg",
                    "https://tourimage.interpark.com/BBS/Tour/FckUpload/202001/6371470205165735740.png",
                    "https://img1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/k41IemYFNns52pFaSJuJGaPlbfU.jpeg"
                ),
                ranking = 5
            ),

            TravelSpotInfo(
                id = 35,
                thumbnailUrl = "https://www.hanbit.co.kr/data/editor/20191017121027_wgbsqeit.png",
                country = "싱가포르",
                region = "싱가포르",
                description = "첨단 건축물과 아름다운 정원이 조화를 이루는 싱가포르! 쇼핑몰, 시장, 테마파크 등 다양한 곳에서 즐거운 시간을 보낼 수 있어요.",
                images = listOf(
                    "https://www.hanbit.co.kr/data/editor/20191017121027_wgbsqeit.png",
                    "https://tourimage.interpark.com//Spot/111/10715/202209/6379995266288289440.jpg",
                    "https://digitalchosun.dizzo.com/site/data/img_dir/2017/06/27/2017062712165_4.jpg"
                ),
                ranking = 0
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

    fun getFirstItem(): TravelSpotInfo {
        return travelSpotList.first()
    }
}