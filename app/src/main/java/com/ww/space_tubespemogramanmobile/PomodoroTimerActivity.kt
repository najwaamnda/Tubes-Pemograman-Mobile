package com.ww.space_tubespemogramanmobile

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PomodoroActivity : AppCompatActivity() {

    private lateinit var timerText: TextView
    private lateinit var startButton: Button
    private lateinit var pomodoroButton: Button
    private lateinit var shortBreakButton: Button
    private lateinit var longBreakButton: Button

    private var timer: CountDownTimer? = null
    private var isTimerRunning = false
    private var timeLeftInMillis: Long = 0

    // Durasi timer dalam milidetik
    private val pomodoroTime: Long = 45 * 60 * 1000 // 45 menit
    private val shortBreakTime: Long = 5 * 60 * 1000 // 5 menit
    private val longBreakTime: Long = 10 * 60 * 1000 // 10 menit

    private var currentMode: String = "pomodoro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pomodoro)

        // Inisialisasi Views
        timerText = findViewById(R.id.timer_text)
        startButton = findViewById(R.id.start_button)
        pomodoroButton = findViewById(R.id.pomodoro_button)
        shortBreakButton = findViewById(R.id.short_break_button)
        longBreakButton = findViewById(R.id.long_break_button)

        // Set button click listeners
        startButton.setOnClickListener { onStartStopButtonClick() }
        pomodoroButton.setOnClickListener { setPomodoroMode() }
        shortBreakButton.setOnClickListener { setShortBreakMode() }
        longBreakButton.setOnClickListener { setLongBreakMode() }

        // Set initial time for pomodoro mode
        setPomodoroMode()
    }

    // Fungsi untuk menangani Start/Stop button
    private fun onStartStopButtonClick() {
        if (isTimerRunning) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    // Fungsi untuk mulai timer
    private fun startTimer() {
        timer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                // Timer selesai
                timerText.text = "00:00"
                isTimerRunning = false
                startButton.text = "Start"
            }
        }.start()

        isTimerRunning = true
        startButton.text = "Stop"
    }

    // Fungsi untuk menghentikan timer
    private fun stopTimer() {
        timer?.cancel()
        isTimerRunning = false
        startButton.text = "Start"
    }

    // Fungsi untuk memperbarui tampilan timer
    private fun updateTimerText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        timerText.text = String.format("%02d:%02d", minutes, seconds)
    }

    // Set timer untuk Pomodoro mode
    private fun setPomodoroMode() {
        currentMode = "pomodoro"
        timeLeftInMillis = pomodoroTime
        updateTimerText()
    }

    // Set timer untuk Short Break mode
    private fun setShortBreakMode() {
        currentMode = "shortBreak"
        timeLeftInMillis = shortBreakTime
        updateTimerText()
    }

    // Set timer untuk Long Break mode
    private fun setLongBreakMode() {
        currentMode = "longBreak"
        timeLeftInMillis = longBreakTime
        updateTimerText()
    }
}
