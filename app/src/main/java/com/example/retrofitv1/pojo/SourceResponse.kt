package com.example.retrofitv1.pojo

import androidx.room.ColumnInfo

data class SourceResponse(
    @ColumnInfo
    val id:String?=null,
    @ColumnInfo
    val name:String
)
