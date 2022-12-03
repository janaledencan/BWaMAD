package com.jana.orwma_lv5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val etName = findViewById<EditText>(R.id.editPersonName)
        val etDescription = findViewById<EditText>(R.id.editDescription)



        findViewById<Button>(R.id.button1).setOnClickListener{
            textView.text = etName.text
            textView2.text = etDescription.text
        }

        findViewById<Button>(R.id.button2).setOnClickListener{
            val height =findViewById<EditText>(R.id.editHeight)
            val weight =findViewById<EditText>(R.id.editWeight)
            Toast.makeText(this, calculateBMI(height, weight).toString(),Toast.LENGTH_LONG).show()

        }

    }

    private fun calculateBMI(height:EditText, weight:EditText):Double{
        return weight.toString().toDouble()/(height.toString().toDouble()*height.toString().toDouble())
    }

    /*
    fun toastMessage(view: View)
    {
        val height =findViewById<EditText>(R.id.editHeight)
        val weight =findViewById<EditText>(R.id.editWeight)

        val message = calculateBMI(height,weight).toString()
        var toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.show()
    }*/
}