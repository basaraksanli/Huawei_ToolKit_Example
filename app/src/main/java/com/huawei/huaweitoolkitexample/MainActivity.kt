package com.huawei.huaweitoolkitexample


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.maps.android.clustering.ClusterManager
import java.util.*


class MainActivity : AppCompatActivity(), OnMapReadyCallback {


    private val TAG: String = MainActivity::class.java.simpleName

    private val REQUEST_LOCATION_PERMISSION = 1
    val INITIAL_ZOOM = 12f
    private var mMap: GoogleMap? = null

    private var mClusterManager: ClusterManager<MyClusterItem>? = null

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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.map_options, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.normal_map -> {
                mMap?.mapType = GoogleMap.MAP_TYPE_NORMAL
                return true
            }
            R.id.hybrid_map -> {
                mMap?.mapType = GoogleMap.MAP_TYPE_HYBRID
                return true
            }
            R.id.satellite_map -> {
                mMap?.mapType = GoogleMap.MAP_TYPE_SATELLITE
                return true
            }
            R.id.terrain_map -> {
                mMap?.mapType = GoogleMap.MAP_TYPE_TERRAIN
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    override fun onMapReady(p0: GoogleMap?) {
        mMap = p0

        val home = LatLng(37.421982, -122.085109)
        mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(home, INITIAL_ZOOM))

        val homeOverlay = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_dialog_map))
            .position(home, 100f)
        mMap?.addGroundOverlay(homeOverlay)



        setMapLongClick(mMap!!); // Set a long click listener for the map;
        setPoiClick(mMap!!) // Set a click listener for points of interest.
        enableMyLocation(mMap!!) // Enable location tracking.
        setInfoWindowClickToPanorama(mMap!!)

        setUpClusterer(p0!!)

    }

    private fun setMapLongClick(map: GoogleMap) {

        map.setOnMapLongClickListener { latLng ->
            val snippet: String = java.lang.String.format(
                Locale.getDefault(),
                getString(R.string.lat_long_snippet),
                latLng.latitude,
                latLng.longitude
            )

            createClusterMarker(
                latLng.latitude,
                latLng.longitude,
                getString(R.string.dropped_pin),
                snippet
            )


        }
    }

    private fun setPoiClick(map: GoogleMap) {
        map.setOnPoiClickListener { poi ->

            createClusterMarker(poi.latLng.latitude, poi.latLng.longitude, poi.name, "snippet")


        }
    }

    private fun enableMyLocation(map: GoogleMap) {
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

    private fun setInfoWindowClickToPanorama(map: GoogleMap) {
        map.setOnInfoWindowClickListener { marker ->
            // Check the tag
            if (marker.tag === "poi") {

                // Set the position to the position of the marker
                val options = StreetViewPanoramaOptions().position(
                    marker.position
                )
                val streetViewFragment = SupportStreetViewPanoramaFragment
                    .newInstance(options)

                // Replace the fragment and add it to the backstack
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container,
                        streetViewFragment
                    )
                    .addToBackStack(null).commit()
            }
        }
    }

    private fun setUpClusterer(map: GoogleMap) {
        mClusterManager = ClusterManager(this, map)

        map.setOnCameraIdleListener(mClusterManager)
        map.setOnMarkerClickListener(mClusterManager)

    }


    private fun createClusterMarker(lat: Double, lng: Double, title: String, snippet: String) {
        val offsetItem = MyClusterItem(lat, lng, title, "snippet")
        mClusterManager!!.addItem(offsetItem)
        mClusterManager!!.cluster()
    }

}