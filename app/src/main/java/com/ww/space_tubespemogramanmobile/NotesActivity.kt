package com.ww.space_tubespemogramanmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ww.space_tubespemogramanmobile.databinding.ActivityNotesBinding
import android.view.View


class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding
    private val notesList = mutableListOf<Note>()

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val note = result.data?.getParcelableExtra<Note>("note")
            note?.let {
                notesList.add(it)
                binding.rvNotes.adapter?.notifyDataSetChanged()
                updateNoNotesMessage()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set RecyclerView
        val noteAdapter = NoteAdapter(notesList) { note ->
            // Handle klik pada item catatan
            Toast.makeText(this, "Clicked on: ${note.title}", Toast.LENGTH_SHORT).show()
        }

        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(this@NotesActivity)
            adapter = noteAdapter
        }

        // Add note button click listener
        binding.btnAddNote.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        // Update the visibility of "No Notes" message
        updateNoNotesMessage()
    }

    // Function to show or hide "No Notes Available" message
    private fun updateNoNotesMessage() {
        if (notesList.isEmpty()) {
            binding.tvNoNotesMessage.visibility = View.VISIBLE
        } else {
            binding.tvNoNotesMessage.visibility = View.GONE
        }
    }
}

