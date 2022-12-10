package com.jana.orwma_lv7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSearch = findViewById<Button>(R.id.button)
            .setOnClickListener{
                val brandName = findViewById<EditText>(R.id.editTextBrandName)
                val brand =brandName.text.toString()
                val request = ServiceBuilder.buildService(MakeupAPI::class.java)
                val call = request.getMakeup(brand)

                call.enqueue(object : Callback<ArrayList<MakeupItem>> {
                    override fun onResponse(
                        call: Call<ArrayList<MakeupItem>>,
                        response: Response<ArrayList<MakeupItem>>
                    ) {
                        if (response.isSuccessful) {
                            findViewById<RecyclerView>(R.id.recyclerView).apply {
                                layoutManager = LinearLayoutManager(this@MainActivity)
                                adapter = MakeupRecyclerAdapter(response.body()!!)

                            }
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<MakeupItem>>, t: Throwable) {
                        Log.d(
                            "FAIL", t.message.toString()
                        )
                    }
                })

            }
    }
}