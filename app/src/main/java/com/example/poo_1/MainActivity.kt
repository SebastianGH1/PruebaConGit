package com.example.poo_1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rectanuloView: View = findViewById(R.id.rectangulo)

        rectanuloView.post {


            val inicialX = rectanuloView.x.toInt()
            val inicialY = rectanuloView.y.toInt()
            val inicialHeight = rectanuloView.height
            val inicialWidth = rectanuloView.width


            val rectangulo: Rectangulo = Rectangulo(
                ContextCompat.getColor(this, R.color.red),
                inicialWidth,
                inicialHeight
            ).apply {

                x = inicialX
                y = inicialY
            }

            val buttonArriba: Button = findViewById(R.id.buttonArriba)
            val buttonAbajo: Button = findViewById(R.id.buttonAbajo)
            val buttonDerecha: Button = findViewById(R.id.buttonDerecha)
            val buttonIzquierda: Button = findViewById(R.id.buttonIzquierda)
            val buttonCambiarTamaño: Button = findViewById(R.id.buttonCambiarTamaño)
            val buttonCambiarColor: Button = findViewById(R.id.buttonCambiarColor)


            buttonArriba.setOnClickListener {
                rectangulo.moverArriba()
                actualizarVista(rectangulo, rectanuloView)
            }
            buttonAbajo.setOnClickListener {
                rectangulo.moverAbajo()
                actualizarVista(rectangulo, rectanuloView)
            }
            buttonDerecha.setOnClickListener {
                rectangulo.moverDerecho()
                actualizarVista(rectangulo, rectanuloView)
            }
            buttonIzquierda.setOnClickListener {
                rectangulo.moverIzquierda()
                actualizarVista(rectangulo, rectanuloView)
            }
            buttonCambiarTamaño.setOnClickListener {
                rectangulo.cambiarTamaño(150, 150)
                actualizarVista(rectangulo, rectanuloView)
            }

            buttonCambiarColor.setOnClickListener {

                //rectangulo.color = ContextCompat.getColor(this, R.color.blue)
                rectangulo.color = generarColorAleatorio()

                actualizarVista(rectangulo, rectanuloView)
            }
        }

        }

    private fun actualizarVista(rectangulo: Rectangulo,rectanguloView: View){

        rectanguloView.layoutParams.width=rectangulo.ancho
        rectanguloView.layoutParams.height=rectangulo.alto

        rectanguloView.setBackgroundColor(rectangulo.color)

        rectanguloView.x=rectangulo.x.toFloat()
        rectanguloView.y=rectangulo.y.toFloat()

        rectanguloView.requestLayout()
    }

        fun generarColorAleatorio():Int{

            val random= Random.Default
            val rojo=random.nextInt(256)
            val verde=random.nextInt(256)
            val azul=random.nextInt(256)

            return Color.rgb(rojo,verde,azul)
        }

    }


