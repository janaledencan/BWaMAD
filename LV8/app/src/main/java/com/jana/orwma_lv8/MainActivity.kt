package com.jana.orwma_lv8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/
class MainActivity : AppCompatActivity(),PersonRecyclerAdapter.ContentListener {

    private val db = Firebase.firestore
    private lateinit var recyclerAdapter: PersonRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.personList)
        db.collection ("persons")
            .get()
            .addOnSuccessListener { result ->
                val personList = ArrayList<Person>()
                for (data in result.documents) {
                    val person = data.toObject(Person::class.java)
                    if (person != null) {
                        person.id = data.id
                        personList.add (person)
                    }
                }
                recyclerAdapter = PersonRecyclerAdapter (personList, this@MainActivity)
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = recyclerAdapter
                }
            }.addOnFailureListener { exception ->
                Log.w(
                    "MainActivity",
                    "Error getting documents.",
                    exception
                )
            }

        val imgURL = findViewById<EditText>(R.id.editTextImgURL)
        val personName =findViewById<EditText>(R.id.editTextPersonName)
        val personDescription=findViewById<EditText>(R.id.editTextPersonDescription)
        val btnSave=findViewById<Button>(R.id.saveBtn)

        btnSave.setOnClickListener {
            val myPerson = Person(imgURL.text.toString(), "123" , personName.text.toString(), personDescription.text.toString())
            //db.collection ("persons").add(myPerson)
            var myDocument = db.collection("persons").document()
            myDocument.set(myPerson).addOnSuccessListener {
                myPerson.id = myDocument.id
                recyclerAdapter.addItem(myPerson)
            }

        }
    }

    override fun onItemButtonClick(index: Int, person: Person, clickType: ItemClickType) {
        if (clickType == ItemClickType.EDIT) {
            db.collection("persons").document(person.id).set(person)
        } else if (clickType == ItemClickType.REMOVE) {
            recyclerAdapter.removeItem(index)
            db.collection ("persons").document(person.id)
                .delete()
        }
    }
}