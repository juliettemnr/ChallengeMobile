package com.example.challenge

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Camera : AppCompatActivity() {

    lateinit var camera_open_id: Button
    lateinit var click_image_id: ImageView
    lateinit var backButton : Button

    companion object {
        private const val pic_id = 123
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        camera_open_id = findViewById<Button>(R.id.camera_button)
        click_image_id = findViewById<ImageView>(R.id.click_image)
        backButton = findViewById<Button>(R.id.backButton)


        camera_open_id.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera_intent, pic_id)
        }

        backButton.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pic_id) {
            val photo = data!!.extras!!["data"] as Bitmap?
            click_image_id.setImageBitmap(photo)
        }
    }
}