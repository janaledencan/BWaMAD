package com.jana.orwma_lv8

data class Person(
    val imageUrl: String,
    var id:String,
    var name: String,
    var description: String
){
    constructor():this("","","","")
}


/*data class Person(
    var id: String ="",
    var imageUrl: String? = null,
    var name : String?= null,
    var description: String?= null
)*/