package com.example.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var translated: TextView
    private lateinit var editTextTranslate: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        translated = findViewById<TextView>(R.id.translated)
        editTextTranslate = findViewById<EditText>(R.id.translate)

        translated.text = "Aqui aparecerá a sua tradução..."

        val translate_button = findViewById<Button>(R.id.translate_button)

        translate_button.setOnClickListener {
             val translatedString = toTranslate(editTextTranslate.text.toString())

            translated.text = translatedString
        }
    }


    private fun toTranslate(portuguese_text: String): String {

            val result = when(portuguese_text) {
                "cama" -> "bed"
                "Cama" -> "Bed"

                "colchão" -> "mattress"
                "Colchão" -> "Mattress"

                "travesseiro" -> "pillow"
                "Travesseiro" -> "Pillow"

                "lençol" -> "sheet"
                "Lençol" -> "Sheet"

                "escrivaninha" -> "writing desk"
                "Escrivaninha" -> "Writing desk"

                "cadeira" -> "chair"
                "Cadeira" -> "Chair"

                else -> "Palavra não encontrada"
            }

        return result



    }
}