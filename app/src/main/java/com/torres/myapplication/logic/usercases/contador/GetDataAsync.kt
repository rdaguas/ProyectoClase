package com.torres.myapplication.logic.usercases.contador

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class GetDataAsync {
    var c = 1

    //Cada cinco segundos se está verificando el valor de c
    //y se envía
    suspend fun invoke() = flow<Int> {
        while (true) {
            delay(5000)
            c++
            //Para recolectar y envíe los datos del flow
            emit(c)
        }
    }
}