package edu.temple.fragmentrefactor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val changeButton = findViewById<Button>(R.id.changeButton)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, GreetingFragment.newInstance("Hello World!"))
                .commit()
        }

        changeButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val message = if (name.isEmpty()) {
                "Please enter your name"
            } else {
                "Hello $name"
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, GreetingFragment.newInstance(message))
                .commit()
        }
    }
}
