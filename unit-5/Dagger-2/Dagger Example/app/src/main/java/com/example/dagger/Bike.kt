package com.example.dagger

import android.util.Log
import javax.inject.Inject

class Bike constructor(val engine: Engine,val suspension: Suspension,val wheels: Wheels) {

    fun drivebike(){
        engine.engine()
        suspension.suspension()
        wheels.wheels()
        Log.d("Suzuki", "bike blow")
    }
}