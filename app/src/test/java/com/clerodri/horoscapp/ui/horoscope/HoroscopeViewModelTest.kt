package com.clerodri.horoscapp.ui.horoscope

import com.clerodri.horoscapp.data.providers.HoroscopeProvider
import com.clerodri.horoscapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class HoroscopeViewModelTest{

    @MockK
    lateinit var horoscopeProvider:HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel
    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscope are loaded`(){
        every { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value
        assertTrue(horoscopes.isNotEmpty())
    }
}