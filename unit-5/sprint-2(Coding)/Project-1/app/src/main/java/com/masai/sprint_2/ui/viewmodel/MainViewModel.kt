package com.masai.sprint_2.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.masai.sprint_2.ui.PeopleRepo

class MainViewModel:ViewModel() {

    private val peopleRepo = PeopleRepo()

    fun searchPeopleList() = peopleRepo.getPagesList()
}