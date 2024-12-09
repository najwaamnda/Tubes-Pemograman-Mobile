package com.ww.space_tubespemogramanmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapter(
    private val noteList: List<Note>,
    private val onNoteClick: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val noteCardView: CardView = itemView.findViewById(R.id.noteCard)
        val noteTitle: TextView = itemView.findViewById(R.id.tvNoteTitle)
        val noteContent: TextView = itemView.findViewById(R.id.tvNoteContent)
        val noteDate: TextView = itemView.findViewById(R.id.tvNoteDate)

        init {
            noteCardView.setOnClickListener {
                val note = noteList[adapterPosition]
                onNoteClick(note)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = noteList[position]
        holder.noteTitle.text = currentNote.title
        holder.noteContent.text = currentNote.summary // Update content if needed

        // Format the date
        val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        holder.noteDate.text = formatter.format(Date(currentNote.dateCreated)) // Tampilkan tanggal yang sudah diformat
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}
