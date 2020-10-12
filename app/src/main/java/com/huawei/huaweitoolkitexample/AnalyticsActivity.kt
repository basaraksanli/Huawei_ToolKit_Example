package com.huawei.huaweitoolkitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.analytics.FirebaseAnalytics

class AnalyticsActivity : AppCompatActivity() {
    private var analyticsInstance :FirebaseAnalytics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytics)

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            val mapIntent = Intent(this, MainActivity::class.java)
            startActivity(mapIntent)
        }

        val favoriteSportButton = findViewById<Button>(R.id.favoriteSportButton)
        val favoriteSportText = findViewById<EditText>(R.id.favoriteSportText)

        analyticsInstance = FirebaseAnalytics.getInstance(this)

        val event1button = findViewById<Button>(R.id.event1button)
        val event2button = findViewById<Button>(R.id.event2button)
        val event3button = findViewById<Button>(R.id.event3button)

        var bundle :Bundle

        analyticsInstance!!.setAnalyticsCollectionEnabled(true)
        analyticsInstance!!.setUserId("user1")
        analyticsInstance!!.setCurrentScreen(this, "AnalyticsPage", "com.huawei.huaweitoolkitexample.AnalyticsActivity")


        event1button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "event1");
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
            analyticsInstance!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }
        event2button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "event2");
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text")
            analyticsInstance!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }
        event3button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "3");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "event3");
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button")
            analyticsInstance!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }

        favoriteSportButton.setOnClickListener{
            if(favoriteSportText.text.isNotEmpty())
                analyticsInstance!!.setUserProperty("favor_sport", favoriteSportText.text.toString())
        }

    }
}