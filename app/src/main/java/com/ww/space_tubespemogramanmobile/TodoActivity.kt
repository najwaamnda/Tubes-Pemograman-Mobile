package com.ww.space_tubespemogramanmobile

import TodoAdapter
import android.util.Log
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        Log.d("TodoActivity", "Layout activity_todo berhasil diimpor!")

        // Data asli
        val allTasks = listOf(
            TodoItem("Belajar RecyclerView", "10 Desember 2024", false),
            TodoItem("Kerjakan Tugas Kotlin", "12 Desember 2024", false),
            TodoItem("Persiapkan Presentasi", "15 Desember 2024", false),
            TodoItem("Membaca Artikel", "5 Desember 2024", true),
            TodoItem("Revisi Proposal", "8 Desember 2024", true)
        )

        // Filter data untuk "Sedang Berlangsung" dan "Sudah Selesai"
        val inProgressTasks = allTasks.filter { !it.isChecked }.take(3)
        val completedTasks = allTasks.filter { it.isChecked }.take(2)

        // RecyclerView untuk "Sedang Berlangsung"
        val recyclerViewInProgress = findViewById<RecyclerView>(R.id.ongoingRecyclerView)
        recyclerViewInProgress.layoutManager = LinearLayoutManager(this)
        recyclerViewInProgress.adapter = TodoAdapter(inProgressTasks)

        // RecyclerView untuk "Sudah Selesai"
        val recyclerViewCompleted = findViewById<RecyclerView>(R.id.completedRecyclerView)
        recyclerViewCompleted.layoutManager = LinearLayoutManager(this)
        recyclerViewCompleted.adapter = TodoAdapter(completedTasks)

        Log.d("TodoActivity", "RecyclerView Sedang Berlangsung berhasil diatur.")
    }
}