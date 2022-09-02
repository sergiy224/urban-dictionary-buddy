package com.codedubu.urbandictionarybuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codedubu.urbandictionarybuddy.databinding.ActivitySearchResultsBinding

class SearchResultsActivity : AppCompatActivity() {

    private val networking = NetworkingService()
    private val dataSource = TermTableViewDataSource()


    // viewDidload
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        val termsTableView              = findViewById<RecyclerView>(R.id.termsTableView)

        termsTableView.layoutManager    = LinearLayoutManager(this)
        termsTableView.adapter          = dataSource


        // Landing pad for the term inputted into the searchTextField.
        val term                        = intent.getStringExtra(MainActivity.termKey) ?: return
        supportActionBar?.title         = term
        getSearchResultsForTerm(term)
    }

    private fun getSearchResultsForTerm(term: String) {
        // terms ->    ==   terms   in
        // it          ==   $0
        // this        ==   self
            networking.defineTerm(term).observe(this, Observer { terms ->
                terms.forEach { println("developerConsole: $it") }
                dataSource.update(terms)
            })
    }
}