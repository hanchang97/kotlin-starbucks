package com.hanchang97.starbucks.common

import android.util.Log

object Common {
    const val eventImageUrl = "https://s3.ap-northeast-2.amazonaws.com/lucas-image.codesquad.kr/1627033273796event-bg.png"

    const val eventBaseUrl = "https://public.codesquad.kr/jk/boostcamp/"
    const val codeSquadBaseUrl = "https://api.codesquad.kr/"
    const val starBucksBaseUrl = "https://www.starbucks.co.kr/"

    fun printLog(log: String){
        Log.d("AppTest", "log: ${log}")
    }
}