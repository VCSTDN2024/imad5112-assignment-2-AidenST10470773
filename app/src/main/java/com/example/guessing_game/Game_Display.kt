package com.example.guessing_game

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Game_Display : AppCompatActivity() {

    private val questions = listOf(
        "The Earth is flat.",
        "The sky is blue.",
        "Water boils at 100 degrees Celsius.",
        "The sun revolves around the Earth.",
        "There are 7 continents."
    )

    private val answers = listOf(
        false,
        true,
        true,
        false,
        true
    )

    private var currentQuestionIndex = 0
    private var score = 0
    private var answered = false

    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_display)

        val videoView: VideoView = findViewById(R.id.videoView1)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.my_video2)
        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()
        }

        questionTextView = findViewById(R.id.questionTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        displayQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            moveToNextQuestion()
        }
    }

    private fun displayQuestion() {
        if (currentQuestionIndex < questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
            trueButton.isEnabled = true
            falseButton.isEnabled = true
            nextButton.visibility = Button.GONE
            answered = false
        } else {
            // Game over, display score or restart
            Toast.makeText(this, "Game Over! Your score: $score", Toast.LENGTH_LONG).show()
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            nextButton.visibility = Button.GONE
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (!answered) {
            val correctAnswer = answers[currentQuestionIndex]
            if (userAnswer == correctAnswer) {
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
            }
            answered = true
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            nextButton.visibility = Button.VISIBLE
        }
    }

    private fun moveToNextQuestion() {
        currentQuestionIndex++
        displayQuestion()
    }
}


