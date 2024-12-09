package com.ww.space_tubespemogramanmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< lia
        setContentView(R.layout.activity_todo_list)

        // Pastikan 'todo_list' adalah ID yang valid dalam layout activity_todo_list.xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.todo_list)) { v, insets ->
            // Mendapatkan insets untuk sistem bar (status bar, navigation bar, dll)
=======
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
>>>>>>> master
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Set padding sesuai dengan system bars (status bar, navigation bar)
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            // Mengembalikan insets agar layout dapat mengatur dirinya sendiri
            insets
        }
    }
}
