package com.ww.space_tubespemogramanmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val etNoteTitle: EditText = findViewById(R.id.etNoteTitle)
        val etNoteContent: EditText = findViewById(R.id.etNoteContent)
        val btnSaveNote: Button = findViewById(R.id.btnSaveNote)

        btnSaveNote.setOnClickListener {
            val title = etNoteTitle.text.toString()
            val content = etNoteContent.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                // Membuat Summary dari Content (potong 100 karakter pertama)
                val summary = if (content.length > 100) content.substring(0, 100) + "..." else content

                // Menyimpan waktu saat catatan dibuat (timestamp)
                val dateCreated = System.currentTimeMillis()

                // Membuat objek Note dan kirim ke Activity sebelumnya
                val note = Note(
                    title = title,
                    summary = summary,
                    content = content,
                    dateCreated = dateCreated // Menyimpan timestamp
                )

                val intent = Intent().apply {
                    putExtra("note", note) // Mengirim objek Note dengan extra
                }
                setResult(RESULT_OK, intent) // Kirim data balik ke Activity sebelumnya
                finish() // Tutup AddNoteActivity
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // Fungsi 'finish' dengan animasi penutupan
    override fun finish() {
        super.finish()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
