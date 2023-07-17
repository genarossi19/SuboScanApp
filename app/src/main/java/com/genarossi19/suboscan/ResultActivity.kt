package com.genarossi19.suboscan
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.genarossi19.suboscan.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null && extras.containsKey("EXTRA_RESULT")) {
            val result = extras.getString("EXTRA_RESULT")
            val id_user = result ?: ""

            when (id_user) {
                "1234" -> {
                    binding.tvPassengerName.text = "Miguel Fernandez"
                    binding.tvTotal.text = "Total: $500"
                    binding.tvSaldo.text = "Saldo: $3000"
                }
                "4321" -> {
                    binding.tvPassengerName.text = "Marcelo Ferreyra"
                    binding.tvTotal.text = "Total: $500"
                    binding.tvSaldo.text = "Saldo: $4500"
                }
                "1243" -> {
                    binding.tvPassengerName.text = "Genaro Rossi"
                    binding.tvTotal.text = "Total: $500"
                    binding.tvSaldo.text = "Saldo: $0"
                }
                "FINISH" -> {
                    setResult(Activity.RESULT_CANCELED) // Indicar que se ha cancelado la actividad con un resultado cancelado
                    finish() // Cerrar la actividad de ResultActivity
                }
                else -> {
                    binding.tvPassengerName.text = ""
                    binding.tvTotal.text = ""
                    binding.tvSaldo.text = ""
                    Toast.makeText(this, "ID no válido", Toast.LENGTH_SHORT).show()
                    finish() // Cerrar la actividad de ResultActivity en caso de un ID inválido
                }
            }
        } else {
            Toast.makeText(this, "Ha ocurrido un Error", Toast.LENGTH_SHORT).show()
            finish() // Cerrar la actividad de ResultActivity en caso de un error
        }
    }
}
