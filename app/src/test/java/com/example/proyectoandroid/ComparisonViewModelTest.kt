package com.example.proyectoandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class ComparisonViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val observer: Observer<String> = mockk(relaxed = true)
    private lateinit var viewModel: ComparisonViewModel

    @Before
    fun setUp() {
        viewModel = ComparisonViewModel()
        viewModel.getResultLiveData().observeForever(observer)
        // viewModel.result.observeForever(observer)
    }

    @Test
    fun testComparisonViewModel() {
        viewModel.compareStrings("abc", "abc")
        verify { observer.onChanged("Las cadenas son iguales.") }

        viewModel.compareStrings("abc", "def")
        verify { observer.onChanged("Las cadenas son diferentes.") }
    }
}