package edu.iest.linearlayoutactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var bnSuma : Button? = null
    private var bnResta : Button? = null
    private var bnMultiplicar : Button? = null
    private var bnDivision : Button? = null
    private var etNumeroPrimero: EditText? = null
    private var etNumeroSegundo: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarVistas()
        asignarEventos()
    }
    private fun inicializarVistas(){
        bnSuma =findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
        bnMultiplicar = findViewById(R.id.bnMultiplicar)
        bnDivision = findViewById(R.id.bnDivision)
        etNumeroPrimero = findViewById(R.id.etNumeroPrimero)
        etNumeroSegundo = findViewById(R.id.etNumeroSegundo)
    }

    private fun asignarEventos(){
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
        bnMultiplicar?.setOnClickListener(this)
        bnDivision?.setOnClickListener(this)
    }

    override fun onClick(miVista: View?) {
        val numeroUno = etNumeroPrimero?.text.toString().toFloatOrNull()
        val numeroDos = etNumeroSegundo?.text.toString().toFloatOrNull()
        if(numeroUno == null)
            return
        if(numeroDos == null)
            return

        val aritmetica = Aritmetica()

        when(miVista?.id){
            R.id.bnSuma -> {
                    val suma = aritmetica.suma(numeroUno,numeroDos)

                val mensaje =Mensajes("La sumatoria fue $suma",this)
                mensaje.mostrarToast()
            }
            R.id.bnResta -> {
                val resta = aritmetica.resta(numeroUno,numeroDos)
                val mensaje =Mensajes("El resultado es $resta",this)
                mensaje.mostrarSnackbar(miVista)
            }
            R.id.bnMultiplicar -> {
                val multiplicacion = aritmetica.multiplicacion(numeroUno,numeroDos)
                val mensaje =Mensajes("El resultado es $multiplicacion",this)
                mensaje.mostrarSnackbar(miVista)
            }
            R.id.bnDivision -> {
                val division = aritmetica.division(numeroUno,numeroDos)
                val mensaje =Mensajes("El resultado es $division",this)
                mensaje.mostrarSnackbar(miVista)
            }
        }

    }
}