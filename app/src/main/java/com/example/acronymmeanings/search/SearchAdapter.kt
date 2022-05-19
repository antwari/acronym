package com.example.acronymmeanings.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acronymmeanings.R
import com.example.acronymmeanings.models.FullForm

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.TextItemViewHolder>() {

    var data = listOf<FullForm>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        return TextItemViewHolder.from(parent)
    }


    class TextItemViewHolder(private val textView: TextView) : RecyclerView.ViewHolder(textView) {

        fun bind(item: FullForm) {
            textView.text = item.longForm
        }

        companion object {
            fun from(parent: ViewGroup): TextItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.text_item_view, parent, false) as TextView

                return TextItemViewHolder(view)
            }
        }
    }
}
