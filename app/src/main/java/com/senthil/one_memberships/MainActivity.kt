package com.senthil.one_memberships

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        input_email.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (Patterns.EMAIL_ADDRESS.matcher(input_email.text.toString()).matches())
                    btn_login.isEnabled = true
                else{
                    btn_login.isEnabled = false
                    input_email.setError("Invalid Email")
                }

            }
        })
        input_password.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var pswd = input_password.text.toString()
               if (pswd.isNullOrEmpty() && pswd.count()<12){
                   btn_login.isEnabled = false
                   input_password.setError(" Password should not be empty")
               }
               else if ( pswd.count()<12){
                   btn_login.isEnabled = false
                   input_password.setError(" Password should above 12 characters")
               }

               else if ( pswd.matches(Regex("[a-zA-Z]+")) || pswd.isNullOrEmpty()){
                   btn_login.isEnabled = false
                   input_password.setError(" Password should should contain atleast 1 number")
               }
               else if ( pswd.matches(Regex("[A-Z]")) || pswd.isNullOrEmpty()){
                   btn_login.isEnabled = false
                   input_password.setError(" Password should should contain atleast 1 Capital Letter")
               }

               else{
                   btn_login.isEnabled = true
               }
            }
        })
        btn_login.isEnabled = false

        btn_login.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            //set title for alert dialog
            builder.setTitle(R.string.dialogTitle)
            //set message for alert dialog
            builder.setMessage(R.string.dialogMessage)
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("OK"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Closed",Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        btn_light.setOnClickListener(View.OnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        })
        btn_light.setOnClickListener(View.OnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        })
    }
}