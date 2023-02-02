package com.example.challenge

import android.content.ContentUris
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import java.util.*

class Agenda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val builder = CalendarContract.CONTENT_URI.buildUpon()
        builder.appendPath("time")
        ContentUris.appendId(builder, Calendar.getInstance().timeInMillis)
        val intent = Intent(Intent.ACTION_VIEW)
            .setData(builder.build())
        startActivity(intent)


        var backButton : Button=findViewById(R.id.backButton)
        backButton.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}