package com.example.guessing_game

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class DisplayScoreScreenActivity : AppCompatActivity() {

    private lateinit var answersDisplay: TextView
    private lateinit var scoreDisplay: TextView
    private lateinit var restartBtn: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.display_score_screen)

        val videoView: VideoView = findViewById(R.id.videoView2)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.my_video2)
        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()
        }

        answersDisplay = findViewById(R.id.AnswersDisplay)
        scoreDisplay = findViewById(R.id.ScoreDisplay)
        restartBtn = findViewById(R.id.RestartBtn)
        exitButton = findViewById(R.id.ExitBtn)



        val questions = intent.getStringArrayListExtra("Questions")
        val correctAnswersAsStrings = intent.getStringArrayListExtra("Answers")
        val score = intent.getIntExtra("SCORE", 0)

        val stringBuilder = StringBuilder()
        if (questions != null && correctAnswersAsStrings != null) {
            if (questions.size == correctAnswersAsStrings.size) {
                for (i in questions.indices) {
                    stringBuilder.append("Q${i + 1}: ${questions[i]}\n")
                    stringBuilder.append("A${i + 1}: ${correctAnswersAsStrings[i]}\n\n")
                }
            } else {
                stringBuilder.append("Error: Mismatch in questions and answers data.\n")
                for (i in questions.indices) {
                    stringBuilder.append("Q${i + 1}: ${questions[i]}\n")
                    stringBuilder.append("A${i + 1}: ${correctAnswersAsStrings.getOrElse(i) { "N/A" }}\n\n")
                }
            }
        } else {
            stringBuilder.append("No questions or answers found.")
        }

        answersDisplay.text = stringBuilder.toString()
        scoreDisplay.text = "Score: $score"

        restartBtn.setOnClickListener {
            val intent = Intent(this, Game_Display::class.java)
            startActivity(intent)
            finish()
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }






    }
}
