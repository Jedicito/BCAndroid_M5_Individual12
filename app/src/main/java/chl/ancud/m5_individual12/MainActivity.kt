package chl.ancud.m5_individual12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    print("Ingresar cantidad de usuarios: ")
    val cantUsuarios = readln().toInt()

    var usuarios = mutableListOf<Usuario>()

    for (i in 1..cantUsuarios) {

        var nombre: String = ingresaNombre()

        var apellido = ingresaApellido()

        var edad = ingresaEdad()

        var correo = ingresaCorreo()

        print("Sistema Salud: ")
        var sistSalud = readln()

        var usuario = Usuario(nombre, apellido, edad, correo, sistSalud)

        usuarios.add(usuario)

        println(usuario)

    }

    println("Lista ordenada por edad")
    for (u in usuarios.sortedBy {it.edad }) {
        println(u)
    }
}

fun ingresaNombre(): String  {
    var nombre = ""
    do {
        print("Nombre: ")
        nombre = readln()
    }while (!validarNombre(nombre))
    return nombre
}

fun ingresaApellido(): String {
    var apellido = ""
    do {
        print("Apellido: ")
        apellido = readln()
    }while (!validaCaracteres(apellido))
    return apellido
}

fun ingresaEdad(): Int {
    var edad = ""
    do {
        print("Edad: ")
        edad = readln()
    }while (!validarNumeros(edad))
    return edad.toInt()
}

fun ingresaCorreo(): String {
    var correo = ""
    do {
        print("Correo: ")
        correo = readln()
    }while (!validaCorreo(correo))

    return correo
}

fun ingresaSistSalud(): String {
    var sistema = 0
    var sistemaSalud = ""
    do {
        print("Sistema de Salud: 1) Fonasa. 2) Isapre. 3) Particular")
        sistema = readln().toInt()
    }while(sistema !in 1..3)
    when(sistema) {
        1 -> sistemaSalud = "Fonasa"
        2 -> sistemaSalud = "Isapre"
        3 -> sistemaSalud = "Particular"
    }

    return sistemaSalud
}

fun validarNombre(nombre: String): Boolean {

    var validado: Boolean = false
    if(nombre.length in 1..20) {
        validado = validaCaracteres(nombre)
    }
    //println("Largo del nombre: ${nombre.length};
    // validado = $validado")

    return validado
}

fun validaCaracteres(cadena: String): Boolean {
    var validado: Boolean = true

    for (c in cadena.toCharArray()) {
        if (c !in 'a'..'z' && c !in 'A'..'Z') {
            validado = false
        }
    }

    return validado
}

fun validarNumeros(cadena: String): Boolean {
    var validado: Boolean = true

    for (c in cadena.toCharArray()) {
        if (c !in '0'..'9') {
            validado = false
        }
    }
    return validado
}

fun validaCorreo(cadena: String): Boolean {
    return cadena.contains('@') && cadena.contains('.')
}

data class Usuario(var nombre: String, var apellido: String, var edad: Int, var correo: String
                   , var sistSalud: String)