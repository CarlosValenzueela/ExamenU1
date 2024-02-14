package mx.edu.potros.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gradosC = 0.0
        var gradosF = 0.0
        var conversion = 0.0
        var strOperacion = ""

        var consolaGradosC: EditText = findViewById(R.id.etGradosC)
        var consolaGradosF: EditText = findViewById(R.id.etGradosF)
        var consolaAux: TextView = findViewById(R.id.tvAviso)

        val btnGradosC: Button = findViewById(R.id.btnGradosC)
        val btnGradosF: Button = findViewById(R.id.btnGradosF)

        fun obtieneDosDecimales(valor: Double): String{
            var format: DecimalFormat = DecimalFormat()
            format.setMaximumFractionDigits(2);
            return format.format(valor);
        }

        btnGradosF.setOnClickListener {
            consolaAux.setText("")
            try {
                if(consolaGradosC.text.isNullOrEmpty()){
                    consolaAux.setText("Establece una cantidad de grados C.")
                }else{
                    gradosC = consolaGradosC.text.toString().toDouble()
                    if(gradosC >= 0){
                        conversion = (gradosC * 1.8) + 32

                        strOperacion = obtieneDosDecimales(conversion)
                        consolaGradosF.setText(strOperacion)

                    }
                }
            }catch (e: Exception){
                println(e.toString())
            }
        }


        btnGradosC.setOnClickListener {
            consolaAux.setText("")
            try {
                if(consolaGradosF.text.isNullOrEmpty()){
                    consolaAux.setText("Establece una cantidad de grados F.")
                }else{
                    gradosF = consolaGradosF.text.toString().toDouble()
                    if(gradosF >= 0){
                        conversion = (gradosF -32) / 1.8
                        strOperacion = obtieneDosDecimales(conversion)
                        consolaGradosC.setText(strOperacion)

                    }
                }
            }catch (e: Exception){
                println(e.toString())
            }
        }
    }
}