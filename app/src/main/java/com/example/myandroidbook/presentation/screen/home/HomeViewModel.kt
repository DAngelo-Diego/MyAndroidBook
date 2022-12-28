package com.example.myandroidbook.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.example.myandroidbook.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {
    val getAllAndroidInfo = useCases.getAllAndroidInfoUseCase()
}