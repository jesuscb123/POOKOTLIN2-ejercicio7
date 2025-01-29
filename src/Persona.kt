class Persona(dni: String, cuenta: Cuenta) {
    val listaCuentas = Array<Cuenta>(3) {cuenta}
    val dni = dni
    var cuentasAsociadas = 1



    init {
        require( listaCuentas.size <= MAX_CUENTAS) {"Error, no puede tener más de tres cuentas asociadas"}
        require(dni.length == 9) {"Error, el dni debe tener 9 caracteres"}
        require(dni[8].isLetter()) {"El último caracter debe ser una letra"}
        listaCuentas[0] = cuenta
    }


    companion object{
        const val MAX_CUENTAS = 3
        fun hacerTransferencia(personaA: Persona, personaB: Persona, numerocuentaA: Int, numerocuentaB: Int, cantidad: Double): Boolean {
            val cuenta1 = personaA.listaCuentas.find { it.numeroCuenta == numerocuentaA}
            val cuenta2 = personaB.listaCuentas.find { it.numeroCuenta == numerocuentaB}
            if(cuenta1 != null && cuenta2 != null && cuenta1.saldo > 0){
                cuenta1.realizarPago(cantidad)
                cuenta2.recibirAbonos(cantidad)
            }else{
                return false
            }
            return true
        }

}

    fun esMoroso(persona: Persona): Boolean{
        for(cuenta in persona.listaCuentas){
            if(cuenta.saldo < 0){
                return true
            }
        }
        return false
    }




    fun agregarCuenta(cuenta: Cuenta){
        if(cuentasAsociadas != MAX_CUENTAS){
            listaCuentas[cuentasAsociadas] = cuenta
            cuentasAsociadas ++
        }else{
            println("Ya no puedes agregar más cuentas")
        }
    }

}