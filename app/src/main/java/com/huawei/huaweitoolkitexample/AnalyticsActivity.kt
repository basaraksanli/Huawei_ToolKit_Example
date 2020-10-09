package com.huawei.huaweitoolkitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.analytics.FirebaseAnalytics

class AnalyticsActivity : AppCompatActivity() {
    private var mFirebaseAnalytics :FirebaseAnalytics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytics)

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            val mapIntent = Intent(this, MainActivity::class.java)
            startActivity(mapIntent)
        }

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

        val event1button = findViewById<Button>(R.id.event1button)
        val event2button = findViewById<Button>(R.id.event2button)
        val event3button = findViewById<Button>(R.id.event3button)

        var bundle :Bundle

        event1button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "event1");
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
            mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }
        event2button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "event2");
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text")
            mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }
        event3button!!.setOnClickListener{
            bundle =  Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "3");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "event3");
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button")
            mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }

    }
}