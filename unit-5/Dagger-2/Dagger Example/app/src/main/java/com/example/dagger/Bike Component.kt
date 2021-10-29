package com.example.dagger

import dagger.Component

@Component(modules = [BikeModule::class])
interface BikeComponent {

    fun inject(mainActivity: MainActivity)
}
