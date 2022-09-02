package com.codedubu.urbandictionarybuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WordDefinitionDetailActivity : AppCompatActivity() {

    // viewDidLoad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_definition)

        val definitionDetailLabel: TextView       = findViewById(R.id.definitionDetailLabel)
        val likesLabel: TextView                  = findViewById(R.id.likesLabel)
        val dislikesLabel: TextView               = findViewById(R.id.dislikesLabel)

        val term = intent.getSerializableExtra(TermCell.termKey) as? Term
        term?.let {
            supportActionBar?.title     = it.word
            definitionDetailLabel.text  = it.htmlDefinition
            likesLabel.text             = "Likes: ${it.likes}"
            dislikesLabel.text          = "Dislikes: ${it.dislikes}"
        }
    }
}