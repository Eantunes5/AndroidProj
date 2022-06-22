package com.example.appfinanca.entity

class GastoEntity {


    constructor(id: Long, valor: String) {
        this.id = id
        this.valor = valor
    }

    constructor(valor: String) {
        this.valor = valor
    }

    var id = 0L
    var valor = ""

}