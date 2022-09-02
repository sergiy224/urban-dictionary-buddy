package com.codedubu.urbandictionarybuddy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TermTableViewDataSource: RecyclerView.Adapter<TermCell>() {

    // var terms: [Term] = []
    var terms = emptyList<Term>()

    // numberOfRows
    override fun getItemCount(): Int {
        return terms.size
    }


    // dequeueReuseIdentifier
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermCell {
        val termView = LayoutInflater.from(parent.context).inflate(R.layout.term_cell, parent, false)
        return TermCell(termView)
    }


    // cellForRowAt indexPath
    // holder == cell
    override fun onBindViewHolder(holder: TermCell, position: Int) {
        val term                    = terms[position]
        holder.wordLabel.text       = term.word
        holder.definitionLabel.text = term.htmlDefinition
        holder.term                 = term
    }


    // reloadData()
    fun update(terms: List<Term>) {
        // self.terms = terms
        this.terms = terms
        // tableView.reloadData()
        notifyDataSetChanged()
    }
}