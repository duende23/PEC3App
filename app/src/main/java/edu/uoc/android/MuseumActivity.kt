package edu.uoc.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.rest.MuseumService
import edu.uoc.android.rest.RetrofitFactory
import edu.uoc.android.rest.models.Element
import edu.uoc.android.rest.models.Museums
import kotlinx.android.synthetic.main.activity_museum.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MuseumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        recyclerciew_main.layoutManager = LinearLayoutManager(this)
        //call to the API
        api()
    }


    fun api() {

        val call = RetrofitFactory().museumService.museums(1, 200)

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
}
