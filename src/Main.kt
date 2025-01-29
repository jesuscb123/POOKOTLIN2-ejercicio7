
fun realizarTrasnferencia(persona1: Persona, persona2: Persona, cuenta1: Cuenta, cuenta3: Cuenta,cantidad: Double){
    if(Persona.hacerTransferencia(persona1,persona2, cuenta1.numeroCuenta,cuenta3.numeroCuenta,700.0)){
        println(persona1.listaCuentas[0].consultarSaldoDisponible())
        println(persona2.listaCuentas[0].consultarSaldoDisponible())
        println("Trasnferencia completada")
    }else{
        println("Transferencia no realizada")
    }
}

fun comprobarSiMoroso(persona: Persona){
    if(persona.esMoroso(persona)){
        println("Es moroso")
    }else{
        println("No es moroso")
    }
}


fun main(){
    val cuenta1 = Cuenta(543567,saldo = 0.0)
    val cuenta2 = Cuenta(3433553,saldo = 700.0)
    val cuenta3 = Cuenta(4545446,saldo = 0.0)
    val persona1 = Persona("77499633Y", cuenta1)
    val persona2 = Persona(dni = "88543290L", cuenta3)
    persona1.agregarCuenta(cuenta2)
    persona1.listaCuentas[0].recibirAbonos(1100.0) //nómina mensual
    persona1.listaCuentas[0].realizarPago(750.0) // pagar alquiler
    comprobarSiMoroso(persona1)
    realizarTrasnferencia(persona1,persona2,cuenta1,cuenta3,200.0)
}