package com.codedubu.urbandictionarybuddy

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent


// Similar to class TermCell: UITableViewCell
class TermCell(termView: View, var term: Term? = null): RecyclerView.ViewHolder(termView) {

    val wordLabel: TextView         = termView.findViewById(R.id.wordLabel)
    val definitionLabel: TextView   = termView.findViewById(R.id.definitionLabel)


    init {
        termView.setOnClickListener {
            // if let it = self.term { do stuff }
            term?.let {
                val intent = Intent(termView.context, WordDefinitionDetailActivity::class.java)

                intent.putExtra(termKey, term)
                termView.context.startActivity(intent)
            }
        }
    }


    companion object {
        const val termKey = "termKey"
    }
}