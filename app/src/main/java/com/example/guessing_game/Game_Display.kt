/*The Independent Institute of Education. (2025) Introduction to Mobile Application Development:
 IMAD5112/p/w Module Manual. [Module Manual]. South Africa: The Independent Institute of Education (Pty) Ltd.

*AstroPlaneet (2024) Space and universe wallpaper at 120fps. [TikTok video]. 29 December.
 Available at: https://vm.tiktok.com/ZMSF94kom/ (Accessed: 22 May 2025).
* */


package com.example.guessing_game

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Game_Display : AppCompatActivity() {

    private val questions = listOf(
        "The Capital of France is Berlin.",
        "Humans need oxygen to survive.",
        "The sun is a star, not a planet",
        "The Great Barrier Reef is indeed the largest coral reef system",
        "water freezes at 0 degrees celsius",
        "DNA is found in all living things",
        "There are 7 continents."
    )

    private val answers = listOf(
        false,
        true,
        true,
        false,
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
    private lateinit var reviewButton: Button
    private lateinit var outComeText: TextView

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
        reviewButton = findViewById(R.id.ReviewBtn)
        outComeText = findViewById(R.id.outComeText)

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
        reviewButton.setOnClickListener {
            moveToNextSreen()
        }
    }

    private fun displayQuestion() {
        if (currentQuestionIndex < questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
            trueButton.isEnabled = true
            falseButton.isEnabled = true
            nextButton.visibility = Button.GONE
            outComeText.text = ""
            answered = false
        } else {

            outComeText.text = "Game Over! Your score: $score"
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            nextButton.visibility = Button.GONE
            questionTextView.visibility = TextView.GONE
            reviewButton.visibility = Button.VISIBLE
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (!answered) {
            val correctAnswer = answers[currentQuestionIndex]
            if (userAnswer == correctAnswer) {
                score++
                outComeText.text = "Correct!"
            } else {
                outComeText.text = "Incorrect!"
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

    private fun moveToNextSreen() {
        val intent = Intent(this, DisplayScoreScreenActivity::class.java)

        intent.putStringArrayListExtra("Questions", ArrayList(questions))
        intent.putStringArrayListExtra("Answers", ArrayList(answers.map { if (it) "True" else "False" }))
        intent.putExtra("SCORE", score)

        startActivity(intent)
        finish()
    }
}


