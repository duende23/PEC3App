package edu.uoc.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout

class PaginaPrincipal : AppCompatActivity() {

    private lateinit var rellayMaps: RelativeLayout

    private lateinit var rellayMuseums: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_principal)

        rellayMuseums = findViewById(R.id.rellay_Museums)

        rellayMuseums.setOnClickListener {
            val nextMuseumActivity = Intent(this, MuseumActivity::class.java)
            startActivity(nextMuseumActivity)
        }

        rellayMaps = findViewById(R.id.rellay_Maps)

        rellayMaps.setOnClickListener {
            val nextMapsActivity = Intent(this, MapsActivity::class.java)
            startActivity(nextMapsActivity)
        }




    }






}
