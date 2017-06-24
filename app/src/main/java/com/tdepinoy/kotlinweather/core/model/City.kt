package com.tdepinoy.kotlinweather.core.model

import com.tdepinoy.kotlinweather.core.model.Coordinate

data class City(val id: Int, val name: String, val coordinate: Coordinate, val country: String, val population: Int)