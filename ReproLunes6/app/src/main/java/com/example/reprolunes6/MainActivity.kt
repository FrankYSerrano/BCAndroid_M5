package com.example.reprolunes6

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reprolunes6.AppConstant.Companion.MEDIA_PLAYER_PLAYING_STATUS
import com.example.reprolunes6.AppConstant.Companion.LOG_MAIN_ACTIVITY
import com.example.reprolunes6.AppConstant.Companion.MEDIA_PLAYER_POSITION
import com.example.reprolunes6.AppConstant.Companion.MEDIA_PLAYER_SONG_INDEX
import com.example.reprolunes6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaplayer: MediaPlayer? = null
    private var position : Int = 0
    private lateinit var currentSong: Song
    private var currentSongindex: Int = 0
    private var isPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        logger("onCreate()")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playPauseButton.setOnClickListener { playOrPauseMusic() }
        binding.playNextButton.setOnClickListener { playNextSong() }
        binding.playPreviousButton.setOnClickListener { playPreviousSong() }

        savedInstanceState?.let {
            position = it.getInt(MEDIA_PLAYER_POSITION)
            isPlaying= it.getBoolean(MEDIA_PLAYER_PLAYING_STATUS)
            currentSongindex = it.getInt(MEDIA_PLAYER_SONG_INDEX)
            logger("Cancion: $currentSongindex -- $isPlaying")
        }

        currentSong = AppConstant.songs[currentSongindex]
        updateUiSong()

    }

    override fun onStart() {
        super.onStart()
        logger("onStart()")
        mediaplayer = MediaPlayer.create(this, currentSong.audioResId)
        if (isPlaying)
            mediaplayer?.start()
    }
    override fun onResume() {
        super.onResume()
        logger("onResume()")
        mediaplayer?.seekTo(position)
        if (isPlaying){
            mediaplayer?.start()
        }
    }
    override fun onPause() {
        super.onPause()
        logger("onPause()")
        if (mediaplayer != null)
            position = mediaplayer!!.currentPosition
        if (isPlaying) {
            mediaplayer?.pause()
//            isPlaying = false
            logger("Soy YO!")
        }
    }
    override fun onStop() {
        super.onStop()
        logger("onStop()")
        mediaplayer?.stop()
//        isPlaying = false
        mediaplayer?.release()
        mediaplayer = null
    }
    override fun onRestart() {
        super.onRestart()
        logger("onRestart()")
    }
    override fun onDestroy() {
        super.onDestroy()
        logger("onDestroy()")
    }
    private fun logger (mensaje: String){
        Log.i(LOG_MAIN_ACTIVITY, mensaje)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(MEDIA_PLAYER_POSITION, position)
        outState.putBoolean(MEDIA_PLAYER_PLAYING_STATUS, isPlaying)
        outState.putInt(MEDIA_PLAYER_SONG_INDEX, currentSongindex)

        logger("salvaEstado()")
    }

    private fun updateUiSong(){
        binding.titleTextView.text = currentSong.title
        binding.albumCoverImageView.setImageResource(currentSong.imageResId)
        updatePlayPauseButton()
    }

    private fun updatePlayPauseButton(){
        if (isPlaying){
            binding.playPauseButton.text = "PAUSE"
        }else{
            binding.playPauseButton.text = "PLAY"
        }
    }

    private fun playOrPauseMusic(){
        if (isPlaying){
            mediaplayer?.pause()
        }else{
            mediaplayer?.start()
        }
        isPlaying = !isPlaying
        updatePlayPauseButton()
    }

    private fun playNextSong(){
        currentSongindex = (currentSongindex + 1) % AppConstant.songs.size
        currentSong = AppConstant.songs[currentSongindex]
        mediaplayer?.stop()
        mediaplayer?.release()
        mediaplayer = MediaPlayer.create(this, currentSong.audioResId)
        mediaplayer?.start()
        isPlaying = true
        updateUiSong()
    }

    private fun playPreviousSong(){
        currentSongindex = (currentSongindex - 1 + AppConstant.songs.size) % AppConstant.songs.size
        currentSong = AppConstant.songs[currentSongindex]
        mediaplayer?.stop()
        mediaplayer?.release()
        mediaplayer = MediaPlayer.create(this, currentSong.audioResId)
        mediaplayer?.start()
        isPlaying = true
        updateUiSong()
    }

}