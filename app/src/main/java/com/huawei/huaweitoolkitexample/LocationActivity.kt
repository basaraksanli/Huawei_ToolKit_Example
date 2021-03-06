package com.huawei.huaweitoolkitexample

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import org.xms.g.location.LocationListener
import org.xms.g.location.LocationResult
import org.xms.g.location.LocationRequest
import org.xms.g.location.FusedLocationProviderClient
import org.xms.g.location.LocationCallback
import org.xms.g.location.LocationSettingsRequest
import org.xms.g.location.LocationServices
import org.xms.g.location.LocationServices.*


import com.google.android.material.floatingactionbutton.FloatingActionButton


class LocationActivity : AppCompatActivity() , LocationListener {
    private var mLastLocation: Location? = null
    private lateinit var mLocationRequest: LocationRequest
    private var locationText: TextView? = null
    private var getLocationButton : Button? = null
    private var stopLocationButton : Button?= null
    private var fusedLocationProviderClient : FusedLocationProviderClient? =null
    private var mLocationCallback : LocationCallback?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        locationText = findViewById(R.id.textview_location)
        getLocationButton = findViewById(R.id.start_button_location)
        stopLocationButton = findViewById(R.id.stop_button_location)


        getLocationButton!!.setOnClickListener {
            createLocationRequest()
        }
        stopLocationButton!!.setOnClickListener{
            removeLocationUpdatesWithCallback()
        }

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            val analyticsIntent = Intent(this, AnalyticsActivity::class.java)
            startActivity(analyticsIntent)
        }

    }

    override fun onLocationChanged(p0: Location?) {
        mLastLocation = p0!!

        locationText!!.append("LocationResult: " + "latitude: " + mLastLocation!!.latitude + " " + "longitude: " + mLastLocation!!.longitude + " " + "accuracy: " + mLastLocation!!.accuracy + "\n\n")
    }

    private fun createLocationRequest() {
        mLocationRequest = LocationRequest()
        mLocationRequest.interval = 1000
        mLocationRequest.fastestInterval = 1000
        mLocationRequest.priority = LocationRequest.getPRIORITY_HIGH_ACCURACY()

        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(mLocationRequest)
        val locationSettingsRequest = builder.build()


        val settingsClient = LocationServices.getSettingsClient(this)
        settingsClient.checkLocationSettings(locationSettingsRequest)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION) ,111)
            return
        }
        mLocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                onLocationChanged(locationResult.lastLocation)
            }
        }
        fusedLocationProviderClient=getFusedLocationProviderClient(this)
        fusedLocationProviderClient!!.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        createLocationRequest()
    }
    private fun removeLocationUpdatesWithCallback() {
        try {
            fusedLocationProviderClient!!.removeLocationUpdates(mLocationCallback)
                .addOnSuccessListener {
                    locationText!!.append(
                        "removeLocationUpdatesWithCallback onSuccess\n\n"
                    )
                }
                .addOnFailureListener { e ->
                    locationText!!.append(
                        "removeLocationUpdatesWithCallback onFailure:${e.message}\n\n"
                    )
                }
        } catch (e: Exception) {
            locationText!!.append("removeLocationUpdatesWithCallback exception:${e.message}\n\n"
            )
        }
    }
}