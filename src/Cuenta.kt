class Cuenta(val numeroCuenta: Int, saldo: Double) {
     var saldo = saldo

    init{
        require(saldo >= 0) {"El saldo no puede se negativo"}

    }


    fun consultarSaldoDisponible(): Double{
        return saldo
    }

    fun recibirAbonos(abono: Double){
        saldo += abono
    }


    fun realizarPago(pago: Double): Boolean{
        if(saldo < pago || pago < 0){
            return false
        }else{
            saldo -= pago
            return true
        }
    }

}