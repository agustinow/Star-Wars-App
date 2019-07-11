package com.odella.starwars.POJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StarshipFeed {

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
    var starships: List<Starship>? = null

}


class Starship {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("model")
    @Expose
    var model: String? = null
    @SerializedName("manufacturer")
    @Expose
    var manufacturer: String? = null
    @SerializedName("cost_in_credits")
    @Expose
    var costInCredits: String? = null
    @SerializedName("length")
    @Expose
    var length: String? = null
    @SerializedName("max_atmosphering_speed")
    @Expose
    var maxAtmospheringSpeed: String? = null
    @SerializedName("crew")
    @Expose
    var crew: String? = null
    @SerializedName("passengers")
    @Expose
    var passengers: String? = null
    @SerializedName("cargo_capacity")
    @Expose
    var cargoCapacity: String? = null
    @SerializedName("consumables")
    @Expose
    var consumables: String? = null
    @SerializedName("hyperdrive_rating")
    @Expose
    var hyperdriveRating: String? = null
    @SerializedName("MGLT")
    @Expose
    var mglt: String? = null
    @SerializedName("starship_class")
    @Expose
    var starshipClass: String? = null
    @SerializedName("pilots")
    @Expose
    var pilots: List<String>? = null
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