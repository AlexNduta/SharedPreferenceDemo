package com.example.spdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    //declare global variables so as to be able to acces them from other functions in the main activity
    private lateinit var nameText: EditText
    private lateinit var ageText: EditText
private lateinit var save:Button
private lateinit var Retrieve :Button
    //declare global variables that reference the sharedPreference object type
    private lateinit var sf: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    // the esitor is needed to edit values for shared preference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText= findViewById(R.id.etName)
        ageText= findViewById(R.id.etAge)
        save= findViewById(R.id.btnsave)
        Retrieve= findViewById(R.id.btnRetrieve)
// create the name of the folder and set the mode
        val pref=getSharedPreferences("details", MODE_PRIVATE)
val edit =pref.edit()

        //get refrerence to our use input
save.setOnClickListener {
 val name = nameText.text.toString()
    val age =ageText.text.toString().toInt()

    edit.apply {
        putString("name", name)
        putInt("age", age)

        apply()
    }
}
Retrieve.setOnClickListener {
    val name = pref.getString("name", null)
    val age = pref.getInt("age", 0)

    nameText.setText(name)
    ageText.setText(age.toString())

}


}


    }

