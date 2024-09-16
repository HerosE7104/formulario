package com.example.formulario

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val Enviar = findViewById<AppCompatButton>(R.id.button)
            val Nombre = findViewById<AppCompatEditText>(R.id.editTextText)
            val Correo = findViewById<AppCompatEditText>(R.id.editTextTextEmailAddress)
            val Telefono = findViewById<AppCompatEditText>(R.id.editTextPhone)
            val cajadeimagen =findViewById<AppCompatImageView>(R.id.imageView);
            Enviar.setOnClickListener {
                val nombre = Nombre.text.toString()
                val correo = Correo.text.toString()
                val telefono= Telefono.text.toString()

                cajadeimagen.setImageResource(R.drawable.atlas_otp)

                  if (nombre.isNotEmpty()){
                    Log.i(
                        "comprobacion",
                        "Enviado ${Nombre.text.toString()}"
                    )
                  }

                if (correo.isNotEmpty()){
                        Log.i(
                            "comprobacion",
                            "Enviado ${Correo.text.toString()}"
                        )
                    }
                if (telefono.isNotEmpty()){
                        Log.i(
                            "comprobacion",
                            "Enviado ${Telefono.text.toString()}"
                        )
                    }


            }
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
    }

    private fun <T> findViewById(): AppCompatButton? {
        TODO("no escribiste nada")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}