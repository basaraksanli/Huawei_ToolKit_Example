package com.huawei.huaweitoolkitexample


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.xms.g.maps.CameraUpdateFactory
import org.xms.g.maps.ExtensionMap
import org.xms.g.maps.OnMapReadyCallback
import org.xms.g.maps.SupportMapFragment
import org.xms.g.maps.model.LatLng
import org.xms.g.maps.model.CameraPosition
import org.xms.g.maps.model.GroundOverlayOptions
import org.xms.g.maps.model.BitmapDescriptorFactory
import org.xms.g.maps.model.CircleOptions
import org.xms.g.maps.model.MarkerOptions

import com.google.android.material.floatingactionbutton.FloatingActionButton

import java.util.*


class MainActivity : AppCompatActivity(), OnMapReadyCallback {



    private val REQUEST_LOCATION_PERMISSION = 1
    val INITIAL_ZOOM = 12f
    private var mMap: ExtensionMap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapFragment = SupportMapFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, mapFragment).commit();
        mapFragment.getMapAsync(this)

        val fab: FloatingActionButton = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            val locationIntent = Intent(this, LocationActivity::class.java)
            startActivity(locationIntent)
        }
    }



    override fun onMapReady(p0: ExtensionMap?) {
        mMap = p0

        val build = CameraPosition.Builder().target(LatLng(38.423733, 27.142826)).zoom(15f).build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(build)
        mMap?.animateCamera(cameraUpdate)

        val homeOverlay = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_camera))
            .position(LatLng(38.423733, 27.142826), 500f)
        mMap?.addGroundOverlay(homeOverlay)

        mMap!!.addCircle(CircleOptions().center(LatLng(38.422731, 27.129463)).radius(500.0)
                .fillColor(Color.RED)
        )





        setMapLongClick(mMap!!); // Set a long click listener for the map;
        setPoiClick(mMap!!) // Set a click listener for points of interest.
        enableMyLocation(mMap!!) // Enable location tracking.

    }

    private fun setMapLongClick(map: ExtensionMap) {

        map.setOnMapLongClickListener { latLng ->
            val snippet: String = java.lang.String.format(
                Locale.getDefault(),
                getString(R.string.lat_long_snippet),
                latLng.latitude,
                latLng.longitude
            )

            val markerOptions = MarkerOptions().position(latLng).snippet(snippet).title("Pinned Place")
            map.addMarker(markerOptions)

        }
    }

    private fun setPoiClick(map: ExtensionMap) {
        map.setOnPoiClickListener { poi ->

            val markerOptions = MarkerOptions().position(poi.latLng).title(poi.name).snippet(poi.latLng.toString())
            val poiMarker =map.addMarker(markerOptions)
            poiMarker.tag = "poi"

        }
    }

    private fun enableMyLocation(map: ExtensionMap) {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            == PackageManager.PERMISSION_GRANTED
        ) {
            map.isMyLocationEnabled = true
            map.uiSettings.isZoomControlsEnabled = true
            map.uiSettings.isMyLocationButtonEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

}