package com.codedubu.urbandictionarybuddy

import com.google.gson.annotations.SerializedName

// Struct
// topLevelObject

data class DefineTermResponse(
    @SerializedName("list")
    val terms: List<Term>
)