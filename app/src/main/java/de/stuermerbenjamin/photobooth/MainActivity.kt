package de.stuermerbenjamin.photobooth

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.gphoto2.Camera

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    val camera = Camera()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val version = camera.libraryVersion()
        Log.e(TAG, "library version: $version")
    }
}
