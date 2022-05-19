package com.hanchang97.starbucks.model.home.menu

data class MenuData(
    var menuInfo: MenuInfo? = MenuInfo(),
    var menuImage: MenuImage? = MenuImage(),
    var rank: Int? = 0
)

// rv 에서 사용