package com.willian.ourofino.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PontoTuristico(
    val id: Int,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    val latitude: Double,
    val longitude: Double,
    val category: Categoria,
    val imageUrl: String = "",
    @StringRes val coordinatesRes: Int = 0
)

enum class Categoria {
    CULTURAL,
    NATURAL,
    RELIGIOUS
}
