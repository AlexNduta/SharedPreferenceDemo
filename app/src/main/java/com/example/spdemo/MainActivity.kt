package com.example.spdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
//declare global variables so as to be able to acces them from other functions in the main activity
    private lateinit var nameText: EditText
    private lateinit var ageText: EditText
//declare global variables that reference the sharedPreference object type
    private lateinit var sf: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    // the esitor is needed to edit values for shared preference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //access the golbal variables
        nameText = findViewById(R.id.etName)
        ageText = findViewById(R.id.etAge)

// initializee the sharepreference
        //"my sf" is the name of the file we will create to save the data
        //MODE_PRIVATE -> access to our data is limited to our application
        sf = getSharedPreferences("my sf", MODE_PRIVATE)

            //initialize the editor by calling the edit fuction
        editor = sf.edit()
    }


    // on pause of our application, the following code will  execute
    override fun onPause() {
        super.onPause()

        //write code to get the user input values
        val name = nameText.text.toString()
        val age = ageText.text.toString().toInt()

        //use editor to save the collected input into the shared preference using key-value pairs
        editor.apply {
//use key 'sf name" to store the value of the name variable
            putString("sf_name", name)
            //use the "sf_age"
            putInt("sf_age", age)

            //commitng saving the data
            commit()
        }
    }

// we use the onResume() to rectrieve the saved values
    override fun onResume() {
        super.onResume()
    //get the name using the getString() and getInt() by passing the key used to store the value
        val name = sf.getString("sf_name", null)
        val age = sf.getInt("sf_sge", 0)
    //display the editext
        nameText.setText(name)
//
if (age != 0) 45
    ageText.setText(age.toString())
}

    }

