package com.huawei.huaweitoolkitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.xms.f.analytics.ExtensionAnalytics

class AnalyticsActivity : AppCompatActivity() {
    private var analyticsInstance :ExtensionAnalytics? = null

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

        analyticsInstance = ExtensionAnalytics.getInstance(this)

        val event1button = findViewById<Button>(R.id.event1button)
        val event2button = findViewById<Button>(R.id.event2button)
        val event3button = findViewById<Button>(R.id.event3button)

        var bundle :Bundle

        analyticsInstance!!.setAnalyticsCollectionEnabled(true)
        analyticsInstance!!.setUserId("user1")


        event1button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(ExtensionAnalytics.Param.getITEM_ID(), "1");
            bundle.putString(ExtensionAnalytics.Param.getITEM_NAME(), "event1");
            bundle.putString(ExtensionAnalytics.Param.getCONTENT_TYPE(), "image")
            analyticsInstance!!.logEvent(ExtensionAnalytics.Event.getSELECT_CONTENT(), bundle)
        }
        event2button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(ExtensionAnalytics.Param.getITEM_ID(), "2");
            bundle.putString(ExtensionAnalytics.Param.getITEM_NAME(), "event2");
            bundle.putString(ExtensionAnalytics.Param.getCONTENT_TYPE(), "text")
            analyticsInstance!!.logEvent(ExtensionAnalytics.Event.getSELECT_CONTENT(), bundle)
        }
        event3button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(ExtensionAnalytics.Param.getITEM_ID(), "3");
            bundle.putString(ExtensionAnalytics.Param.getITEM_NAME(), "event3");
            bundle.putString(ExtensionAnalytics.Param.getCONTENT_TYPE(), "button")
            analyticsInstance!!.logEvent(ExtensionAnalytics.Event.getSELECT_CONTENT(), bundle)
        }

        favoriteSportButton.setOnClickListener{
            if(favoriteSportText.text.isNotEmpty())
                analyticsInstance!!.setUserProperty("favor_sport", favoriteSportText.text.toString())
        }

    }
}