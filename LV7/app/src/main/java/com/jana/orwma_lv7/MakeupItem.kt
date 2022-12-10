package com.jana.orwma_lv7

data class MakeupItem(  //Persons
    val id: Int,
    val brand: String,
    val name: String,
    val price: String,
    val price_sign: Any,
    val currency: Any,
    val image_link: String,
    val product_link: String,
    val website_link: String,
    val description: String,
    val rating: Double,
    val category: String,
    val product_type: String,
    val tag_list: List<Any>,
    val created_at: String,
    val updated_at: String,
    val product_api_url: String,
    val api_featured_image: String,
)