
package com.example.dagger

import dagger.Module
import dagger.Provides


@Module
class BikeModule {

    @Provides
    fun getEngine() : Engine{
        return Engine()
    }

    @Provides
    fun getWheels() : Wheels{
        return Wheels()
    }

    @Provides
    fun getSuspension() : Suspension{
        return Suspension()
    }

    @Provides
    fun getBike(engine: Engine,wheels: Wheels,suspension: Suspension) : Bike{
        return Bike(engine,suspension,wheels)
    }

}