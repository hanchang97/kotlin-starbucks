package com.hanchang97.starbucks.ui.main.tab.order

import androidx.lifecycle.ViewModel
import com.hanchang97.starbucks.model.order.OrderInfo

class OrderViewModel : ViewModel() {

    private val coldbrew_image_url =
        "https://www.starbucks.co.kr/upload/store/skuimg/2022/04/[9200000003988]_20220406113215251.jpg"
    private val espresso_image_url =
        "https://www.starbucks.co.kr/upload/store/skuimg/2021/04/[25]_20210415144211211.jpg"
    private val frappuccino_image_url =
        "https://www.starbucks.co.kr/upload/store/skuimg/2021/04/[9200000002760]_20210415133558068.jpg"

    private val cold_brew_list_url = "www.starbucks.co.kr/upload/json/menu/W0000171.js"
    private val espresso_list_url = "www.starbucks.co.kr/upload/json/menu/W0000003.js"
    private val frappuccino_list_url = "www.starbucks.co.kr/upload/json/menu/W0000004.js"

    val foodList = listOf(
        OrderInfo("콜드 브루", "Cold Brew", coldbrew_image_url, cold_brew_list_url),
        OrderInfo("에스프레소", "Espresso", espresso_image_url, espresso_list_url),
        OrderInfo("프라푸치노", "Frappuccino", frappuccino_image_url, frappuccino_list_url)
    )



}