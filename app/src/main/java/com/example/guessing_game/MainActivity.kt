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
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val videoView: VideoView = findViewById(R.id.videoView)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.my_video2)
        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()
        }
        val startButton: Button = findViewById(R.id.StartBtn)

        startButton.setOnClickListener {
            val intent = Intent(this, Game_Display::class.java)
            startActivity(intent)
        }
    }
}