package com.hanchang97.starbucks.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuEntity(
    @PrimaryKey val product_cd: String,
    @NonNull @ColumnInfo(name = "menu_name") val menu_name: String,
    @NonNull @ColumnInfo(name = "menu_name_eng") val menu_name_eng: String,
    @NonNull @ColumnInfo(name = "menu_image_url") val menu_image_url: String
)
