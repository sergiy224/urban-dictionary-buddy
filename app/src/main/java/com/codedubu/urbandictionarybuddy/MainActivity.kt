package com.codedubu.urbandictionarybuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.codedubu.urbandictionarybuddy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // private lateinit var searchVC: ActivityMainBinding
    // searchVC ('binding' in Kotlin terms) = ActivityMainBinding.inflate(layoutInflater)
    // setContentView(searchVC.root)

    // viewDidLoad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton    = findViewById<Button>(R.id.searchButton)
        val termTextField   = findViewById<TextView>(R.id.termTextField)
        val termText        = termTextField.text

        // setOnClickListener == didTouchUpInside
            searchButton.setOnClickListener {
                if (termText.isNotEmpty()) {
                    println("developerConsole: '${termTextField.text}' was input in the textView")
                    navigateToSearchResultsForWord(termTextField.text.toString())
                    termTextField.text = ""
                } else {
                    println("developerConsole: Type something in the textView!")
                }
            }
    }


    private fun navigateToSearchResultsForWord(word: String) {
        // let intent = Intent(self, SearchResultsViewController.self)
        val intent = Intent(this, SearchResultsActivity::class.java)

            intent.putExtra(termKey, word)

            startActivity(intent)
    }


    // static let termKey = "termKey"
    companion object {
        const val termKey = "termKey"
    }
}