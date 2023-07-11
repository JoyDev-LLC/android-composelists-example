package com.composelists.mock

import com.composelists.model.Category
import com.composelists.model.Subcategory

val categories = listOf(
    Category(
        0,
        "First",
        listOf(
            Subcategory(0, "FirstSub1"),
            Subcategory(1, "FirstSub2"),
            Subcategory(2, "FirstSub3"),
            Subcategory(3, "FirstSub4")
        )
    ),
    Category(
        1, "Second", listOf(
            Subcategory(4, "SecondSub1"),
            Subcategory(5, "SecondSub2"),
            Subcategory(6, "SecondSub3"),
            Subcategory(7, "SecondSub4")
        )
    ),
    Category(
        2, "Third", listOf(
            Subcategory(8, "ThirdSub1"),
            Subcategory(9, "ThirdSub2"),
            Subcategory(10, "ThirdSub3"),
            Subcategory(11, "ThirdSub4")
        )
    ),
    Category(
        3, "Fourth", listOf(
            Subcategory(12, "FourthSub1"),
            Subcategory(13, "FourthSub2"),
            Subcategory(14, "FourthSub3"),
            Subcategory(15, "FourthSub4")
        )
    ),
    Category(
        4, "Fifth", listOf(
            Subcategory(16, "FifthSub1"),
            Subcategory(17, "FifthSub2"),
            Subcategory(18, "FifthSub3"),
            Subcategory(19, "FifthSub4")
        )
    ),
    Category(
        5, "Sixth", listOf(
            Subcategory(20, "SixthSub1"),
            Subcategory(21, "SixthSub2"),
            Subcategory(22, "SixthSub3"),
            Subcategory(23, "SixthSub4")
        )
    ),
    Category(
        6, "Seventh", listOf(
            Subcategory(24, "SeventhSub1"),
            Subcategory(25, "SeventhSub2"),
            Subcategory(26, "SeventhSub3"),
            Subcategory(27, "SeventhSub4")
        )
    ),
    Category(
        7, "Eighth", listOf(
            Subcategory(28, "EighthSub1"),
            Subcategory(29, "EighthSub2"),
            Subcategory(30, "EighthSub3"),
            Subcategory(31, "EighthSub4")
        )
    ),
    Category(
        8, "Ninth", listOf(
            Subcategory(32, "NinthSub1"),
            Subcategory(33, "NinthSub2"),
            Subcategory(34, "NinthSub3"),
            Subcategory(35, "NinthSub4")
        )
    )
)
