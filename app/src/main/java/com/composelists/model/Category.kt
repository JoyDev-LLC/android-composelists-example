package com.composelists.model

data class Category(
    val id: Int,
    val name: String,
    val subcategories: List<Subcategory>
)
