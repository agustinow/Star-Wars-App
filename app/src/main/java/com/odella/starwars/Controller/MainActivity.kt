package com.odella.starwars.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import com.odella.starwars.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onTogglePassword(view: View) = if(switchPass.isChecked) showPassword()
    else hidePassword()

    private fun showPassword() {
        txtPass.run {
            val cursorPosition = selectionStart
            transformationMethod = HideReturnsTransformationMethod.getInstance()
            setSelection(cursorPosition)
        }
    }

    private fun hidePassword() {
        txtPass.run {
            val cursorPosition = selectionStart
            transformationMethod = PasswordTransformationMethod.getInstance()
            setSelection(cursorPosition)
        }
    }

    fun onLoginClick(view: View) {
        if (txtUser.text.toString() == "anti_juan" && txtPass.text.toString() == "juancho1") {
            //Login
            var intent = Intent(this, SelectActivity::class.java)
            startActivity(intent)

        } else {
            Toast.makeText(this, "Los datos no son correctos.", Toast.LENGTH_SHORT).show()
        }
    }

}
