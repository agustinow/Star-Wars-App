package com.odella.starwars.POJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlanetFeed {

    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("next")
    @Expose
    var next: String? = null
    @SerializedName("previous")
    @Expose
    var previous: Any? = null
    @SerializedName("results")
    @Expose
    var planets: List<Planet>? = null

}

class Planet {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("rotation_period")
    @Expose
    var rotationPeriod: String? = null
    @SerializedName("orbital_period")
    @Expose
    var orbitalPeriod: String? = null
    @SerializedName("diameter")
    @Expose
    var diameter: String? = null
    @SerializedName("climate")
    @Expose
    var climate: String? = null
    @SerializedName("gravity")
    @Expose
    var gravity: String? = null
    @SerializedName("terrain")
    @Expose
    var terrain: String? = null
    @SerializedName("surface_water")
    @Expose
    var surfaceWater: String? = null
    @SerializedName("population")
    @Expose
    var population: String? = null
    @SerializedName("residents")
    @Expose
    var residents: List<String>? = null
    @SerializedName("films")
    @Expose
    var films: List<String>? = null
    @SerializedName("created")
    @Expose
    var created: String? = null
    @SerializedName("edited")
    @Expose
    var edited: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null

}