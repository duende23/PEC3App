package edu.uoc.android

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.rest.RetrofitFactory
import edu.uoc.android.rest.models.Museums
import kotlinx.android.synthetic.main.activity_museum.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MuseumActivity : AppCompatActivity() {

  //  private var progressBar: ProgressBar? = null

    //private var progressStatus = 0

    var progressBar : ProgressBar? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        progressBar = findViewById(R.id.pb1)

        recyclerciew_main.layoutManager = LinearLayoutManager(this)

        //call to the API
        api()

    }
        fun api() {
        val call = RetrofitFactory().museumService.museums(1, 5)
        call.enqueue(object : Callback<Museums> {
            override fun onResponse(call: Call<Museums>, response: Response<Museums>) {
                if (response.code() == 200) {
                    //progressBar?.visibility = View.GONE
                    //progressBar?.visibility = View.INVISIBLE
                    /*if (progressBar != null) {
                            val visibility = if (progressBar?.visibility == RecyclerView.GONE) View.VISIBLE else RecyclerView.GONE
                            progressBar?.visibility = visibility

                    }*/
                    progressBar?.visibility = View.GONE


                    val museums = response.body()!!
                    val elements = museums.elements
                    recyclerciew_main.adapter = MainAdapter(elements)
                }
            }

            override fun onFailure(call: Call<Museums>, t: Throwable) {
                progressBar?.visibility = View.GONE
                Log.d("museums", "On Failure")
            }
        })
    }
}
