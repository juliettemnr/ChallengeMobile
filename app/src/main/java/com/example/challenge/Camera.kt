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
    // Define the button and imageview type variable
    lateinit var camera_open_id: Button
    lateinit var click_image_id: ImageView
    lateinit var backButton : Button

    companion object {
        // Define the pic id
        private const val pic_id = 123
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        // By ID we can get each component which id is assigned in XML file get Buttons and imageview.
        camera_open_id = findViewById<Button>(R.id.camera_button)
        click_image_id = findViewById<ImageView>(R.id.click_image)
        backButton = findViewById<Button>(R.id.backButton)

        // Camera_open button is for open the camera and add the setOnClickListener in this button
        camera_open_id.setOnClickListener {
            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
            val camera_intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            } else {
                TODO("VERSION.SDK_INT < CUPCAKE")
            }
            // Start the activity with camera_intent, and request pic id
            startActivityForResult(camera_intent, pic_id)
        }

        backButton.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    // This method will help to retrieve the image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            val photo = data!!.extras!!["data"] as Bitmap?
            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo)
        }
    }
}