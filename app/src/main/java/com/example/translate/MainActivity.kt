package com.example.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.translate.api.Endpoint
import com.example.translate.util.NetworkUtils
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

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

            val translatedString = getEnglishWord(editTextTranslate.text.toString())

            translated.text = translatedString.toString()

            println(getEnglishWord(editTextTranslate.text.toString()))

        }
    }

    fun getEnglishWord(portuguese_word: String) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("http://192.168.0.183:3000/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getEnglishWord(portuguese_word)

        callback.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                println(t.message)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                val traduzido = response.body().toString()

                translated.text = traduzido
            }
        })

    }

}