package com.genarossi19.suboscan
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.genarossi19.suboscan.ResultActivity

import com.genarossi19.suboscan.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanFrontal.setOnClickListener { initScannerFrontal() }
        binding.btnScan.setOnClickListener { initScanner() }
    }

    private fun initScannerFrontal() {
        val integrator = IntentIntegrator(this)
        integrator.setPrompt("ESCANEE QR EN EL RECUADRO")
        integrator.setCameraId(1) // Especifica el ID de la cámara frontal
        integrator.initiateScan()
    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setPrompt("ESCANEE QR EN EL RECUADRO")
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            } else {
                val scanResult = result.contents
                if (scanResult == "FINISH") {
                    Toast.makeText(this, "Escaneo finalizado", Toast.LENGTH_SHORT).show()
                    // Agrega aquí la lógica que deseas ejecutar al escanear el código "FINISH"
                } else {
                    Toast.makeText(this, "El valor escaneado es: $scanResult", Toast.LENGTH_LONG).show()
                    // Aquí puedes agregar la lógica correspondiente al resultado del escaneo
                }
            }
        }
    }
}
