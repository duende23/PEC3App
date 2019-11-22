package edu.uoc.android

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import edu.uoc.android.rest.RetrofitFactory
import edu.uoc.android.rest.models.Museums
import kotlinx.android.synthetic.main.activity_maps2.*
import kotlinx.android.synthetic.main.activity_museum.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapsActivity2 : AppCompatActivity(), OnMapReadyCallback, OnMarkerClickListener {

    override fun onMarkerClick(p0: Marker?) = false


    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_maps2)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        //api()

    }


    fun api() {
        val call = RetrofitFactory().museumService.museums(1, 5)
        call.enqueue(object : Callback<Museums> {
            override fun onResponse(call: Call<Museums>, response: Response<Museums>) {
                if (response.code() == 200) {
                    val museums = response.body()!!
                    val elements = museums.elements
                    recyclerciew_main.adapter = MainAdapter(elements)
                }
            }

            override fun onFailure(call: Call<Museums>, t: Throwable) {
                Log.d("museums", "On Failure")
            }
        })
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sevilla = LatLng(35.0, 35.0)
        mMap.addMarker(MarkerOptions().position(sevilla).title("rrrrr"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sevilla))


    }

}

