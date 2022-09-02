package com.codedubu.urbandictionarybuddy

import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// Struct Term
// SerializedName is like CodingKeys

data class Term(
    @SerializedName("word")
    val word: String,
    @SerializedName("definition")
    val definition: String,
    @SerializedName("thumbs_up")
    val likes: String,
    @SerializedName("thumbs_down")
    val dislikes: String
): Serializable {
    val htmlDefinition: Spanned
        get() {
            val replacedBracesDefinition = this.definition
                .replace("[", "<b>")
                .replace("]", "</b>")

            return HtmlCompat.fromHtml(
                replacedBracesDefinition,
                HtmlCompat.FROM_HTML_MODE_COMPACT
            )
        }
}
